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
				Administrativo adm = new Administrativo("Rafael","Souza","40769055800","36695190","13330010","","19992534332","");
				System.out.println(adm.toString());
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
}
