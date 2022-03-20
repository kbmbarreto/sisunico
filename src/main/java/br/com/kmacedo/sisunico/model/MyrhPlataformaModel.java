package br.com.kmacedo.sisunico.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "myrh_plataforma")
public class MyrhPlataformaModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idplataforma;

    @Column(name = "plataforma", length = 45, columnDefinition = "VARCHAR(45)", nullable = false)
    private String plataforma;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idusuariologin")
    private UsuariosModel idusuariologin;

    public MyrhPlataformaModel() {

    }

    public long getIdplataforma() {
        return idplataforma;
    }

    public void setIdplataforma(long idplataforma) {
        this.idplataforma = idplataforma;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public UsuariosModel getIdusuariologin() {
        return idusuariologin;
    }

    public void setIdusuariologin(UsuariosModel idusuariologin) {
        this.idusuariologin = idusuariologin;
    }
}
