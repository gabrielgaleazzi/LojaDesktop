/**
 * 
 */
package com.br.lojadesktop.vendas.javaBean;

/**
 * @author gabrielgaleazzi
 *
 */
public class ClienteJuridico extends Cliente {

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public ClienteJuridico(int id, String nome, String sobrenome, String cep,
			String complemento, String celular, String telefone, String login,
			String senha, String cnpj) throws Exception {
		super(id, nome, sobrenome, cep, complemento, celular, telefone, login,
				senha);
		this.cnpj = cnpj;
	}

	private String cnpj;
	
	
}
