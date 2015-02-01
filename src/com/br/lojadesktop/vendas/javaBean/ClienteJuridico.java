/**
 * 
 */
package com.br.lojadesktop.vendas.javaBean;

import com.br.lojadesktop.valid.Valid;

/**
 * @author gabrielgaleazzi
 *
 */
public class ClienteJuridico extends Cliente {

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) throws Exception {
		if(!Valid.validCPNJ(cnpj))
			throw new Exception("CPNJ invalido");
		
		this.cnpj=cnpj;
	}

	public ClienteJuridico(int id, String nome, String sobrenome, String cep,
			String complemento, String celular, String telefone, String login,
			String senha, String cnpj) throws Exception {
		super(id, nome, sobrenome, cep, complemento, celular, telefone, login,
				senha);
		this.cnpj = cnpj;
	}

	public ClienteJuridico(String cnpj) throws Exception
	{
		setCnpj(cnpj);
	}
	private String cnpj;
	@Override
	public String toString() {
		return "ClienteJuridico [cnpj=" + cnpj + ", getLogin()=" + getLogin()
				+ ", getId()=" + getId() + ", getNome()=" + getNome()
				+ ", getSobrenome()=" + getSobrenome() + ", getCep()="
				+ getCep() + ", getComplemento()=" + getComplemento()
				+ ", getCelular()=" + getCelular() + ", getTelefone()="
				+ getTelefone() + "]";
	}
	
	
	
	
}
