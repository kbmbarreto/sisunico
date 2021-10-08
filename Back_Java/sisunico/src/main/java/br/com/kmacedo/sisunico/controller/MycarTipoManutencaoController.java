package br.com.kmacedo.sisunico.controller;

import br.com.kmacedo.sisunico.model.MycarTipoManutencaoModel;
import br.com.kmacedo.sisunico.repository.MycarTipoManutencaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MycarTipoManutencaoController {

    @Autowired
    private MycarTipoManutencaoRepository mycarTipoManutencaoRepository;

    //Método para salvar

    @PostMapping(value = "salvarMycarTipoManutencao")
    @ResponseBody
    public ResponseEntity<MycarTipoManutencaoModel> salvarMycarTipoManutencao(@RequestBody MycarTipoManutencaoModel mycarTipoManutencaoModel) {

        MycarTipoManutencaoModel mycarTipoManutencao = mycarTipoManutencaoRepository.save(mycarTipoManutencaoModel);

        return new ResponseEntity<MycarTipoManutencaoModel>(mycarTipoManutencao, HttpStatus.CREATED);
    }

    //Método atualizar

    @PutMapping(value = "editarMycarTipoManutencao")
    @ResponseBody
    public ResponseEntity<?> editarMycarTipoManutencao(@RequestBody MycarTipoManutencaoModel mycarTipoManutencaoModel) {

        if (mycarTipoManutencaoModel.getIdtipomanutencao() == 0) {

            return new ResponseEntity<String>("O ID do cadastro não foi informado para a atualização!", HttpStatus.OK);
        }

        MycarTipoManutencaoModel tipomanutencao = mycarTipoManutencaoRepository.saveAndFlush(mycarTipoManutencaoModel);

        return new ResponseEntity<MycarTipoManutencaoModel>(tipomanutencao, HttpStatus.OK);
    }

    //Método excluir

    @DeleteMapping(value = "excluirMycarTipoManutencao")
    @ResponseBody
    public ResponseEntity<String> excluirMycarTipoManutencao(@RequestParam Long idtipomanutencao) {

        mycarTipoManutencaoRepository.deleteById(idtipomanutencao);

        return new ResponseEntity<String>("Registro excluído com sucesso!", HttpStatus.OK);
    }

    //Método pesquisar por ID

    @GetMapping(value = "pesquisarMycarTipoManutencaoPorId")
    @ResponseBody
    public ResponseEntity<MycarTipoManutencaoModel> pesquisarMycarTipoManutencaoPorId(@RequestParam(name = "idtipomanutencao") Long idtipomanutencao) {

        MycarTipoManutencaoModel tipomanutencao = mycarTipoManutencaoRepository.findById(idtipomanutencao).get();

        return new ResponseEntity<MycarTipoManutencaoModel>(tipomanutencao, HttpStatus.OK);
    }

    //Método para listar todos os tipos de manutenção

    @GetMapping(value = "listarTodosMycarTipoManutencao")
    @ResponseBody
    public ResponseEntity<List<MycarTipoManutencaoModel>> listarTodosMycarTipoManutencao() {

        List<MycarTipoManutencaoModel> tipomanutencao = mycarTipoManutencaoRepository.findAll();

        return new ResponseEntity<List<MycarTipoManutencaoModel>>(tipomanutencao, HttpStatus.OK);
    }

    //Método para listar por tipo de manutencao

    @GetMapping(value = "listarMycarTipoManutencaoPorTipoManutencao")
    @ResponseBody
    public ResponseEntity<List<MycarTipoManutencaoModel>> listarMycarTipoManutencaoPorTipoManutencao(@RequestParam(name = "tipomanutencao") String tipomanutencao) {

        List<MycarTipoManutencaoModel> mycarTipoManutencaoModel = mycarTipoManutencaoRepository.buscarPorTipoManutencao(tipomanutencao.trim().toUpperCase());

        return new ResponseEntity<List<MycarTipoManutencaoModel>>(mycarTipoManutencaoModel, HttpStatus.OK);
    }
}