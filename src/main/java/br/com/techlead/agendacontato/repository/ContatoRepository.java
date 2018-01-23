package br.com.techlead.agendacontato.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.techlead.agendacontato.model.Contato;
import br.com.techlead.agendacontato.model.Usuario;

/**
* Classe reponsável por realizar as transações com o banco de dados da tabela Contato.
*
* @author  José Aleixo Araujo Porpino Filho
* @version 1.0
* @since   19/01/2018 
*/
@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer>{
	Collection<Contato> findByUsuario(Usuario usuario);
	Collection<Contato> findByNomeContains(String nome);
	Collection<Contato> findBySobrenomeContains(String sobrenome);
	Collection<Contato> findByNomeAndSobrenomeContains(String nome, String sobrenome);
	Collection<Contato> findByNomeContainsAndUsuario(String nome, Usuario usuario);
}
