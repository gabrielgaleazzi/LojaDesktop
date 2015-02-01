/**
 * 
 */
package com.br.lojadesktop.javaBean;

import javax.persistence.*;

import com.br.lojadesktop.valid.Valid;


/**
 * @author gabrielgaleazzi
 *
 */
@Entity
@Table(name="Login")
@SequenceGenerator(name="LOGIN_SEQUENCE", sequenceName="LOGIN_SEQUENCE", allocationSize=1, initialValue=0)
public class Login {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="LOGIN_SEQUENCE")
	private int id;
	@Column
	private String user;
	@Column
	private String senha;	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private char tipo;


	public String getuser() {
		return user;
	}
	public void setuser(String user) throws Exception {
		if(!Valid.validLogin(user)) throw new Exception("user invalido, precisa ser email");
		this.user = user;
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
	public Login(String user, String senha, char tipo) throws Exception {
		super();
		this.setuser(user);
		this.setSenha(senha);
		this.tipo = tipo;
	}
	
	
	
	
}
