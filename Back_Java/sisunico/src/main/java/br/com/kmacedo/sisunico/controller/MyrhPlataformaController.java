package br.com.kmacedo.sisunico.controller;

import br.com.kmacedo.sisunico.model.MyrhPlataformaModel;
import br.com.kmacedo.sisunico.repository.MyrhPlataformaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyrhPlataformaController {

    @Autowired
    private MyrhPlataformaRepository myrhPlataformaRepository;

    // Método para salvar
    @PostMapping(value = "salvarMyrhPlataforma")
    @ResponseBody
    public ResponseEntity<MyrhPlataformaModel> salvarMyrhPlataforma(@RequestBody MyrhPlataformaModel myrhPlataformaModel) {

        MyrhPlataformaModel plataforma = myrhPlataformaRepository.save(myrhPlataformaModel);

        return new ResponseEntity<MyrhPlataformaModel>(plataforma, HttpStatus.CREATED);
    }

    //Método atualizar

    @PutMapping(value = "editarMyrhPlataforma")
    @ResponseBody
    public ResponseEntity<?> editarMyrhPlataforma(@RequestBody MyrhPlataformaModel myrhPlataformaModel) {

        if (myrhPlataformaModel.getIdplataforma() == 0) {

            return new ResponseEntity<String>("O ID do cadastro não foi informado para a atualização!", HttpStatus.OK);
        }

        MyrhPlataformaModel plataforma = myrhPlataformaRepository.saveAndFlush(myrhPlataformaModel);

        return new ResponseEntity<MyrhPlataformaModel>(plataforma, HttpStatus.OK);
    }

    //Método excluir

    @DeleteMapping(value = "excluirMyrhPlataforma")
    @ResponseBody
    public ResponseEntity<String> excluirMyrhPlataforma(@RequestParam Long idplataforma) {

        myrhPlataformaRepository.deleteById(idplataforma);

        return new ResponseEntity<String>("Registro excluído com sucesso!", HttpStatus.OK);
    }

    //Método pesquisar por ID

    @GetMapping(value = "pesquisarMyrhPlataformaPorId")
    @ResponseBody
    public ResponseEntity<MyrhPlataformaModel> pesquisarMyrhPlataformaPorId(@RequestParam(name = "idplataforma") Long idplataforma) {

        MyrhPlataformaModel plataforma = myrhPlataformaRepository.findById(idplataforma).get();

        return new ResponseEntity<MyrhPlataformaModel>(plataforma, HttpStatus.OK);
    }

    //Método para listar todas as plataformas

    @GetMapping(value = "listarTodosMyrhPlataforma")
    @ResponseBody
    public ResponseEntity<List<MyrhPlataformaModel>> listarTodosMyrhPlataforma() {

        List<MyrhPlataformaModel> plataforma = myrhPlataformaRepository.findAll();

        return new ResponseEntity<List<MyrhPlataformaModel>>(plataforma, HttpStatus.OK);
    }

    //Método para listar por plataforma

    @GetMapping(value = "listarMyrhPlataformaPorPlataforma")
    @ResponseBody
    public ResponseEntity<List<MyrhPlataformaModel>> listarMyrhPlataformaPorPlataforma(@RequestParam(name = "plataforma") String plataforma) {

        List<MyrhPlataformaModel> myrhPlataformaModel = myrhPlataformaRepository.buscarPorPlataforma(plataforma.trim().toUpperCase());

        return new ResponseEntity<List<MyrhPlataformaModel>>(myrhPlataformaModel, HttpStatus.OK);
    }
}