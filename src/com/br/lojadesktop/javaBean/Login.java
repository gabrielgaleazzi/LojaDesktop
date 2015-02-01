/**
 * 
 */
package com.br.lojadesktop.javaBean;

import com.br.lojadesktop.valid.Valid;


/**
 * @author gabrielgaleazzi
 *
 */
public class Login {

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) throws Exception {
		if(!Valid.validLogin(login)) throw new Exception("Login invalido, precisa ser email");
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) throws Exception{
		if(!Valid.validSenha(senha)) throw new Exception("Senha invalida");
		this.senha = senha;
	}
	public char getTipo() {
		return tipo;
	}
	public void setTipo(char tipo) {
		this.tipo=tipo;
	}
	public Login(String login, String senha, char tipo) throws Exception {
		super();
		this.setLogin(login);
		this.setSenha(senha);
		this.tipo = tipo;
	}
	private String login;
	private String senha;	
	private char tipo;
	
	
	
}
