/**
 * 
 */
package com.br.lojadesktop.cadastro.DAO;

import com.br.lojadesktop.ConexaoBanco.BD;
import com.br.lojadesktop.cadastro.javaBean.Administrativo;
import com.br.lojadesktop.cadastro.javaBean.Gerente;
import com.br.lojadesktop.cadastro.javaBean.Vendedor;
import com.br.lojadesktop.vendas.javaBean.ClienteFisico;
import com.br.lojadesktop.vendas.javaBean.ClienteJuridico;

/**
 * @author Rafael S. Vieira
 *
 * 
 */
public class AdministrativoDAO {
	
	private BD bd;
	public AdministrativoDAO(BD bd){
		this.bd=bd;
	}
	public void createFuncionario(Administrativo adm){
		if(adm.getClass()==Gerente.class)
			createGerente((Gerente) adm);
		else
			createVendedor((Vendedor) adm);
		
	}
	private void createVendedor(Vendedor vend){
		
	}
	private void createGerente(Gerente gerente){
		
	}
	public void altereFuncionario(){
		
	}
	public void deleteFuncionario(){
		
	}
}