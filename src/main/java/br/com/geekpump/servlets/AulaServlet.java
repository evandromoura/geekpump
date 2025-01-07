package br.com.geekpump.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AulaServlet", urlPatterns = {"/aulaServlet"})
public class AulaServlet extends HttpServlet{

	private static final long serialVersionUID = -720452407857886838L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("CHEGOU NA SERVLET");
		String pesoParam = req.getParameter("peso");
		double peso = Double.valueOf(pesoParam);
		String alturaParam = req.getParameter("altura");
		double altura = Double.valueOf(alturaParam);
		double imc = peso / (altura * altura);
		String retorno = "";
		System.out.println("O IMC é: "+imc);
		
		if(imc < 18.5) {
			retorno = "Abaixo do peso";
		}else if(imc >= 18.5 && imc <=24.9) {
			retorno = "Normal";
		}else if(imc >= 25 && imc <= 29.9) {
			retorno = "Sobrepeso";
		}else if(imc >= 30 && imc <= 34.9) {
			retorno = "Obesidade Grau 1";
		}else if(imc >= 35 && imc <= 39.9) {
			retorno = "Obesidade Grau 2";
		}else if (imc >= 40) {
			retorno = "Obesidade grau III ou mórbida";
		}
		resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().println(retorno);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

	
	
	
}
