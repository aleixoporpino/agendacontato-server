package br.com.techlead.agendacontato.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.techlead.agendacontato.model.Contato;
import br.com.techlead.agendacontato.model.Usuario;
import br.com.techlead.agendacontato.repository.ContatoRepository;

/**
* Classe de negócio da entidade Contato.
*
* @author  José Aleixo Araujo Porpino Filho
* @version 1.0
* @since   19/01/2018 
*/
@Service
public class ContatoService implements IContatoService {
	@Autowired
	private ContatoRepository contatoRepository;

	@Transactional(readOnly = true)
	public Contato findById(int id) {
		return contatoRepository.findOne(id);
	}

	@Transactional(readOnly = true)
	public Collection<Contato> findAll() {
		return contatoRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Collection<Contato> findByUsuario(Usuario usuario) {
		return contatoRepository.findByUsuario(usuario);
	}

	@Transactional(readOnly = true)
	public Collection<Contato> findByNome(String nome) {
		return contatoRepository.findByNomeContains(nome);
	}
	
	@Transactional(readOnly = true)
	public Collection<Contato> findByNomeAndUsuario(String nome, Usuario usuario) {
		return contatoRepository.findByNomeContainsAndUsuario(nome, usuario);
	}

	@Transactional(readOnly = true)
	public Collection<Contato> findBySobrenome(String sobrenome) {
		return contatoRepository.findBySobrenomeContains(sobrenome);
	}
	
	@Override
	public Collection<Contato> findByNomeAndSobrenome(String nome, String sobrenome) {
		return contatoRepository.findByNomeAndSobrenomeContains(nome,sobrenome);
	}

	@Transactional
	public Contato salvar(Contato contato) {
		contatoRepository.save(contato);
		return contato;
	}

	@Transactional
	public Contato editar(Contato contato) {
		//TODO: verificar se já não existe um contato
		Collection<Contato> contatos = findAll();
		for (Contato c : contatos) {
			if (c.getIdContato().equals(contato.getIdContato())) {
				contatoRepository.save(contato);
				return contato;
			}
		}
		return null;
	}

	@Transactional
	public Integer excluir(int id) {
		Collection<Contato> contatos = findAll();
		for (Contato c : contatos) {
			if (c.getIdContato().equals(id)) {
				contatoRepository.delete(id);
				return id;
			}
		}
		return null;
	}

}
