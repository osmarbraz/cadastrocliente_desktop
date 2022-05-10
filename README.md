[![Github Actions Status for osmarbraz/figuras_teste](https://github.com/osmarbraz/cadastrocliente_desktop/workflows/Java%20CI%20with%20Maven/badge.svg)](https://github.com/osmarbraz/cadastrocliente_desktop/actions) 
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=cadastrocliente_desktop&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=cadastrocliente_destkop)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=cadastrocliente_desktop&metric=coverage)](https://sonarcloud.io/component_measures?id=cadastrocliente_destkop&metric=coverage)

# Sistema de Cadastro de Clientes para Desktop em Banco de Dados em 3 camadas utilizando o padrão Abstract Factory.
 - O projeto é uma versão do sistema para a IDE NetBeans.<br> 
 - O projeto no NetBeans deve ser chamado cadastrocliente_desktop.<br>
 - Este programa possui diversas classes organizada nos pacotes visão, controle, modelo e dao.<br>
 - Utiliza o padrão abstract factory para abstrair 3 formas de armazenamento:
	- 1 - Banco de Dados(sqllite)
	- 2 - HashMap
	- 3 - Arquivo Binário
 - Toda iteração com banco de dados é tratada diretamente pelo DAO(Data Access Object).<br>
 - A aplicação esta configurada para utilizar inicialmente memória principal(Hashmap) para armazenamento.
 - Se desejar utilizar outra fonte de dados, edite o arquivo src\dao\Factory.java alterando a FABRICA para outro valor.
 - Toda iteração com banco de dados é tratada diretamente pelo DAO(Data Access Object).<br>
 - Os dados de configuração (Servidor, Database, Usuario, Senha) da integração do java com o banco de dados estão no arquivo src/dao/OracleDAOFactory.java.<br>
 - A especificação da fábrica a ser utilizada é feita na interface Factory.java.
 - Crie o banco de dados antes de executar o projeto, as especificações das tabelas estão no arquivo banco_oracle.sql.<br>
 - A pasta test contêm os testes unitários do projeto utilizando JUnit 4.<br>