/**
 * 
 */
package com.br.lojadesktop.test;
import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import com.br.lojadesktop.cadastro.javaBean.Administrativo;

/**
 * @author Rafael S. Vieira
 *
 * 
 */
public class TestAdministrativo extends TestCase {
	public void testConstAdministrativo() throws Exception{
		Administrativo adm= new Administrativo("Rafael","407.690.558-00","36.695.189-0");
	}
}
