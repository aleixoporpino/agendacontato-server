package br.com.techlead.agendacontato.service;

import java.util.Collection;

import br.com.techlead.agendacontato.model.Contato;
import br.com.techlead.agendacontato.model.Usuario;

/**
* Interface de negócio da entidade Contato.
*
* @author  José Aleixo Araujo Porpino Filho
* @version 1.0
* @since   21/01/2018 
*/
public interface IContatoService {
	/**
	 * Retorna uma entidade Contato.  
	 *
	 * @param  id chave primária da entidade Contato
	 * @return      Contato
	 */
	Contato findById(int id);
	
	/**
	 * Retorna todos os contatos.
	 *
	 * @return      Collection<Contato>
	 */
	Collection<Contato> findAll();
	
	/**
	 * Retorna uma lista de entidade Contato por Usuario.
	 *
	 * @param 		Usuario
	 * @return      Collection<Contato>
	 */
	Collection<Contato> findByUsuario(Usuario usuario);
	
	/**
	 * Retorna uma lista de entidade Contato por nome.
	 *
	 * @param 		nome
	 * @return      Collection<Contato>
	 */
	Collection<Contato> findByNome(String nome);
	
	/**
	 * Retorna uma lista de entidade Contato por nome e Usuario.
	 *
	 * @param 		nome
	 * @param 		Usuario
	 * @return      Collection<Contato>
	 */
	Collection<Contato> findByNomeAndUsuario(String nome, Usuario usuario);
	
	/**
	 * Retorna uma lista de entidade Contato por sobrenome.
	 *
	 * @param 		sobrenome
	 * @return      Collection<Contato>
	 */
	Collection<Contato> findBySobrenome(String sobrenome);
	
	/**
	 * Retorna uma lista de entidade Contato por nome e sobrenome.
	 *
	 * @param 		sobrenome
	 * @return      Collection<Contato>
	 */
	Collection<Contato> findByNomeAndSobrenome(String nome, String sobrenome);
	
	/**
	 * Salva uma entidade Usuario na tabela.
	 *
	 * @param usuario
	 * @return Usuario
	 */
	Contato salvar(Contato contato);
	
	/**
	 * Editar uma entidade Usuario na tabela.
	 *
	 * @param usuario
	 * @return Usuario
	 */
	Contato editar(Contato contato);
	
	/**
	 * Excluir uma entidade Usuario na tabela.
	 *
	 * @param usuario
	 * @return Integer
	 */
	Integer excluir(int id);
}
