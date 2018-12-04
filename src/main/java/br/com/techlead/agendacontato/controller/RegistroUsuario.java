package br.com.techlead.agendacontato.controller;

import br.com.techlead.agendacontato.model.User;
import br.com.techlead.agendacontato.service.IPersonUserService;
import br.com.techlead.agendacontato.utils.HttpMessageEnum;
import br.com.techlead.agendacontato.utils.HttpReturnMessage;
import br.com.techlead.agendacontato.utils.RestUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/register")
public class RegistroUsuario extends RestUtils<IPersonUserService> {

    @PostMapping(path = "/save", consumes = "application/json", produces = "application/json")
    public @ResponseBody
    ResponseEntity<Object> save(@RequestBody User user) {
        Collection<User> users = service.findAll();
        for (User u : users) {
            if (u.getLogin().equals(user.getLogin())) {
                return new ResponseEntity<>(
                        new HttpReturnMessage(1, "This login already exist, please choose another one.", user),
                        HttpStatus.OK);
            }
        }

        this.service.save(user);
        return new ResponseEntity<>(new HttpReturnMessage(0, HttpMessageEnum.SUCCESS_SAVE.getMessage(), user),
                HttpStatus.OK);
    }
}
