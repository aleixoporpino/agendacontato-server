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

import br.com.techlead.agendacontato.model.Contato;
import br.com.techlead.agendacontato.model.Usuario;
import br.com.techlead.agendacontato.service.IContatoService;
import br.com.techlead.agendacontato.utils.HttpMessageEnum;
import br.com.techlead.agendacontato.utils.HttpReturnMessage;
import br.com.techlead.agendacontato.utils.RestUtils;


@RestController
@RequestMapping("/api/contato")
public class ContatoController extends RestUtils<IContatoService>{
	
	@GetMapping("{id}")
	Contato findById(@PathVariable("id") Integer id) {
		return this.service.findById(id);
	}

	@GetMapping("")
	Collection<Contato> findAll() {
		return service.findAll();
	}

	@GetMapping("pornome/{nome}")
	Collection<Contato> findByLogin(@PathVariable("nome") String nome) {
		return this.service.findByNome(nome);
	}
	
	@GetMapping("pornome/{nome}/{idUsuario}")
	Collection<Contato> findByLogin(@PathVariable("nome") String nome,@PathVariable("idUsuario") int idUsuario) {
		return this.service.findByNomeAndUsuario(nome, new Usuario(idUsuario));
	}

	@GetMapping("porsobrenome/{sobrenome}")
	Collection<Contato> findBySobrenome(@PathVariable("sobrenome") String sobrenome) {
		return this.service.findBySobrenome(sobrenome);
	}
	
	@GetMapping("pornomes/{nome}/{sobrenome}")
	Collection<Contato> findByNomeSobrenome(@PathVariable("nome") String nome,@PathVariable("sobrenome") String sobrenome) {
		return this.service.findByNomeAndSobrenome(nome, sobrenome);
	}
	
	@GetMapping("porusuario/{idUsuario}")
	Collection<Contato> findByEmail(@PathVariable("idUsuario") int idUsuario) {
		return this.service.findByUsuario(new Usuario(1));
	}

	@PostMapping(path = "/salvar", consumes = "application/json", produces = "application/json")
	public @ResponseBody ResponseEntity<HttpReturnMessage> save(@RequestBody Contato contato) {
		contato.setUsuario(new Usuario(1));
		this.service.salvar(contato);
		httpReturnMessage = new HttpReturnMessage(0, HttpMessageEnum.SUCCESS_SAVE.getMessage(), contato);
	    return new ResponseEntity<HttpReturnMessage>(httpReturnMessage, HttpStatus.OK);
	}
	
	@PutMapping(path = "/editar/{idContato}", consumes = "application/json", produces = "application/json")
	public @ResponseBody ResponseEntity<HttpReturnMessage> update(@PathVariable("idContato") int idContato, @RequestBody Contato contato) {
		httpReturnMessage = new HttpReturnMessage(0, HttpMessageEnum.SUCCESS_UPDATE.getMessage(), contato);
		if (this.service.editar(contato) == null) {
			httpReturnMessage = new HttpReturnMessage(1, "Registro com id " + contato.getIdContato() + " não encontrado.", contato);
			return new ResponseEntity<HttpReturnMessage>(httpReturnMessage, HttpStatus.NOT_FOUND);
		}
	    return new ResponseEntity<HttpReturnMessage>(httpReturnMessage, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/excluir/{idContato}")
	public ResponseEntity<HttpReturnMessage> delete(@PathVariable("idContato") int idContato) {
		httpReturnMessage = new HttpReturnMessage(0, HttpMessageEnum.SUCCESS_DELETE.getMessage(), new Integer(idContato));
		if (this.service.excluir(idContato) == null) {
			httpReturnMessage = new HttpReturnMessage(1, "Registro com id " + idContato + " não encontrado.", new Integer(idContato));
			return new ResponseEntity<HttpReturnMessage>(httpReturnMessage,HttpStatus.NOT_FOUND);
		}
	    return new ResponseEntity<HttpReturnMessage>(httpReturnMessage, HttpStatus.OK);
	}
	
}
