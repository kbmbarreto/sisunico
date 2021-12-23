package br.com.kmacedo.sisunico.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "myrh_empresa")
public class MyrhEmpresaModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idempresa;

    @Column(name = "empresa", length = 45, columnDefinition = "VARCHAR(45)", nullable = false)
    private String empresa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idusuariologin")
    private UsuariosModel idusuariologin;

    public MyrhEmpresaModel() {

    }

    public long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(long idempresa) {
        this.idempresa = idempresa;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public UsuariosModel getIdusuariologin() {
        return idusuariologin;
    }

    public void setIdusuariologin(UsuariosModel idusuariologin) {
        this.idusuariologin = idusuariologin;
    }
}
