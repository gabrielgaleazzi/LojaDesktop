//falta imagem
/**
 * 
 */
package com.br.lojadesktop.cadastro.javaBean;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.br.lojadesktop.valid.Valid;
/**
 * @author Rafael S. Vieira
 *
 * 
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED) 
public class Produto {
	@Id
    @GeneratedValue
	private int id;
	@Column
	private String nome;
	@Column
	private String tipo;
	@Column
	private String descricao;
	@Column
	private BigDecimal valor;
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	@Column
	private int quantidade;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Produto(int id, String nome, String tipo, String descricao,
			BigDecimal valor) throws Exception {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.descricao = descricao;
		setValor(valor);
	}
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
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
	
	public Double getDoubleValor()
	{
		return this.valor.doubleValue();
	}
	@Override
	public String toString() {
		return "Produtos [id=" + id + ", Nome=" + nome
				+ ", Tipo=" + tipo + ", descricao=" + descricao + ", valor="
				+ valor + "]";
	}
	public void setValor(BigDecimal valor) throws Exception {
	if(!Valid.validValor(valor))
		throw new Exception("Valor invalido");
	
		this.valor = valor;
	} 
	
	public Produto(){}
	
}