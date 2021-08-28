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

import br.com.kmacedo.sisunico.model.UsuariosModel;
import br.com.kmacedo.sisunico.repository.UsuariosRepository;

@RestController
public class UsuariosController {

	@Autowired
	private UsuariosRepository usuariosRepository;
	
	/* MÉTODO PARA SALVAR USUARIOS */
	
	@PostMapping(value = "saveUser")
	@ResponseBody
	public ResponseEntity<UsuariosModel> salvar(@RequestBody UsuariosModel usuariosModel) {
		
		UsuariosModel usuariologin = usuariosRepository.save(usuariosModel);
		
		return new ResponseEntity<UsuariosModel>(usuariologin, HttpStatus.CREATED);
	}
	
	/* MÉTODO PARA ATUALIZAR USUARIOS */
	
	@PutMapping(value = "updateUser")
	@ResponseBody
	public ResponseEntity<?> atualizar(@RequestBody UsuariosModel usuariosModel) {
		
		if(usuariosModel.getIdusuariologin() == 0) {
			return new ResponseEntity<String>("O ID do cadastro não foi informado para a atualização!", HttpStatus.OK);
		}
		
		UsuariosModel usuariologin = usuariosRepository.saveAndFlush(usuariosModel);
		
		return new ResponseEntity<UsuariosModel>(usuariologin, HttpStatus.OK);
	}
	
	/* MÉTODO PARA DELETAR USUARIOS */
	
    @DeleteMapping(value = "deleteUser")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long idusuariologin) {
    	
    	usuariosRepository.deleteById(idusuariologin);
    	
    	return new ResponseEntity<String>("Registro excluído com sucesso!", HttpStatus.OK);
    }
	
	/* MÉTODO PARA PESQUISAR ID */

	@GetMapping(value = "findUserid")
	@ResponseBody
	public ResponseEntity<UsuariosModel> buscarusuarioid(@RequestParam(name = "idusuariologin") Long idusuariologin) {
	
		UsuariosModel usuarioslogin = usuariosRepository.findById(idusuariologin).get();
	
		return new ResponseEntity<UsuariosModel>(usuarioslogin, HttpStatus.OK);
	}
	
    /* MÉTODO PARA LISTAR TODOS OS REGISTROS */
	
	@GetMapping(value = "viewAllUsers")
    @ResponseBody
    public ResponseEntity<List<UsuariosModel>> listaUsuarios() {
    	
    	List<UsuariosModel> usuarioslogin = usuariosRepository.findAll();
    	
    	return new ResponseEntity<List<UsuariosModel>>(usuarioslogin, HttpStatus.OK);	
    }
	
	/* MÉTODO PARA PESQUISAR POR DESCRIÇÃO */
	
    @GetMapping(value = "findByUser")
    @ResponseBody
    public ResponseEntity<List<UsuariosModel>> findByUser(@RequestParam(name = "usuariologin") String usuariologin) {
    	
    	List<UsuariosModel> usuariosModel = usuariosRepository.buscarPorUsuario(usuariologin.trim().toUpperCase());
    	
    	return new ResponseEntity<List<UsuariosModel>>(usuariosModel, HttpStatus.OK);
    } 
}