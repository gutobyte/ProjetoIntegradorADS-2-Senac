package projeto;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Arquivo {

	
	
	public static void limparTabelaDados() throws SQLException {
		Connection con = null;
		try {
			con = Conexao.getConexao();
			PreparedStatement st = con.prepareStatement("DELETE FROM DADOS");
			
			st.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			con.commit();
			con.close();
		}
	}

	public static void lerDados(String pergunta, String opcao) throws ClassNotFoundException, SQLException {
		Connection con = null;
		
		try {
			con = Conexao.getConexao();
			String sql = "SELECT PERGUNTA, OPCAO, QUANTIDADE FROM DADOS WHERE PERGUNTA = ? AND OPCAO = ?";
			PreparedStatement statement = con.prepareStatement(sql);

			statement.setString(1, pergunta); //1
			statement.setString(2, opcao); //2
			ResultSet rs = statement.executeQuery();
			while (rs.next() ) {
				System.out.println("Qtde de alunos: " + pergunta +" "+  opcao+": " + rs.getString(3));
			}
			rs.close();
			statement.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	public static void lerArquivoESalvarNoBanco() throws ClassNotFoundException, SQLException {
		String arquivoCSV = "C:\\Users\\gutow\\Documents\\DADOS.csv";

		int batchSize = 20;
		Connection con = null;
		
		try {

			con = Conexao.getConexao();

			String sql = "INSERT INTO DADOS VALUES (?, ?, ?)";
			PreparedStatement statement = con.prepareStatement(sql);

			BufferedReader lineReader = new BufferedReader(new FileReader(arquivoCSV));
			String lineText = null;

			int count = 0;

			lineReader.readLine(); // pula o cabeçalho

			while ((lineText = lineReader.readLine()) != null) {
				String[] data = lineText.split(",");
				String pergunta = data[0];
				String opcao = data[1];
				int quantidade = Integer.parseInt(data[2]);

				statement.setString(1, pergunta);
				statement.setString(2, opcao);
				statement.setInt(3, quantidade);

				statement.addBatch();

				if (count % batchSize == 0) {
					statement.executeBatch();
				}
			}

			lineReader.close();

			statement.executeBatch();

			con.commit();
			con.close();

		} catch (IOException ex) {
			System.err.println(ex);
		} catch (SQLException ex) {
			ex.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
