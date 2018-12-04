package br.com.techlead.agendacontato.service;

import br.com.techlead.agendacontato.model.User;

import java.util.Collection;
import java.util.Optional;

/**
* Interface de negócio da entidade User.
*
* @author  José Aleixo Araujo Porpino Filho
* @version 1.0
* @since   21/01/2018 
*/
public interface IPersonUserService {
	/**
	 * Retorna uma entidade User.  
	 *
	 * @param  id chave primária da entidade User
	 * @return      User
	 */
	User findById(int id);


	Collection<User> findAll();

	/**
	 * Retorna uma entidade User pelo login e senha.
	 *
	 * @param login
	 * @param password
	 * @return User
	 */
	User findByLoginPassword(String login, String password);
	
	/**
	 * Salva uma entidade User na tabela.
	 *
	 * @param usuario
	 * @return User
	 */
	User save(User usuario);
	
	/**
	 * Edita uma entidade User na tabela.
	 *
	 * @param usuario
	 * @return User
	 */
	User update(User usuario);
	
	/**
	 * Deleta uma entidade User na tabela.
	 *
	 * @param id
	 * @return Integer
	 */
	Integer delete(int id);

	User findByLogin(String login);
}
