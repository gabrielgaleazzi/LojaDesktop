package com.br.lojadesktop.vendas.test;

/**
 * 
 */







import com.br.lojadesktop.vendas.javaBean.Cliente;
import com.br.lojadesktop.vendas.javaBean.ClienteFisico;
import com.br.lojadesktop.vendas.javaBean.ClienteJuridico;

import junit.framework.TestCase;

/**
 * @author gabrielgaleazzi
 *
 */
public class TestCliente extends TestCase {

	public void testClienteFisico() 
	{
		try {
			Cliente cliente = new ClienteFisico("41954438818","41954438818");
			cliente.setCelular("(16)99777-7974");
			cliente.setTelefone("(16)3322-0504");
			cliente.setComplemento("Ap. 123");
			cliente.setId(0);
			cliente.setLogin("gg.com","g306090");
			cliente.setNome("Gabriel");
			cliente.setSobrenome("Galeazzi");
			
			System.out.println(cliente.toString());
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
			cliente.setLogin("g@g.com","g306090");
			cliente.setNome("Gabriel");
			cliente.setSobrenome("Galeazzi");
			
			System.out.println(cliente.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
}
