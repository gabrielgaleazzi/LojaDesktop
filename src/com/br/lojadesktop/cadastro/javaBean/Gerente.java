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
	public void setLogin(Login login) {
		this.login = login;
	}
	public Gerente(String nome, String cPF, String rG,String login, String senha)throws Exception 
	{
		super(nome, cPF, rG);
		this.login = new Login(login,senha,'G');
	}
	
	
}
