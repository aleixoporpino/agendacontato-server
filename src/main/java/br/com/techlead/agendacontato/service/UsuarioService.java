package br.com.techlead.agendacontato.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.techlead.agendacontato.model.Usuario;
import br.com.techlead.agendacontato.repository.UsuarioRepository;
import br.com.techlead.agendacontato.security.CustomUserDetails;

/**
* Classe de negócio da entidade Usuario.
*
* @author  José Aleixo Araujo Porpino Filho
* @version 1.0
* @since   19/01/2018 
*/
@Service
public class UsuarioService implements UserDetailsService,IUsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
	
	@Transactional(readOnly = true)
	public Usuario findById(int id) {
		return usuarioRepository.findOne(id);
	}

	@Transactional(readOnly = true)
	public Collection<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Optional<Usuario> usersOptional = usuarioRepository.findByLogin(login);
        usersOptional
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrato"));
        return usersOptional
                .map(CustomUserDetails::new)
                .get();
	}
	
	@Transactional(readOnly = true)
	public Usuario findOneByLogin(String login) {
		return usuarioRepository.findOneByLogin(login);
	}
	
	@Transactional(readOnly = true)
	public Optional<Usuario> findByLogin(String login) {
		return usuarioRepository.findByLogin(login);
	}

	@Transactional(readOnly = true)
	public Collection<Usuario> findByLoginContains(String login) {
		return usuarioRepository.findByLoginContains(login);
	}

	@Transactional(readOnly = true)
	public Usuario findByLoginSenha(String login, String senha) {
		return usuarioRepository.findByLoginAndSenha(login, senha);
	}
	
	@Transactional(readOnly = true)
	public Collection<Usuario> findByEmail(String email) {
		return usuarioRepository.findByEmailContains(email);
	}
	
	@Transactional
	public Usuario salvar(Usuario usuario) {
		usuario.setSenha(getPasswordEncoder().encode(usuario.getSenha()));
		usuarioRepository.save(usuario);
		return usuario;
	}

	@Transactional
	public Usuario editar(Usuario usuario) {
		Collection<Usuario> usuarios = findAll();
		for (Usuario c : usuarios) {
			if (c.getIdUsuario().equals(usuario.getIdUsuario())) {
				usuarioRepository.save(usuario);
				return usuario;
			}
		}
		return null;
	}

	@Transactional
	public Integer excluir(int id) {
		Collection<Usuario> usuarios = findAll();
		for (Usuario c : usuarios) {
			if (c.getIdUsuario().equals(id)) {
				usuarioRepository.delete(id);
				return id;
			}
		}
		return null;
	}

	

}
