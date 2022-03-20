# SISUNICO - Uma única API com três soluções do dia-a-dia

<p>Projeto de API para servir três sistemas: MyRH(gerenciamento de busca por empregos), MyCar(controle de manutenção veicular) e MyAccess(controle de senhas)</p>

## Ferramentas utilizadas

- Java
- Maven
- Microsoft SQL Server (AZURE)
- Spring Framework

## Preparação do ambiente
Para rodar o projeto, utlize a IDE que você mais se identifique **(no meu caso, utilizo o IntelliJ)**, em seguida, altere o arquivo **application.properties** para que o projeto se adeque ao seu servidor de **banco de dados**:

**Exemplo do arquivo application.properties**:

````java
#Spring Boot server configuration

# *** STRING DE CONEXÃO DO AZURE ***
spring.datasource.url=jdbc:sqlserver://{YOUR_SERVER}.database.windows.net:{PORT};database=sisunico;user={USER};password={PASSWORD};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;
spring.datasource.username={USER}
spring.datasource.password={PASSWORD}

spring.datasource.driverClassName=com.microsoft.sqlserver.jdbc.SQLServerDriver
spring.jpa.hibernate.ddl-auto=update

spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.SQLServer2012Dialect

spring.jackson.serialization.fail-on-empty-beans=false
logging.level.org.springframework.web=DEBUG

server.servlet.context-path=/sisunico

server.address=0.0.0.0
server.port=8000

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
````

Em seguida, basta criar um banco de dados no Microsoft SQL Server (o exemplo acima está conectando com um banco de dados SQL Server no Azure) com o comando `Create database {Nome do banco de dados}`

## Tutoriais úteis para configurar sua estação de trabalho.

- [Configurar variáveis de ambiente JAVA](https://mauriciogeneroso.medium.com/configurando-java-4-como-configurar-as-vari%C3%A1veis-java-home-path-e-classpath-no-windows-46040950638f)
- [Configurar variáveis de ambiente MAVEN](https://pt.stackoverflow.com/questions/259927/como-configurar-vari%C3%A1veis-de-ambiente-maven-java)
