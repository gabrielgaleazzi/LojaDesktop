/**
 * 
 */
package com.br.lojadesktop.vendas.javaBean;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Transient;

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
	@Transient 
	private ArrayList<Produto> produtos;
	
	@ManyToOne
    @JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@Transient 
	private BigDecimal valor;
	
	@ManyToOne
    @JoinColumn(name = "produto_id")
	private Produto produto;
	
	private int quantidade;
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Carrinho(Produto produto, Cliente cliente,int quantidade)
	{
		super();
		this.produto=produto;
		this.cliente=cliente;
		this.quantidade=quantidade;
	}
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void addProduto(Produto produto)
	{
		produtos.add(produto);
	}
	
	
	@Override
	public String toString() {
		return "Carrinho [id=" + id + ", produtos=" + produtos + ", cliente="
				+ cliente + ", valor=" + valor + ", produto=" + produto
				+ ", quantidade=" + quantidade + "]";
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
		produtos = new ArrayList<Produto>();
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
