package br.com.kmacedo.sisunico.repository;

import br.com.kmacedo.sisunico.model.MycarTipoManutencaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MycarTipoManutencaoRepository extends JpaRepository<MycarTipoManutencaoModel, Long> {

    @Query(value = "select u from MycarTipoManutencaoModel u where upper(trim(u.tipomanutencao)) like %?1%")
    List<MycarTipoManutencaoModel> buscarPorTipoManutencao(String tipomanutencao);
}