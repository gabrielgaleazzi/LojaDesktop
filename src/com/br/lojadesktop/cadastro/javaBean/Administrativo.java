/**
 * 
 */
package com.br.lojadesktop.cadastro.javaBean;

import javax.persistence.Column;

import com.br.lojadesktop.javaBean.Login;
import com.br.lojadesktop.valid.Valid;

/**
 * @author Rafael S. Vieira
 *
 * 
 */
public class Administrativo {
	private String Nome;
	private String sobrenome;
	private String CPF;
	private String RG;
	private String cep;
	private String complemento;
	private String celular;
	private String telefone;
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	
	public String getRG() {
		return RG;
	}
	public void setRG(String rG) {
		RG = rG;
	}
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CPF == null) ? 0 : CPF.hashCode());
		result = prime * result + ((Nome == null) ? 0 : Nome.hashCode());
		result = prime * result + ((RG == null) ? 0 : RG.hashCode());
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result
				+ ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result
				+ ((sobrenome == null) ? 0 : sobrenome.hashCode());
		result = prime * result
				+ ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Administrativo other = (Administrativo) obj;
		if (CPF == null) {
			if (other.CPF != null)
				return false;
		} else if (!CPF.equals(other.CPF))
			return false;
		if (Nome == null) {
			if (other.Nome != null)
				return false;
		} else if (!Nome.equals(other.Nome))
			return false;
		if (RG == null) {
			if (other.RG != null)
				return false;
		} else if (!RG.equals(other.RG))
			return false;
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (sobrenome == null) {
			if (other.sobrenome != null)
				return false;
		} else if (!sobrenome.equals(other.sobrenome))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}
	
	public Administrativo(String nome, String sobrenome, String cPF, String rG,
			String cep, String complemento, String celular, String telefone) {
		this.Nome = nome;
		this.sobrenome = sobrenome;
		this.CPF = cPF;
		this.RG = rG;
		this.cep = cep;
		this.complemento = complemento;
		this.celular = celular;
		this.telefone = telefone;
	}

	
}
