package br.com.techlead.agendacontato.repository;

import br.com.techlead.agendacontato.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Classe reponsável por realizar as transações com o banco de dados da tabela User.
 *
 * @author José Aleixo Araujo Porpino Filho
 * @version 1.0
 * @since 19/01/2018
 */
@Repository
public interface PersonUserRepository extends JpaRepository<User, Integer> {
    User findByLoginAndPassword(String login, String password);

    User findByLogin(String login);
}
