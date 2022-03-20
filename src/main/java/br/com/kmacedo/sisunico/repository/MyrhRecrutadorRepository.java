package br.com.kmacedo.sisunico.repository;

import br.com.kmacedo.sisunico.model.MyrhRecrutadorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MyrhRecrutadorRepository extends JpaRepository<MyrhRecrutadorModel, Long> {

    @Query(value = "select u from MyrhRecrutadorModel u where upper(trim(u.nome)) like %?1%")
    List<MyrhRecrutadorModel> buscarPorNome(String nome);
}
