package br.com.kmacedo.sisunico.repository;

import br.com.kmacedo.sisunico.model.MyrhEmpresaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MyrhEmpresaRepository extends JpaRepository<MyrhEmpresaModel, Long> {

    @Query(value = "select u from MyrhEmpresaModel u where upper(trim(u.empresa)) like %?1%")
    List<MyrhEmpresaModel> buscarPorEmpresa(String empresa);
}