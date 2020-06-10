# ProjetoIntegradorADS-2-Senac
Projeto Integrador - Faculdade Senac - ADS - 2020/01
Gustavo Moreira
Vitor de Almeida


ProjetoIntegradorADS-2-Senac/Integrador/src/main/java/projeto/

Classe Conexao:

 É responsavel por fazer a conexão com o postgre, deve se alterar dentro do:
 
        return DriverManager.getConnection("jdbc:postgresql:postgres","postgres","gaara");
 
 onde 'postgres' é nome da database e 'gaara' senha do seu banco.
 
 Comando postgree criar a tabela com os dados referente a pesquisa:
 
     TabelaPostgre.txt
     
Classe Arquivo

     LerArquivoCSV.lerArquivoCVS("C:\\Users\\gutow\\Documents\\DADOS.csv");
 
 O diretório onde se encontra o arquivo csv, eu submeti o arquivo também, para caso de testes.
