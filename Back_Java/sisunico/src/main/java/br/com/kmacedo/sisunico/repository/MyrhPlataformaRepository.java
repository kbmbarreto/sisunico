package br.com.kmacedo.sisunico.repository;

import br.com.kmacedo.sisunico.model.MyrhPlataformaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MyrhPlataformaRepository extends JpaRepository<MyrhPlataformaModel, Long> {

    @Query(value = "select u from MyrhPlataformaModel u where upper(trim(u.plataforma)) like %?1%")
    List<MyrhPlataformaModel> buscarPorPlataforma(String plataforma);
}
