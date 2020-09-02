
## Подготовка приложения aqa-shop.jar к тестированию в СУБД MySql

### Начало работы
1.  В docker-compose.yml прописать настройки запуска и переменные окружения: 
                                                                                                                                                  
### Необходимо установить
На ПК должна быть установлена JDK, IntelliJ IDEA, Docker Toolbox, браузер, Node.js

### Установка и запуск
1. запустить Docker Toolbox
2. выполнить команду docker-compose up, если запуск происходит впервые или docker-compose up --force-recreate, чтобы сделать перезапуск базы данных.
3. * для запуска СУБД mysql application.properties заменить на следующий:  spring.credit-gate.url=http://localhost:9999/credit
                                                                           spring.payment-gate.url=http://localhost:9999/payment
                                                                           spring.datasource.url=jdbc:mysql://192.168.99.100:3306/app
                                                                           spring.datasource.username=app
                                                                           spring.datasource.password=pass
   * для запуска СУБД postgres application.properties заменить на следующий: spring.credit-gate.url=http://localhost:9999/credit
                                                                           spring.payment-gate.url=http://localhost:9999/payment   
                                                                           spring.datasource.url=jdbc:postgresql://192.168.99.100:5432/my_db
                                                                           spring.datasource.username=app
                                                                           spring.datasource.password=pass
4. выполнить команду:
java -jar artifacts/aqa-shop.jar 
                                                                          
5. открыть приложение в браузере на http://localhost:8080
6. открыть Node.js command prompt, командой cd перейти в каталог /gate-simulator, выполнить команду npm start.