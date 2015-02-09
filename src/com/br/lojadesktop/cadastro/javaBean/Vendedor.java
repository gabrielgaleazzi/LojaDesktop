/**
 * 
 */
package com.br.lojadesktop.cadastro.javaBean;
import com.br.lojadesktop.javaBean.Login;

/**
 * @author Rafael S. Vieira
 *
 * 
 */
public class Vendedor extends Administrativo{
	
	private Login login;
	
	public Login getLogin() {
		return login;
	}

	public void setLogin(String login,String senha) throws Exception {
		this.login = new Login(login,senha,'F');
	}

	public Vendedor(String nome, String sobrenome, String cPF, String rG,
			String cep, String complemento, String celular, String telefone,
			String user,String senha) throws Exception {
		super(nome, sobrenome, cPF, rG, cep, complemento, celular, telefone);
		this.login =new Login(user,senha,'F');
	}

	public String toString() {
		return "Vendedor [login=" + login + ", getLogin()=" + getLogin()
				+ ", getNome()=" + getNome() + ", getSobrenome()="
				+ getSobrenome() + ", getCPF()=" + getCPF() + ", getRG()="
				+ getRG() + ", getCep()=" + getCep() + ", getComplemento()="
				+ getComplemento() + ", getCelular()=" + getCelular()
				+ ", getTelefone()=" + getTelefone() + ", hashCode()="
				+ hashCode() + ", getClass()=" + getClass() + ", toString()="
				+ super.toString() + "]";
	}

	
	
}
