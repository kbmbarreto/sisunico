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
    private long idhistoricomanutencao;

    @Column(name = "km", columnDefinition = "DECIMAL(7,3)", nullable = false)
    private double km;

    @Column(name = "datamanutencao", nullable = false)
    private Date datamanutencao;

    @Column(name = "kmproximatroca", columnDefinition = "DECIMAL(7,3)", nullable = true)
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

    public MycarHistoricoManutencaoModel() {

    }

    public long getIdhistoricomanutencao() {
        return idhistoricomanutencao;
    }

    public void setIdhistoricomanutencao(long idhistoricomanutencao) {
        this.idhistoricomanutencao = idhistoricomanutencao;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public Date getDatamanutencao() {
        return datamanutencao;
    }

    public void setDatamanutencao(Date datamanutencao) {
        this.datamanutencao = datamanutencao;
    }

    public double getKmproximatroca() {
        return kmproximatroca;
    }

    public void setKmproximatroca(double kmproximatroca) {
        this.kmproximatroca = kmproximatroca;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public MycarFabricanteModel getIdfabricante() {
        return idfabricante;
    }

    public void setIdfabricante(MycarFabricanteModel idfabricante) {
        this.idfabricante = idfabricante;
    }

    public MycarTipoManutencaoModel getIdtipomanutencao() {
        return idtipomanutencao;
    }

    public void setIdtipomanutencao(MycarTipoManutencaoModel idtipomanutencao) {
        this.idtipomanutencao = idtipomanutencao;
    }

    public MycarComponenteModel getIdcomponente() {
        return idcomponente;
    }

    public void setIdcomponente(MycarComponenteModel idcomponente) {
        this.idcomponente = idcomponente;
    }

    public MycarVeiculoModel getIdveiculo() {
        return idveiculo;
    }

    public void setIdveiculo(MycarVeiculoModel idveiculo) {
        this.idveiculo = idveiculo;
    }
}