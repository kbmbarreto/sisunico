package br.com.kmacedo.sisunico.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class UsuariosModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idusuariologin;
	
	@Column(name = "usuariologin", length = 60, columnDefinition = "VARCHAR(60)", nullable = false)
	private String usuariologin;
	
	@Column(name = "senhalogin", length = 128, columnDefinition = "VARCHAR(128)", nullable = false)
	private String senhalogin;
	
	public UsuariosModel() {
		
	}

	public long getIdusuariologin() {
		return idusuariologin;
	}

	public void setIdusuariologin(long idusuariologin) {
		this.idusuariologin = idusuariologin;
	}

	public String getUsuariologin() {
		return usuariologin;
	}

	public void setUsuariologin(String usuariologin) {
		this.usuariologin = usuariologin;
	}

	public String getSenhalogin() {
		return senhalogin;
	}

	public void setSenhalogin(String senhalogin) {
		this.senhalogin = senhalogin;
	}
}