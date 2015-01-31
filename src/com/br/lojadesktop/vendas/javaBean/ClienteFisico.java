/**
 * 
 */
package com.br.lojadesktop.vendas.javaBean;

/**
 * @author gabrielgaleazzi
 *
 */
public class ClienteFisico extends Cliente {

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public ClienteFisico(int id, String nome, String sobrenome, String cep,
			String complemento, String celular, String telefone, String cpf,
			String rg, String usuario, String senha) throws Exception {
		super(id, nome, sobrenome, cep, complemento, celular, telefone, usuario, senha);
		this.cpf = cpf;
		this.rg = rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	private String cpf;
	private String rg;
	
	public ClienteFisico(){}
	
}
