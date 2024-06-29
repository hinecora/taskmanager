# Spring Boot 3.0 Security with JWT Implementation
 В основе проекта Spring Boot 3.0 и веб-токен JSON (JWT). Проект включает в себя следующие функции:

## Features
* Регистрация пользователя и вход в систему с аутентификацией JWT.
* Добавление задач пользователю.
* Поиск пользователя по: id, username.
* Поиск задач пользователя.
* Шифрование пароля

## Technologies
* Spring Boot 3.0
* Spring Security
* JSON Web Tokens (JWT)
* Maven
* Lombok
* Liquibase
* MapStruct

## Getting Started
Чтобы начать работу с проектом, вам необходимо установить на локальном компьютере следующее:

* JDK 17+
* Maven 3+


Чтобы собрать и запустить проект, выполните следующие действия:

* Клонируем репозиторий: `git clone https://github.com/hinecora/taskmanager.git`
* Перейдите в каталог проекта: cd taskmanager.
* Добавьте базу данных «taskmanager» в postgres.
* Сборка проекта: mvn clean install
* Запустите проект: mvn Spring-boot:run.

* Приложение будет доступно по адресу http://localhost:8080.
* SwaggerUI: http://localhost:8080/swagger-ui/index.html#/
