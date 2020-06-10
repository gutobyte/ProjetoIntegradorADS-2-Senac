package projeto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InserirDeletUpdate {
	
	/*Ex: sexo, 1, masculino, 25
	 * 	  sexo, 2, feminino, 1
	 * 
	 * 
	 */

	public void inserirDados(String tabela, int id, String NomeReferenteQuantidade, int variavelComDados) throws SQLException, ClassNotFoundException
	{
		Connection con = Conexao.getConexao();
		PreparedStatement pstmt = con.prepareStatement
				(
						"INSERT INTO "+ tabela +" VALUES("+id+",'"+ NomeReferenteQuantidade+"',"+ variavelComDados + ");"
						
				);
		pstmt.execute();
		con.close();
		
	}
	
	/* Metodo que permite o úsuario faça update de algum dado que já se encontra na tabela, 
	 * ele deve informar o nome da tabela e chave primaria
	 * Ex:
	 * 		manipulandoBanco.updateDados("sexo", quantidade, 30, 1);
	 * 
	 *No comando a cima ele muda a quantidade do id 1 da tabela sexo que no caso é masculino para 30.
	 */
	
	public void updateDados(String tabela, String oqueMudar, String mudanca, int idMudanca) throws ClassNotFoundException, SQLException
	{
		Connection con = Conexao.getConexao();
		PreparedStatement pstmt = con.prepareStatement
				(
						"update" + tabela + "set"+ oqueMudar+" ="+ mudanca+" where id =" + idMudanca +";"
				);
		pstmt.execute();
		con.close();
	}
	
	/* Metodo que permite o úsuario deletar algum dado, ele deve informar o nome da tabela e chave primaria
	 * Ex:
	 * 		manipulandoBanco.deletarDados("sexo", 1);
	 * 
	 *No comando a cima ele deleta os dados da tabela sexo que se encontra na chave de id 1, no caso o masculino
	 */
	
	
	public void deletarDados(String tabela, int idDeletar) throws SQLException, ClassNotFoundException
	{
		Connection con = Conexao.getConexao();
		PreparedStatement pstmt = con.prepareStatement
				(
						"delete from "+ tabela +" where id =" + idDeletar 
				);
		pstmt.execute();
		con.close();
		
	}
	
}
