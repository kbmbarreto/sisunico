package br.com.kmacedo.sisunico.model;

import javax.persistence.*;

@Entity
@Table(name = "mycar_tipomanutencao")
public class MycarTipoManutencaoModel {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idtipomanutencao;

    @Column(name = "tipomanutencao", length = 45, columnDefinition = "VARCHAR(45)", nullable = false)
    private String tipomanutencao;

    public MycarTipoManutencaoModel() {

    }

    public long getIdtipomanutencao() {
        return idtipomanutencao;
    }

    public void setIdtipomanutencao(long idtipomanutencao) {
        this.idtipomanutencao = idtipomanutencao;
    }

    public String getTipomanutencao() {
        return tipomanutencao;
    }

    public void setTipomanutencao(String tipomanutencao) {
        this.tipomanutencao = tipomanutencao;
    }
}