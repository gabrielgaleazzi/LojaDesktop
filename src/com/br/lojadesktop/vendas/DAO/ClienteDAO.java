/**
 * 
 */
package com.br.lojadesktop.vendas.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.br.lojadesktop.vendas.javaBean.Cliente;

/**
 * @author gabrielgaleazzi
 *
 */
public class ClienteDAO {

	 private final EntityManagerFactory factory =
				Persistence.createEntityManagerFactory("loja");
		 private final EntityManager em = factory.createEntityManager();
		 
		 public void NovoClienteFisico(Cliente cliente)
		 {
			   em.getTransaction().begin();
				em.persist(cliente);
				em.getTransaction().commit(); 
		 }
}
