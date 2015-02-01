/**
 * 
 */
package com.br.lojadesktop.cadastro.test;

import com.br.lojadesktop.cadastro.javaBean.Administrativo;
import junit.framework.TestCase;

/**
 * @author Rafael S. Vieira
 *
 * 
 */
public class TestAdministrativo extends TestCase {

		public void testAdm()
		{
			
			try {
				Administrativo adm = new Administrativo("Rafael","4076905580","36695190");
				System.out.println(adm.toString());
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
}
