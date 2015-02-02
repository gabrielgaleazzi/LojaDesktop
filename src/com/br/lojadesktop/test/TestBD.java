/**
 * 
 */
package com.br.lojadesktop.test;

import com.br.lojadesktop.ConexaoBanco.BD;

import junit.framework.TestCase;

/**
 * @author Rafael S. Vieira
 *
 * 
 */
public class TestBD extends TestCase {
	public void testBD() throws Exception{
		BD bd = new BD ("com.mysql.jdbc.Driver",
		           "jdbc:mysql://localhost/loja",
		           "root", "Rafa9074");
		
		//bd.execComando(cmdSQL);
		//bd.execConsulta(qrySQL)
		bd.fecharConexao();

	}
}
