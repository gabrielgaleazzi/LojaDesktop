/**
 * 
 */
package com.br.lojadesktop.vendas.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author gabrielgaleazzi
 *
 */
public class CarrinhoDAO {
	
	private final  EntityManagerFactory factory =
			Persistence.createEntityManagerFactory("loja");
	 private final  EntityManager em = factory.createEntityManager();
	
}