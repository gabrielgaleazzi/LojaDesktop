//falta imagem
/**
 * 
 */
package com.br.lojadesktop.cadastro.javaBean;
import java.math.BigDecimal;


import com.br.lojadesktop.valid.Valid;
/**
 * @author Rafael S. Vieira
 *
 * 
 */
public class Produtos {
	private int idProduto;
	private String Nome;
	private String Tipo;
	private String descricao;
	private BigDecimal valor;

	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public Produtos(int idProduto, String nome, String tipo, String descricao,
			BigDecimal valor) throws Exception {
		super();
		this.idProduto = idProduto;
		Nome = nome;
		Tipo = tipo;
		this.descricao = descricao;
		setValor(valor);
	}
	public String getTipo() {
		return Tipo;
	}
	
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getValorReal()  {
		
		java.text.DecimalFormat df = new java.text.DecimalFormat( "#,##0.00" ); 
		return "R$ "+df.format(this.valor);
	}
	public BigDecimal getValor()  {
			
		return this.valor;
		}
	@Override
	public String toString() {
		return "Produtos [idProduto=" + idProduto + ", Nome=" + Nome
				+ ", Tipo=" + Tipo + ", descricao=" + descricao + ", valor="
				+ valor + "]";
	}
	public void setValor(BigDecimal valor) throws Exception {
	if(!Valid.validValor(valor))
		throw new Exception("Valor invalido");
	
		this.valor = valor;
	} 
	
}