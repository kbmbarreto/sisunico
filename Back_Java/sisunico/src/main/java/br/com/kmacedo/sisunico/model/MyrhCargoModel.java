package br.com.kmacedo.sisunico.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "myrh_cargo")
public class MyrhCargoModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idcargo;

    @Column(name = "cargo", length = 45, columnDefinition = "VARCHAR(45)", nullable = false)
    private String cargo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idusuariologin")
    private UsuariosModel idusuariologin;

    public MyrhCargoModel() {

    }

    public long getIdcargo() {
        return idcargo;
    }

    public void setIdcargo(long idcargo) {
        this.idcargo = idcargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public UsuariosModel getIdusuariologin() {
        return idusuariologin;
    }

    public void setIdusuariologin(UsuariosModel idusuariologin) {
        this.idusuariologin = idusuariologin;
    }
}
