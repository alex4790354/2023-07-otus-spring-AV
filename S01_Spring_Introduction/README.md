# Task-01. Introduction to the Spring.

Application for testing students - only displaying questions and answer options (if any)

Target:
Create an application using Spring IoC to become familiar with the core IoC functionality on which all of Spring is built.
The result: a simple application configured with an XML context.


Description/Step-by-step instructions for completing homework:
Task description:
The resources store questions and various answers to them in the form of a CSV file (5 questions).
Questions can be with a choice from several options or with a free answer - at your desire and discretion.
The application should simply output the test questions from the CSV file with possible answer options (if any).
Requirements:
0) The application must have an object model (we give preference to objects and classes rather than strings and arrays/lists of strings).

1) All classes in the application must solve a strictly defined problem (see paragraphs 18-19 “Rules for code formatting.pdf”, attached to the lesson materials).
2) The context is described by an XML file.
3) All dependencies must be configured in the IoC container.
4) The name of the resource with questions (CSV file) must be hardcoded with a line in the XML file with the context.
5) CSV with questions is read exactly as a resource, and not as a file.
6) Scanner, PrintStream and other standard types do not need to be placed in the context!
7) All input and output is carried out in English.
8) It is highly advisable to write a unit test of some service (only the attempt to write a test will be evaluated).
9) Remember - “without fanaticism.”
   Optional (task with an asterisk):
   1*. The application should run correctly using "java -jar"
   The assignment is submitted as a link to a pull-request in a chat with the teacher in your OTUS personal account, not in Slack!
   Instructions for working with pull requests are in the document “Setting up the environment.pdf” in the lesson materials.
   Questions can be asked in chat, but for efficiency we recommend Slack.
   The code written in this assignment will be used further in homework #2 (Lesson #2), #3 (Lesson #4), #4 (Lesson #5)

###########################

Приложение по проведению тестирования студентов - только вывод вопросов и вариантов ответа (если имеются)

Цель:
Создать приложение с помощью Spring IoC, чтобы познакомиться с основной функциональностью IoC, на которой строится весь Spring.
Результат: простое приложение, сконфигурированное XML-контекстом.


Описание/Пошаговая инструкция выполнения домашнего задания:
Описание задания:
В ресурсах хранятся вопросы и различные ответы к ним в виде CSV файла (5 вопросов).
Вопросы могут быть с выбором из нескольких вариантов или со свободным ответом - на Ваше желание и усмотрение.
Приложение должна просто вывести вопросы теста из CSV-файла с возможными вариантами ответа (если имеются).
Требования:
0) В приложении должна присутствовать объектная модель (отдаём предпочтение объектам и классам, а не строчкам и массивам/спискам строчек).

1) Все классы в приложении должны решать строго определённую задачу (см. п. 18-19 "Правила оформления кода.pdf", прикреплённые к материалам занятия).
2) Контекст описывается XML-файлом.
3) Все зависимости должны быть настроены в IoC контейнере.
4) Имя ресурса с вопросами (CSV-файла) необходимо захардкодить строчкой в XML-файле с контекстом.
5) CSV с вопросами читается именно как ресурс, а не как файл.
6) Scanner, PrintStream и другие стандартные типы в контекст класть не нужно!
7) Весь ввод-вывод осуществляется на английском языке.
8) Крайне желательно написать юнит-тест какого-нибудь сервиса (оцениваться будет только попытка написать тест).
9) Помним - "без фанатизма".
Опционально (задание со "звёздочкой"):
1*. Приложение должно корректно запускаться с помощью "java -jar"
Задание сдаётся в виде ссылки на pull-request в чат с преподавателем в личном кабинете ОТУС, не в Slack!
Инструкция по работе с pull-request-ами находится в документе "Настройка окружения.pdf" в материалах занятия.
Вопросы можно задавать в чате, но для оперативности рекомендуем Slack.
Код, написанный в данном ДЗ будет использоваться дальше в домашних заданиях #2 (Занятие #2), #3 (Занятие #4), #4 (Занятие #5) 

