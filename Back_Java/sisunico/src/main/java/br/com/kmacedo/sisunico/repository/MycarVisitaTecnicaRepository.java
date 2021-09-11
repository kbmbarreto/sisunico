package br.com.kmacedo.sisunico.repository;

import br.com.kmacedo.sisunico.model.MycarVisitaTecnicaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MycarVisitaTecnicaRepository extends JpaRepository<MycarVisitaTecnicaModel,Long> {

    @Query(value = "select u from MycarVisitaTecnicaModel u where upper(trim(u.descricaoagendamento)) like %?1%")
    List<MycarVisitaTecnicaModel> buscarPorDescricao(String descricaoagendamento);

    @Query(value = "select vt.idvisita, vt.agendamento, vt.descricaoagendamento, vt.localordemservico, " +
            "vt.visitaconcluida, v.descricaoveiculo, of.oficina from MycarVisitaTecnicaModel vt" +
            "inner join vt.descricaoveiculo v" +
            "inner join vt.oficina of" +
            "order by vt.idvisita desc")
    List<MycarVisitaTecnicaModel> exibirVisitasTecnicas(String visitastecnicas);
}
