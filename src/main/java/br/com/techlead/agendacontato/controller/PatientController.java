package br.com.techlead.agendacontato.controller;

import br.com.techlead.agendacontato.model.Patient;
import br.com.techlead.agendacontato.service.IPatientService;
import br.com.techlead.agendacontato.utils.HttpMessageEnum;
import br.com.techlead.agendacontato.utils.HttpReturnMessage;
import br.com.techlead.agendacontato.utils.RestUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/api/patients")
public class PatientController extends RestUtils<IPatientService> {

    @GetMapping("{id}")
    Patient findById(@PathVariable("id") Integer id) {
        return this.service.findById(id);
    }

    @GetMapping("")
    Collection<Patient> findAll() {
        return service.findAll();
    }

    @GetMapping("name/{name}")
    Collection<Patient> findByName(@PathVariable("name") String name) {
        return this.service.findByName(name);
    }

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public @ResponseBody
    ResponseEntity<HttpReturnMessage> save(@RequestBody Patient patient) {
        /*patient.setUsuario(new Usuario(1));*/
        this.service.save(patient);
        httpReturnMessage = new HttpReturnMessage(0, HttpMessageEnum.SUCCESS_SAVE.getMessage(), patient);
        return new ResponseEntity<>(httpReturnMessage, HttpStatus.OK);
    }

    @PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
    public @ResponseBody
    ResponseEntity<HttpReturnMessage> update(@PathVariable("id") int idPatient, @RequestBody Patient patient) {
        httpReturnMessage = new HttpReturnMessage(0, HttpMessageEnum.SUCCESS_UPDATE.getMessage(), patient);
        if (this.service.update(patient) == null) {
            httpReturnMessage = new HttpReturnMessage(1, "Registro com id " + patient.getId() + " não encontrado.", patient);
            return new ResponseEntity<>(httpReturnMessage, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(httpReturnMessage, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<HttpReturnMessage> delete(@PathVariable("id") int idPatient) {
        httpReturnMessage = new HttpReturnMessage(0, HttpMessageEnum.SUCCESS_DELETE.getMessage(), idPatient);
        if (this.service.delete(idPatient) == null) {
            httpReturnMessage = new HttpReturnMessage(1, "Registro com id " + idPatient + " não encontrado.", idPatient);
            return new ResponseEntity<>(httpReturnMessage, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(httpReturnMessage, HttpStatus.OK);
    }

}
