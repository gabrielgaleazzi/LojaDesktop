/**
 * 
 */
package com.br.lojadesktop.vendas.test;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.br.lojadesktop.cadastro.javaBean.Produtos;
import com.br.lojadesktop.vendas.javaBean.Carrinho;
import com.br.lojadesktop.vendas.javaBean.Cliente;
import com.br.lojadesktop.vendas.javaBean.ClienteJuridico;
import com.br.lojadesktop.vendas.javaBean.Pagamento;
import com.br.lojadesktop.vendas.javaBean.Venda;

import junit.framework.TestCase;

/**
 * @author gabrielgaleazzi
 *
 */
public class TestVenda extends TestCase {

	public void testNovaVenda() throws Exception
	{
		Cliente cliente = new ClienteJuridico("27815518000130");
		cliente.setCelular("(16)99777-7974");
		cliente.setTelefone("(16)3322-0504");
		cliente.setComplemento("Ap. 123");
		cliente.setId(0);
		cliente.setLogin("g@g.com","g306090");
		cliente.setNome("Gabriel");
		cliente.setSobrenome("Galeazzi");
		Carrinho carrinho = new Carrinho();
		Produtos produto1 = 
		new Produtos(0,"Bola","Futebol",
		"Bola de Futebol da Nike",
		new BigDecimal(99.90));
		Produtos produto2 =
		new Produtos(0,"Camisa","Futebol",
		"Camisa de Futebol da Nike",
		new BigDecimal(150));
		ArrayList<Produtos> lista = new ArrayList<Produtos>();
		lista.add(produto1);
		lista.add(produto2);
		carrinho.setProdutos(lista);
		carrinho.setCliente(cliente);
		Venda venda = new Venda(carrinho,Pagamento.Real);
		System.out.println(venda.toString());
	}
	
	public void testNovaVenda1() throws Exception
	{
		Cliente cliente = new ClienteJuridico("27815518000130");
		cliente.setCelular("(16)99777-7974");
		cliente.setTelefone("(16)3322-0504");
		cliente.setComplemento("Ap. 123");
		cliente.setId(0);
		cliente.setLogin("g@g.com","g306090");
		cliente.setNome("Gabriel");
		cliente.setSobrenome("Galeazzi");
		Carrinho carrinho = new Carrinho();
		Produtos produto1 = 
		new Produtos(0,"Bola","Futebol",
		"Bola de Futebol da Nike",
		new BigDecimal(99.90));
		Produtos produto2 =
		new Produtos(0,"Camisa","Futebol",
		"Camisa de Futebol da Nike",
		new BigDecimal(150));
		ArrayList<Produtos> lista = new ArrayList<Produtos>();
		lista.add(produto1);
		lista.add(produto2);
		carrinho.setProdutos(lista);
		carrinho.setCliente(cliente);
		Venda venda = new Venda(carrinho,Pagamento.Credito);
		System.out.println(venda.toString());
	}
}
