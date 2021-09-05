package br.com.kmacedo.sisunico.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "mycar_componente")

public class MycarComponenteModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idcomponente;

    @Column(name = "componente", length = 75, columnDefinition = "VARCHAR(75)", nullable = false)
    private String componente;

    public MycarComponenteModel() {

    }

    public long getIdcomponente() {
        return idcomponente;
    }

    public void setIdcomponente(long idcomponente) {
        this.idcomponente = idcomponente;
    }

    public String getComponente() {
        return componente;
    }

    public void setComponente(String componente) {
        this.componente = componente;
    }
}