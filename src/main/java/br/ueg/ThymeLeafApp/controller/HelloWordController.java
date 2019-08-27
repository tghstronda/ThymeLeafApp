/**
 * 
 */
package br.ueg.ThymeLeafApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author tghstronda
 *
 */

@Controller
public class HelloWordController {
	
	@GetMapping("/")//pega os dados da pagina html
	public ModelAndView mostraIndex() // metodo que atende a requisição barra
	{
		//ModelAndView= /cria os modelos de visão
		ModelAndView model = new ModelAndView("index");//model vai trazzer o metdo index
		return model;// retornando o index
	}
	
}
