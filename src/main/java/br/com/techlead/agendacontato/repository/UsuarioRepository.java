package br.com.techlead.agendacontato.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.techlead.agendacontato.model.Usuario;

/**
* Classe reponsável por realizar as transações com o banco de dados da tabela Usuario.
*
* @author  José Aleixo Araujo Porpino Filho
* @version 1.0
* @since   19/01/2018 
*/
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	Optional<Usuario> findByLogin(String login);
	Collection<Usuario> findByLoginContains(String login);
	Usuario findByLoginAndSenha(String login, String senha);
	Collection<Usuario> findByEmailContains(String email);
	Usuario findOneByLogin(String login);
	
}
