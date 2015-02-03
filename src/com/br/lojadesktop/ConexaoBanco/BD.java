package com.br.lojadesktop.ConexaoBanco;
import java.sql.*;

public class BD
{
    private Connection conexao;
    private Statement  comando;

    public BD (String drv, String url,
               String username, String senha) throws Exception
    {
        try
        {
            Class.forName (drv);
        }
        catch (ClassNotFoundException e)
        {
            throw new Exception ("driver " +e);
        }

        try
        {
            conexao = DriverManager.getConnection (url, username, senha);
        }
        catch (SQLException e)
        {
            throw new Exception ("conexao "+e);
        }

        try
        {
            comando = conexao.createStatement
                     (ResultSet.TYPE_SCROLL_INSENSITIVE,
                      ResultSet.CONCUR_READ_ONLY);
        }
        catch (SQLException e)
        {
            throw new Exception ("comando "+e);
        }
    }

    public void execComando (String cmdSQL) throws Exception
    {
        try
        {
            this.comando.executeUpdate (cmdSQL);
        }
        catch (SQLException e)
        {
            throw new Exception ("execucao comando "+e);
        }
    }

    public ResultSet execConsulta (String qrySQL) throws Exception
    {
        ResultSet resultado = null;

        try
        {
            resultado = this.comando.executeQuery (qrySQL);
        }
        catch (SQLException e)
        {
            throw new Exception ("execucao consulta "+e);
        }

        return resultado;
    }

    public void fecharConexao () throws Exception
    {
        try
        {
            this.comando.close ();
            this.comando = null;

            this.conexao.close ();
            this.conexao = null;
        }
        catch (SQLException e)
        {
            throw new Exception ("fechamento "+e);
        }
    }
}

/*CREATE TABLE `loja`.`funcionario` (
  `idFuncionario` INT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `cpf` VARCHAR(11) NULL,
  `rg` VARCHAR(45) NULL,
  `login` VARCHAR(45) NULL,
  `senha` VARCHAR(45) NULL,
  PRIMARY KEY (`idFuncionario`));*/