package br.com.kmacedo.sisunico.repository;


import br.com.kmacedo.sisunico.model.MycarHistoricoManutencaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface MycarHistoricoManutencaoRepository extends JpaRepository<MycarHistoricoManutencaoModel, Long> {

    //TODO -> Ajustar a query Historico de Manutencao
    @Query(value = "select h from MycarHistoricoManutencaoModel h")
    List<MycarHistoricoManutencaoModel> buscarPorData(Long idhistoricomanutencao);
}
