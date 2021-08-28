package br.com.kmacedo.sisunico.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "senhas")

public class SenhasModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idsenha;
	
	@Column(name = "descricao", length = 70, columnDefinition = "VARCHAR(70)", nullable = false)
	private String descricao;
	
	@Column(name = "enderecovirtual", length = 100, columnDefinition = "VARCHAR(100)", nullable = true)
	private String enderecovirtual;
	
	@Column(name = "usuario", length = 60, columnDefinition = "VARCHAR(60)", nullable = false)
	private String usuario;
	
	@Column(name = "senha", length = 128, columnDefinition = "VARCHAR(128)", nullable = false)
	private String senha;
	
	@Column(name = "anotacoes", length = 255, columnDefinition = "VARCHAR(255)", nullable = true)
	private String anotacoes;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idusuariologin")
	private UsuariosModel idusuariologin;

	//emptyConstructor
	public SenhasModel() {

	}

	public long getIdsenha() {
		return idsenha;
	}

	public void setIdsenha(long idsenha) {
		this.idsenha = idsenha;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEnderecovirtual() {
		return enderecovirtual;
	}

	public void setEnderecovirtual(String enderecovirtual) {
		this.enderecovirtual = enderecovirtual;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getAnotacoes() {
		return anotacoes;
	}

	public void setAnotacoes(String anotacoes) {
		this.anotacoes = anotacoes;
	}

	public UsuariosModel getIdusuariologin() {
		return idusuariologin;
	}

	public void setIdusuariologin(UsuariosModel idusuariologin) {
		this.idusuariologin = idusuariologin;
	}
}