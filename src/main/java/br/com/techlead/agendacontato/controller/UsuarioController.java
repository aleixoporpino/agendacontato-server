package br.com.techlead.agendacontato.controller;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@RequestMapping("/api/usuario")
public class UsuarioController extends RestUtils<IUsuarioService> {

	@GetMapping("{id}")
	Usuario findById(@PathVariable("id") Integer id) {
		return this.service.findById(id);
	}

	@GetMapping("")
	Collection<Usuario> findAll() {
		return service.findAll();
	}

	@GetMapping("porlogin/{login}")
	Usuario findByLogin(@PathVariable("login") String login) {
		return this.service.findOneByLogin(login);
	}

	@GetMapping("porlogincontains/{login}")
	Collection<Usuario> findByLoginContains(@PathVariable("login") String login) {
		return this.service.findByLoginContains(login);
	}

	@GetMapping("porloginsenha/{login}/{senha}")
	Usuario findByLoginSenha(@PathVariable("login") String login, @PathVariable("senha") String senha) {
		return this.service.findByLoginSenha(login, senha);
	}

	@GetMapping("poremail/{email}")
	Collection<Usuario> findByEmail(@PathVariable("email") String email) {
		return this.service.findByEmail(email);
	}

	@PostMapping(path = "/salvar", consumes = "application/json", produces = "application/json")
	public @ResponseBody ResponseEntity<Object> save(@RequestBody Usuario usuario) {
		Collection<Usuario> usuarios = findAll();
		for (Usuario u : usuarios) {
			if (u.getLogin().equals(usuario.getLogin())) {
				return new ResponseEntity<Object>(
						new HttpReturnMessage(1, "Login já existente, por favor preencha um outro.", usuario),
						HttpStatus.CONFLICT);
			}
		}

		this.service.salvar(usuario);
		return new ResponseEntity<Object>(new HttpReturnMessage(0, HttpMessageEnum.SUCCESS_SAVE.getMessage(), usuario), HttpStatus.OK);
	}

	@PutMapping(path = "/editar", consumes = "application/json", produces = "application/json")
	public @ResponseBody ResponseEntity<String> update(@RequestBody Usuario usuario) {
		httpReturnMessage = new HttpReturnMessage(0, HttpMessageEnum.SUCCESS_UPDATE.getMessage(), usuario);
		if (this.service.editar(usuario) == null) {
			httpReturnMessage = new HttpReturnMessage(1,
					"Registro com id " + usuario.getIdUsuario() + " não encontrado.", usuario);
			return new ResponseEntity<String>(httpReturnMessage.toString(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(httpReturnMessage.toString(), HttpStatus.OK);
	}

	@DeleteMapping(path = "/excluir/{idUsuario}")
	public ResponseEntity<String> delete(@PathVariable("idUsuario") int idUsuario) {
		httpReturnMessage = new HttpReturnMessage(0, HttpMessageEnum.SUCCESS_DELETE.getMessage(),
				new Integer(idUsuario));
		if (this.service.excluir(idUsuario) == null) {
			httpReturnMessage = new HttpReturnMessage(1, "Registro com id " + idUsuario + " não encontrado.",
					new Integer(idUsuario));
			return new ResponseEntity<String>("Registro com id " + idUsuario + " não encontrado.",
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(httpReturnMessage.toString(), HttpStatus.OK);
	}

}
