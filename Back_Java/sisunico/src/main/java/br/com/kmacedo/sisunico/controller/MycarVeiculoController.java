package br.com.kmacedo.sisunico.controller;

import br.com.kmacedo.sisunico.model.MycarVeiculoModel;
import br.com.kmacedo.sisunico.repository.MycarVeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MycarVeiculoController {

    @Autowired
    private MycarVeiculoRepository mycarVeiculoRepository;

    //Método para salvar

    @PostMapping(value = "salvarMycarVeiculo")
    @ResponseBody
    public ResponseEntity<MycarVeiculoModel> salvarMycarVeiculo(@RequestBody MycarVeiculoModel mycarVeiculoModel) {

        MycarVeiculoModel mycarVeiculo = mycarVeiculoRepository.save(mycarVeiculoModel);

        return new ResponseEntity<MycarVeiculoModel>(mycarVeiculo, HttpStatus.CREATED);
    }

    //Método atualizar

    @PutMapping(value = "editarMycarVeiculo")
    @ResponseBody
    public ResponseEntity<?> editarMycarVeiculo(@RequestBody MycarVeiculoModel mycarVeiculoModel) {

        if (mycarVeiculoModel.getIdveiculo() == 0) {

            return new ResponseEntity<String>("O ID do cadastro não foi informado para a atualização!", HttpStatus.OK);
        }

        MycarVeiculoModel veiculo = mycarVeiculoRepository.saveAndFlush(mycarVeiculoModel);

        return new ResponseEntity<MycarVeiculoModel>(veiculo, HttpStatus.OK);
    }

    //Método excluir

    @DeleteMapping(value = "excluirMycarVeiculo")
    @ResponseBody
    public ResponseEntity<String> excluirMycarVeiculo(@RequestParam Long idveiculo) {

        mycarVeiculoRepository.deleteById(idveiculo);

        return new ResponseEntity<String>("Registro excluído com sucesso!", HttpStatus.OK);
    }

    //Método pesquisar por ID

    @GetMapping(value = "pesquisarMycarVeiculoPorId")
    @ResponseBody
    public ResponseEntity<MycarVeiculoModel> pesquisarMycarVeiculoPorId(@RequestParam(name = "idveiculo") Long idveiculo) {

        MycarVeiculoModel veiculo = mycarVeiculoRepository.findById(idveiculo).get();

        return new ResponseEntity<MycarVeiculoModel>(veiculo, HttpStatus.OK);
    }

    //Método para listar todos os veiculos

    @GetMapping(value = "listarTodosMycarVeiculo")
    @ResponseBody
    public ResponseEntity<List<MycarVeiculoModel>> listarTodosMycarVeiculo() {

        List<MycarVeiculoModel> veiculo = mycarVeiculoRepository.findAll();

        return new ResponseEntity<List<MycarVeiculoModel>>(veiculo, HttpStatus.OK);
    }

    //Método para listar por descricao

    @GetMapping(value = "listarMycarVeiculoPorDescricao")
    @ResponseBody
    public ResponseEntity<List<MycarVeiculoModel>> listarMycarVeiculoPorDescricao(@org.jetbrains.annotations.NotNull @RequestParam(name = "descricaoveiculo") String descricaoveiculo) {

        List<MycarVeiculoModel> veiculo = mycarVeiculoRepository.buscarPorDescricao(descricaoveiculo.trim().toUpperCase());

        return new ResponseEntity<List<MycarVeiculoModel>>(veiculo, HttpStatus.OK);
    }
}