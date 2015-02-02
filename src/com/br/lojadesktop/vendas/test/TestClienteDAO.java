/**
 * 
 */
package com.br.lojadesktop.vendas.test;


import java.util.List;

import junit.framework.TestCase;






import com.br.lojadesktop.vendas.DAO.ClienteDAO;
import com.br.lojadesktop.vendas.javaBean.Cliente;
import com.br.lojadesktop.vendas.javaBean.ClienteFisico;
import com.br.lojadesktop.vendas.javaBean.ClienteJuridico;

/**
 * @author gabrielgaleazzi
 *
 */
public class TestClienteDAO extends TestCase{

	ClienteDAO dao = new ClienteDAO();
	public void testClienteFisico() 
	{
		try {
			Cliente cliente = new ClienteFisico("4546546565","41954438818");
			cliente.setCelular("(16)99777-7974");
			cliente.setTelefone("(16)3322-0504");
			cliente.setComplemento("Ap. 123");
			cliente.setId(0);
			cliente.setLogin("g@g.com","205080");
			cliente.setNome("Gabriel");
			cliente.setSobrenome("Galeazzi");
			cliente.setCep("48788978");
			
			dao.NovoCliente(cliente);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void testClienteJuridico() 
	{
		try {
			Cliente cliente = new ClienteJuridico("27133699000114");
			cliente.setCelular("(16)99777-7974");
			cliente.setTelefone("(16)3322-0504");
			cliente.setComplemento("Ap. 123");
			cliente.setId(0);
			cliente.setLogin("l@l.com","205080");
			cliente.setNome("Gabriel");
			cliente.setSobrenome("Galeazzi");
			cliente.setCep("48788978");
			dao.NovoCliente(cliente);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void testListaClientes() 
	{
		try {
			@SuppressWarnings("unchecked")
			List<Cliente> lista = (List<Cliente>)dao.ListarClientes();
			for(Cliente cliente : lista)
			{
				System.out.println(cliente.toString());
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	

}
