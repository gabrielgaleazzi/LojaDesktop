/**
 * 
 */
package com.br.lojadesktop.ConexaoBanco;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 
 * @author Rafael S. Vieira
 *
 * 
 */
public class BD {
	public static String status = "Não conectou...";	

	public BD(){
	
	}
	
	public static java.sql.Connection getConexaoMySQL() {
	try{
		Connection connection = null;
		String driverName ="com.mysql.jdbc.Driver"; 
		Class.forName(driverName);
		String url = "jdbc:mysql://localhost/loja";
		String username = "root";
		String password = "Rafa9074";
		 connection = DriverManager.getConnection(url, username, password);
		 //<property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver" />
		 //<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost/loja" /> 
		 //<property name="javax.persistence.jdbc.user" value="root" /> 
		 //<property name="javax.persistence.jdbc.password" value="Rafa9074" />
		 if(connection!=null)
			 status=("STATUS--> Conectado com sucesso!");
			 
		 else
			 status=("STATUS--> Não foi possivel realizar conexão");
		 
		 return connection;
	}
	
	catch(ClassNotFoundException e)
	{
		System.out.println("O driver expecificado nao foi encontrado.");
		return null;
	}
	catch(SQLException e)
	{
		System.out.println("Nao foi possivel conectar ao Banco de Dados."); 
		return null;
		}
	}
	
	public static String statusConection() {
		return status;
	}
	public static boolean FecharConexao() {
		try{
			BD.getConexaoMySQL().close();
			return true;
		}
		catch(SQLException e){
			return false;
		}
	}
	
}
