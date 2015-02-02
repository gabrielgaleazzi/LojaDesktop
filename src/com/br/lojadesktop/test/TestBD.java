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
	public void testBD(){
		System.out.println(BD.statusConection());

	}
}
