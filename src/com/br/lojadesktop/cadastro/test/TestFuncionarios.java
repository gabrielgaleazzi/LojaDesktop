/**
 * 
 */
package com.br.lojadesktop.cadastro.test;

import com.br.lojadesktop.cadastro.javaBean.Funcionarios;

import junit.framework.TestCase;

/**
 * @author Rafael S. Vieira
 *
 * 
 */
public class TestFuncionarios extends TestCase {
	public void testFuncionarios(){
		try {
			Funcionarios g = new Funcionarios("Rafael","40769055800","36695190","ra@sa.com","123112");
			System.out.println(g.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
