package br.com.kmacedo.sisunico.controller;

import br.com.kmacedo.sisunico.model.MyrhSituacaoModel;
import br.com.kmacedo.sisunico.repository.MyrhSituacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyrhSituacaoController {

    @Autowired
    private MyrhSituacaoRepository myrhSituacaoRepository;

    // Método para salvar
    @PostMapping(value = "salvarMyrhSituacao")
    @ResponseBody
    public ResponseEntity<MyrhSituacaoModel> salvarMyrhSituacao(@RequestBody MyrhSituacaoModel myrhSituacaoModel) {

        MyrhSituacaoModel situacao = myrhSituacaoRepository.save(myrhSituacaoModel);

        return new ResponseEntity<MyrhSituacaoModel>(situacao, HttpStatus.CREATED);
    }

    //Método atualizar

    @PutMapping(value = "editarMyrhSituacao")
    @ResponseBody
    public ResponseEntity<?> editarMyrhSituacao(@RequestBody MyrhSituacaoModel myrhSituacaoModel) {

        if (myrhSituacaoModel.getIdsituacao() == 0) {

            return new ResponseEntity<String>("O ID do cadastro não foi informado para a atualização!", HttpStatus.OK);
        }

        MyrhSituacaoModel situacao = myrhSituacaoRepository.saveAndFlush(myrhSituacaoModel);

        return new ResponseEntity<MyrhSituacaoModel>(situacao, HttpStatus.OK);
    }

    //Método excluir

    @DeleteMapping(value = "excluirMyrhSituacao")
    @ResponseBody
    public ResponseEntity<String> excluirMyrhSituacao(@RequestParam Long idsituacao) {

        myrhSituacaoRepository.deleteById(idsituacao);

        return new ResponseEntity<String>("Registro excluído com sucesso!", HttpStatus.OK);
    }

    //Método pesquisar por ID

    @GetMapping(value = "pesquisarMyrhSituacaoPorId")
    @ResponseBody
    public ResponseEntity<MyrhSituacaoModel> pesquisarMyrhSituacaoPorId(@RequestParam(name = "idsituacao") Long idsituacao) {

        MyrhSituacaoModel situacao = myrhSituacaoRepository.findById(idsituacao).get();

        return new ResponseEntity<MyrhSituacaoModel>(situacao, HttpStatus.OK);
    }

    //Método para listar todas as situações

    @GetMapping(value = "listarTodosMyrhSituacao")
    @ResponseBody
    public ResponseEntity<List<MyrhSituacaoModel>> listarTodosMyrhSituacao() {

        List<MyrhSituacaoModel> situacao = myrhSituacaoRepository.findAll();

        return new ResponseEntity<List<MyrhSituacaoModel>>(situacao, HttpStatus.OK);
    }

    //Método para listar por situacao

    @GetMapping(value = "listarMyrhSituacaoPorSituacao")
    @ResponseBody
    public ResponseEntity<List<MyrhSituacaoModel>> listarMyrhSituacaoPorNome(@RequestParam(name = "situacao") String situacao) {

        List<MyrhSituacaoModel> myrhSituacaoModel = myrhSituacaoRepository.buscarPorSituacao(situacao.trim().toUpperCase());

        return new ResponseEntity<List<MyrhSituacaoModel>>(myrhSituacaoModel, HttpStatus.OK);
    }
}