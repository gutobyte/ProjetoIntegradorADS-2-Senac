package projeto;
import java.io.IOException;
import java.sql.SQLException;


public class Principal  {
	

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException  {
	
		Arquivo.limparTabelaDados();
		Arquivo.lerArquivoESalvarNoBanco();
		Arquivo.calcularDistribuicaoDeFrequencia("IDADE");
		Arquivo.calcularDistribuicaoDeFrequencia("SEXO");
		Arquivo.calcularDistribuicaoDeFrequencia("DEFICIENCIA");
		Arquivo.calcularDistribuicaoDeFrequencia("FATOR");
		Arquivo.calcularDistribuicaoDeFrequencia("CURSO");
	}

}