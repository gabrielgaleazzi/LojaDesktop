/**
 * 
 */
package com.br.lojadesktop.vendas.DAO;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
		List<?> lista =  em.createQuery("from Login where"
				+ " user = :user and senha = :senha").
		 setParameter("user", login.getuser()).
		 setParameter("senha", login.getSenha()).
		 getResultList();
		if(lista.size()==0)
			return null;
		Login logado = (Login) lista.get(0);
		if(logado.getTipo()=='C')
		//return ClienteDAO.getCliente(logado.getId());	
		if(logado.getTipo()=='V')	
		return null;	
			 
		
		 
		return null;
	}
	
	
	
}
