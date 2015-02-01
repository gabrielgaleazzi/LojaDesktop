/**
 * 
 */
package com.br.lojadesktop.cadastro.test;

import com.br.lojadesktop.cadastro.javaBean.Gerente;

import junit.framework.TestCase;

/**
 * @author Rafael S. Vieira
 *
 * 
 */
public class TestGerente extends TestCase {
	public void testGerente(){
		try {
			Gerente g = new Gerente("Rafael","40769055800","36695190","ra@sa.com","123112");
			System.out.println(g.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
