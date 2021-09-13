package br.com.kmacedo.sisunico.controller;

import br.com.kmacedo.sisunico.model.MycarCompraModel;
import br.com.kmacedo.sisunico.repository.MycarCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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


}
