package br.com.geekpump.service.exercicioimagem;

import java.io.File;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import br.com.geekpump.entity.Exercicio;
import br.com.geekpump.service.exercicio.ExercicioService;
import br.com.geekpump.util.Base64Utils;
import br.com.geekpump.util.GifResizer;
import br.com.geekpump.util.UtilArquivo;


@Singleton
@Startup
public class ExercicioImagemLoad {
	
	private @Inject ExercicioService exercicioService;
	UtilArquivo utilArquivo = new UtilArquivo();
	
	@PostConstruct
	private void init() {
//		List<Exercicio> exercicios = exercicioService.listar();
//		String diretorioDestino = System.getProperty("jboss.server.base.dir") + File.separator + "deployments" + File.separator + "geekpump.war" + File.separator + "assets" + File.separator + "images";
//		for(Exercicio exercicio:exercicios) {
//			if(exercicio.getImagens() != null && !exercicio.getImagens().isEmpty()) {
//				try {
//					String nomeArquivo = exercicio.getUid() +".gif";
//					String nomeArquivoFinal = diretorioDestino +"/"+ nomeArquivo;
//	                String nomeArquivoThumb = exercicio.getUid() +"_thumb.gif";
//	                String nomeArquivoThumbFinal = diretorioDestino +"/"+ nomeArquivoThumb;
//					if(!new File(nomeArquivoFinal).exists()) {
//						utilArquivo.criarArquivoEmDisco(nomeArquivo, diretorioDestino, Base64Utils.base64Decode(exercicio.getImagens().get(0).getExecucao()));
//						System.out.println("Criou o Arquivo: "+nomeArquivoFinal);
//						if(!new File(nomeArquivoThumbFinal).exists()) {
//							GifResizer.resizeGif(nomeArquivoFinal,nomeArquivoThumbFinal, 200, 200);
//							System.out.println("Criou o thumb: "+nomeArquivoThumbFinal);
//						}
//					}	
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}
		System.out.println("INICIOU O EXERCICIO IMAGEM LOAD...");
	}

}
