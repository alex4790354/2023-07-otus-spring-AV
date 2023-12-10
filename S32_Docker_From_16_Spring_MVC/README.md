# 32-Docker

Purpose: to deploy the application in a modern DevOPS stack
The task is based on any web application.

- Wrap the application in the Docker container. Dockerfile is usually located at the root of the repository. Image should get a JAR application. The assembly in the container is recommended, but not required.
- You do not need to wrap the database into your own container (unless you use custom plugins)
- Configure the connection between containers using Docker-Compose
- Optional: do it in a local cube.
- It is advisable to implement the application using all Best Practices Docker (logging in Stdout, etc.)


==============================

Цель: деплоить приложение в современном DevOps-стеке
Задание выполняется на основе любого сделанного Web-приложения

- Обернуть приложение в docker-контейнер. Dockerfile принято располагать в корне репозитория. В image должна попадать JAR-приложения. Сборка в контейнере рекомендуется, но не обязательна.
- БД в собственный контейнер оборачивать не нужно (если только Вы не используете кастомные плагины)
- Настроить связь между контейнерами, с помощью docker-compose
- Опционально: сделать это в локальном кубе.
- Приложение желательно реализовать с помощью всех Best Practices Docker (логгирование в stdout и т.д.)



