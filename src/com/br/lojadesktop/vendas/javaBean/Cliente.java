/**
 * 
 */
package com.br.lojadesktop.vendas.javaBean;

import com.br.lojadesktop.javaBean.Login;
import com.br.lojadesktop.valid.Valid;

/**
 * @author gabrielgaleazzi
 *
 */
public class Cliente {

	

	public Login getLogin() {
		return login;
	}
	
	
	public void setLogin(Login login) {
		this.login = login;
	}
	public void setLogin(String usuario, String senha) throws Exception {
		this.login = new Login(usuario,senha,'C');
	}

	private int id;
	private String nome;
	private String sobrenome;
	private String cep;
	private String complemento;
	private String celular;
	private String telefone;
	private Login login;
	
	
	
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
	public void setCelular(String celular) throws Exception{
		if(!Valid.validTelefone(celular)) throw new Exception("Celular invalido");
		this.celular=celular;
		
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone)throws Exception{
		if(!Valid.validTelefone(telefone)) throw new Exception("Telefone invalido");
		this.telefone=telefone;
	}
	
	
	public Cliente(int id, String nome, String sobrenome, String cep,
			String complemento, String celular, String telefone, String login, String senha) throws Exception {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cep = cep;
		this.complemento = complemento;
		this.setCelular(celular);
		this.setTelefone(telefone);
		this.login = new Login(login,senha,'C');
	}
	
	public Cliente()
	{
		
	}
	
	
}
