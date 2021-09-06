package br.com.kmacedo.sisunico.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "mycar_visitatecnica")
public class MycarVisitaTecnicaModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idvisita;

    @Column(name = "agendamento", nullable = true)
    private Date agendamento;

    @Column(name = "descricaoagendamento", length = 75, columnDefinition = "VARCHAR(75)", nullable = true)
    private String descricaoagendamento;

    @Column(name = "localordemservico", length = 128, columnDefinition = "VARCHAR(128)", nullable = true)
    private String localordemservico;

    @Column(name = "visitaconcluida", nullable = false)
    private boolean visitaconcluida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idveiculo")
    private MycarVeiculoModel idveiculo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idoficina")
    private MycarOficinaModel idoficina;

    public MycarVisitaTecnicaModel() {

    }

    public int getIdvisita() {
        return idvisita;
    }

    public void setIdvisita(int idvisita) {
        this.idvisita = idvisita;
    }

    public Date getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Date agendamento) {
        this.agendamento = agendamento;
    }

    public String getDescricaoagendamento() {
        return descricaoagendamento;
    }

    public void setDescricaoagendamento(String descricaoagendamento) {
        this.descricaoagendamento = descricaoagendamento;
    }

    public String getLocalordemservico() {
        return localordemservico;
    }

    public void setLocalordemservico(String localordemservico) {
        this.localordemservico = localordemservico;
    }

    public boolean isVisitaconcluida() {
        return visitaconcluida;
    }

    public void setVisitaconcluida(boolean visitaconcluida) {
        this.visitaconcluida = visitaconcluida;
    }

    public MycarVeiculoModel getIdveiculo() {
        return idveiculo;
    }

    public void setIdveiculo(MycarVeiculoModel idveiculo) {
        this.idveiculo = idveiculo;
    }

    public MycarOficinaModel getIdoficina() {
        return idoficina;
    }

    public void setIdoficina(MycarOficinaModel idoficina) {
        this.idoficina = idoficina;
    }
}
