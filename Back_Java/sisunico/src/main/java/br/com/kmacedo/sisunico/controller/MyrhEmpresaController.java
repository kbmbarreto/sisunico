package br.com.kmacedo.sisunico.controller;

import br.com.kmacedo.sisunico.model.MyrhEmpresaModel;
import br.com.kmacedo.sisunico.repository.MyrhEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyrhEmpresaController {

    @Autowired
    private MyrhEmpresaRepository myrhEmpresaRepository;

    // Método para salvar
    @PostMapping(value = "salvarMyrhEmpresa")
    @ResponseBody
    public ResponseEntity<MyrhEmpresaModel> salvarMyrhEmpresa(@RequestBody MyrhEmpresaModel myrhEmpresaModel) {

        MyrhEmpresaModel empresa = myrhEmpresaRepository.save(myrhEmpresaModel);

        return new ResponseEntity<MyrhEmpresaModel>(empresa, HttpStatus.CREATED);
    }

    //Método atualizar

    @PutMapping(value = "editarMyrhEmpresa")
    @ResponseBody
    public ResponseEntity<?> editarMyrhEmpresa(@RequestBody MyrhEmpresaModel myrhEmpresaModel) {

        if (myrhEmpresaModel.getIdempresa() == 0) {

            return new ResponseEntity<String>("O ID do cadastro não foi informado para a atualização!", HttpStatus.OK);
        }

        MyrhEmpresaModel empresa = myrhEmpresaRepository.saveAndFlush(myrhEmpresaModel);

        return new ResponseEntity<MyrhEmpresaModel>(empresa, HttpStatus.OK);
    }

    //Método excluir

    @DeleteMapping(value = "excluirMyrhEmpresa")
    @ResponseBody
    public ResponseEntity<String> excluirMyrhEmpresa(@RequestParam Long idempresa) {

        myrhEmpresaRepository.deleteById(idempresa);

        return new ResponseEntity<String>("Registro excluído com sucesso!", HttpStatus.OK);
    }

    //Método pesquisar por ID

    @GetMapping(value = "pesquisarMyrhEmpresaPorId")
    @ResponseBody
    public ResponseEntity<MyrhEmpresaModel> pesquisarMyrhEmpresaPorId(@RequestParam(name = "idempresa") Long idempresa) {

        MyrhEmpresaModel empresa = myrhEmpresaRepository.findById(idempresa).get();

        return new ResponseEntity<MyrhEmpresaModel>(empresa, HttpStatus.OK);
    }

    //Método para listar todas as empresas

    @GetMapping(value = "listarTodosMyrhEmpresa")
    @ResponseBody
    public ResponseEntity<List<MyrhEmpresaModel>> listarTodosMyrhEmpresa() {

        List<MyrhEmpresaModel> empresa = myrhEmpresaRepository.findAll();

        return new ResponseEntity<List<MyrhEmpresaModel>>(empresa, HttpStatus.OK);
    }

    //Método para listar por empresa

    @GetMapping(value = "listarMyrhEmpresaPorEmpresa")
    @ResponseBody
    public ResponseEntity<List<MyrhEmpresaModel>> listarMyrhEmpresaPorEmpresa(@RequestParam(name = "empresa") String empresa) {

        List<MyrhEmpresaModel> myrhEmpresaModel = myrhEmpresaRepository.buscarPorEmpresa(empresa.trim().toUpperCase());

        return new ResponseEntity<List<MyrhEmpresaModel>>(myrhEmpresaModel, HttpStatus.OK);
    }
}