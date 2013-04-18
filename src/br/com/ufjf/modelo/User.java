package br.com.ufjf.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idScientist;

	private String cpfScientist;

	private String emailScientist;

	private String instituicaoScientist;

	private String loginScientist;

	private String nomeScientist;

	private String senhaScientist;

	public User() {
	}

	public int getIdScientist() {
		return this.idScientist;
	}

	public void setIdScientist(int idScientist) {
		this.idScientist = idScientist;
	}

	public String getCpfScientist() {
		return this.cpfScientist;
	}

	public void setCpfScientist(String cpfScientist) {
		this.cpfScientist = cpfScientist;
	}

	public String getEmailScientist() {
		return this.emailScientist;
	}

	public void setEmailScientist(String emailScientist) {
		this.emailScientist = emailScientist;
	}

	public String getInstituicaoScientist() {
		return this.instituicaoScientist;
	}

	public void setInstituicaoScientist(String instituicaoScientist) {
		this.instituicaoScientist = instituicaoScientist;
	}

	public String getLoginScientist() {
		return this.loginScientist;
	}

	public void setLoginScientist(String loginScientist) {
		this.loginScientist = loginScientist;
	}

	public String getNomeScientist() {
		return this.nomeScientist;
	}

	public void setNomeScientist(String nomeScientist) {
		this.nomeScientist = nomeScientist;
	}

	public String getSenhaScientist() {
		return this.senhaScientist;
	}

	public void setSenhaScientist(String senhaScientist) {
		this.senhaScientist = senhaScientist;
	}

}