package projeto;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.math.RoundingMode;

public class Arquivo {

	String perguntaA[];

	public static void calcularDistribuicaoDeFrequencia(String pergunta) throws ClassNotFoundException, SQLException {
		Connection con = null;
		try {
			con = Conexao.getConexao();
			String sql = "SELECT OPCAO, QUANTIDADE FROM DADOS WHERE PERGUNTA = ? ORDER BY OPCAO";
			PreparedStatement st1 = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			st1.setString(1, pergunta);
			ResultSet rs1 = st1.executeQuery();
			
			double soma_f = 0;
			
			while (rs1.next()) {
				soma_f = soma_f + rs1.getInt(2);
			}
			rs1.beforeFirst();
			
			String xi, mo, md;
			mo = "";
			md = "";
			
			double fi, fri, Fi, Fri, soma_fri, moda, mediana, med;			
			fi = 0;
			fri = 0;
			Fi = 0;
			Fri = 0;
			soma_fri = 0;
			moda = 0;
			mediana = soma_f / 2;
			med=0;
			int xim=0;
			int i = 1;
			
			DecimalFormat df = new DecimalFormat("0.0000");
			df.setRoundingMode(RoundingMode.CEILING);
			System.out.println("******************************************************************");
			System.out.println("DISTRIBUIÇÃO DE FREQUÊNCIA " + pergunta);
			System.out.println("------------------------------------------------------------------");
			System.out.printf("|%2s|%17s|%10s|%10s|%10s|%10s|\n", "i", "xi", "fi", "fri", "Fi", "Fri");
			double desvioPadrao = 0;
			
			while (rs1.next()) {
			
				xi = rs1.getString(1);
				fi = rs1.getInt(2);
				fri = fi / soma_f;
				Fi = Fi + fi;
				Fri = Fi / soma_f;
				soma_fri = soma_fri + fri;
				xim+=1;
				med= soma_f/xim;
				
				if (fi > moda) {
					mo = xi;
					moda = fi;
				}
				
				if (mediana < Fi) {
					md = xi;
					mediana = 9999999;
				}
				
				desvioPadrao = desvioPadrao + (fi * fri);
				
				System.out.println("------------------------------------------------------------------");
				System.out.printf("|%2s|%17s|%10s|%10s|%10s|%10s|\n", i, xi, fi, df.format(fri), Fi, df.format(Fri));
				i++;
			}
			System.out.println("------------------------------------------------------------------");
			System.out.printf("%s %26s|%10s|\n", "TOTAL", soma_f, df.format(soma_fri));
			System.out.println("------------------------------------------------------------------");
			System.out.println("Moda (Mo): " + mo);
			System.out.println("Mediana (Md): " + md);
			System.out.println("Media: " + df.format(med));
			System.out.println("Desvio padrão: " + df.format(desvioPadrao));
			System.out.println("------------------------------------------------------------------");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
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
		String arquivoCSV = "/home/vitor/eclipse-workspace/ProjetoIntegradorADS-2-Senac/DADOS.csv";

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