package projeto;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Principal  {
	

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException  {
	
		//Arquivo.lerArquivoESalvarNoBanco();

		//Testando o metodo de calcular os dados  
		Arquivo.calcularDistribuicaoDeFrequencia("IDADE");
		
	}
		

}