/**
 * 
 */
package com.br.lojadesktop.vendas.javaBean;



import javax.persistence.*;

import com.br.lojadesktop.javaBean.Login;
import com.br.lojadesktop.valid.Valid;

/**
 * @author gabrielgaleazzi
 *
 */

@Entity
@SequenceGenerator(name = "LOGIN_SEQUENCE", sequenceName = "LOGIN_SEQUENCE", allocationSize = 1, initialValue = 0)
@DiscriminatorColumn(name = "tipo", length = 2, discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("P")
public class Cliente {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY , generator = "LOGIN_SEQUENCE")
	private int id;
	@Column
	private String nome;
	@Column
	private String sobrenome;
	@Column
	private String cep;
	@Column
	private String complemento;
	@Column
	private String celular;
	@Column
	private String telefone;

	@OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name="login_id")
	private Login login;
	
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public void setLogin(String usuario, String senha) throws Exception {
		this.login = new Login(usuario,senha,'C');
	}	
	public int getId() {
		return id;
	}
	public void setId(int i) {
		this.id = i;
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
