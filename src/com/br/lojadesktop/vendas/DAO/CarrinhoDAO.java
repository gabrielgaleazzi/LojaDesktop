/**
 * 
 */
package com.br.lojadesktop.vendas.DAO;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.br.lojadesktop.cadastro.javaBean.Produto;
import com.br.lojadesktop.vendas.javaBean.Carrinho;
import com.br.lojadesktop.vendas.javaBean.Cliente;

/**
 * @author gabrielgaleazzi
 *
 */
public class CarrinhoDAO {
	
	private final   EntityManagerFactory factory =
			Persistence.createEntityManagerFactory("loja");
	 private final   EntityManager em = factory.createEntityManager();
	
	 public CarrinhoDAO () {
		 
	 }
	 
	 public void Update()
	 {
		 em.getTransaction().begin();
		 em.createQuery("Delete from Carrinho where quantidade = 0").executeUpdate();
		 em.getTransaction().commit();
	}
	 
	
	 private void ChangeQuantidade(Cliente cliente, Produto produto, int quantidade)
	 {
		 em.getTransaction().begin();
		 em.createQuery("Update from Carrinho set quantidade = quantidade + :quantidade where"
		 		+ " cliente_id = :cliente_id and "
		 		+ " produto_id = :produto_id").
		 		setParameter("quantidade", quantidade).
		 		setParameter("cliente_id", cliente.getId()).
		 		setParameter("produto_id", produto.getId()).executeUpdate();
		 em.getTransaction().commit();
	 }
	 private boolean ContainsProductInCart(Cliente cliente, Produto produto)
	 {
		List<?> lista = em.createQuery("from Carrinho where"
		 		+ " cliente_id = :cliente_id and "
		 		+ " produto_id = :produto_id").
		 		setParameter("cliente_id", cliente.getId()).
		 		setParameter("produto_id", produto.getId()).getResultList();
		return  lista.size()==0?false:(((Carrinho) lista.get(0)).getQuantidade()>0)?true:false;
	
	 }
	 public void addToCart(Cliente cliente, Produto produto, int quantidade)
	 {
		 Carrinho carrinho = new Carrinho();
		 carrinho.setCliente(cliente);
		 carrinho.setProduto(produto);
		 carrinho.setQuantidade(quantidade);
		 addToCart(carrinho);
	 }
	 public void addToCart(Carrinho carrinho)
	 {
		 Update();
		 if(ContainsProductInCart(carrinho.getCliente(),carrinho.getProduto()))
		 {
			ChangeQuantidade(carrinho.getCliente(),carrinho.getProduto(),carrinho.getQuantidade());
			return ;
		 }
		 em.getTransaction().begin();
		 em.persist(carrinho);
		 em.getTransaction().commit();
	 }
	 public void addToCart(Cliente cliente, ArrayList<Produto> produtos,int quantidade)
	 {
		 for (Produto produto:produtos)
		 {
			 addToCart(cliente,produto,quantidade);
		 }
	 }
	 
	 public void RemoveAllToCart(Cliente cliente)
	 {
		 em.getTransaction().begin();
		 em.createQuery("Delete from Carrinho where"
		 		+ " cliente_id = :cliente_id ").
		 		setParameter("cliente_id", cliente.getId()).executeUpdate();
		 em.getTransaction().commit();
	 }
	 public void RemoveToCart(Cliente cliente, Produto produto)
	 {
		 Update();
		 em.getTransaction().begin();
		 em.createQuery("Delete from Carrinho where"
		 		+ " cliente_id = :cliente_id and "
		 		+ " produto_id = :produto_id").
		 		setParameter("cliente_id", cliente.getId()).
		 		setParameter("produto_id", produto.getId()).executeUpdate();
		 em.getTransaction().commit();
		 
	 }
	 
	
	 public void RemoveToCart(Carrinho carrinho)
	 {
		 RemoveToCart(carrinho.getCliente(),carrinho.getProduto());
	 }
	 
	 public Carrinho SelectCart (Cliente cliente)
	 {
		 Update();
		@SuppressWarnings("unchecked")
		List <Carrinho> lista =   (List<Carrinho>) em.createQuery("from Carrinho where cliente_id = :cliente_id").
		 setParameter("cliente_id", cliente.getId()).getResultList();
		Carrinho retornado = new Carrinho();
		retornado.setCliente(lista.get(0).getCliente());
		ArrayList<Produto> list = new ArrayList<Produto>();
		for(Carrinho carrinho:lista)
		{
			Produto produto = carrinho.getProduto();
			produto.setQuantidade(carrinho.getQuantidade());
			list.add(produto);
			
		}
		retornado.setProdutos(list);
		return retornado;
	 }
	 
	 
}