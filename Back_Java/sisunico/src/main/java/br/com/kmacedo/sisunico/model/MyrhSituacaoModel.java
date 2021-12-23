package br.com.kmacedo.sisunico.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "myrh_situacao")
public class MyrhSituacaoModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idsituacao;

    @Column(name = "situacao", length = 45, columnDefinition = "VARCHAR(45)", nullable = false)
    private String situacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idusuariologin")
    private UsuariosModel idusuariologin;

    public MyrhSituacaoModel() {

    }

    public long getIdsituacao() {
        return idsituacao;
    }

    public void setIdsituacao(long idsituacao) {
        this.idsituacao = idsituacao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public UsuariosModel getIdusuariologin() {
        return idusuariologin;
    }

    public void setIdusuariologin(UsuariosModel idusuariologin) {
        this.idusuariologin = idusuariologin;
    }
}
