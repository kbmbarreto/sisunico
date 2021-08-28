package br.com.kmacedo.sisunico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.kmacedo.sisunico.model.SenhasModel;

public interface SenhasRepository extends JpaRepository <SenhasModel, Long>{

	@Query(value = "select u from SenhasModel u where upper(trim(u.descricao)) like %?1%")
	List<SenhasModel> buscarPorDescricao(String descricao);
}