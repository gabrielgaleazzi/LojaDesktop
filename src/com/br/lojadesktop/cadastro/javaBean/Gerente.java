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
public class Gerente extends Administrativo {
	private Login login;

	public Login getLogin() {
		return login;
	}
	public void setLogin(String login,String senha) throws Exception {
		this.login = new Login(login,senha,'F');
	}

	public Gerente(String nome, String sobrenome, String cPF, String rG,
			String cep, String complemento, String celular, String telefone,String user, String senha) throws Exception {
		super(nome, sobrenome, cPF, rG, cep, complemento, celular, telefone);
		this.login = new Login(user,senha,'G');
	}
}
