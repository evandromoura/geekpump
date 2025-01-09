package br.com.geekpump.view;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

@URLMappings(mappings={
		  @URLMapping(id = "home", 			 			pattern = "/home",   viewId = "/home.xhtml"),
		  @URLMapping(id = "login", 			 		pattern = "/login",   viewId = "/login.xhtml"),
		  @URLMapping(id = "exercicio_list", 			pattern = "/exercicio",   viewId = "/pages/exercicio/exercicio_list.xhtml"),
		  @URLMapping(id = "exercicio_edit", 			pattern = "/exercicio/edit/#{parametro}",   viewId = "/pages/exercicio/exercicio_form.xhtml"),
		  @URLMapping(id = "grupamentomuscular_list", 	pattern = "/grupamentomuscular",   viewId = "/pages/grupamentomuscular/grupamentomuscular_list.xhtml"),
		  @URLMapping(id = "grupamentomuscular_edit", 	pattern = "/grupamentomuscular/edit/#{parametro}",   viewId = "/pages/grupamentomuscular/grupamentomuscular_form.xhtml"),
		  @URLMapping(id = "usuario_list", 			 	pattern = "/usuario",   viewId = "/pages/usuario/usuario_list.xhtml"),
		  @URLMapping(id = "usuario_edit", 			 	pattern = "/usuario/edit/#{parametro}",   viewId = "/pages/usuario/usuario_form.xhtml"),

		  @URLMapping(id = "treino_usuario", 			pattern = "/treinousuario",   viewId = "/pages/treinousuario/treinousuario.xhtml"),
		  @URLMapping(id = "treino_usuario_exercicio", 	pattern = "/treinousuarioexercicio/#{parametro}",   viewId = "/pages/treinousuarioexercicio/treinousuarioexercicio.xhtml"),
		})
public class GeekpumpRotas {
	

}
