package projeto;
import java.util.Scanner;

import java.io.IOException;
import java.sql.SQLException;
import java.util.function.Consumer;

public class Principal extends LerArquivoCSV {
	
	
		
		public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
			
			
			Scanner scan = new Scanner(System.in);
			LerArquivoCSV.lerArquivoCVS("C:\\Users\\gutow\\Documents\\teste2.csv");
			
			String tamanhoVetorSeparador = ("Vetor separado possui tamanho de : " + separador.length);
			System.out.println(tamanhoVetorSeparador);
			ConverterStringtoInt.ConverterSexo(separador[1], separador[3]);
			ConverterStringtoInt.ConverterDeficiencia(separador[8], separador[6], separador[10]);
			ConverterStringtoInt.ConverterCurso(separador[13], separador[15], separador[17], separador[19], separador[21]);
			ConverterStringtoInt.ConverterEscolha(separador[24], separador[26], separador[28], separador[30]);
			ConverterStringtoInt.ConverterIdades(separador[33], separador[35], separador[37], separador[39], separador[41], 
												separador[43], separador[45], separador[47], separador[49], separador[51], 
												separador[53], separador[55], separador[57], separador[59]);
			
			addSexoBanco();
			addIdadeBanco();
			addDeficienciaBanco();
			addCursosBanco();
			addEscolhaBanc();
			
			
						
		}
		public static void addIdadeBanco() throws ClassNotFoundException, SQLException
		{
			InserirDeletUpdate manipulandoBancoIdade = new InserirDeletUpdate();
			
			manipulandoBancoIdade.inserirDados("idade", 1, "19_anos", ConverterStringtoInt.idade19q);
			manipulandoBancoIdade.inserirDados("idade", 2, "21_anos", ConverterStringtoInt.idade21q);
			manipulandoBancoIdade.inserirDados("idade", 3, "22_anos", ConverterStringtoInt.idade22q);
			manipulandoBancoIdade.inserirDados("idade", 4, "23_anos", ConverterStringtoInt.idade23q);
			manipulandoBancoIdade.inserirDados("idade", 5, "24_anos", ConverterStringtoInt.idade24q);
			manipulandoBancoIdade.inserirDados("idade", 6, "25_anos", ConverterStringtoInt.idade25q);
			manipulandoBancoIdade.inserirDados("idade", 7, "26_anos", ConverterStringtoInt.idade26q);
			manipulandoBancoIdade.inserirDados("idade", 8, "27_anos", ConverterStringtoInt.idade27q);
			manipulandoBancoIdade.inserirDados("idade", 9, "28_anos", ConverterStringtoInt.idade28q);
			manipulandoBancoIdade.inserirDados("idade", 10, "30_anos", ConverterStringtoInt.idade30q);
			manipulandoBancoIdade.inserirDados("idade", 11, "31_anos", ConverterStringtoInt.idade31q);
			manipulandoBancoIdade.inserirDados("idade", 12, "37_anos", ConverterStringtoInt.idade37q);
			manipulandoBancoIdade.inserirDados("idade", 13, "39_anos", ConverterStringtoInt.idade39q);
			manipulandoBancoIdade.inserirDados("idade", 14, "49_anos", ConverterStringtoInt.idade49q);	
		}
		public static void addSexoBanco() throws ClassNotFoundException, SQLException
		{
			InserirDeletUpdate manipulandoBancoSexo = new InserirDeletUpdate();
			manipulandoBancoSexo.inserirDados("sexo", 1, "masculino", ConverterStringtoInt.Masculino);
			manipulandoBancoSexo.inserirDados("sexo", 2, "feminino", ConverterStringtoInt.Feminino);
		}
		public static void addDeficienciaBanco() throws ClassNotFoundException, SQLException
		{
			
			InserirDeletUpdate manipulandoBancoDef = new InserirDeletUpdate();
			manipulandoBancoDef.inserirDados("deficiencia", 1, "nenhuma", ConverterStringtoInt.DefNehuma);
			manipulandoBancoDef.inserirDados("deficiencia", 2, "visual", ConverterStringtoInt.DefVisual);
			manipulandoBancoDef.inserirDados("deficiencia", 3, "sem_resposta", ConverterStringtoInt.DefRespostaEmBranco);
		}
		public static void addCursosBanco() throws ClassNotFoundException, SQLException
		{
			InserirDeletUpdate manipulandoBancoCurso = new InserirDeletUpdate();
			manipulandoBancoCurso.inserirDados("cursos", 1, "ADS", ConverterStringtoInt.ADS);
			manipulandoBancoCurso.inserirDados("cursos", 2, "GC", ConverterStringtoInt.GC);
			manipulandoBancoCurso.inserirDados("cursos", 3, "GTI", ConverterStringtoInt.GTI);
			manipulandoBancoCurso.inserirDados("cursos", 4, "SI", ConverterStringtoInt.SI);
			manipulandoBancoCurso.inserirDados("cursos", 5, "JD", ConverterStringtoInt.JD);
		}
		public static void addEscolhaBanc() throws ClassNotFoundException, SQLException
		{
			InserirDeletUpdate manipulandoBancoEsc = new InserirDeletUpdate();
			manipulandoBancoEsc.inserirDados("escolha", 1, "Mercado_Promissor", ConverterStringtoInt.FatorPromissor);
			manipulandoBancoEsc.inserirDados("escolha", 2, "Trabalha_na_Area", ConverterStringtoInt.TrabalhaArea);
			manipulandoBancoEsc.inserirDados("escolha", 3, "Possui_Vocacao", ConverterStringtoInt.Vocacao);
			manipulandoBancoEsc.inserirDados("escolha", 4, "outros", ConverterStringtoInt.Outros);
		}
		
		
	}