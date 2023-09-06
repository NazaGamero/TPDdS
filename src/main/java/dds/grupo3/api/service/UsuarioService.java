package dds.grupo3.api.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import dds.grupo3.api.dto.Usuario;
import dds.grupo3.api.dto.request.UsuarioRegistroDTO;

public interface UsuarioService extends UserDetailsService {

	public Usuario guardar(UsuarioRegistroDTO registroDTO);
}
