# Comunicacao
### Autor: Jhony Wesley Marques

### Requisitos para funcionar
Utilizar editor preferido eclipse,visual studio,netbeans etc,
Instalar as estensões do springboot, Banco de dados utilizado é o mysql.

### Configurções
Quando for iniciar modificar o arquivo application.properties com as respectivas configurações para funcionar no seu computador.

server.port=

spring.datasource.url = jdbc:mysql://localhost:3306/banco?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC

spring.datasource.username = 

spring.datasource.password = 

### Teste
Pode utilizar os seguintes comandos no cmd na pasta raiz do projeto aonde se encontra os arquivos json.

curl -v -d @data_add.json -H "Content-Type: application/json" POST localhost:8081/mensagem

curl -v -d @data_put.json -H "Content-Type: application/json" -X PUT localhost:8081/mensagem

curl -v -d @data_del.json -H "Content-Type: application/json" -X DELETE localhost:8081/mensagem

Ou se preferir utilizar o Postman para fazer isso.

### Teste unitário
Nos testes modifique os valores a serem salvos aos que preferir.

No teste do delete deve-se mudar o valor de 'num' para o id que deseja excluir.


