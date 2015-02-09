/**
 * 
 */
package com.br.lojadesktop.cadastro.test;

import com.br.lojadesktop.cadastro.javaBean.Vendedor;

import junit.framework.TestCase;

/**
 * @author Rafael S. Vieira
 *
 * 
 */
public class TestFuncionarios extends TestCase {
	public void testFuncionarios(){
		try {
			Vendedor g = new Vendedor("Rafael","Souza","40769055800","36695190","13330010","","19992534332","","ra@sa.com","123112");
			System.out.println(g.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
