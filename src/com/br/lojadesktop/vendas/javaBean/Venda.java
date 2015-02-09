/**
 * 
 */
package com.br.lojadesktop.vendas.javaBean;



import java.util.Date;

import javax.persistence.*;

import com.br.lojadesktop.cadastro.javaBean.Produto;

/**
 * @author gabrielgaleazzi
 *
 */
@Entity 
public class Venda {
	@Id
	@GeneratedValue
	private int id;
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Enumerated(EnumType.STRING)
	@Column(name="pagamento")
	private Pagamento tipo;
	@ManyToOne
    @JoinColumn(name = "produto_id")
	private Produto produto;
	@ManyToOne
    @JoinColumn(name = "cliente_id")
	private Cliente cliente;
	@Column(name="Data")
	@Temporal(TemporalType.DATE)
	private Date data;
	
	public Venda(Produto produto, Cliente cliente, Pagamento tipo, Date data)
	{
		
		this.tipo=tipo;
		this.produto=produto;
		this.cliente=cliente;
		this.data = data;
		
	}
	
	public Venda(){}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Pagamento getTipo() {
		return tipo;
	}

	public void setTipo(Pagamento tipo) {
		this.tipo = tipo;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", tipo=" + tipo + ", produto=" + produto
				+ ", cliente=" + cliente + ", data=" + data + "]";
	}
	
	
}
