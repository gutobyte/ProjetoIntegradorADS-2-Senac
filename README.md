# ProjetoIntegradorADS-2-Senac
Projeto Integrador - Faculdade Senac - ADS - 2020/01


ProjetoIntegradorADS-2-Senac/Integrador/src/main/java/projeto/

Classe Conexao:

 É responsavel por fazer a conexão com o postgre, deve se alterar dentro do:
 
        return DriverManager.getConnection("jdbc:postgresql:postgres","postgres","gaara");
 
 onde 'postgres' é nome da database e 'gaara' senha do seu banco.
 
 OBS: É importante criar as tabelas: sexo, idade, deficiencia, cursos e escolha no Postgre antes de dar run no código.
 Eu submeti um arquivo txt com os comandos do postgre para criar estas tabelas:
 
     TabelasPostgre.txt
Classe Principal

     LerArquivoCSV.lerArquivoCVS("C:\\Users\\gutow\\Documents\\teste2.csv");
 
 O diretório onde se encontra o arquivo csv, eu submeti o arquivo também, para caso de testes.
