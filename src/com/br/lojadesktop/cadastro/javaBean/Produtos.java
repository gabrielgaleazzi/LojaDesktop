/**
 * 
 */
package com.br.lojadesktop.cadastro.javaBean;
import java.math.BigDecimal;
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
	private BigDecimal valor = new BigDecimal("0.00");//http://www.devmedia.com.br/java-bigdecimal-trabalhando-com-mais-precisao/30286
	//criar imagem
	
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
	public BigDecimal getValor()  {
		
		return valor;
	}
	
	public void setValor(BigDecimal valor) throws Exception {
		if(valor.signum()<=0)
			throw new Exception("Valor Inválido");
		this.valor = valor;
	} 
	
}
