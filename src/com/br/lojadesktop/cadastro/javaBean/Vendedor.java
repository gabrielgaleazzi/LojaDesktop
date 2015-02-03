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

	public Vendedor(String nome, String cPF, String rG,String login, String senha) throws Exception {
		super(nome,cPF,rG);
		this.login= new Login(login,senha,'V');
	}

	public String toString() {
		return "Funcionarios [Nome=" + getNome() + ", CPF="
				+ getCPF() + ", RG=" + getRG() + "Login=" + login.getuser() +", Senha="
				+login.getSenha()+ "]";
	}
	
}
