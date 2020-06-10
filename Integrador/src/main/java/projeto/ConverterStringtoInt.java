package projeto;

public class ConverterStringtoInt {
	
	static int Masculino;   //Sexo 
	static int Feminino;
	static int DefVisual, DefNehuma, DefRespostaEmBranco;  //Possui algum tipo de deficiência
	static int ADS, GC, GTI, SI, JD; //Cursos
	static int FatorPromissor, TrabalhaArea, Vocacao, Outros;  // Principal fator da escolha do curso
	static int idade19q, idade21q, idade22q, idade23q, idade24q, idade25q, idade26q, idade27q, idade28q, idade30q, idade31q,
	idade37q, idade39q, idade49q;
	
	
	/*
	 * ADS - Análise é desenvolvimento de sistemas
	 * GC - Gestão Comercial
	 * GTI - Gestão da Tecnologia da Informação
	 * SI - Segurança da Informação
	 * JD - Jogos Digitais
	 */
	
	
	
	public static void ConverterSexo(String vetorM, String vetorF) 
	{
		Masculino = Integer.parseInt(vetorM);
		Feminino = Integer.parseInt(vetorF);	
	}
	public static void ConverterDeficiencia(String vetorVisual, String vetorNenhum, String vetorBranco)
	{
		DefVisual = Integer.parseInt(vetorVisual);
		DefNehuma = Integer.parseInt(vetorNenhum);
		DefRespostaEmBranco = Integer.parseInt(vetorBranco);
	}
	public static void ConverterCurso(String vetorADS, String vetorGC, String vetorGTI, String vetorSI, String vetorJD) 
	{
		ADS = Integer.parseInt(vetorADS);
		GC = Integer.parseInt(vetorGC);
		GTI = Integer.parseInt(vetorGTI);
		SI = Integer.parseInt(vetorSI);
		JD = Integer.parseInt(vetorJD);
	}
	
	public static void ConverterEscolha(String vetorPromissor, String vetorTrabalhaArea, String vetorVocacao, String vetorOutros)
	{
		FatorPromissor = Integer.parseInt(vetorPromissor);
		TrabalhaArea = Integer.parseInt(vetorTrabalhaArea);
		Vocacao = Integer.parseInt(vetorVocacao);
		Outros = Integer.parseInt(vetorOutros);
	}
	public static void ConverterIdades(String vetorI33, String vetorI35, String vetorI37, String vetorI39,
			String vetorI41, String vetorI43, String vetorI45, String vetorI47, String vetorI49, String vetorI51,
			String vetorI53, String vetorI55, String vetorI57, String vetorI59)
	{
		idade19q = Integer.parseInt(vetorI33);
		idade21q = Integer.parseInt(vetorI35);
		idade22q = Integer.parseInt(vetorI37);
		idade23q = Integer.parseInt(vetorI39);
		idade24q = Integer.parseInt(vetorI41);
		idade25q = Integer.parseInt(vetorI43);
		idade26q = Integer.parseInt(vetorI45);
		idade27q = Integer.parseInt(vetorI47);
		idade28q = Integer.parseInt(vetorI49);
		idade30q = Integer.parseInt(vetorI51);
		idade31q = Integer.parseInt(vetorI53);
		idade37q = Integer.parseInt(vetorI55);
		idade39q = Integer.parseInt(vetorI57);
		idade49q = Integer.parseInt(vetorI59);
		
	}

}