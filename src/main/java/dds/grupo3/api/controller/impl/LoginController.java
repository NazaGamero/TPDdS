package dds.grupo3.api.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
		
	
		@GetMapping("/login")
		public String iniciarSesion() {
			return "login";
		} 
		
}
