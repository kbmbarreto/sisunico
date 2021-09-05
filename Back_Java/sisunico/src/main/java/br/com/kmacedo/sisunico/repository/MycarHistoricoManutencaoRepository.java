package br.com.kmacedo.sisunico.repository;

import br.com.kmacedo.sisunico.model.MycarHistoricoManutencaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MycarHistoricoManutencaoRepository extends JpaRepository<MycarHistoricoManutencaoModel, Long> {

    //TODO -> Fazer uma consulta com inner join (Componente)
    @Query(value = "select u from MycarHistoricoManutencaoModel u where upper(trim(u.descricao)) like %?1%")
    List<MycarHistoricoManutencaoModel> buscarPorComponente(String componente);
}
