package br.com.kmacedo.sisunico.repository;

import br.com.kmacedo.sisunico.model.MyrhCargoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MyrhCargoRepository extends JpaRepository<MyrhCargoModel, Long> {

    @Query(value = "select u from MyrhCargoModel u where upper(trim(u.cargo)) like %?1%")
    List<MyrhCargoModel> buscarPorCargo(String cargo);
}
