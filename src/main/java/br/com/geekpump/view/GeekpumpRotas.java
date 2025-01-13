package br.com.geekpump.view;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

@URLMappings(mappings={
		  @URLMapping(id = "home", 			 			pattern = "/home",   viewId = "/home.xhtml"),
		  @URLMapping(id = "login", 			 		pattern = "/login",  viewId = "/login.xhtml"),
		  @URLMapping(id = "perfil", 			 		pattern = "/perfil", viewId = "/pages/perfil/perfil.xhtml"),
		  @URLMapping(id = "auth", 			 			pattern = "/auth",   viewId = "/auth.xhtml"),
		  
		  @URLMapping(id = "exercicio_list", 			pattern = "/exercicio",   viewId = "/pages/exercicio/exercicio_list.xhtml"),
		  @URLMapping(id = "exercicio_edit", 			pattern = "/exercicio/edit/#{parametro}",   viewId = "/pages/exercicio/exercicio_form.xhtml"),
		  @URLMapping(id = "grupamentomuscular_list", 	pattern = "/grupamentomuscular",   viewId = "/pages/grupamentomuscular/grupamentomuscular_list.xhtml"),
		  @URLMapping(id = "grupamentomuscular_edit", 	pattern = "/grupamentomuscular/edit/#{parametro}",   viewId = "/pages/grupamentomuscular/grupamentomuscular_form.xhtml"),
		  @URLMapping(id = "usuario_list", 			 	pattern = "/usuario",   viewId = "/pages/usuario/usuario_list.xhtml"),
		  @URLMapping(id = "usuario_edit", 			 	pattern = "/usuario/edit/#{parametro}",   viewId = "/pages/usuario/usuario_form.xhtml"),

		  @URLMapping(id = "treino_usuario", 			pattern = "/treinousuario",   viewId = "/pages/treinousuario/treinousuario.xhtml"),
		  @URLMapping(id = "treino_usuario_divisao", 			pattern = "/treinousuariodivisao/#{parametro}",   viewId = "/pages/treinousuariodivisao/treinousuariodivisao.xhtml"),
		  @URLMapping(id = "treino_usuario_divisao_exercicio", 	pattern = "/treinousuariodivisaoexercicio/#{parametro}",   viewId = "/pages/treinousuariodivisaoexercicio/treinousuariodivisaoexercicio.xhtml"),
		  @URLMapping(id = "treino_usuario_divisao_exercicio_view", 	pattern = "/treinousuariodivisaoexercicio/view/#{uid}",   viewId = "/pages/treinousuariodivisaoexercicio/treinousuariodivisaoexercicio_view.xhtml"),
		})
public class GeekpumpRotas {
	

}
