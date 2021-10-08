package br.com.kmacedo.sisunico.controller;

import br.com.kmacedo.sisunico.model.MycarFabricanteModel;
import br.com.kmacedo.sisunico.repository.MycarFabricanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MycarFabricanteController {

    @Autowired
    private MycarFabricanteRepository mycarFabricanteRepository;

    //Método para salvar Fabricante

    @PostMapping(value = "salvarMycarFabricante")
    @ResponseBody
    public ResponseEntity<MycarFabricanteModel> salvarMycarFabricante(@RequestBody MycarFabricanteModel mycarFabricanteModel) {
        MycarFabricanteModel mycarFabricante = mycarFabricanteRepository.save(mycarFabricanteModel);

        return new ResponseEntity<MycarFabricanteModel>(mycarFabricante, HttpStatus.CREATED);
    }

    //Método para atualizar o fabricante

    @PutMapping(value = "editarMycarFabricante")
    @ResponseBody
    public ResponseEntity<?> editarMycarFabricante(@RequestBody MycarFabricanteModel mycarFabricanteModel) {

        if (mycarFabricanteModel.getIdfabricante() == 0) {

            return new ResponseEntity<String>("O ID do cadastro não foi informado para a atualização!", HttpStatus.OK);
        }

        MycarFabricanteModel fabricante = mycarFabricanteRepository.saveAndFlush(mycarFabricanteModel);

        return new ResponseEntity<MycarFabricanteModel>(fabricante, HttpStatus.OK);
    }

    //Método para excluir fabricante

    @DeleteMapping(value = "excluirMycarFabricante")
    @ResponseBody
    public ResponseEntity<String> excluirMycarFabricante(@RequestParam Long idfabricante) {

        mycarFabricanteRepository.deleteById(idfabricante);

        return new ResponseEntity<String>("Registro excluído com sucesso!", HttpStatus.OK);
    }

    //Método para pesquisar por ID

    @GetMapping(value = "pesquisarMycarFabricantePorId")
    @ResponseBody
    public ResponseEntity<MycarFabricanteModel> pesquisarMycarFabricantePorId(@RequestParam(name = "idfabricante") Long idfabricante) {

        MycarFabricanteModel fabricante = mycarFabricanteRepository.findById(idfabricante).get();

        return new ResponseEntity<MycarFabricanteModel>(fabricante, HttpStatus.OK);
    }

    //Método para listar os fabricantes

    @GetMapping(value = "listarTodosMycarFabricante")
    @ResponseBody
    public ResponseEntity<List<MycarFabricanteModel>> listarTodosMycarFabricante() {

        //List<MycarFabricanteModel> fabricante = mycarFabricanteRepository.exibirFabricante();
        List<MycarFabricanteModel> fabricante = mycarFabricanteRepository.findAll();

        return new ResponseEntity<List<MycarFabricanteModel>>(fabricante, HttpStatus.OK);
    }

    //Método para listar por fabricante

    @GetMapping(value = "listarMycarFabricantePorFabricante")
    @ResponseBody
    public ResponseEntity<List<MycarFabricanteModel>> listarMycarFabricantePorFabricante(@RequestParam(name = "fabricante") String fabricante) {

        List<MycarFabricanteModel> mycarFabricanteModel = mycarFabricanteRepository.buscarPorFabricante(fabricante.trim().toUpperCase());

        return new ResponseEntity<List<MycarFabricanteModel>>(mycarFabricanteModel, HttpStatus.OK);
    }
}
