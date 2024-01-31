# 30 Spring Integration  / task 15

Implement the processing of the domain entity through the Spring Integration channels

**Target:**
- Participants will be able to "integrate" parts of the application using EIP
- Result: Appendix using EIP on Spring Integration

**Description/Step -by -step instruction for homework:**
- Choose another domain area and entity. Example: turning the caterpillar into a butterfly.
- Describe/configure the process (IntegrationFlow) using the tools provided by Spring Integration.
- It is desirable to use Messaginggateway and Subfolw (if necessary).


=====

FeedServiceImp description:
- Loads currency rates for the last 8 days from https://www.cbr.ru/development/SXML/ in loop for each day:
- get List of ValCurs 
- load to IntegrationFlow
- convert to List of CurrencyDto
- Load to DB using 


================================= 

Реализовать обработку доменной сущности через каналы Spring Integration

**Цель:**
- Участники смогут осуществлять "интеграцию" частей приложения с помощью EIP
- Результат: приложение c применением EIP на Spring Integration


**Описание/Пошаговая инструкция выполнения домашнего задания:**
- Выберите другую доменную область и сущности. Пример: превращение гусеницы в бабочку.
- Опишите/сконфигурируйте процесс (IntegrationFlow) с помощью инструментария предоставляемого Spring Integration.
- Желательно использование MessagingGateway и subfolw (при необходимости).

