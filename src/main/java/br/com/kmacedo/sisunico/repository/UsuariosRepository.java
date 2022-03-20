package br.com.kmacedo.sisunico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.kmacedo.sisunico.model.UsuariosModel;

public interface UsuariosRepository extends JpaRepository <UsuariosModel, Long>{

	@Query(value = "select u from UsuariosModel u where upper(trim(u.usuariologin)) like %?1%")
	List<UsuariosModel> buscarPorUsuario(String usuariologin);
}
