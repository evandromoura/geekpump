package br.com.geekpump.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Base64;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.geekpump.entity.ExercicioImagem;
import br.com.geekpump.service.exercicioimagem.ExercicioImagemService;

@WebServlet({"/view/image"})
public class ImagemDownload extends HttpServlet {

	private static final long serialVersionUID = 4043679811548773728L;

	private @Inject ExercicioImagemService exercicioImagemService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		File arquivo = null;
		FileInputStream fis = null;
		String nomeArquivoFinal = null;
		try {
			ExercicioImagem exercicioImagem = exercicioImagemService.recuperarPorUidExercicio(req.getParameter("uid"));
			
			if(req.getParameter("type").equals("thumbnail")) {
				nomeArquivoFinal = gerarImagem(req.getParameter("uid"), exercicioImagem.getThumbnail());
			}else if(req.getParameter("type").equals("execucao")) {
				nomeArquivoFinal = gerarImagem(req.getParameter("uid"), exercicioImagem.getExecucao());
			}else if(req.getParameter("type").equals("ativacao")) {
				nomeArquivoFinal = gerarImagem(req.getParameter("uid"), exercicioImagem.getAtivacao());
			}
			
			arquivo = new File(nomeArquivoFinal);
            resp.setContentType("image/png");
            int BUFF_SIZE = 1024;
            byte[] buffer = new byte[BUFF_SIZE];
            resp.setContentLength((int) arquivo.length());
            fis = new FileInputStream(arquivo);
            OutputStream os = resp.getOutputStream();
            int byteCount = 0;
            do {
                byteCount = fis.read(buffer);
                if (byteCount == -1) {
                    break;
                }
                os.write(buffer, 0, byteCount);
                os.flush();
            } while (true);
			
        }catch(Exception e) {
        } finally {
//        	if(arquivo !=null && arquivo.exists()) {
//        		arquivo.delete();
//        	}
        	if(fis != null) {
        		fis.close();
        	}
        }
	}
	
	private String gerarImagem(String uid,String imagem) {
		String nomeArquivo = "img_"+uid+"_thumb.jpg";
		String nomeArquivoFinal = "/tmp/"+nomeArquivo;
		try {
			if(!new File(nomeArquivoFinal).exists()) {
				if(!new File(nomeArquivo).exists()) {
					Files.write(Paths.get(nomeArquivoFinal), Base64.getDecoder().decode(imagem.replace("data:image/jpeg;base64,","").replace("data:image/png;base64,","")),StandardOpenOption.CREATE);
				}	
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return nomeArquivoFinal;
	}
	
}
