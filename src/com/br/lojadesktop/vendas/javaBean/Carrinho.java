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

	@Override
	public String toString() {
		return "Carrinho [produtos=" + produtos + ", cliente=" + cliente
				+ ", valor=" + valor + "]";
	}
	
	public ArrayList<Produtos> getProdutos() {
		return produtos;
	}
	public void setProdutos(ArrayList<Produtos> produtos) {
		this.produtos = produtos;
		setValor();
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
		if(produtos.size()==0)
			this.valor = new BigDecimal(0);
		BigDecimal soma = new BigDecimal(0);
		for (Produtos p : produtos)
			soma = soma.add(p.getValor());
	
		this.valor=soma;
		
	}
	private ArrayList<Produtos> produtos;
	private Cliente cliente;
	private BigDecimal valor;
	
	public String getValorReal()  {
		
		java.text.DecimalFormat df = new java.text.DecimalFormat( "#,##0.00" ); 
		return "R$ "+df.format(this.valor);
	}
	
	
}
