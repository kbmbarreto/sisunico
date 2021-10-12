package br.com.kmacedo.sisunico.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "mycar_compra")
public class MycarCompraModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idcompra;

    @Column(name = "descricaocompra", length = 75, columnDefinition = "VARCHAR(75)", nullable = false)
    private String descricaocompra;

    @Column(name = "localcupomfiscal", length = 128, columnDefinition = "VARCHAR(128)", nullable = true)
    private String localcupomfiscal;

    @Column(name = "quantidadecompra", nullable = false)
    private int quantidadecompra;

    @Column(name = "comprarealizada", nullable = false)
    private boolean comprarealizada;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcomponente")
    private MycarComponenteModel idcomponente;

    public MycarCompraModel() {

    }

    public long getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(long idcompra) {
        this.idcompra = idcompra;
    }

    public String getDescricaocompra() {
        return descricaocompra;
    }

    public void setDescricaocompra(String descricaocompra) {
        this.descricaocompra = descricaocompra;
    }

    public String getLocalcupomfiscal() {
        return localcupomfiscal;
    }

    public void setLocalcupomfiscal(String localcupomfiscal) {
        this.localcupomfiscal = localcupomfiscal;
    }

    public int getQuantidadecompra() {
        return quantidadecompra;
    }

    public void setQuantidadecompra(int quantidadecompra) {
        this.quantidadecompra = quantidadecompra;
    }

    public boolean isComprarealizada() {
        return comprarealizada;
    }

    public void setComprarealizada(boolean comprarealizada) {
        this.comprarealizada = comprarealizada;
    }

    public MycarComponenteModel getIdcomponente() {
        return idcomponente;
    }

    public void setIdcomponente(MycarComponenteModel idcomponente) {
        this.idcomponente = idcomponente;
    }
}