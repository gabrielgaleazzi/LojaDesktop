/**
 * 
 */
package com.br.lojadesktop.valid;

import java.util.InputMismatchException;

/**
 * @author gabrielgaleazzi
 *
 */
public class Valid {

	public static boolean validCPF(String CPF)
	{
		char dig10,dig11;
		int sm, i, r, num, peso;
		
		try {
				sm = 0;
		        peso = 10;
		        for (i=0; i<9; i++) {   
		        	 num = (int)(CPF.charAt(i) - 48); 
		        	 sm = sm + (num * peso);
		        	 peso = peso - 1;
		        }
		        r = 11 - (sm % 11);
		        if((r == 10) || (r == 11))
		        	dig10 = '0';
		        else dig10 = (char)(r + 48);
		       
		        sm = 0;
		        peso = 11;
		        for (i=0; i<10; i++) {   
		        	 num = (int)(CPF.charAt(i) - 48); 
		        	 sm = sm + (num * peso);
		        	 peso = peso - 1;
		        }
		        r = 11 - (sm % 11);
		        if((r == 10) || (r == 11))
		        	dig11 = '0';
		        else dig11 = (char)(r + 48);
		        
		        if((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
		        	return true;
		        else return false;
		      }catch (InputMismatchException erro) {
		    	  return(false);
		      }
	}
	public static boolean validCPNJ(String cnpj)
	{
		
	}
	public static boolean validRG(String rg)
	{
		
	}
	public static boolean validSenha(String cnpj)
	{
		
	}
	public static boolean validLogin(String login)
	{
		
	}
	public static boolean validCEP(String CEP)
	{
		
	}
	public static boolean validTelefone(String telefone)
	{
		
	}
}
