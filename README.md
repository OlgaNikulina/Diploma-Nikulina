
# Подготовка приложения aqa-shop.jar к тестированию в СУБД MySql

## Начало работы
1.  и docker-compose.yml. В docker-compose.yml прописать настройки запуска и переменные окружения: 
```
version: '3.7'
services:
  mysql:
    image: mysql:8.0.18
    restart: always
    ports:
      - "8080:8080"
    volumes:
      - ./init_db:/docker-entrypoint-initdb.d
    environment:
      - MYSQL_RANDOM_ROOT_PASSWORD=yes
      - MYSQL_DATABASE=app
      - MYSQL_USER=app
      - MYSQL_PASSWORD=pass
```                                                                                                                                                         
                                                                                                                                                                        
### Prerequisites
На ПК должна быть установлена JDK, IntelliJ IDEA, Docker Toolbox, браузер

### Установка и запуск
1. запустить Docker Toolbox
2. выполнить команду docker-compose up  / docker-compose up --force-recreate 
3. java -jar artifacts/aqa-shop.jar или java -jar artifacts/aqa-shop.jar -P:jdbc.url=jdbc:mysql://192.168.99.100:3306/app -P:jdbc.user=app -P:jdbc.password=pass
4. при повторном запуске выполнить docker-compose down,  выполнить п.3, п.4. 
5. открыть приложение в браузере на http://localhost:8080
6. в каталоге init_db/gate-simulator открыть терминал и запустить симулятор командой npm start