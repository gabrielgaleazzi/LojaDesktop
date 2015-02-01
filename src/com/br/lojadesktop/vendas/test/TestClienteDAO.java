/**
 * 
 */
package com.br.lojadesktop.vendas.test;

import static org.junit.Assert.*;
import junit.framework.TestCase;



import com.br.lojadesktop.vendas.DAO.ClienteDAO;
import com.br.lojadesktop.vendas.javaBean.Cliente;
import com.br.lojadesktop.vendas.javaBean.ClienteFisico;

/**
 * @author gabrielgaleazzi
 *
 */
public class TestClienteDAO extends TestCase{

	public void testClienteFisico() 
	{
		try {
			Cliente cliente = new Cliente();
			cliente.setCelular("(16)99777-7974");
			cliente.setTelefone("(16)3322-0504");
			cliente.setComplemento("Ap. 123");
			cliente.setId(0);
			cliente.setLogin("g@g.com","205080");
			cliente.setNome("Gabriel");
			cliente.setSobrenome("Galeazzi");
			ClienteDAO dao = new ClienteDAO();
			dao.NovoClienteFisico(cliente);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
