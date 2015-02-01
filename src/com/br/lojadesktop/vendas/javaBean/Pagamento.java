/**
 * 
 */
package com.br.lojadesktop.vendas.javaBean;

/**
 * @author gabrielgaleazzi
 *
 */
public enum Pagamento {

	Credito("Crédito",0),
	Debito("Débito",5),
	Bitcoin("Bitcoin",0),
	Pontos("Pontos",0),
	Real("Reais(R$)",10);
	
	private String moeda;
	private int desconto;
	
	private Pagamento(String moeda, int desconto) {
		this.moeda = moeda;
		this.desconto = desconto;
	}
	
	

	public String getMoeda() {
		return moeda;
	}

	public void setMoeda(String moeda) {
		this.moeda = moeda;
	}

	public int getDesconto() {
		return desconto;
	}

	public void setDesconto(int desconto) {
		this.desconto = desconto;
	}
	
	
	

	

	

	
	
	
	
	
	
	
}
