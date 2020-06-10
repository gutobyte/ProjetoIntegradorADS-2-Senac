package projeto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public static Connection getConexao() throws SQLException, ClassNotFoundException
	{
		Class.forName("org.postgresql.Driver");
		return DriverManager.getConnection("jdbc:postgresql:postgres","postgres","gaara");
		
	}

}
