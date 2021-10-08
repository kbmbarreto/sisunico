package br.com.kmacedo.sisunico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.kmacedo.sisunico.model.SenhasModel;
import br.com.kmacedo.sisunico.repository.SenhasRepository;

@RestController
public class SenhasController {

	@Autowired
	private SenhasRepository senhasRepository;
	
	/* MÉTODO PARA SALVAR SENHA */
	
	@PostMapping(value = "saveSenha")
	@ResponseBody
	public ResponseEntity<SenhasModel> salvar(@RequestBody SenhasModel senhasModel) {
		
		SenhasModel senhas = senhasRepository.save(senhasModel);
		
		return new ResponseEntity<SenhasModel>(senhas, HttpStatus.CREATED);
	}
	
	/* MÉTODO PARA ATUALIZAR SENHA */
	
	@PutMapping(value = "updateSenha")
	@ResponseBody
	public ResponseEntity<?> atualizar(@RequestBody SenhasModel senhasModel) {
		
		if(senhasModel.getIdsenha() == 0) {
			return new ResponseEntity<String>("O ID do cadastro não foi informado para a atualização!", HttpStatus.OK);
		}
		
		SenhasModel senhas = senhasRepository.saveAndFlush(senhasModel);
		
		return new ResponseEntity<SenhasModel>(senhas, HttpStatus.OK);
	}
	
	/* MÉTODO PARA DELETAR SENHA */
	
    @DeleteMapping(value = "deleteSenha")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long idsenha) {
    	
    	senhasRepository.deleteById(idsenha);
    	
    	return new ResponseEntity<String>("Registro excluído com sucesso!", HttpStatus.OK);
    }
	
	/* MÉTODO PARA PESQUISAR ID */

	@GetMapping(value = "findSenhaid")
	@ResponseBody
	public ResponseEntity<SenhasModel> buscarsenhaid(@RequestParam(name = "idsenha") Long idsenha) {
	
		SenhasModel senhas = senhasRepository.findById(idsenha).get();
	
		return new ResponseEntity<SenhasModel>(senhas, HttpStatus.OK);
	}
	
    /* MÉTODO PARA LISTAR TODOS OS REGISTROS */
	
	@GetMapping(value = "viewAllSenhas")
    @ResponseBody
    public ResponseEntity<List<SenhasModel>> listaSenhas() {
    	
    	List<SenhasModel> senhas = senhasRepository.findAll();
    	
    	return new ResponseEntity<List<SenhasModel>>(senhas, HttpStatus.OK);
    }
	
	/* MÉTODO PARA PESQUISAR POR DESCRIÇÃO */
	
    @GetMapping(value = "findByDescricao")
    @ResponseBody
    public ResponseEntity<List<SenhasModel>> findByDescricao(@RequestParam(name = "descricao") String descricao) {
    	
    	List<SenhasModel> senhasModel = senhasRepository.buscarPorDescricao(descricao.trim().toUpperCase());
    	
    	return new ResponseEntity<List<SenhasModel>>(senhasModel, HttpStatus.OK);
    } 
}