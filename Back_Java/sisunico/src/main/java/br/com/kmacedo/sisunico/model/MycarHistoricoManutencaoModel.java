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
    private MycarFabricanteModel fabricante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idtipomanutencao")
    private MycarTipoManutencaoModel tipomanutencao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcomponente")
    private MycarComponenteModel componente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idveiculo")
    private MycarVeiculoModel veiculodescricao;

    public MycarHistoricoManutencaoModel() {

    }

    public int getIdhistoricomanutencao() {
        return idhistoricomanutencao;
    }

    public void setIdhistoricomanutencao(int idhistoricomanutencao) {
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

    public MycarFabricanteModel getFabricante() {
        return fabricante;
    }

    public void setFabricante(MycarFabricanteModel fabricante) {
        this.fabricante = fabricante;
    }

    public MycarTipoManutencaoModel getTipomanutencao() {
        return tipomanutencao;
    }

    public void setTipomanutencao(MycarTipoManutencaoModel tipomanutencao) {
        this.tipomanutencao = tipomanutencao;
    }

    public MycarComponenteModel getComponente() {
        return componente;
    }

    public void setComponente(MycarComponenteModel componente) {
        this.componente = componente;
    }

    public MycarVeiculoModel getVeiculodescricao() {
        return veiculodescricao;
    }

    public void setVeiculodescricao(MycarVeiculoModel veiculodescricao) {
        this.veiculodescricao = veiculodescricao;
    }
}