/**
 * 
 */
package com.br.lojadesktop.vendas.test;



import com.br.lojadesktop.javaBean.Login;
import com.br.lojadesktop.vendas.DAO.LoginDAO;

import junit.framework.TestCase;



/**
 * @author gabrielgaleazzi
 *
 */
public class TestLoginDAO extends TestCase{

	LoginDAO dao = new LoginDAO();
	public void testLogin() throws Exception
	{
		Login login = new Login();
		login.setSenha("215080");
		login.setuser("telec@e.com");
		Object logado = dao.Login(login);
		if(logado==null)
			System.out.println("Usuario e senha invalidos");
		else
		System.out.println(logado.getClass().toString());
		
	}

}
