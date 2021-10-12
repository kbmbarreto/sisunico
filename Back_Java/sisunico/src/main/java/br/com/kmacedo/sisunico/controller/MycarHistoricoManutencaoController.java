package br.com.kmacedo.sisunico.controller;

import br.com.kmacedo.sisunico.model.MycarHistoricoManutencaoModel;
import br.com.kmacedo.sisunico.repository.MycarHistoricoManutencaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MycarHistoricoManutencaoController {

    @Autowired
    private MycarHistoricoManutencaoRepository mycarHistoricoManutencaoRepository;

    //Método para salvar o historico de manutencao

    @PostMapping(value = "salvarMycarHistoricoManutencao")
    @ResponseBody
    public ResponseEntity<MycarHistoricoManutencaoModel> salvarMycarHistoricoManutencao(@RequestBody MycarHistoricoManutencaoModel mycarHistoricoManutencaoModel) {

        MycarHistoricoManutencaoModel mycarHistorico = mycarHistoricoManutencaoRepository.save(mycarHistoricoManutencaoModel);

        return new ResponseEntity<MycarHistoricoManutencaoModel>(mycarHistorico, HttpStatus.CREATED);
    }

    //Método para atualizar os historicos de manutencao

    @PutMapping(value = "editarMycarHistoricoManutencao")
    @ResponseBody
    public ResponseEntity<?> editarMycarHistoricoManutencao(@RequestBody MycarHistoricoManutencaoModel mycarHistoricoManutencaoModel) {

        if (mycarHistoricoManutencaoModel.getIdhistoricomanutencao() == 0) {

            return new ResponseEntity<String>("O ID do cadastro não foi informado para a atualização!", HttpStatus.OK);
        }

        MycarHistoricoManutencaoModel historico = mycarHistoricoManutencaoRepository.saveAndFlush(mycarHistoricoManutencaoModel);

        return new ResponseEntity<MycarHistoricoManutencaoModel>(historico, HttpStatus.OK);
    }

    //Método para excluir historico de manutencao

    @DeleteMapping(value = "excluirMycarHistoricoManutencao")
    @ResponseBody
    public ResponseEntity<String> excluirMycarHistoricoManutencao(@RequestParam Long idhistoricomanutencao) {

        mycarHistoricoManutencaoRepository.deleteById(idhistoricomanutencao);

        return new ResponseEntity<String>("Registro excluído com sucesso!", HttpStatus.OK);
    }

    //Método para pesquisar por ID

    @GetMapping(value = "pesquisarMycarHistoricoManutencaoPorId")
    @ResponseBody
    public ResponseEntity<MycarHistoricoManutencaoModel> pesquisarMycarHistoricoManutencaoPorId(@RequestParam(name = "idhistoricomanutencao") Long idhistoricomanutencao) {

        MycarHistoricoManutencaoModel historico = mycarHistoricoManutencaoRepository.findById(idhistoricomanutencao).get();

        return new ResponseEntity<MycarHistoricoManutencaoModel>(historico, HttpStatus.OK);
    }

    //Método para listar os historicos

    @GetMapping(value = "listarTodosMycarHistoricoManutencao")
    @ResponseBody
    public ResponseEntity<List<MycarHistoricoManutencaoModel>> listarTodosMycarHistoricoManutencao() {

        //List<MycarHistoricoManutencaoModel> historico = mycarHistoricoManutencaoRepository.exibirHistoricoManutencao();
        List<MycarHistoricoManutencaoModel> historico = mycarHistoricoManutencaoRepository.findAll();

        return new ResponseEntity<List<MycarHistoricoManutencaoModel>>(historico, HttpStatus.OK);
    }

    //TODO -> Implementar pesquisa por componente

}
