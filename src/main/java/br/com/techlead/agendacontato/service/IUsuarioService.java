package br.com.techlead.agendacontato.service;

import java.util.Collection;
import java.util.Optional;

import br.com.techlead.agendacontato.model.Usuario;

/**
* Interface de negócio da entidade Usuario.
*
* @author  José Aleixo Araujo Porpino Filho
* @version 1.0
* @since   21/01/2018 
*/
public interface IUsuarioService {
	/**
	 * Retorna uma entidade Usuario.  
	 *
	 * @param  id chave primária da entidade Usuario
	 * @return      Usuario
	 */
	Usuario findById(int id);
	
	/**
	 * Retorna todos os usuarios.
	 *
	 * @return      Collection<Usuario>
	 */
	Collection<Usuario> findAll();
	
	/**
	 * Retorna uma entidade opcional Usuario.
	 *
	 * @param login
	 * @return Optional<Usuario>
	 */
	Optional<Usuario> findByLogin(String login);
	
	/**
	 * Retorna uma lista de entidades Usuario pelo login.
	 *
	 * @param login
	 * @return Collection<Usuario>
	 */
	Collection<Usuario> findByLoginContains(String login);
	/**
	 * Retorna uma entidade Usuario pelo login e senha.
	 *
	 * @param login
	 * @param senha
	 * @return Usuario
	 */
	Usuario findByLoginSenha(String login, String senha);
	/**
	 * Retorna somente uma entidade Usuario pelo login.
	 *
	 * @param login
	 * @return Usuario
	 */
	Usuario findOneByLogin(String login);
	
	/**
	 * Retorna uma lista de entidades Usuario pelo email.
	 *
	 * @param email
	 * @return Collection<Usuario>
	 */
	Collection<Usuario> findByEmail(String email);
	
	/**
	 * Salva uma entidade Usuario na tabela.
	 *
	 * @param usuario
	 * @return Usuario
	 */
	Usuario salvar(Usuario usuario);
	
	/**
	 * Edita uma entidade Usuario na tabela.
	 *
	 * @param usuario
	 * @return Usuario
	 */
	Usuario editar(Usuario usuario);
	
	/**
	 * Deleta uma entidade Usuario na tabela.
	 *
	 * @param id
	 * @return Integer
	 */
	Integer excluir(int id);
}
