package br.com.kmacedo.sisunico.controller;

import br.com.kmacedo.sisunico.model.MyrhCandidaturaModel;
import br.com.kmacedo.sisunico.repository.MyrhCandidaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyrhCandidaturaController {

    @Autowired
    private MyrhCandidaturaRepository myrhCandidaturaRepository;

    // Método para salvar
    @PostMapping(value = "salvarMyrhCandidatura")
    @ResponseBody
    public ResponseEntity<MyrhCandidaturaModel> salvarMyrhCandidatura(@RequestBody MyrhCandidaturaModel myrhCandidaturaModel) {

        MyrhCandidaturaModel candidatura = myrhCandidaturaRepository.save(myrhCandidaturaModel);

        return new ResponseEntity<MyrhCandidaturaModel>(candidatura, HttpStatus.CREATED);
    }

    //Método atualizar

    @PutMapping(value = "editarMyrhCandidatura")
    @ResponseBody
    public ResponseEntity<?> editarMyrhCandidatura(@RequestBody MyrhCandidaturaModel myrhCandidaturaModel) {

        if (myrhCandidaturaModel.getIdcandidatura() == 0) {

            return new ResponseEntity<String>("O ID do cadastro não foi informado para a atualização!", HttpStatus.OK);
        }

        MyrhCandidaturaModel candidatura = myrhCandidaturaRepository.saveAndFlush(myrhCandidaturaModel);

        return new ResponseEntity<MyrhCandidaturaModel>(candidatura, HttpStatus.OK);
    }

    //Método excluir

    @DeleteMapping(value = "excluirMyrhCandidatura")
    @ResponseBody
    public ResponseEntity<String> excluirMyrhCandidatura(@RequestParam Long idcandidatura) {

        myrhCandidaturaRepository.deleteById(idcandidatura);

        return new ResponseEntity<String>("Registro excluído com sucesso!", HttpStatus.OK);
    }

    //Método pesquisar por ID

    @GetMapping(value = "pesquisarMyrhCandidaturaPorId")
    @ResponseBody
    public ResponseEntity<MyrhCandidaturaModel> pesquisarMyrhCandidaturaPorId(@RequestParam(name = "idcandidatura") Long idcandidatura) {

        MyrhCandidaturaModel candidatura = myrhCandidaturaRepository.findById(idcandidatura).get();

        return new ResponseEntity<MyrhCandidaturaModel>(candidatura, HttpStatus.OK);
    }

    //Método para listar todas as candidaturas

    @GetMapping(value = "listarTodosMyrhCandidatura")
    @ResponseBody
    public ResponseEntity<List<MyrhCandidaturaModel>> listarTodosMyrhCandidatura() {

        List<MyrhCandidaturaModel> candidatura = myrhCandidaturaRepository.findAll();

        return new ResponseEntity<List<MyrhCandidaturaModel>>(candidatura, HttpStatus.OK);
    }

    //Método para listar por anotacoes

    @GetMapping(value = "listarMyrhCandidaturaPorAnotacao")
    @ResponseBody
    public ResponseEntity<List<MyrhCandidaturaModel>> listarMyrhCandidaturaPorAnotacao(@RequestParam(name = "anotacoes") String anotacoes) {

        List<MyrhCandidaturaModel> myrhCandidaturaModel = myrhCandidaturaRepository.buscarPorAnotacoes(anotacoes.trim().toUpperCase());

        return new ResponseEntity<List<MyrhCandidaturaModel>>(myrhCandidaturaModel, HttpStatus.OK);
    }
}