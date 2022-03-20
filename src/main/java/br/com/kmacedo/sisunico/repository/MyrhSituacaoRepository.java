package br.com.kmacedo.sisunico.repository;

import br.com.kmacedo.sisunico.model.MyrhSituacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MyrhSituacaoRepository extends JpaRepository<MyrhSituacaoModel, Long> {

    @Query(value = "select u from MyrhSituacaoModel u where upper(trim(u.situacao)) like %?1%")
    List<MyrhSituacaoModel> buscarPorSituacao(String situacao);
}
