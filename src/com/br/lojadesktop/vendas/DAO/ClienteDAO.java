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
		
		 public ClienteDAO()
		 {
			em.getTransaction().begin(); 
		 }
		 public void NewCliente(Cliente cliente)
		 {
			   
				em.persist(cliente);
				em.getTransaction().commit(); 
		 }
		 public void DeleteCliente(Cliente cliente)
		 {
			if(cliente.getClass()==ClienteJuridico.class)
				DeleteJuridico((ClienteJuridico) cliente);
			else
				DeleteFisico((ClienteFisico) cliente);
			
		 }
		 private void DeleteJuridico(ClienteJuridico cliente)
		 {
			
			 em.createQuery("delete from Cliente where cnpj = :cnpj ").setParameter("cnpj", cliente.getCnpj()).executeUpdate();
			 em.createQuery("delete from Login where user= :user ").setParameter("user",cliente.getLogin().getuser()).executeUpdate();
			 em.getTransaction().commit(); 
		 }
		 private void DeleteFisico(ClienteFisico cliente)
		 {
			
			 em.createQuery("delete from Cliente where cpf = :cpf ").setParameter("cpf", cliente.getCpf()).executeUpdate();
			 em.createQuery("delete from Login where user= :user ").setParameter("user",cliente.getLogin().getuser()).executeUpdate();
			 em.getTransaction().commit(); 
		 }
		 public void UpdateCliente(Cliente alterado)
		 {
			 if(alterado.getClass()==ClienteJuridico.class)
				 UpdateClienteJuridico((ClienteJuridico) alterado);
			 else
				 UpdateClienteFisico((ClienteFisico) alterado);
				 
		 }
		 private void UpdateClienteFisico(ClienteFisico alterado)
		 {
			 
			 
			 em.createQuery("update Cliente set sobrenome = :sobrenome "
			 							 + ",nome = :nome "
			 							 + ",cep = :cep "
			 							 + ",complemento = :complemento "
			 							 + ",celular = :celular "
			 							 + ",telefone = :telefone "
			 							 + "where cpf = :cpf  ").
			 setParameter("sobrenome", alterado.getSobrenome()).
			 setParameter("nome", alterado.getNome()).
			 setParameter("cep", alterado.getCep()).
			 setParameter("complemento", alterado.getComplemento()).
			 setParameter("celular", alterado.getCelular()).
			 setParameter("telefone", alterado.getTelefone()).
			 setParameter("cpf", alterado.getCpf()).
			 executeUpdate();
			
			 em.getTransaction().commit(); 
		 }
		 private void UpdateClienteJuridico(ClienteJuridico alterado)
		 {
			
			 em.createQuery("update Cliente set sobrenome = :sobrenome "
			 							 + ",nome = :nome "
			 							 + ",cep = :cep "
			 							 + ",complemento = :complemento "
			 							 + ",celular = :celular "
			 							 + ",telefone = :telefone "
			 							 + "where cnpj = :cnpj  ").
			 setParameter("sobrenome", alterado.getSobrenome()).
			 setParameter("nome", alterado.getNome()).
			 setParameter("cep", alterado.getCep()).
			 setParameter("complemento", alterado.getComplemento()).
			 setParameter("celular", alterado.getCelular()).
			 setParameter("telefone", alterado.getTelefone()).
			 setParameter("cnpj", alterado.getCnpj()).
			 executeUpdate();
			 
			
			 em.getTransaction().commit();  
		 }
		 public void UpdateSenha(Cliente alterado)
		 {
			 
			 em.createQuery("update Login set senha = :senha "
			 							 + "where user = :user  ").
			 
			 setParameter("senha", alterado.getLogin().getSenha()).
			 setParameter("user", alterado.getLogin().getuser()).
			 executeUpdate();
			 em.getTransaction().commit();  
			
			
			 
		 }
		 public boolean Authorized(Cliente alterado)
		 {
			 return true;
			
		 }
		 public List<?> getList()
		 {
			 return em.createQuery("from Cliente").getResultList();
		 }
		 public List<?> getList(String nome)
		 {
			 return em.createQuery("from Cliente where nome like :nome or sobrenome like :sobrenome").setParameter("nome", "%"+nome+"%").setParameter("sobrenome", "%"+nome+"%").getResultList();
		 }
		 public Cliente getCliente(String info)
		 {
			 return (Cliente) em.createQuery("from Cliente where cpf = :cpf or cnpj = :cnpj").
					 setParameter("cpf", info).setParameter("cnpj", info).getResultList().get(0);
		 }
		 
		 public Venda ComprasEfetuadasDe( Cliente cliente)
		 {
			 return null;
		 }
		
		
		
		 
}
