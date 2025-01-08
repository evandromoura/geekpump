package br.com.geekpump.view;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

@URLMappings(mappings={
		  @URLMapping(id = "exercicio_list", 			 pattern = "/exercicio",   viewId = "/pages/exercicio/exercicio_list.xhtml"),
		  @URLMapping(id = "exercicio_edit", 			 pattern = "/exercicio/edit/#{parametro}",   viewId = "/pages/exercicio/exercicio_form.xhtml"),
		})
public class GeekpumpRotas {
	

}
