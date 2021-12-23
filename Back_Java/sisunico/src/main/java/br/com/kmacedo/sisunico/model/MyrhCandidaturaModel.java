package br.com.kmacedo.sisunico.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "myrh_candidatura")
public class MyrhCandidaturaModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idcandidatura;

    @Column(name = "data", nullable = false)
    private Date data;

    @Column(name = "anotacoes", length = 128, columnDefinition = "VARCHAR(128)", nullable = true)
    private String anotacoes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idempresa")
    private MyrhEmpresaModel idempresa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcargo")
    private MyrhCargoModel idcargo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idplataforma")
    private MyrhPlataformaModel idplataforma;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idrecrutador")
    private MyrhRecrutadorModel idrecrutador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idsituacao")
    private MyrhSituacaoModel idsituacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idusuariologin")
    private UsuariosModel idusuariologin;

    public MyrhCandidaturaModel() {

    }

    public long getIdcandidatura() {
        return idcandidatura;
    }

    public void setIdcandidatura(long idcandidatura) {
        this.idcandidatura = idcandidatura;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }

    public MyrhEmpresaModel getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(MyrhEmpresaModel idempresa) {
        this.idempresa = idempresa;
    }

    public MyrhCargoModel getIdcargo() {
        return idcargo;
    }

    public void setIdcargo(MyrhCargoModel idcargo) {
        this.idcargo = idcargo;
    }

    public MyrhPlataformaModel getIdplataforma() {
        return idplataforma;
    }

    public void setIdplataforma(MyrhPlataformaModel idplataforma) {
        this.idplataforma = idplataforma;
    }

    public MyrhRecrutadorModel getIdrecrutador() {
        return idrecrutador;
    }

    public void setIdrecrutador(MyrhRecrutadorModel idrecrutador) {
        this.idrecrutador = idrecrutador;
    }

    public MyrhSituacaoModel getIdsituacao() {
        return idsituacao;
    }

    public void setIdsituacao(MyrhSituacaoModel idsituacao) {
        this.idsituacao = idsituacao;
    }

    public UsuariosModel getIdusuariologin() {
        return idusuariologin;
    }

    public void setIdusuariologin(UsuariosModel idusuariologin) {
        this.idusuariologin = idusuariologin;
    }
}
