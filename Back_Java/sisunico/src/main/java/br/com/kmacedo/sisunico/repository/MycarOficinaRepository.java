package br.com.kmacedo.sisunico.repository;

import br.com.kmacedo.sisunico.model.MycarOficinaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MycarOficinaRepository extends JpaRepository<MycarOficinaModel, Long> {

    @Query(value = "select u from MycarOficinaModel u where upper(trim(u.oficina)) like %?1%")
    List<MycarOficinaModel> buscarPorOficina(String oficina);
}
