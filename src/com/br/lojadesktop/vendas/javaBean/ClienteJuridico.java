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

	private String cnpj;
	
	
}
