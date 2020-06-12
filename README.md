
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
2. Запустить Docker Toolbox
3. выполнить команду docker-compose up    
4. java -jar artifacts/artifacts/aqa-shop.jar 
5. При повторном запуске выполнить docker-compose down,  выполнить п.3, п.4. 
6. открыть приложение в браузере на http://localhost:8080