package br.com.kmacedo.sisunico.controller;

import br.com.kmacedo.sisunico.model.MycarComponenteModel;
import br.com.kmacedo.sisunico.repository.MycarComponenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MycarComponenteController {

    @Autowired
    private MycarComponenteRepository mycarComponenteRepository;

    //Método para salvar

    @PostMapping(value = "salvarMycarComponente")
    @ResponseBody
    public ResponseEntity<MycarComponenteModel> salvarMycarComponente(@RequestBody MycarComponenteModel mycarComponenteModel) {

        MycarComponenteModel mycarComponente = mycarComponenteRepository.save(mycarComponenteModel);

        return new ResponseEntity<MycarComponenteModel>(mycarComponente, HttpStatus.CREATED);
    }

    //Método atualizar

    @PutMapping(value = "editarMycarComponente")
    @ResponseBody
    public ResponseEntity<?> editarMycarComponente(@RequestBody MycarComponenteModel mycarComponenteModel) {

        if (mycarComponenteModel.getIdcomponente() == 0) {

            return new ResponseEntity<String>("O ID do cadastro não foi informado para a atualização!", HttpStatus.OK);
        }

        MycarComponenteModel component = mycarComponenteRepository.saveAndFlush(mycarComponenteModel);

        return new ResponseEntity<MycarComponenteModel>(component, HttpStatus.OK);
    }

    //Método excluir

    @DeleteMapping(value = "excluirMycarComponente")
    @ResponseBody
    public ResponseEntity<String> excluirMycarComponente(@RequestParam Long idcomponente) {

        mycarComponenteRepository.deleteById(idcomponente);

        return new ResponseEntity<String>("Registro excluído com sucesso!", HttpStatus.OK);
    }

    //Método pesquisar por ID

    @GetMapping(value = "pesquisarMycarComponentePorId")
    @ResponseBody
    public ResponseEntity<MycarComponenteModel> pesquisarMycarComponentePorId(@RequestParam(name = "idcomponente") Long idcomponente) {

        MycarComponenteModel componente = mycarComponenteRepository.findById(idcomponente).get();

        return new ResponseEntity<MycarComponenteModel>(componente, HttpStatus.OK);
    }

    //Método para listar todos os componentes

    @GetMapping(value = "listarTodosMycarComponente")
    @ResponseBody
    public ResponseEntity<List<MycarComponenteModel>> listarTodosMycarComponente() {

        List<MycarComponenteModel> componente = mycarComponenteRepository.findAll();

        return new ResponseEntity<List<MycarComponenteModel>>(componente, HttpStatus.OK);
    }

    //Método para listar por componente

    @GetMapping(value = "listarMycarComponentePorComponente")
    @ResponseBody
    public ResponseEntity<List<MycarComponenteModel>> listarMycarComponentePorComponente(@RequestParam(name = "componente") String componente) {

        List<MycarComponenteModel> mycarComponenteModel = mycarComponenteRepository.buscarPorComponente(componente.trim().toUpperCase());

        return new ResponseEntity<List<MycarComponenteModel>>(mycarComponenteModel, HttpStatus.OK);
    }
}