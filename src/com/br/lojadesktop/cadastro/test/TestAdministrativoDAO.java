/**
 * 
 */
package com.br.lojadesktop.cadastro.test;

import com.br.lojadesktop.ConexaoBanco.BD;
import com.br.lojadesktop.cadastro.DAO.AdministrativoDAO;
import com.br.lojadesktop.cadastro.javaBean.Gerente;
import com.br.lojadesktop.cadastro.javaBean.Vendedor;

import junit.framework.TestCase;

/**
 * @author Rafael S. Vieira
 *
 * 
 */
public class TestAdministrativoDAO extends TestCase {
	public void testAdmDAO() throws Exception{
	BD bd = new BD ("com.mysql.jdbc.Driver",
	           "jdbc:mysql://localhost/loja",
	           "root", "Rafa9074");
	AdministrativoDAO adm = new AdministrativoDAO(bd);
	Vendedor vend = new Vendedor("Rafael","Souza","40769055800","36695190","13330010","","19992534332","","r9@r9.com.br","7723456");
	Gerente ger= new Gerente("Joao","marcos","57919372291","566001890","13330010","","","","g@g.com.br","123456");
	System.out.println(ger.toString());
	//adm.createFuncionario(ger);
	//adm.createFuncionario(vend);
	//ger.setNome("Romario");
	//ger.setLogin("kasda@r1.com.br", "098765");
	//adm.altereFuncionarioNome(vend);
	adm.altereFuncionarioCPF(ger);
	adm.altereFuncionarioCPF(vend);
	//adm.deleteFuncionario(ger);
	//adm.deleteFuncionario(vend);
	
	}
	
}
