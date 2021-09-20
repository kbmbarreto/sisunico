package br.com.kmacedo.sisunico.controller;

import br.com.kmacedo.sisunico.model.MycarCompraModel;
import br.com.kmacedo.sisunico.repository.MycarCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MycarCompraController {

    @Autowired
    private MycarCompraRepository mycarCompraRepository;

    //Método para salvar a compra

    @PostMapping(value = "salvarMycarCompra")
    @ResponseBody
    public ResponseEntity<MycarCompraModel> salvarMycarCompra(@RequestBody MycarCompraModel mycarCompraModel) {

        MycarCompraModel mycarCompra = mycarCompraRepository.save(mycarCompraModel);

        return new ResponseEntity<MycarCompraModel>(mycarCompra, HttpStatus.CREATED);
    }

    //Método para atualizar a compra

    @PutMapping(value = "editarMycarCompra")
    @ResponseBody
    public ResponseEntity<?> editarMycarCompra(@RequestBody MycarCompraModel mycarCompraModel) {

        if (mycarCompraModel.getIdcompra() == 0) {

            return new ResponseEntity<String>("O ID do cadastro não foi informado para a atualização!", HttpStatus.OK);
        }

        MycarCompraModel compra = mycarCompraRepository.saveAndFlush(mycarCompraModel);

        return new ResponseEntity<MycarCompraModel>(compra, HttpStatus.OK);
    }

    //Método para excluir compra

    @DeleteMapping(value = "excluirMycarCompra")
    @ResponseBody
    public ResponseEntity<String> excluirMycarCompra(@RequestParam Long idcompra) {

        mycarCompraRepository.deleteById(idcompra);

        return new ResponseEntity<String>("Registro excluído com sucesso!", HttpStatus.OK);
    }

    //Método para pesquisar por ID

    @GetMapping(value = "pesquisarMycarCompraPorId")
    @ResponseBody
    public ResponseEntity<MycarCompraModel> pesquisarMycarCompraPorId(@RequestParam(name = "idcompra") Long idcompra) {

        MycarCompraModel compra = mycarCompraRepository.findById(idcompra).get();

        return new ResponseEntity<MycarCompraModel>(compra, HttpStatus.OK);
    }

    //Método para listar as compras

    @GetMapping(value = "listarTodosMycarCompra")
    @ResponseBody
    public ResponseEntity<List<MycarCompraModel>> listarTodosMycarCompra() {

        //List<MycarCompraModel> compra = mycarCompraRepository.exibirCompra();
        List<MycarCompraModel> compra = mycarCompraRepository.findAll();

        return new ResponseEntity<List<MycarCompraModel>>(compra, HttpStatus.OK);
    }

    //Método para listar por descricao

    @GetMapping(value = "listarMycarCompraPorDescricao")
    @ResponseBody
    public ResponseEntity<List<MycarCompraModel>> listarMycarCompraPorCompra(@RequestParam(name = "compra") String compra) {

        List<MycarCompraModel> mycarCompraModel = mycarCompraRepository.buscarPorDescricao(compra.trim().toUpperCase());

        return new ResponseEntity<List<MycarCompraModel>>(mycarCompraModel, HttpStatus.OK);
    }
}