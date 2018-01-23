package br.com.techlead.agendacontato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.techlead.agendacontato.model.Perfil;

/**
* Classe reponsável por realizar as transações com o banco de dados da tabela Perfil.
*
* @author  José Aleixo Araujo Porpino Filho
* @version 1.0
* @since   19/01/2018 
*/
@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Integer>{
	
}
