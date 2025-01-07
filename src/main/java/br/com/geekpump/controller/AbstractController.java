package br.com.geekpump.controller;

import java.lang.reflect.ParameterizedType;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AbstractController<TO> {

	private TO to;
	private boolean edicao;
	private boolean insercao;
	
	public HttpServletRequest getRequest() { 
		FacesContext ctx = getFacesContext();
		ExternalContext exc = ctx.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) exc.getRequest();
		return request;
	}
	
	public HttpServletResponse getResponse() { 
		FacesContext ctx = getFacesContext();
		ExternalContext exc = ctx.getExternalContext();
		HttpServletResponse response = (HttpServletResponse) exc.getResponse();
		return response;
	}
	
	public ServletContext getServletContext() { 
		FacesContext ctx = getFacesContext();
		ExternalContext exc = ctx.getExternalContext();
		return (ServletContext)exc.getContext();
	}
	
	
	protected FacesContext getFacesContext() {
		return FacesContext
				.getCurrentInstance();
	}
	
	
	 public String getStackTrace() {
	        Throwable throwable = (Throwable)  FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("javax.servlet.error.exception");
	        StringBuilder builder = new StringBuilder();
	        if(throwable!= null && throwable.getMessage() != null){
		        builder.append(throwable.getMessage()).append("\n");
		        for (StackTraceElement element : throwable.getStackTrace()) {
		            builder.append(element).append("\n");
		        }
	        }   
	        return builder.toString();
	    }
	 
	 
	public String getMessage(String label){
		ResourceBundle rb = ResourceBundle.getBundle("resources", getFacesContext().getViewRoot().getLocale());
		return rb.getString(label);
	}
	
	public void adicionarMensagem(String key,Severity severity){
		String mensagem = getMessage(key);
		getFacesContext().addMessage(null, new FacesMessage(severity, mensagem, mensagem));
		getFacesContext().getExternalContext().getFlash().setKeepMessages(true);
	}
	
	public void adicionarMensagemGlobal(Severity severity,String titulo, String texto) {
		getFacesContext().addMessage(null, new FacesMessage(severity, titulo, texto));
		getFacesContext().getExternalContext().getFlash().setKeepMessages(true);
	}
	
	@SuppressWarnings("unchecked")
	public TO getTo(){
		if (to == null) {
			try{
				to = ((Class<TO>)((ParameterizedType)this.getClass().
					       getGenericSuperclass()).getActualTypeArguments()[0]).newInstance();
			}catch(ClassCastException cce){
				try{
					to = ((Class<TO>)((ParameterizedType)(((Class<TO>)
							this.getClass().getAnnotatedSuperclass().getType()).getGenericSuperclass()))
								.getActualTypeArguments()[0]).newInstance();
				}catch(Exception e){
					e.printStackTrace();
				}	
			}catch(Exception e){
				e.printStackTrace();
			}	
		}
		return to;
	}

	public boolean isEdicao() {
		return edicao;
	}

	public void setEdicao(boolean edicao) {
		this.edicao = edicao;
	}

	public boolean isInsercao() {
		return insercao;
	}

	public void setInsercao(boolean insercao) {
		this.insercao = insercao;
	}
}
