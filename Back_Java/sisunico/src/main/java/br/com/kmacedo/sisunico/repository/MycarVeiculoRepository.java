package br.com.kmacedo.sisunico.repository;

import br.com.kmacedo.sisunico.model.MycarVeiculoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MycarVeiculoRepository extends JpaRepository<MycarVeiculoModel, Long> {

    @Query(value = "select u from MycarVeiculoModel u where upper(trim(u.descricaoveiculo)) like %?1%")
    List<MycarVeiculoModel> buscarPorDescricao(String descricaoveiculo);

    @Query(value = "select v.idveiculo, v.anomodelo, v.descricaoveiculo, v.modeloveiculo, " +
            "v.fabricante from MycarVeiculoModel v " +
            "inner join v.fabricante")
    List<MycarVeiculoModel> exibirVeiculos(String veiculos);
}
