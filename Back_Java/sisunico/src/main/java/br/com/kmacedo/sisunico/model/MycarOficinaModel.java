package br.com.kmacedo.sisunico.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name =  "mycar_oficina")
public class MycarOficinaModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idoficina;

    @Column(name = "oficina", length = 45, columnDefinition = "VARCHAR(45)", nullable = false)
    private String oficina;

    @Column(name = "oficinacontato", length = 75, columnDefinition = "VARCHAR(75)", nullable = true)
    private String oficinaContato;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idusuariologin")
    private UsuariosModel idusuariologin;

    public MycarOficinaModel() {

    }

    public long getIdoficina() {
        return idoficina;
    }

    public void setIdoficina(long idoficina) {
        this.idoficina = idoficina;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public String getOficinaContato() {
        return oficinaContato;
    }

    public void setOficinaContato(String oficinaContato) {
        this.oficinaContato = oficinaContato;
    }

    public UsuariosModel getIdusuariologin() {
        return idusuariologin;
    }

    public void setIdusuariologin(UsuariosModel idusuariologin) {
        this.idusuariologin = idusuariologin;
    }
}
