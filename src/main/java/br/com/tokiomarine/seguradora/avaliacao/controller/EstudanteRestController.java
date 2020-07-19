package br.com.tokiomarine.seguradora.avaliacao.controller;

import br.com.tokiomarine.seguradora.avaliacao.dto.EstudanteCreateDTO;
import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.service.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("api/v1/estudantes")
@RestController
public class EstudanteRestController {
    @Autowired
    private EstudanteService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Estudante> createUser(@RequestBody @Valid EstudanteCreateDTO dto) {
        try {
            Estudante e = this.service.cadastrarEstudante(dto.toEstudante());

            return new ResponseEntity<>(e, HttpStatus.CREATED);

        } catch (Exception e) {
            Map<String, String> response = new HashMap<String, String>();
            response.put("error", e.toString());
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Estudante> updateUser(@PathVariable("id") long id, @RequestBody @Valid EstudanteCreateDTO dto) {
        try {
            Estudante e = dto.toEstudante();
            e.setId(id);

            this.service.atualizarEstudante(e);

            return new ResponseEntity<>(e, HttpStatus.CREATED);

        } catch (Exception e) {
            Map<String, String> response = new HashMap<String, String>();
            response.put("error", e.toString());
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Estudante>> listAll() {
        try {
            List<Estudante> list = this.service.buscarEstudantes();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> response = new HashMap<String, String>();
            response.put("error", e.toString());
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Estudante> delete(@PathVariable("id") long id) {
        try {
            Estudante e = this.service.buscarEstudante(id);
            this.service.removerEstudante(id);

            return new ResponseEntity<>(e, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> response = new HashMap<String, String>();
            response.put("error", e.toString());
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
