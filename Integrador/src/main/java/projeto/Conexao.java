package projeto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public static Connection getConexao() throws SQLException, ClassNotFoundException
	{
		Connection con = null;
		//Class.forName("org.postgresql.Driver");
		//return DriverManager.getConnection("jdbc:postgresql:teste2","postgres","gaara");
		DriverManager.getConnection("jdbc:postgresql:teste2","postgres","gaara");
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql:teste2","postgres", "gaara");
			con.setAutoCommit(false);
			return con;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
