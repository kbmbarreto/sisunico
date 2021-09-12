package br.com.kmacedo.sisunico.repository;


import br.com.kmacedo.sisunico.model.MycarCompraModel;
import br.com.kmacedo.sisunico.model.MycarHistoricoManutencaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface MycarHistoricoManutencaoRepository extends JpaRepository<MycarHistoricoManutencaoModel, Long> {

    //TODO -> Ajustar a query Historico de Manutencao
    @Query(value = "select h from MycarHistoricoManutencaoModel h")
    List<MycarHistoricoManutencaoModel> buscarPorData(Long idhistoricomanutencao);

    @Query(value = "select hist.idhistoricomanutencao, hist.km, hist.datamanutencao, hist.kmproximatroca, " +
            "hist.valor, fab.fabricante, tpm.tipomanutencao, comp.componente, v.veiculodescricao " +
            "from MycarHistoricoManutencaoModel hist" +
            "inner join hist.componente comp" +
            "inner join hist.fabricante fab" +
            "inner join hist.tipomanutencao tpm" +
            "inner join hist.veiculodescricao v" +
            "order by hist.idhistoricomanutencao desc")
    List<MycarHistoricoManutencaoModel> exibirHistoricoManutencao(String historicomanutencao);
}
