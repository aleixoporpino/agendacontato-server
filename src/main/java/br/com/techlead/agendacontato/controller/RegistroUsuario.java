package br.com.techlead.agendacontato.controller;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.techlead.agendacontato.model.Usuario;
import br.com.techlead.agendacontato.service.IUsuarioService;
import br.com.techlead.agendacontato.utils.HttpMessageEnum;
import br.com.techlead.agendacontato.utils.HttpReturnMessage;
import br.com.techlead.agendacontato.utils.RestUtils;

@RestController
@RequestMapping("/registro")
public class RegistroUsuario extends RestUtils<IUsuarioService> {

	@PostMapping(path = "/salvar", consumes = "application/json", produces = "application/json")
	public @ResponseBody ResponseEntity<Object> save(@RequestBody Usuario usuario) {
		Collection<Usuario> usuarios = service.findAll();
		for (Usuario u : usuarios) {
			if (u.getLogin().equals(usuario.getLogin())) {
				return new ResponseEntity<Object>(
						new HttpReturnMessage(1, "Login já existente, por favor escolha outro.", usuario),
						HttpStatus.OK);
			}
		}

		this.service.salvar(usuario);
		return new ResponseEntity<Object>(new HttpReturnMessage(0, HttpMessageEnum.SUCCESS_SAVE.getMessage(), usuario),
				HttpStatus.OK);
	}
}
