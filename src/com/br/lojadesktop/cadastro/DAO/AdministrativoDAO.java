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
	public void altereFuncionarioCPF(Administrativo adm) throws Exception{
		if(adm.getClass()==Gerente.class)
			altereGerenteCPF((Gerente) adm);
		else
			altereVendedorCPF((Vendedor) adm);
	}
	private void altereGerenteCPF(Gerente ger) throws Exception{
		String SQL="UPDATE `loja`.`funcionario` SET `nome`='"+ger.getNome()+"', `rg`='"+ger.getRG()+"', `login`='"+ger.getLogin().getuser()+"', `senha`='"+ger.getLogin().getSenha()+"', `cargo`='"+ger.getLogin().getTipo()+"' WHERE `cpf`='"+ger.getCPF()+"';";
		System.out.println(SQL);
		bd.execComando(SQL);
	}
	private void altereVendedorCPF(Vendedor vend) throws Exception{
		String SQL="UPDATE `loja`.`funcionario` SET `nome`='"+vend.getNome()+"', `rg`='"+vend.getRG()+"', `login`='"+vend.getLogin().getuser()+"', `senha`='"+vend.getLogin().getSenha()+"' WHERE `cpf`='"+vend.getCPF()+"';";
		System.out.println(SQL);
		bd.execComando(SQL);
	}
	public void altereFuncionarioNome(Administrativo adm) throws Exception{
		if(adm.getClass()==Gerente.class)
			altereGerenteNome((Gerente) adm);
		else
			altereVendedorNome((Vendedor) adm);
	}
	private void altereGerenteNome(Gerente ger) throws Exception{
		String SQL="";
		System.out.println(SQL);
		bd.execComando(SQL);
	}
	private void altereVendedorNome(Vendedor vend) throws Exception{
		String SQL="";
		System.out.println(SQL);
		bd.execComando(SQL);
	}
}