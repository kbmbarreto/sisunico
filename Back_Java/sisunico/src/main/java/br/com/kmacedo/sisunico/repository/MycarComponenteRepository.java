package br.com.kmacedo.sisunico.repository;

import br.com.kmacedo.sisunico.model.MycarComponenteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MycarComponenteRepository extends JpaRepository<MycarComponenteModel, Long> {

    @Query(value = "select u from MycarComponenteModel u where upper(trim(u.componente)) like %?1%")
    List<MycarComponenteModel> buscarPorComponente(String componente);
}
