
## Подготовка приложения aqa-shop.jar к тестированию в СУБД MySql

### Начало работы
1.  В docker-compose.yml прописать настройки запуска и переменные окружения: 
                                                                                                                                                  
### Необходимо установить
На ПК должна быть установлена JDK, IntelliJ IDEA, Docker Toolbox, браузер, Node.js

### Установка и запуск
1. запустить Docker Toolbox
2. выполнить команду docker-compose up, если запуск происходит впервые или docker-compose up --force-recreate, чтобы сделать перезапуск базы данных.
3. java -jar artifacts/aqa-shop.jar -P:jdbc.url=jdbc:mysql://192.168.99.100:3306/app -P:jdbc.user=app -P:jdbc.password=pass 
4. открыть приложение в браузере на http://localhost:8080
5. открыть Node.js command prompt, командой cd перейти в каталог /gate-simulator, выполнить команду npm start.