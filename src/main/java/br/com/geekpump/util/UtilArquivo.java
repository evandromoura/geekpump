package br.com.geekpump.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class UtilArquivo {

	@SuppressWarnings("resource")
	public byte[] getBytesFromFile(File file) throws IOException {
		InputStream is = new FileInputStream(file);
		long length = file.length();
		
		if (length > Integer.MAX_VALUE) {
			throw new IOException("File is too large!");
		}
		byte[] bytes = new byte[(int) length];
		int offset = 0;
		int numRead = 0;
		try {
			while (offset < bytes.length
					&& (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
				offset += numRead;
			}
		} catch (IOException e) {
			throw e;
		} finally {
			is.close();
		}
		if (offset < bytes.length) {
			throw new IOException("Could not completely read file "
					+ file.getName());
		}
		return bytes;
	}

	public String getStringFromFile(File file) throws IOException {
		StringBuilder sb = new StringBuilder();
		InputStream is = new FileInputStream(file);
		long length = file.length();

		if (length > Integer.MAX_VALUE) {
			throw new IOException("File is too large!");
		}
		byte[] bytes = new byte[(int) length];
		int offset = 0;
		int numRead = 0;
		try {
			while (offset < bytes.length
					&& (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
				offset += numRead;
				sb.append(new String(bytes));
			}
		} catch (IOException e) {
			throw e;
		} finally {
			is.close();
		}
		if (offset < bytes.length) {
			throw new IOException("Could not completely read file "
					+ file.getName());
		}
		return sb.toString();
	}
	
	public static ByteArrayOutputStream converterBytesEmByteArrayOutputStream(byte[] bytes) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream(bytes.length);
		baos.write(bytes, 0, bytes.length);
		baos.close();
		return baos;
	}
	
	private static String getExtension(File file) {
	    String nomeArq = file.getName();
	    String ext = nomeArq.substring(nomeArq.lastIndexOf('.') + 1);
	    return ext;
	}
	
	public File escreverConteudoEmArquivo(List<String> conteudo,String caminhoCompletoArquivo)throws Exception{
		if(new File(caminhoCompletoArquivo).exists()){
			new File(caminhoCompletoArquivo).delete();
		}
		FileWriter fw = new FileWriter(caminhoCompletoArquivo, true);
		for(String linha:conteudo){
			fw.write(linha+"\r\n");
		}
		fw.close();
		return new File(caminhoCompletoArquivo);
	}
	
	
	public File getFileFromBytes(byte[] bytes,String name) throws Exception {
		File novoArquivo = new File(name);
		novoArquivo.createNewFile();
		OutputStream out = new FileOutputStream(name);
		out.write(bytes);
		out.close();
		return new File(name);
	}
	
	public boolean verificarArquivoExistente(String caminhoArquivo,String nome)throws Exception{
		return new File(caminhoArquivo,nome).exists();
	}
	
	
	public void criarArquivoEmDisco(String nome,String diretorio,byte[] conteudo)throws Exception{
		
		if(!verificarArquivoExistente(diretorio,nome)){
		File arquivo = new File(diretorio,nome);
		OutputStream outFile = new FileOutputStream(arquivo);
		outFile.write(conteudo);
		outFile.close();
		outFile.flush();
		}
	}
	
	
	public void criarDeleteArquivoEmDisco(String nome,String diretorio,byte[] conteudo)throws Exception{
			File arquivo = new File(diretorio,nome);
			OutputStream outFile = new FileOutputStream(arquivo);
			outFile.write(conteudo);
			outFile.close();
			outFile.flush();
		
	}
	
	
	public void convertFileToByteArrayOutputStream(File file, ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        FileInputStream inputStream = new FileInputStream(file);
        byte[] buffer = new byte[2048];
        int read = -1;
        while ((read = inputStream.read(buffer, 0, buffer.length)) != -1) {   
            byteArrayOutputStream.write(buffer, 0, read);
        }
    }
	
	
	public static byte[] converteInputStreamEmBytes(InputStream inputStream) throws Exception {
		BufferedInputStream bis = new BufferedInputStream(inputStream);
		byte[] bytes = new byte[bis.available()];
		while(bis.available()>0) {
			bis.read(bytes);
		}
		bis.close();
		return bytes;
    }
	
}
