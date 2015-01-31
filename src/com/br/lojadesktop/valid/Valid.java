/**
 * 
 */
package com.br.lojadesktop.valid;

import java.math.BigDecimal;
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
	public static boolean validCPNJ(String CNPJ)
	{
		char dig13, dig14;
		int sm, i, r, num, peso;
		try{
		 sm = 0;
		 peso = 2;
		 for (i=11; i>=0; i--) {
			 num = (int)(CNPJ.charAt(i) - 48);
			 sm = sm + (num * peso);
			 peso = peso + 1; 
			 if (peso == 10)
				 peso = 2;
		 }
			 r = sm % 11;
			 if((r == 0) || (r == 1))
				 dig13 = '0';
			 else dig13 = (char)((11-r) + 48);
			 
			 sm = 0;
		      peso = 2;
		      for (i=12; i>=0; i--) {
		    	  num = (int)(CNPJ.charAt(i)- 48);
		    	  sm = sm + (num * peso);
		    	  peso = peso + 1;
		    	  if (peso == 10)
		    		  peso = 2;
		      }
		      
		      r = sm % 11;
		      if((r == 0) || (r == 1))
		    	  dig14 = '0';
		      else dig14 = (char)((11-r) + 48);
		      
		      if((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13))) return true;
		      else return false;
		      
		      

				
		 }catch(InputMismatchException erro)
		{
			 return false;
		}
		
	}
	public static boolean validRG(String rg)
	{
		return rg.length()==11?true:false;
	}
	public static boolean validSenha(String senha)
	{
		return senha.length() > 5?true:false;
	}
	public static boolean validLogin(String login)
	{
		return login.contains("@");
	}
	public static boolean validTelefone(String telefone)
	{
		return telefone.length()==14?true:telefone.length()==15?true:false;
	}
	public static boolean validValor(BigDecimal valor)
	{
		return valor.signum()<=0?false:true;
		
	}
}
