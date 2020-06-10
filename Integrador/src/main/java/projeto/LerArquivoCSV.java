package projeto;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

	
	public class LerArquivoCSV {
		
		static String separador[];
		
		public static void lerArquivoCVS(String localizacaoArquivo) throws IOException
		{
			String conteudo="";
			FileReader locArquiv = new FileReader(localizacaoArquivo);
			BufferedReader lendoArquivo = new BufferedReader(locArquiv);
			String linha="";
			while(linha!=null)
			{
				conteudo+=linha;
				linha=lendoArquivo.readLine();
			}
			separador = conteudo.split(",");
			
			lendoArquivo.close();
		}
		
		
		

	}


