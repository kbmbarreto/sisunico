package br.com.kmacedo.sisunico.controller;

import br.com.kmacedo.sisunico.model.MyrhRecrutadorModel;
import br.com.kmacedo.sisunico.repository.MyrhRecrutadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyrhRecrutadorController {

    @Autowired
    private MyrhRecrutadorRepository myrhRecrutadorRepository;

    // Método para salvar
    @PostMapping(value = "salvarMyrhRecrutador")
    @ResponseBody
    public ResponseEntity<MyrhRecrutadorModel> salvarMyrhRecrutador(@RequestBody MyrhRecrutadorModel myrhRecrutadorModel) {

        MyrhRecrutadorModel recrutador = myrhRecrutadorRepository.save(myrhRecrutadorModel);

        return new ResponseEntity<MyrhRecrutadorModel>(recrutador, HttpStatus.CREATED);
    }

    //Método atualizar

    @PutMapping(value = "editarMyrhRecrutador")
    @ResponseBody
    public ResponseEntity<?> editarMyrhRecrutador(@RequestBody MyrhRecrutadorModel myrhRecrutadorModel) {

        if (myrhRecrutadorModel.getIdrecrutador() == 0) {

            return new ResponseEntity<String>("O ID do cadastro não foi informado para a atualização!", HttpStatus.OK);
        }

        MyrhRecrutadorModel recrutador = myrhRecrutadorRepository.saveAndFlush(myrhRecrutadorModel);

        return new ResponseEntity<MyrhRecrutadorModel>(recrutador, HttpStatus.OK);
    }

    //Método excluir

    @DeleteMapping(value = "excluirMyrhRecrutador")
    @ResponseBody
    public ResponseEntity<String> excluirMyrhRecrutador(@RequestParam Long idrecrutador) {

        myrhRecrutadorRepository.deleteById(idrecrutador);

        return new ResponseEntity<String>("Registro excluído com sucesso!", HttpStatus.OK);
    }

    //Método pesquisar por ID

    @GetMapping(value = "pesquisarMyrhRecrutadorPorId")
    @ResponseBody
    public ResponseEntity<MyrhRecrutadorModel> pesquisarMyrhRecrutadorPorId(@RequestParam(name = "idrecrutador") Long idrecrutador) {

        MyrhRecrutadorModel recrutador = myrhRecrutadorRepository.findById(idrecrutador).get();

        return new ResponseEntity<MyrhRecrutadorModel>(recrutador, HttpStatus.OK);
    }

    //Método para listar todos os recrutadores

    @GetMapping(value = "listarTodosMyrhRecrutador")
    @ResponseBody
    public ResponseEntity<List<MyrhRecrutadorModel>> listarTodosMyrhRecrutador() {

        List<MyrhRecrutadorModel> recrutador = myrhRecrutadorRepository.findAll();

        return new ResponseEntity<List<MyrhRecrutadorModel>>(recrutador, HttpStatus.OK);
    }

    //Método para listar por plataforma

    @GetMapping(value = "listarMyrhRecrutadorPorNome")
    @ResponseBody
    public ResponseEntity<List<MyrhRecrutadorModel>> listarMyrhRecrutadorPorNome(@RequestParam(name = "nome") String nome) {

        List<MyrhRecrutadorModel> myrhRecrutadorModel = myrhRecrutadorRepository.buscarPorNome(nome.trim().toUpperCase());

        return new ResponseEntity<List<MyrhRecrutadorModel>>(myrhRecrutadorModel, HttpStatus.OK);
    }
}