# RestApi
Для теста API установите в ()-> properties свои значения
server.port = your port
spring.datasource.url=jdbc:postgresql://localhost:your url
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.username=your username
spring.datasource.password= your password
для миграции с помощью liquibase раскоментировать следующию строку
#spring.liquibase.change-log=classpath:db/changelog/db.changelog-master.xml
закоментировать эту
spring.liquibase.enabled=false
раскоментировать эту
#spring.liquibase.enabled=true

spring.jpa.database=POSTGRESQL
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation= true
spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.PostgreSQLDialect
spring.jpa.show-sql=true
Для первоначального запуска используйте эти значения
spring.jpa.hibernate.ddl-auto=create
Для последущих запусков 
spring.jpa.hibernate.ddl-auto=none

Сборка проекта -> в терминале выполнить команду mvn clean install
после того как проект с билдится можно запускать jar фаил по пути target/your name jar file

описание работы с Api:
GET запрос :http://localhost:8081/api/v1/clients/all - для получения всех клиентов
GET запрос :http://localhost:8081/api/v1/clients/accountClient/1 - для получения счета слиента по id = 1
GET запрос :http://localhost:8081/api/v1/clients/1 - для получения клиента по id = 1
GET запрос :http://localhost:8081/api/v1/clients/transaction/1 -для получения всех транзакций клиента id = 1
GET запрос :http://localhost:8081/api/v1/clients/cashWarrant/1 - для получения всех кассовых ордеров клиента id = 1

Post запрос : http://localhost:8081/api/v1/clients/createClient создание клиента передаем Json
Post запрос : http://localhost:8081/api/v1/createAccount/create создание счета клиента передаем Json
Post запрос :http://localhost:8081/api/v1/order/create создаем кассовый ордер передаем Json в зависимости от типа операции передаваемой в Json происходит->
снятие, зачисление, или перевод со счета

Ссылка с готовыми Get Post запросами
https://documenter.getpostman.com/view/21777259/2s8YzP24s9

