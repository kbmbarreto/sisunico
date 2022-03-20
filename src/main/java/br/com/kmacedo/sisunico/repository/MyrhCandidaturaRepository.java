package br.com.kmacedo.sisunico.repository;

import br.com.kmacedo.sisunico.model.MyrhCandidaturaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MyrhCandidaturaRepository extends JpaRepository<MyrhCandidaturaModel, Long> {

    @Query(value = "select u from MyrhCandidaturaModel u where upper(trim(u.anotacoes)) like %?1%")
    List<MyrhCandidaturaModel> buscarPorAnotacoes(String anotacoes);
}
