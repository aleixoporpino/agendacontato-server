package br.com.techlead.agendacontato.service;

import br.com.techlead.agendacontato.model.User;
import br.com.techlead.agendacontato.repository.PersonUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Classe de negócio da entidade User.
 *
 * @author José Aleixo Araujo Porpino Filho
 * @version 1.0
 * @since 19/01/2018
 */
@Service
public class PersonUserService implements IPersonUserService {

    @Autowired
    private PersonUserRepository personUserRepository;

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Transactional(readOnly = true)
    public User findById(int id) {
        return personUserRepository.findOne(id);
    }

    @Transactional(readOnly = true)
    public Collection<User> findAll() {
        return personUserRepository.findAll();
    }

    @Transactional(readOnly = true)
    public User findByLoginPassword(String login, String password) {
        return personUserRepository.findByLoginAndPassword(login, password);
    }
    @Transactional(readOnly = true)
    public User findByLogin(String login) {
        return personUserRepository.findByLogin(login);
    }

    @Transactional
    public User save(User user) {
        user.setPassword(getPasswordEncoder().encode(user.getPassword()));
        personUserRepository.save(user);
        return user;
    }

    @Transactional
    public User update(User usuario) {
        Collection<User> usuarios = findAll();
        for (User c : usuarios) {
            if (c.getId().equals(usuario.getId())) {
                personUserRepository.save(usuario);
                return usuario;
            }
        }
        return null;
    }

    @Transactional
    public Integer delete(int id) {
        Collection<User> usuarios = findAll();
        for (User c : usuarios) {
            if (c.getId().equals(id)) {
                personUserRepository.delete(id);
                return id;
            }
        }
        return null;
    }

}
