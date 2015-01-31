/**
 * 
 */
package com.br.lojadesktop.test;

import java.math.BigDecimal;

import com.br.lojadesktop.valid.Valid;

import junit.framework.TestCase;

/**
 * @author gabrielgaleazzi
 *
 */
public class TestValid extends TestCase {

	public void testValidCPF()
	{
		System.out.println("VALID CPF"+Valid.validCPF("41954438818"));
	}
	public void testValidRG()
	{
		System.out.println("VALID RG"+Valid.validRG("366951890"));
	}
	public void testValidCNPJ()
	{
		System.out.println("VALID CNPF"+Valid.validCPNJ("27133699000114"));
	}
	public void testValidLogin()
	{
		System.out.println("VALID Login"+Valid.validLogin("g@g.com"));
	}
	public void testValidSenha()
	{
		System.out.println("VALID Senha"+Valid.validSenha("306090"));
	}
	public void testValidTelefone()
	{
		System.out.println("VALID Telefone"+Valid.validTelefone("(16)99777-7974"));
	}
	public void testValidValor()
	{
		System.out.println("VALID Valor"+Valid.validValor(new BigDecimal(0)));
	}
	
	
}
