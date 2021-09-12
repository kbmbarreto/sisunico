package br.com.kmacedo.sisunico.repository;

import br.com.kmacedo.sisunico.model.MycarHistoricoManutencaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MycarHistoricoManutencaoRepository extends JpaRepository<MycarHistoricoManutencaoModel, Long> {

    @Query(value = "select h from MycarHistoricoManutencaoModel h where upper(trim(h.datamanutencao)) like %?1%")
    List<MycarHistoricoManutencaoModel> buscarPorData(String datamanutencao);

    @Query(value = "select hist.idhistoricomanutencao, hist.km, hist.datamanutencao, hist.kmproximatroca, " +
            "hist.valor, hist.fabricante, hist.tipomanutencao, hist.componente, hist.veiculodescricao " +
            "from MycarHistoricoManutencaoModel hist " +
            "inner join hist.componente " +
            "inner join hist.fabricante " +
            "inner join hist.tipomanutencao " +
            "inner join hist.veiculodescricao " +
            "order by hist.idhistoricomanutencao desc")
    List<MycarHistoricoManutencaoModel> exibirHistoricoManutencao(String historicomanutencao);
}
