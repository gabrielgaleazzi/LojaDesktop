/**
 * 
 */
package com.br.lojadesktop.vendas.javaBean;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


import com.br.lojadesktop.cadastro.javaBean.Produto;

/**
 * @author gabrielgaleazzi
 *
 */
@Entity
public class Carrinho {
	
	@Id
    @GeneratedValue
	private int id;
	private ArrayList<Produto> produtos;
	@OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	private BigDecimal valor;
	
	@OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name="produto_id")
	private Produto produto;
	
	
	public Carrinho(Produto produto, Cliente cliente)
	{
		super();
		this.produto=produto;
		this.cliente=cliente;
	}
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
		return "Carrinho [produtos=" + produtos + ", cliente=" + cliente
				+ ", valor=" + valor + "]";
	}
	
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
		setValor();
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Carrinho(int id, ArrayList<Produto> produtos, Cliente cliente,
			BigDecimal valor) {
		super();
		this.id=id;
		this.produtos = produtos;
		this.cliente = cliente;
		this.valor = valor;
	}
	public Carrinho() {}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor() {
		if(produtos.size()==0)
			this.valor = new BigDecimal(0);
		BigDecimal soma = new BigDecimal(0);
		for (Produto p : produtos)
			soma = soma.add(p.getValor());
	
		this.valor=soma;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getValorReal()  {
		
		java.text.DecimalFormat df = new java.text.DecimalFormat( "#,##0.00" ); 
		return "R$ "+df.format(this.valor);
	}

	
	
	
}
