/**
 * 
 */
package com.br.lojadesktop.vendas.javaBean;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.br.lojadesktop.cadastro.javaBean.Produtos;

/**
 * @author gabrielgaleazzi
 *
 */
public class Carrinho {

	public ArrayList<Produtos> getProdutos() {
		return produtos;
	}
	public void setProdutos(ArrayList<Produtos> produtos) {
		this.produtos = produtos;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor() {
		for (Produtos p : produtos)
		{
			
		}
	}
	private ArrayList<Produtos> produtos;
	private Cliente cliente;
	private BigDecimal valor;
	
	
	
	
}
