package br.com.kmacedo.sisunico.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "mycar_fabricante")

public class MycarFabricanteModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idfabricante;

    @Column(name = "fabricante", length = 45, columnDefinition = "VARCHAR(45)", nullable = false)
    private String fabricante;

    public MycarFabricanteModel() {

    }

    public long getIdfabricante() {
        return idfabricante;
    }

    public void setIdfabricante(long idfabricante) {
        this.idfabricante = idfabricante;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
}
