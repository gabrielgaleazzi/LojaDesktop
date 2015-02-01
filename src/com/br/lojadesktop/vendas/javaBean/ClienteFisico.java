/**
 * 
 */
package com.br.lojadesktop.vendas.javaBean;

import com.br.lojadesktop.valid.Valid;

/**
 * @author gabrielgaleazzi
 *
 */
public class ClienteFisico extends Cliente {

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) throws Exception {
		if(!Valid.validCPF(cpf))
			throw new Exception("CPF invalido");
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public ClienteFisico(int id, String nome, String sobrenome, String cep,
			String complemento, String celular, String telefone, String cpf,
			String rg, String usuario, String senha) throws Exception {
		super(id, nome, sobrenome, cep, complemento, celular, telefone, usuario, senha);
		this.setCpf(cpf);
		this.setRg(rg);
		
	}
	public void setRg(String rg) throws Exception {
		if(!Valid.validRG(rg))
			throw new Exception("RG invalido");
		this.rg=rg;
	}
	private String cpf;
	private String rg;
	
	public ClienteFisico(){}
	
	public ClienteFisico(String rg, String cpf) throws Exception
	{
		this.setRg(rg);
		this.setCpf(cpf);
		
	}
	@Override
	public String toString() {
		return "ClienteFisico [cpf=" + cpf + ", rg=" + rg + ", getLogin()="
				+ getLogin() + ", getId()=" + getId() + ", getNome()="
				+ getNome() + ", getSobrenome()=" + getSobrenome()
				+ ", getCep()=" + getCep() + ", getComplemento()="
				+ getComplemento() + ", getCelular()=" + getCelular()
				+ ", getTelefone()=" + getTelefone() + ", getClass()="
				+ getClass() + "]";
	}
	
	
}
