/**
 * 
 */
package com.br.lojadesktop.vendas.DAO;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.br.lojadesktop.vendas.javaBean.Cliente;
import com.br.lojadesktop.vendas.javaBean.ClienteFisico;
import com.br.lojadesktop.vendas.javaBean.ClienteJuridico;
import com.br.lojadesktop.vendas.javaBean.Venda;

/**
 * @author gabrielgaleazzi
 *
 */
public class ClienteDAO {

	     private final EntityManagerFactory factory =
				Persistence.createEntityManagerFactory("loja");
		 private final EntityManager em = factory.createEntityManager();
		
		 public void NovoCliente(Cliente cliente)
		 {
			    em.getTransaction().begin();
				em.persist(cliente);
				em.getTransaction().commit(); 
		 }
		 public void DeletaCliente(Cliente cliente)
		 {
			if(cliente.getClass()==ClienteJuridico.class)
				DeletaJuridico((ClienteJuridico) cliente);
			else
				DeletaFisico((ClienteFisico) cliente);
			
		 }
		 private void DeletaJuridico(ClienteJuridico cliente)
		 {
			 em.getTransaction().begin();
			 em.createQuery("delete from Cliente where cnpj = :cnpj ").setParameter("cnpj", cliente.getCnpj()).executeUpdate();
			 em.createQuery("delete from Login where user= :user ").setParameter("user",cliente.getLogin().getuser()).executeUpdate();
			 em.getTransaction().commit(); 
		 }
		 private void DeletaFisico(ClienteFisico cliente)
		 {
			 em.getTransaction().begin();
			 em.createQuery("delete from Cliente where cpf = :cpf ").setParameter("cpf", cliente.getCpf()).executeUpdate();
			 em.createQuery("delete from Login where user= :user ").setParameter("user",cliente.getLogin().getuser()).executeUpdate();
			 em.getTransaction().commit(); 
		 }
		 public void AlteraCliente(Cliente atual,Cliente diferente)
		 {
			 
		 }
		 public List<?> ListarClientes()
		 {
			 return em.createQuery("from Cliente").getResultList();
		 }
		 public Cliente BuscaCliente()
		 {
			 return null;
		 }
		 
		 public Venda ComprasEfetuadasDe( Cliente cliente)
		 {
			 return null;
		 }
		
		
		 
}
