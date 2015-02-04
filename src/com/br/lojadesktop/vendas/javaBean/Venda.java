/**
 * 
 */
package com.br.lojadesktop.vendas.javaBean;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;

import com.br.lojadesktop.cadastro.javaBean.Produto;

/**
 * @author gabrielgaleazzi
 *
 */
public class Venda extends Carrinho{

	private Pagamento tipo;

	public Pagamento getTipo() {
		return tipo;
	}

	public void setTipo(Pagamento tipo) {
		this.tipo = tipo;
	}

	public Venda(int id, ArrayList<Produto> produtos, Cliente cliente,
			BigDecimal valor, Pagamento tipo) {
		super(id, produtos, cliente, valor);
		this.tipo = tipo;
	}

	
	public String toString() {
		return "Venda [tipo=" + tipo + ", getProdutos()=" + getProdutos()
				+ ", getCliente()=" + getCliente() + ", getValorReal()="
				+ getValorReal() + ", getValorRealDesconto()=" + getValorRealDesconto() + "]";
	}

	public Venda(int id, Carrinho carrinho, Pagamento tipo) {
		super(id, carrinho.getProdutos(), carrinho.getCliente(), carrinho.getValor());
		this.tipo = tipo;
	}
	
	public String getValorRealDesconto()  {
		
		DecimalFormat df = new DecimalFormat( "#,##0.00" ); 
		
		BigDecimal desconto = new BigDecimal(this.tipo.getDesconto());
		if(desconto.doubleValue() == 0)
		return "R$ "+df.format(this.getValor());
		BigDecimal descontofinal = this.getValor().divide(desconto);
		
		return "R$ "+df.format(this.getValor().subtract(descontofinal));
	}
	
	
	
	
	
}
