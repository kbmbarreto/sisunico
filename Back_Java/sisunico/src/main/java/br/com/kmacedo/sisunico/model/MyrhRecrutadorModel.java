package br.com.kmacedo.sisunico.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "myrh_recrutador")
public class MyrhRecrutadorModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idrecrutador;

    @Column(name = "datacontato", nullable = false)
    private Date datacontato;

    @Column(name = "nome", length = 75, columnDefinition = "VARCHAR(75)", nullable = true)
    private String nome;

    @Column(name = "telefone", length = 45, columnDefinition = "VARCHAR(45)", nullable = true)
    private String telefone;

    @Column(name = "email", length = 75, columnDefinition = "VARCHAR(75)", nullable = true)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idempresa")
    private MyrhEmpresaModel idempresa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcargo")
    private MyrhCargoModel idcargo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idusuariologin")
    private UsuariosModel idusuariologin;

    public MyrhRecrutadorModel() {

    }

    public long getIdrecrutador() {
        return idrecrutador;
    }

    public void setIdrecrutador(long idrecrutador) {
        this.idrecrutador = idrecrutador;
    }

    public Date getDatacontato() {
        return datacontato;
    }

    public void setDatacontato(Date datacontato) {
        this.datacontato = datacontato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MyrhEmpresaModel getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(MyrhEmpresaModel idempresa) {
        this.idempresa = idempresa;
    }

    public MyrhCargoModel getIdcargo() {
        return idcargo;
    }

    public void setIdcargo(MyrhCargoModel idcargo) {
        this.idcargo = idcargo;
    }

    public UsuariosModel getIdusuariologin() {
        return idusuariologin;
    }

    public void setIdusuariologin(UsuariosModel idusuariologin) {
        this.idusuariologin = idusuariologin;
    }
}
