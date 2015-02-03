/*
 terminar altere 
 */
package com.br.lojadesktop.cadastro.DAO;

import com.br.lojadesktop.ConexaoBanco.BD;
import com.br.lojadesktop.cadastro.javaBean.Administrativo;
import com.br.lojadesktop.cadastro.javaBean.Gerente;
import com.br.lojadesktop.cadastro.javaBean.Vendedor;
import com.br.lojadesktop.vendas.javaBean.ClienteFisico;
import com.br.lojadesktop.vendas.javaBean.ClienteJuridico;

/**
 * @author Rafael S. Vieira
 *
 * 
 */
public class AdministrativoDAO {
	
	private BD bd;
	public AdministrativoDAO(BD bd){
		this.bd=bd;
	}
	public void createFuncionario(Administrativo adm) throws Exception{
		if(adm.getClass()==Gerente.class)
			createGerente((Gerente) adm);
		else
			createVendedor((Vendedor) adm);
		
	}
	private void createVendedor(Vendedor vend) throws Exception{
		String SQL = "INSERT INTO `loja`.`funcionario` (`nome`, `cpf`, `rg`, `login`, `senha`, `cargo`) VALUES ('"+vend.getNome()+"', '"+vend.getCPF()+"', '"+vend.getRG()+"', '"+vend.getLogin().getuser()+"', '"+vend.getLogin().getSenha()+"','"+vend.getLogin().getTipo()+"');";
		bd.execComando(SQL);
		System.out.println(SQL);
	}
	private void createGerente(Gerente gerente) throws Exception{
		String SQL = "INSERT INTO `loja`.`funcionario` (`nome`, `cpf`, `rg`, `login`, `senha`, `cargo`) VALUES ('"+gerente.getNome()+"', '"+gerente.getCPF()+"', '"+gerente.getRG()+"', '"+gerente.getLogin().getuser()+"', '"+gerente.getLogin().getSenha()+"','"+gerente.getLogin().getTipo()+"');";
		bd.execComando(SQL);
		System.out.println(SQL);
	}
	
	public void altereFuncionario(Administrativo adm) throws Exception{
		if(adm.getClass()==Gerente.class)
			altereGerente((Gerente) adm);
		else
			altereVendedor((Vendedor) adm);
	}
	private void altereGerente(Gerente ger) throws Exception{
		String SQL="";
		System.out.println(SQL);
		bd.execComando(SQL);
	}
	private void altereVendedor(Vendedor vend) throws Exception{
		String SQL="";
		System.out.println(SQL);
		bd.execComando(SQL);
	}
	
	public void deleteFuncionario(Administrativo adm) throws Exception{
		if(adm.getClass()==Gerente.class)
			deleteGerente((Gerente)adm);
		else
			deleteVendedor((Vendedor)adm);
	}
	private void deleteVendedor(Vendedor ven) throws Exception{
		String SQL="DELETE FROM `loja`.`funcionario` WHERE `cpf`='"+ven.getCPF()+"';";
		System.out.println(SQL);
		bd.execComando(SQL);
	}
	private void deleteGerente(Gerente gen) throws Exception{
		String SQL="DELETE FROM `loja`.`funcionario` WHERE `cpf`='"+gen.getCPF()+"';";
		System.out.println(SQL);
		bd.execComando(SQL);
	}
}