/**
 * 
 */
package com.br.lojadesktop.vendas.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.br.lojadesktop.cadastro.javaBean.Produto;
import com.br.lojadesktop.vendas.DAO.ProdutoDAO;

import junit.framework.TestCase;



/**
 * @author gabrielgaleazzi
 *
 */
public class TestProdutoDAO extends TestCase{

	ProdutoDAO dao = new ProdutoDAO();
	
	
	public void testNewProduto() throws Exception
	{
		String res ;
		Produto produto = new Produto();
		produto.setDescricao("Segunda Camisa do SPFC, temporada 2009/2010, Material: Penalty");
		produto.setNome("Camisa SPFC");
		produto.setQuantidade(3);
		produto.setTipo("Esporte/Roupas");
		produto.setValor(new BigDecimal(199.99));
		res = dao.newProduto(produto);
		System.out.println(res);
		
		Produto produto1 = new Produto();
		produto1.setDescricao("Primeira Camisa do Tolima, temporada 2009/2010, Material: Puma");
		produto1.setNome("Camisa Tolima");
		produto1.setQuantidade(2);
		produto1.setTipo("Esporte/Roupas");
		produto1.setValor(new BigDecimal(159.99));
		res = dao.newProduto(produto1);
		System.out.println(res);
		
		Produto produto2 = new Produto();
		produto2.setDescricao("Chuteira da Nike Tiempo, Society 2014 Branca e Verde");
		produto2.setNome("Nike Tiempo Society");
		produto2.setQuantidade(8);
		produto2.setTipo("Esporte/Acessorios");
		produto2.setValor(new BigDecimal(269.99));
		res = dao.newProduto(produto2);
		System.out.println(res);
		
		Produto produto3 = new Produto();
		produto3.setDescricao("Notebook HP, i7, HD de 1tb ");
		produto3.setNome("Notebook HP 18' ");
		produto3.setQuantidade(10);
		produto3.setTipo("Tecnologia");
		produto3.setValor(new BigDecimal(2229.99));
		res = dao.newProduto(produto3);
		System.out.println(res);
		
		Produto produto4 = new Produto();
		produto4.setDescricao("Sony PlayStation 4 com Fifa 15 e 2 controles");
		produto4.setNome("PlayStation 4");
		produto4.setQuantidade(20);
		produto4.setTipo("Games");
		produto4.setValor(new BigDecimal(1999.99));
		res = dao.newProduto(produto4);
		System.out.println(res);
		
		Produto produto5 = new Produto();
		produto5.setDescricao("Sony Bravia TV 60'");
		produto5.setNome("TV Sony Bravia");
		produto5.setQuantidade(20);
		produto5.setTipo("Televisao");
		produto5.setValor(new BigDecimal(3999.99));
		res = dao.newProduto(produto5);
		System.out.println(res);
		
		Produto produto6 = new Produto();
		produto6.setDescricao("Jogo de Futebol Fifa 15, PT-BR");
		produto6.setNome("Fifa 15");
		produto6.setQuantidade(20);
		produto6.setTipo("Games");
		produto6.setValor(new BigDecimal(159.45));
		res = dao.newProduto(produto6);
		System.out.println(res);
		
		System.out.println("-----------------------------------------------------------------");
		
	}
	
	public void testSellProduto() throws Exception
	{
		Produto produto = new Produto();
		produto.setDescricao("Segunda Camisa do SPFC, temporada 2009/2010, Material: Penalty");
		produto.setNome("Camisa SPFC");
		produto.setQuantidade(3);
		produto.setTipo("Esporte/Roupas");
		produto.setValor(new BigDecimal(199.99));
		int op =  dao.SellProduto(produto);
		if (op==1)
			System.out.println("Produto Vendido");
		else
			System.out.println("Produto indisponivel do estoque");
		System.out.println("-----------------------------------------------------------------");
		
	}
	
	public void testBuscaProduto() 
	{
		@SuppressWarnings("unchecked")
		List<Produto> lista = (List<Produto>) dao.getList("TV Sony");
		System.out.println("-----------------------------------------------------------------");
		for(Produto produto:lista)
		{
			System.out.println(produto.toString());
		}
	}
	
	public void testSellProdutosLista() throws Exception
	{
		ArrayList<Produto> lista = new ArrayList<Produto>();
		System.out.println("-----------------------------------------------------------------");
		Produto produto = new Produto();
		produto.setDescricao("Segunda Camisa do SPFC, temporada 2009/2010, Material: Penalty");
		produto.setNome("Camisa SPFC");
		produto.setQuantidade(3);
		produto.setTipo("Esporte/Roupas");
		produto.setValor(new BigDecimal(199.99));
		Produto produto3 = new Produto();
		
		produto3.setDescricao("Notebook HP, i7, HD de 1tb ");
		produto3.setNome("Notebook HP 18' ");
		produto3.setQuantidade(10);
		produto3.setTipo("Tecnologia");
		produto3.setValor(new BigDecimal(2229.99));
		lista.add(produto);
		lista.add(produto3);
		
		dao.SellProduto(lista);
		
	}
	public void testBuscaporValor() throws Exception
	{
		System.out.println("-----------------------------------------------------------------");
		@SuppressWarnings("unchecked")
		List<Produto> lista = (List<Produto>) dao.getList(new BigDecimal("159.45"));
		
		for(Produto pr:lista)
		{
			System.out.println(pr.toString());
		}
	
	}
	
	public void testBuscaProdutoUnico() throws Exception
	{
		System.out.println("-----------------------------------------------------------------");
		Produto produto = new Produto();
		produto.setDescricao("Segunda Camisa do SPFC");
		produto.setNome("Camisa SPFC");
		produto.setTipo("Esporte/Roupas");
		produto = dao.getProduto(produto);
		System.out.println(produto.toString());
	}
	
	public void testBuscaEntreValores() throws Exception
	{
		System.out.println("lista -----------------------------------------------------------------");
		@SuppressWarnings("unchecked")
		List<Produto> lista = (List<Produto>) dao.getList(new BigDecimal("0"),new BigDecimal("300"));
		
		for(Produto pr:lista)
		{
			System.out.println(pr.toString());
		}
		
	}
	
	public void testContem()
	{
		System.out.println("contem -----------------------------------------------------------------");
		ArrayList<Produto> lista = (ArrayList<Produto>) dao.getList(new BigDecimal("159.45"));
	ArrayList<Produto> list = dao.ContainsProducts(lista);
	System.out.println("kaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+list.size());
	}
	
	public void testNContem()
	{
		System.out.println("nao contem -----------------------------------------------------------------");
		ArrayList<Produto> lista = (ArrayList<Produto>) dao.getList(new BigDecimal("159.45"));
		Produto produto = new Produto();
		produto.setNome("Teste");
		lista.add(produto);
		Produto produto1 = new Produto();
		produto1.setNome("Camisa Santos");
		lista.add(produto1);
		
	ArrayList<Produto> list = dao.ContainsProducts(lista);
	for(Produto p:list)
	{
		System.out.println(p.toString());
	}
	}
 
}
