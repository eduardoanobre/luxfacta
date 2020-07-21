# Sistema Desafio Luxfacta

* [esta api roda em máquinas windows e linux]
</br>
</br>
* prerequisitos:
<ul>
<li>oracle java OpenJDK 11</li>
<li>Mysql8</li>
</ul>
</br>
</br>

* será gerado um build desta api "jar" que funciona como
	um executável (luxfacta-0.0.1-SNAPSHOT.jar) 
	e será disponibilizado junto com o código fonte

* Atenção para as permissões de execução e leitura desta arquivo "jar" pois dependendo do sistema pode deixá-lo como 'somente leitura'.
</br>
</br>


### passo1
* instalar Java11 como jvm default (sudo apt install default-jdk)

### passo2
* instalar Mysql Versão 8 sem requisitos de autenticação (para efeito de teste)
* criar um NOME_USUARIO/SENHA
* configurar para tabelas do tipo InnoDB
* lower-case-table-names=1
* executar o comando: ('CREATE SCHEMA IF NOT EXISTS `api_desafio`');

### passo3
* editar aquivo \ApiLuxfacta\src\main\resources\application.properties e alterar as propriedades:
* spring.datasource.username=NOME_USUARIO
* spring.datasource.password=SENHA

### passo 4
 * para rodar a API no ubuntu
 <ul>
 	<li>certifique-se que o java 11 é default (java -version)</li>
 	<li>certifique-se que o MySql esteja rodando</li>
 	<li>certifique-se que existe o schema 'api_desafio' no MySql</li>
	<li>copie o jar para a pasta /home/testeedunobre</li>
	<li>verifique as permissões de execução</li>
	<li>abra o terminal CTRL+T</li>
	<li>execute o comando: java - jar /home/testeedunobre/luxfacta-0.0.1-SNAPSHOT.jar</li>
</ul>
 
### passo 5
* acesse a API pelo browser: 'http://localhost:3000/swagger-ui.html'

e VOILA...



.. qualquer dúvida
....Edu Nobre
.....Celular/Whatsapp 85986050000
......Email eduardoanobre@gmail.com




