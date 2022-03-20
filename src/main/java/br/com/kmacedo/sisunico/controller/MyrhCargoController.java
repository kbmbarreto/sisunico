package br.com.kmacedo.sisunico.controller;

import br.com.kmacedo.sisunico.model.MyrhCargoModel;
import br.com.kmacedo.sisunico.repository.MyrhCargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyrhCargoController {

    @Autowired
    private MyrhCargoRepository myrhCargoRepository;

    // Método para salvar
    @PostMapping(value = "salvarMyrhCargo")
    @ResponseBody
    public ResponseEntity<MyrhCargoModel> salvarMyrhCargo(@RequestBody MyrhCargoModel myrhCargoModel) {

        MyrhCargoModel cargo = myrhCargoRepository.save(myrhCargoModel);

        return new ResponseEntity<MyrhCargoModel>(cargo, HttpStatus.CREATED);
    }

    //Método atualizar

    @PutMapping(value = "editarMyrhCargo")
    @ResponseBody
    public ResponseEntity<?> editarMyrhCargo(@RequestBody MyrhCargoModel myrhCargoModel) {

        if (myrhCargoModel.getIdcargo() == 0) {

            return new ResponseEntity<String>("O ID do cadastro não foi informado para a atualização!", HttpStatus.OK);
        }

        MyrhCargoModel cargo = myrhCargoRepository.saveAndFlush(myrhCargoModel);

        return new ResponseEntity<MyrhCargoModel>(cargo, HttpStatus.OK);
    }

    //Método excluir

    @DeleteMapping(value = "excluirMyrhCargo")
    @ResponseBody
    public ResponseEntity<String> excluirMyrhCargo(@RequestParam Long idcargo) {

        myrhCargoRepository.deleteById(idcargo);

        return new ResponseEntity<String>("Registro excluído com sucesso!", HttpStatus.OK);
    }

    //Método pesquisar por ID

    @GetMapping(value = "pesquisarMyrhCargoPorId")
    @ResponseBody
    public ResponseEntity<MyrhCargoModel> pesquisarMyrhCargoPorId(@RequestParam(name = "idcargo") Long idcargo) {

        MyrhCargoModel cargo = myrhCargoRepository.findById(idcargo).get();

        return new ResponseEntity<MyrhCargoModel>(cargo, HttpStatus.OK);
    }

    //Método para listar todos os cargos

    @GetMapping(value = "listarTodosMyrhCargo")
    @ResponseBody
    public ResponseEntity<List<MyrhCargoModel>> listarTodosMyrhCargo() {

        List<MyrhCargoModel> cargo = myrhCargoRepository.findAll();

        return new ResponseEntity<List<MyrhCargoModel>>(cargo, HttpStatus.OK);
    }

    //Método para listar por cargo

    @GetMapping(value = "listarMyrhCargoPorCargo")
    @ResponseBody
    public ResponseEntity<List<MyrhCargoModel>> listarMyrhCargoPorCargo(@RequestParam(name = "cargo") String cargo) {

        List<MyrhCargoModel> myrhCargoModel = myrhCargoRepository.buscarPorCargo(cargo.trim().toUpperCase());

        return new ResponseEntity<List<MyrhCargoModel>>(myrhCargoModel, HttpStatus.OK);
    }
}