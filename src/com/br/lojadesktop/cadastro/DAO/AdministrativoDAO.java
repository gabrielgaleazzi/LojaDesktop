/*
 terminar altere 
 */
package com.br.lojadesktop.cadastro.DAO;

import java.sql.ResultSet;

import com.br.lojadesktop.ConexaoBanco.BD;
import com.br.lojadesktop.cadastro.javaBean.Administrativo;
import com.br.lojadesktop.cadastro.javaBean.Gerente;
import com.br.lojadesktop.cadastro.javaBean.Vendedor;
import com.br.lojadesktop.vendas.DAO.LoginDAO;
import com.br.lojadesktop.vendas.javaBean.ClienteFisico;
import com.br.lojadesktop.vendas.javaBean.ClienteJuridico;

/**
 * @author Rafael S. Vieira
 *
 * 
 */
public class AdministrativoDAO {
	
	private BD bd;
	private LoginDAO log=new LoginDAO();
	
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
		String SQL="INSERT INTO `loja`.`Login` (`senha`, `tipo`, `user`) VALUES ('"+vend.getLogin().getSenha()+"', '"+vend.getLogin().getTipo()+"', '"+vend.getLogin().getuser()+"');";
		bd.execComando(SQL);
		SQL ="INSERT INTO `loja`.`Funcionario` (`nome`, `sobrenome`, `cpf`, `rg`, `cep`, `complemento`, `celular`, `telefone`, `login_id`) VALUES ('"+vend.getNome()+"', '"+vend.getSobrenome()+"', '"+vend.getCPF()+"', '"+vend.getRG()+"', '"+vend.getCep()+"', '"+vend.getComplemento()+"', '"+vend.getCelular()+"', '"+vend.getTelefone()+"', '"+log.getId(vend.getLogin().getuser())+"');";
		System.out.println(SQL);
		bd.execComando(SQL);
	}
	private void createGerente(Gerente gerente) throws Exception{
		String SQL="INSERT INTO `loja`.`Login` (`senha`, `tipo`, `user`) VALUES ('"+gerente.getLogin().getSenha()+"', '"+gerente.getLogin().getTipo()+"', '"+gerente.getLogin().getuser()+"');";
		bd.execComando(SQL);
		SQL ="INSERT INTO `loja`.`Funcionario` (`nome`, `sobrenome`, `cpf`, `rg`, `cep`, `complemento`, `celular`, `telefone`, `login_id`) VALUES ('"+gerente.getNome()+"', '"+gerente.getSobrenome()+"', '"+gerente.getCPF()+"', '"+gerente.getRG()+"', '"+gerente.getCep()+"', '"+gerente.getComplemento()+"', '"+gerente.getCelular()+"', '"+gerente.getTelefone()+"', '"+log.getId(gerente.getLogin().getuser())+"');";
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
	
	public void altereFuncionarioCPF(Administrativo adm) throws Exception{
		if(adm.getClass()==Gerente.class)
			altereGerenteCPF((Gerente) adm);
		else
			altereVendedorCPF((Vendedor) adm);
	}
	private void altereGerenteCPF(Gerente ger) throws Exception{
		String SQL="UPDATE `loja`.`Funcionario` SET `nome`='"+ger.getNome()+"', `sobrenome`='"+ger.getSobrenome()+"', `rg`='"+ger.getRG()+"', `cep`='"+ger.getCep()+"', `complemento`='"+ger.getComplemento()+"', `celular`='"+ger.getCelular()+"', `telefone`='"+ger.getTelefone()+"' WHERE `cpf`='"+ger.getCPF()+"';";
		System.out.println(SQL);
		bd.execComando(SQL);
		SQL="SELECT * FROM loja.Funcionario where cpf='"+ger.getCPF()+"';";
		System.out.println(SQL);
		ResultSet result = bd.execConsulta(SQL);
		int id=0;
		while(result.next())
		id=result.getInt("login_id");
		
		SQL ="UPDATE `loja`.`Login` SET `senha`='"+ger.getLogin().getSenha()+"', `user`='"+ger.getLogin().getuser()+"' WHERE `id`='"+id+"';";
		System.out.println(SQL);
		bd.execComando(SQL);
	}
	private void altereVendedorCPF(Vendedor vend) throws Exception{
		String SQL="UPDATE `loja`.`Funcionario` SET `nome`='"+vend.getNome()+"', `sobrenome`='"+vend.getSobrenome()+"', `rg`='"+vend.getRG()+"', `cep`='"+vend.getCep()+"', `complemento`='"+vend.getComplemento()+"', `celular`='"+vend.getCelular()+"', `telefone`='"+vend.getTelefone()+"' WHERE `cpf`='"+vend.getCPF()+"';";
		System.out.println(SQL);
		bd.execComando(SQL);
		SQL="SELECT * FROM loja.Funcionario where cpf='"+vend.getCPF()+"';";
		System.out.println(SQL);
		ResultSet result = bd.execConsulta(SQL);
		int id=0;
		while(result.next()){
		id=result.getInt("login_id");
		System.out.println(id);
		}
		SQL ="UPDATE `loja`.`Login` SET `senha`='"+vend.getLogin().getSenha()+"', `user`='"+vend.getLogin().getuser()+"' WHERE `id`='"+id+"';";
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
		String SQL="SELECT * FROM loja.Funcionario where nome='"+ger.getNome()+"';";
		System.out.println(SQL);
		ResultSet result = bd.execConsulta(SQL);
		int id=0;
		while(result.next()){
			id=result.getInt("login_id");
			System.out.println(id);
		}
	}
	private void altereVendedorNome(Vendedor vend) throws Exception{
		String SQL="SELECT * FROM loja.Funcionario where nome='"+vend.getNome()+"';";
		System.out.println(SQL);
		ResultSet result = bd.execConsulta(SQL);
		int id=0;
		while(result.next()){
			id=result.getInt("login_id");
			System.out.println(id);
		}
	}
}