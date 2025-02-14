package br.com.geekpump.controller.home;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.google.common.io.Files;

import br.com.geekpump.controller.AbstractController;
import br.com.geekpump.entity.Exercicio;
import br.com.geekpump.entity.ExercicioImagem;
import br.com.geekpump.entity.GrupamentoMuscular;
import br.com.geekpump.security.CustomIdentity;
import br.com.geekpump.service.exercicio.ExercicioService;
import br.com.geekpump.service.grupamentomuscular.GrupamentoMuscularService;
import br.com.geekpump.service.treinousuario.TreinoUsuarioService;
import br.com.geekpump.to.HomeTO;
import br.com.geekpump.util.Base64Utils;
import br.com.geekpump.util.GifResizer;
import br.com.geekpump.util.UtilArquivo;
import br.com.geekpump.util.UtilBeans;


@Named
@ViewScoped
public class HomeController extends AbstractController<HomeTO> implements Serializable {

	private static final long serialVersionUID = 172034915448715026L;

	
	private @Inject TreinoUsuarioService treinoUsuarioService;
	private @Inject CustomIdentity customIdentity;
	private @Inject ExercicioService exercicioService;
	private @Inject GrupamentoMuscularService grupamentoMuscularService;
	UtilArquivo utilArquivo = new UtilArquivo();
	
	@PostConstruct
	private void init() {
//		getTo().setTreinos(treinoUsuarioService.pesquisarPorUsuario(customIdentity.getUsuario()));
		
		System.out.println("Inicializou o homeController");
	}
	
	private void calcularDados() {
		
	}
	
	/*
	 * PEITORAL
	 * OMBRO
	 * COSTAS
	 * TRICEPS
	 * BICEPS
	 * GLUTEOS
	 * PANTURRILHAS
	 * PERNAS
	 * TRAPEZIO
	 * ANTEBRACOS
	 */
	
	public void importarArquivos() {
		
		String caminhoDiretorio = "/home/trixti/Downloads/gymvisual/import/Peitoral";
        File diretorio = new File(caminhoDiretorio);
        GrupamentoMuscular grupamentoMuscular = grupamentoMuscularService.recuperar(1);

        if (diretorio.exists() && diretorio.isDirectory()) {
            File[] arquivos = diretorio.listFiles();

            if (arquivos != null && arquivos.length > 0) {
                Arrays.stream(arquivos)
                        .filter(file->file.isFile())
                        .forEach(arquivo -> {
                        	try {
	                            String nomeCompleto = arquivo.getName();
	                            int indicePonto = nomeCompleto.lastIndexOf('.');
	                            String nome = nomeCompleto.substring(0, indicePonto);
	                            String extensao = nomeCompleto.substring(indicePonto + 1);
	                            Exercicio exercicio = exercicioService.recuperarPorNome(nome);
	                            if(exercicio == null) {
	                            	exercicio = new Exercicio();
	                            	exercicio.setNome(nome);
	                            	exercicio.setGrupamentoMuscular(grupamentoMuscular);
	                            	exercicio.setImagens(new ArrayList<ExercicioImagem>());
	                            	ExercicioImagem exercicioImagem = new ExercicioImagem();
	                            	UtilArquivo utilArquivo = new UtilArquivo();
	                            	String imagemBase64 = Base64Utils.base64Encode(utilArquivo.getBytesFromFile(arquivo));
	                            	exercicioImagem.setAtivacao(imagemBase64);
	                            	exercicioImagem.setExecucao(imagemBase64);
	                            	exercicioImagem.setThumbnail(imagemBase64);
	                            	exercicioImagem.setExercicio(exercicio);
	                            	exercicio.getImagens().add(exercicioImagem);
	                            	exercicioService.incluir(exercicio);
	                            }else {
	                            	exercicio.setImagens(new ArrayList<ExercicioImagem>());
	                            	ExercicioImagem exercicioImagem = new ExercicioImagem();
	                            	UtilArquivo utilArquivo = new UtilArquivo();
	                            	String imagemBase64 = Base64Utils.base64Encode(utilArquivo.getBytesFromFile(arquivo));
	                            	exercicioImagem.setAtivacao(imagemBase64);
	                            	exercicioImagem.setExecucao(imagemBase64);
	                            	exercicioImagem.setThumbnail(imagemBase64);
	                            	exercicioImagem.setExercicio(exercicio);
	                            	exercicio.getImagens().add(exercicioImagem);
	                            	exercicioService.alterar(exercicio);
	                            }
	                            System.out.println("Nome: " + nome + " | Extensão: " + extensao);
                        	}catch(Exception e) {
                        		e.printStackTrace();
                        	}
                            
                            
                        });
            } else {
                System.out.println("O diretório está vazio.");
            }
        } else {
            System.out.println("O diretório não existe ou não é um diretório válido.");
        }
	}
	
	public static void main(String[] args) {
		HomeController homeController = new HomeController();
		homeController.importarArquivos();
	}
	
}
