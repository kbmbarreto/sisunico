package br.com.kmacedo.sisunico.controller;

import br.com.kmacedo.sisunico.model.MycarOficinaModel;
import br.com.kmacedo.sisunico.repository.MycarOficinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MycarOficinaController {

    @Autowired
    private MycarOficinaRepository mycarOficinaRepository;

    //Método para salvar Oficina

    @PostMapping(value = "salvarMycarOficina")
    @ResponseBody
    public ResponseEntity<MycarOficinaModel> salvarMycarOficina(@RequestBody MycarOficinaModel mycarOficinaModel) {
        MycarOficinaModel mycarOficina = mycarOficinaRepository.save(mycarOficinaModel);

        return new ResponseEntity<MycarOficinaModel>(mycarOficina, HttpStatus.CREATED);
    }

    //Método para atualizar Oficina

    @PutMapping(value = "editarMycarOficina")
    @ResponseBody
    public ResponseEntity<?> editarMycarOficina(@RequestBody MycarOficinaModel mycarOficinaModel) {

        if (mycarOficinaModel.getIdoficina() == 0) {

            return new ResponseEntity<String>("O ID do cadastro não foi informado para a atualização!", HttpStatus.OK);
        }

        MycarOficinaModel oficina = mycarOficinaRepository.saveAndFlush(mycarOficinaModel);

        return new ResponseEntity<MycarOficinaModel>(oficina, HttpStatus.OK);
    }

    //Método para excluir oficina

    @DeleteMapping(value = "excluirMycarOficina")
    @ResponseBody
    public ResponseEntity<String> excluirMycarOficina(@RequestParam Long idoficina) {

        mycarOficinaRepository.deleteById(idoficina);

        return new ResponseEntity<String>("Registro excluído com sucesso!", HttpStatus.OK);
    }

    //Método para pesquisar por ID

    @GetMapping(value = "pesquisarMycarOficinaPorId")
    @ResponseBody
    public ResponseEntity<MycarOficinaModel> pesquisarMycarOficinaPorId(@RequestParam(name = "idoficina") Long idoficina) {

        MycarOficinaModel oficina = mycarOficinaRepository.findById(idoficina).get();

        return new ResponseEntity<MycarOficinaModel>(oficina, HttpStatus.OK);
    }

    //Método para listar todas as oficinas

    @GetMapping(value = "listarTodosMycarOficina")
    @ResponseBody
    public ResponseEntity<List<MycarOficinaModel>> listarTodosMycarOficina() {

        List<MycarOficinaModel> oficina = mycarOficinaRepository.findAll();

        return new ResponseEntity<List<MycarOficinaModel>>(oficina, HttpStatus.OK);
    }

    //Método para listar por oficina

    @GetMapping(value = "listarMycarOficinaPorOficina")
    @ResponseBody
    public ResponseEntity<List<MycarOficinaModel>> listarMycarOficinaPorOficina(@RequestParam(name = "oficina") String oficina) {

        List<MycarOficinaModel> mycarOficinaModel = mycarOficinaRepository.buscarPorOficina(oficina.trim().toUpperCase());

        return new ResponseEntity<List<MycarOficinaModel>>(mycarOficinaModel, HttpStatus.OK);
    }
}