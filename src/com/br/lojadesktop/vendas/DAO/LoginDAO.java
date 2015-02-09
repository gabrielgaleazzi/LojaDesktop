/**
 * 
 */
package com.br.lojadesktop.vendas.DAO;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.br.lojadesktop.cadastro.javaBean.Produto;
import com.br.lojadesktop.javaBean.*;

/**
 * @author gabrielgaleazzi
 *
 */
public class LoginDAO {

	private final EntityManagerFactory factory =
			Persistence.createEntityManagerFactory("loja");
	 private final EntityManager em = factory.createEntityManager();
	 
	 public LoginDAO()
	 {
		 em.getTransaction().begin();
	 }
	public Object Login(Login login)
	{
		ClienteDAO dao = new ClienteDAO();
		List<?> lista =  em.createQuery("from Login where"
				+ " user = :user"
				+ " and senha = :senha").
		 setParameter("user", login.getuser()).
		 setParameter("senha", login.getSenha()).
		 getResultList();
		if(lista.size()==0)
			return null;
		Login logado = (Login) lista.get(0);
		if(logado.getTipo()=='C')
		return dao.getClienteLogged(logado.getId());	
		
	
		if(logado.getTipo()=='V')	
		return null;	
			 
		
		 
		return null;
	}
	public int getId(String user)
	{
		Login login =  (Login) em.createQuery("from Login where"
				+ " user = :user").
		 setParameter("user", user).getResultList().get(0);
		return login.getId();
	}
	
	public static void main(String args[])
	{
		LoginDAO l = new LoginDAO();
		int id = l.getId("a@a.com");
		System.out.println(id);
	}
	
}
