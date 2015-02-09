/**
 * 
 */
package com.br.lojadesktop.vendas.DAO;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
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
public class ProdutoDAO {

	 private final  EntityManagerFactory factory =
			Persistence.createEntityManagerFactory("loja");
	 private final  EntityManager em = factory.createEntityManager();
	 
	 public ProdutoDAO()
	 {
		 
	 }
	 
	 private void Update()
	 {
		 em.getTransaction().begin();
		 em.createQuery("Delete from Produto where quantidade = 0").executeUpdate();
		 em.getTransaction().commit(); 
	 }
	 public String newProduto(Produto produto)
	 {
		 Update();
		 em.getTransaction().begin(); 
		 if(ExisteProduto(produto))
		 {
			 em.createQuery("Update Produto set quantidade = quantidade + :quantidade"
			 		+ " where nome = :nome").
			 setParameter("quantidade", produto.getQuantidade()).
			 setParameter("nome", produto.getNome()).
			 executeUpdate();
			 
			 em.getTransaction().commit();
			 return "Quantidade do Produto "+produto.getNome()+" aumentada";
		 }
		 em.persist(produto);
		 em.getTransaction().commit();
		 return "Novo produto Cadastrado";
	 }
	 
	 private boolean ExisteProduto(Produto produto)
	 {
		 List<?> lista = (List<?>) em.createQuery("from Produto where nome = :nome").
				 setParameter("nome", produto.getNome()).
				 getResultList();
		 return lista.size()==0? false: true;
	 }
	 
	 private boolean Estoque(Produto produto)
	 {
		 List<?> lista = (List<?>) em.createQuery("from Produto where nome = :nome").
				 setParameter("nome", produto.getNome()).
				 getResultList();
		 return lista.size()==0? false: ((Produto) lista.get(0)).getQuantidade()==0?false:true;
	 }
	 
	 public int SellProduto(Produto produto)
	 {
		 Update();
		 if(Estoque(produto)){
		 em.getTransaction().begin(); 
		 em.createQuery("Update Produto set quantidade = quantidade -1"
			 		+ " where nome = :nome").
			 setParameter("nome", produto.getNome()).
			 executeUpdate();
		 	em.getTransaction().commit();
		 	return 1;
		 }
			 
			return 0;
	 }
	 
	 public void SellProduto(ArrayList<Produto> lista)
	 {
		 for(Produto produto:lista)
			 SellProduto(produto);
	 }
	 public void SellProduto(Carrinho carrinho)
	 {
		 for (Produto produto:carrinho.getProdutos())
		 {
			 SellProduto(produto);
		 }
	 }
	 
	 
	 public void UpdateProduto(Produto produto)
	 {
		 em.createQuery("Update Produto set valor = :valor"
			 		+ " where nome = :nome").
			 setParameter("valor", produto.getValor()).	
			 setParameter("nome", produto.getNome()).
			 executeUpdate();
	 }
	 
	 public List<?> getList()
	 {
		 return em.createQuery("from Produtos").getResultList();
	 }
	 
	 public List<?> getList(String info)
	 {
		 return em.createQuery("from Produto where descricao like :info1"
		 		+ " or nome like :info2"
		 		+ " or tipo like :info3").setParameter("info1", "%"+info+"%").setParameter("info2", "%"+info+"%").setParameter("info3", "%"+info+"%").getResultList();
	 }
	 
	 public Produto getProduto(Produto produto)
	 {
		 return (Produto) em.createQuery("from Produto where descricao like :descricao and"
			 		+ " nome like :nome"
			 		+ " and tipo like :tipo").
			 		setParameter("descricao", "%"+produto.getDescricao()+"%").
			 		setParameter("nome", "%"+produto.getNome()+"%").
			 		setParameter("tipo", "%"+produto.getTipo()+"%").
			 		getResultList().get(0);
	 }
	 
	 public List<?> getList(BigDecimal produto)
	 {
		 return (List<?>) em.createQuery("from Produto where valor = :valor").
				 setParameter("valor", produto).
				 getResultList();
	 }
	 
	 public List<?> getList(BigDecimal de, BigDecimal ate)
	 {
		 return (List<?>) em.createQuery("from Produto where valor between :de and :ate").
				 setParameter("de", de).
				 setParameter("ate", ate).
				 getResultList();
	 }
	 
	 public Produto getProduto(int id)
	 {
		return em.getReference(Produto.class, id);

	 }
	 
	 public ArrayList<Produto> ContainsProducts(ArrayList<Produto> lista)
	 {
		 ArrayList<Produto> list = new ArrayList<Produto>();
		 for(Produto produto:lista)
		 {
			 if(!Estoque(produto))
				 list.add(produto);
			
				 
		 }
		 
		 return list;
	 }
	 
	 
}
