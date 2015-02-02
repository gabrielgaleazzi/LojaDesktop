/**
 * 
 */
package com.br.lojadesktop.vendas.DAO;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
			 em.getTransaction().begin();
				Query query = (Query) em.createQuery("Delete from Profissional where user = :user");
				query.setParameter("user", cliente.getLogin().getuser());
				query.executeUpdate();
				em.getTransaction().commit();
			
		 }
		 public void AlteraCliente(Cliente atual,Cliente diferente)
		 {
			 
		 }
		 public ArrayList<Cliente> ListarClientes()
		 {
			 return null;
		 }
		 public Cliente BuscaCliente()
		 {
			 return null;
		 }
		 
		 public Venda ComprasEfetuadasDe( Cliente cliente)
		 {
			 return null;
		 }
		
		 public static void main(String args[])
		 {
			
				
					try {
						
						Cliente cliente = new ClienteFisico("41954438818","41954438818");
						cliente.setCelular("(16)99777-7974");
						cliente.setTelefone("(16)3322-0504");
						cliente.setComplemento("Ap. 123");
						cliente.setId(0);
						cliente.setLogin("g@g.com","205080");
						cliente.setNome("Gabriel");
						cliente.setSobrenome("Galeazzi");
						cliente.setCep("48788978");
						ClienteDAO dao = new ClienteDAO();
						dao.DeletaCliente(cliente);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				
		 }
		 
}
