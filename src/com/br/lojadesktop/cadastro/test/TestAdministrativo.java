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

		public void TestAdm()
		{
			
			try {
				Administrativo adm = new Administrativo("Rafael","41954438818","41954438818","r@r.com","123456");
				adm.toString();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
}
