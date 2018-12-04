package br.com.techlead.agendacontato.controller;

import br.com.techlead.agendacontato.model.User;
import br.com.techlead.agendacontato.service.IPersonUserService;
import br.com.techlead.agendacontato.utils.HttpMessageEnum;
import br.com.techlead.agendacontato.utils.HttpReturnMessage;
import br.com.techlead.agendacontato.utils.RestUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/user")
public class PersonUserController extends RestUtils<IPersonUserService> {

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @GetMapping("{id}")
    User findById(@PathVariable("id") Integer id) {
        return this.service.findById(id);
    }

    @GetMapping("login/{login}/{password}")
    User findByLoginSenha(@PathVariable("login") String login, @PathVariable("password") String password) {
        User user = this.service.findByLogin(login);
        if (user != null) {
            if(getPasswordEncoder().matches(password, user.getPassword())){
                return user;
            }
        }
        return null;
    }

    @PostMapping(path = "/save", consumes = "application/json", produces = "application/json")
    public @ResponseBody
    ResponseEntity<Object> save(@RequestBody User user) {
        Collection<User> users = service.findAll();
        for (User u : users) {
            if (u.getLogin().equals(user.getLogin())) {
                return new ResponseEntity<>(
                        new HttpReturnMessage(1, "This user already exists.", user),
                        HttpStatus.CONFLICT);
            }
        }

        this.service.save(user);
        return new ResponseEntity<>(new HttpReturnMessage(0, HttpMessageEnum.SUCCESS_SAVE.getMessage(), user), HttpStatus.OK);
    }

}
