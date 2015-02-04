package com.br.lojadesktop.vendas.test;

/**
 * 
 */





import java.math.BigDecimal;
import java.util.ArrayList;

import com.br.lojadesktop.cadastro.javaBean.Produto;
import com.br.lojadesktop.vendas.javaBean.Carrinho;
import com.br.lojadesktop.vendas.javaBean.Cliente;
import com.br.lojadesktop.vendas.javaBean.ClienteFisico;

import junit.framework.TestCase;

/**
 * @author gabrielgaleazzi
 *
 */
public class TestCarrinho extends TestCase {
	public void testNovoCarrinho() 
	{
		
		try {
			
			Cliente cliente;
			cliente = new ClienteFisico("41954438818","41954438818");
			cliente.setCelular("(16)99777-7974");
			cliente.setTelefone("(16)3322-0504");
			cliente.setComplemento("Ap. 123");
			cliente.setId(0);
			cliente.setLogin("g@g.com","g306090");
			cliente.setNome("Gabriel");
			cliente.setSobrenome("Galeazzi");
			Carrinho carrinho = new Carrinho();
			Produto produto1 = 
			new Produto(0,"Bola","Futebol",
			"Bola de Futebol da Nike",
			new BigDecimal(99.90));
			Produto produto2 =
			new Produto(0,"Camisa","Futebol",
			"Camisa de Futebol da Nike",
			new BigDecimal(150));
			ArrayList<Produto> lista = new ArrayList<Produto>();
			lista.add(produto1);
			lista.add(produto2);
			carrinho.setProdutos(lista);
			carrinho.setCliente(cliente);
			System.out.println(carrinho.toString());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void testNovoCarrinho1() 
	{
		
		try {
			
			Cliente cliente;
			cliente = new ClienteFisico("41954438818","41954438818");
			cliente.setCelular("(16)99777-7974");
			cliente.setTelefone("(16)3322-0504");
			cliente.setComplemento("Ap. 123");
			cliente.setId(0);
			cliente.setLogin("g@g.com","g306090");
			cliente.setNome("Gabriel");
			cliente.setSobrenome("Galeazzi");
			Carrinho carrinho = new Carrinho();
			ArrayList<Produto> lista = new ArrayList<Produto>();
			carrinho.setProdutos(lista);
			carrinho.setCliente(cliente);
			System.out.println(carrinho.getValorReal());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}



