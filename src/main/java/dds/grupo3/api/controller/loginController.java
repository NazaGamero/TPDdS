package dds.grupo3.api.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
public interface loginController {

	/*
	 * Retorna la pagina principal de login
	 */
	@GetMapping("")
	public String inicio(); 
	
	/*
	 * Recibe la pagina de login con los datos del usuario y le retorna la pagina con el menu principal
	 */
	@GetMapping("/login")
	public String login(Model paginaLogin);
}
