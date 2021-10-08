package br.com.kmacedo.sisunico.controller;

import br.com.kmacedo.sisunico.model.MycarComponenteModel;
import br.com.kmacedo.sisunico.model.MycarVisitaTecnicaModel;
import br.com.kmacedo.sisunico.repository.MycarVisitaTecnicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MycarVisitaTecnicaController {

    @Autowired
    private MycarVisitaTecnicaRepository mycarVisitaTecnicaRepository;

    //Método para salvar

    @PostMapping(value = "salvarMycarVisitaTecnica")
    @ResponseBody
    public ResponseEntity<MycarVisitaTecnicaModel> salvarMycarVisitaTecnica(@RequestBody MycarVisitaTecnicaModel mycarVisitaTecnicaModel) {

        MycarVisitaTecnicaModel mycarVisitaTecnica = mycarVisitaTecnicaRepository.save(mycarVisitaTecnicaModel);

        return new ResponseEntity<MycarVisitaTecnicaModel>(mycarVisitaTecnica, HttpStatus.CREATED);
    }

    //Método atualizar

    @PutMapping(value = "editarMycarVisitaTecnica")
    @ResponseBody
    public ResponseEntity<?> editarMycarVisitaTecnica(@RequestBody MycarVisitaTecnicaModel mycarVisitaTecnicaModel) {

        if (mycarVisitaTecnicaModel.getIdvisita() == 0) {

            return new ResponseEntity<String>("O ID do cadastro não foi informado para a atualização!", HttpStatus.OK);
        }

        MycarVisitaTecnicaModel visita = mycarVisitaTecnicaRepository.saveAndFlush(mycarVisitaTecnicaModel);

        return new ResponseEntity<MycarVisitaTecnicaModel>(visita, HttpStatus.OK);
    }

    //Método excluir

    @DeleteMapping(value = "excluirMycarVisitaTecnica")
    @ResponseBody
    public ResponseEntity<String> excluirMycarVisitaTecnica(@RequestParam Long idvisita) {

        mycarVisitaTecnicaRepository.deleteById(idvisita);

        return new ResponseEntity<String>("Registro excluído com sucesso!", HttpStatus.OK);
    }

    //Método pesquisar por ID

    @GetMapping(value = "pesquisarMycarVisitaTecnicaPorId")
    @ResponseBody
    public ResponseEntity<MycarVisitaTecnicaModel> pesquisarMycarVisitaTecnicaPorId(@RequestParam(name = "idvisita") Long idvisita) {

        MycarVisitaTecnicaModel visita = mycarVisitaTecnicaRepository.findById(idvisita).get();

        return new ResponseEntity<MycarVisitaTecnicaModel>(visita, HttpStatus.OK);
    }

    //Método para listar todsa as visitas

    @GetMapping(value = "listarTodosMycarVisitaTecnica")
    @ResponseBody
    public ResponseEntity<List<MycarVisitaTecnicaModel>> listarTodosMycarVisitaTecnica() {

        List<MycarVisitaTecnicaModel> visita = mycarVisitaTecnicaRepository.findAll();

        return new ResponseEntity<List<MycarVisitaTecnicaModel>>(visita, HttpStatus.OK);
    }

    //Método para listar por descricao

    @GetMapping(value = "listarMycarVisitaTecnicaPorDescricao")
    @ResponseBody
    public ResponseEntity<List<MycarVisitaTecnicaModel>> listarMycarVisitaTecnicaPorDescricao(@RequestParam(name = "descricaoagendamento") String descricaoagendamento) {

        List<MycarVisitaTecnicaModel> mycarVisitaTecnicaModel = mycarVisitaTecnicaRepository.buscarPorDescricao(descricaoagendamento.trim().toUpperCase());

        return new ResponseEntity<List<MycarVisitaTecnicaModel>>(mycarVisitaTecnicaModel, HttpStatus.OK);
    }
}