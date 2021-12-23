package br.com.kmacedo.sisunico.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "mycar_veiculo")
public class MycarVeiculoModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idveiculo;

    @Column(name = "descricaoveiculo", length = 45, columnDefinition = "VARCHAR(45)", nullable = false)
    private String descricaoveiculo;

    @Column(name = "modeloveiculo", length = 45, columnDefinition = "VARCHAR(45)", nullable = false)
    private String modeloveiculo;

    @Column(name = "anomodelo", nullable = false)
    private int anomodelo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idfabricante")
    private MycarFabricanteModel idfabricante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idusuariologin")
    private UsuariosModel idusuariologin;

    public MycarVeiculoModel() {

    }

    public long getIdveiculo() {
        return idveiculo;
    }

    public void setIdveiculo(long idveiculo) {
        this.idveiculo = idveiculo;
    }

    public String getDescricaoveiculo() {
        return descricaoveiculo;
    }

    public void setDescricaoveiculo(String descricaoveiculo) {
        this.descricaoveiculo = descricaoveiculo;
    }

    public String getModeloveiculo() {
        return modeloveiculo;
    }

    public void setModeloveiculo(String modeloveiculo) {
        this.modeloveiculo = modeloveiculo;
    }

    public int getAnomodelo() {
        return anomodelo;
    }

    public void setAnomodelo(int anomodelo) {
        this.anomodelo = anomodelo;
    }

    public MycarFabricanteModel getIdfabricante() {
        return idfabricante;
    }

    public void setIdfabricante(MycarFabricanteModel idfabricante) {
        this.idfabricante = idfabricante;
    }

    public UsuariosModel getIdusuariologin() {
        return idusuariologin;
    }

    public void setIdusuariologin(UsuariosModel idusuariologin) {
        this.idusuariologin = idusuariologin;
    }
}
