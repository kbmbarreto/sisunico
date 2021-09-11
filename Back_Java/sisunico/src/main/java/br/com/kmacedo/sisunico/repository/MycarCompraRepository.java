package br.com.kmacedo.sisunico.repository;

import br.com.kmacedo.sisunico.model.MycarCompraModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MycarCompraRepository extends JpaRepository<MycarCompraModel, Long> {

    @Query(value = "select u from MycarCompraModel u where upper(trim(u.descricaocompra)) like %?1%")
    List<MycarCompraModel> buscarPorDescricao(String descricaocompra);

    @Query(value = "select buy.idcompra, buy.descricaocompra, buy.localcupomfiscal, buy.quantidadecompra, " +
            "buy.comprarealizada, comp.componente from MycarCompraModel buy" +
            "inner join buy.componente comp")
    List<MycarCompraModel> exibirCompra(String componente);
}
