# agendacontato-server
Projeto demo Agenda de Contatos utilizando Spring Boot, Spring Data, Spring Security, Swagger, MySql, Jpa, OAuth2.


### Configuração ###

* Configuração do Banco de Dados
- Baixe o banco de dados MySql https://www.mysql.com/downloads/.
- Baixe o arquivo banco.sql do diretório principal e execute em um banco MySql.
- Se o login e senha do banco no servidor localhost:3306 não for root abra o arquivo 
application.properties dentro do diretório:
```
src > main > resources > application.properties
```
e altere a linha 7,8 para:
```
spring.datasource.username=(Seu login)
spring.datasource.password=(Sua senha)
```


### Instruções de Deploy ###
- Abra o eclipse.
 -Vá em 
 ```
 File > Import > Existing Maven Projects
 ```
Em seguida clique em Next.
Clique em Browse e navegue até a pasta do projeto, selecione a pasta do projeto e clique em Finish.
- Espere o Maven baixar as dependências.
- Vá em Java Resources dentro do projeto aberto no eclipse, localize o arquivo 
 ```
 src/main/java > br.com.techlead.agendacontato.AgendacontatoApplication.java.
 ```
Clique com o botão direito do mouse no arquivo > Run as Java Application.
O servidor com o back end estará rodando.
