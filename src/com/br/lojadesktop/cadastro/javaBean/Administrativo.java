/**
 * 
 */
package com.br.lojadesktop.cadastro.javaBean;

/**
 * @author Rafael S. Vieira
 *
 * 
 */
public class Administrativo {
	private String Nome,CPF,RG;

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
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

	
	public String toString() {
		return "Administrativo [Nome=" + Nome + ", CPF=" + CPF + ", RG=" + RG
				+ "]";
	}

	public Administrativo(String nome, String cPF, String rG) {
		Nome = nome;
		CPF = cPF;
		RG = rG;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CPF == null) ? 0 : CPF.hashCode());
		result = prime * result + ((Nome == null) ? 0 : Nome.hashCode());
		result = prime * result + ((RG == null) ? 0 : RG.hashCode());
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
		return true;
	}
	
	
}
