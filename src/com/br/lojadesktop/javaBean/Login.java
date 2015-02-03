/**
 * 
 */
package com.br.lojadesktop.javaBean;

import javax.persistence.*;

import jdk.nashorn.internal.ir.annotations.Reference;

import com.br.lojadesktop.valid.Valid;
import com.br.lojadesktop.vendas.javaBean.Cliente;


/**
 * @author gabrielgaleazzi
 *
 */
@Entity
@Table(name="Login")
@SequenceGenerator(name="LOGIN_SEQUENCE", sequenceName="LOGIN_SEQUENCE", allocationSize=1, initialValue=0)
public class Login {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY , generator="LOGIN_SEQUENCE")
	private int id;
	@Column
	private String user;
	@Column
	private String senha;
	
	private char tipo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	


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
	
	public Login(){}
	
	
}
