/**
 * 
 */
package com.br.lojadesktop.vendas.javaBean;

/**
 * @author gabrielgaleazzi
 *
 */
public class Cliente {

	private int id;
	private String nome;
	private String sobrenome;
	private String cep;
	private String complemento;
	private String celular;
	private String telefone;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
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
	
	
	public Cliente(int id, String nome, String sobrenome, String cep,
			String complemento, String celular, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cep = cep;
		this.complemento = complemento;
		this.celular = celular;
		this.telefone = telefone;
	}
	
	public Cliente()
	{
		
	}
	
	
}
