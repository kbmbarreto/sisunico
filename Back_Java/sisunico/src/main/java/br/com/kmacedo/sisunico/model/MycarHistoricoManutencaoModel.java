package br.com.kmacedo.sisunico.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "mycar_historicomanutencao")
public class MycarHistoricoManutencaoModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idhistoricomanutencao;

    @Column(name = "km", columnDefinition = "DECIMAL(7,2)", nullable = false)
    private double km;

    @Column(name = "datamanutencao", nullable = false)
    private Date datamanutencao;

    @Column(name = "kmproximatroca", columnDefinition = "DECIMAL(7,2)", nullable = true)
    private double kmproximatroca;

    @Column(name = "valor", columnDefinition = "DECIMAL(7,2)", nullable = true)
    private double valor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idfabricante")
    private MycarFabricanteModel idfabricante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idtipomanutencao")
    private MycarTipoManutencaoModel idtipomanutencao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcomponente")
    private MycarComponenteModel idcomponente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idveiculo")
    private MycarVeiculoModel idveiculo;
}
