package br.com.kmacedo.sisunico.repository;

import br.com.kmacedo.sisunico.model.MycarFabricanteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MycarFabricanteRepository extends JpaRepository<MycarFabricanteModel, Long> {

    @Query(value = "select u from MycarFabricanteModel u where upper(trim(u.fabricante)) like %?1%")
    List<MycarFabricanteModel> buscarPorFabricante(String fabricante);
}
