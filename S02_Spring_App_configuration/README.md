# Task-02. Spring Applications Configuration


Target:
Goal: Configure Spring applications in a modern way, as is done in the modern world
Result: a ready-made modern application in pure Spring

Description/Step-by-step instructions for completing homework:
Task description:
The resources store questions and various answers to them in the form of a CSV file (5 questions).
Questions can be with a choice from several options or with a free answer - at your desire and discretion.
New functionality:
The program should ask the user for last and first name, ask 5 questions from the CSV file and display the test result.
Performed on the basis of the previous homework +, in fact, the testing functionality itself.
Requirements:
0) The application must have an object model (we give preference to objects and classes rather than strings and arrays/lists of strings).

1) All classes in the application must solve a strictly defined problem (see paragraphs 18-19 “Rules for code formatting.pdf”, attached to the lesson materials).
2) Rewrite the configuration as a Java + Annotation-based configuration. All dependencies must be configured in the IoC container.
3) Add student testing functionality.
4) Add a settings file for the student testing application.
5) You can put the path to the CSV file in the configuration file; the number of correct answers for credit is at your discretion.
6) Remember, CSV with questions is read exactly as a resource, and not as a file.
7) You need to write an integration test for a class that reads questions and a unit test for the service with a dependency mock
8) Settings file and question file for tests d.b. their.
9) Scanner, PrintStream and other standard types do not need to be placed in the context! See relevant slides from the session.
10) All input and output is carried out in English.
11) Remember: "No fanaticism" :)


# #########################################################################################################

Приложение по проведению тестирования студентов (с самим тестированием)

Цель:
Цель: конфигурировать Spring-приложения современным способом, как это и делается в современном мире
Результат: готовое современное приложение на чистом Spring


Описание/Пошаговая инструкция выполнения домашнего задания:
Описание задания:
В ресурсах хранятся вопросы и различные ответы к ним в виде CSV файла (5 вопросов).
Вопросы могут быть с выбором из нескольких вариантов или со свободным ответом - на Ваше желание и усмотрение.
Новый функционал:
Программа должна спросить у пользователя фамилию и имя, спросить 5 вопросов из CSV-файла и вывести результат тестирования.
Выполняется на основе предыдущего домашнего задания + , собственно, сам функционал тестирования.
Требования:
0) В приложении должна присутствовать объектная модель (отдаём предпочтение объектам и классам, а не строчкам и массивам/спискам строчек).
1) Все классы в приложении должны решать строго определённую задачу (см. п. 18-19 "Правила оформления кода.pdf", прикреплённые к материалам занятия).
2) Переписать конфигурацию в виде Java + Annotation-based конфигурации. Все зависимости должны быть настроены в IoC контейнере.
3) Добавить функционал тестирования студента.
4) Добавьте файл настроек для приложения тестирования студентов.
5) В конфигурационный файл можно поместить путь до CSV-файла, количество правильных ответов для зачёта - на Ваше усмотрение.
6) Помним, CSV с вопросами читается именно как ресурс, а не как файл.
7) Нужно написать интеграционный тест класса, читающего вопросы и юнит-тест сервиса с моком зависимости
8) Файл настроек и файл с вопросами, для тестов д.б. свои.
9) Scanner, PrintStream и другие стандартные типы в контекст класть не нужно! См. соответствующие слайды с занятия.
10) Весь ввод-вывод осуществляется на английском языке.
11) Помним: "без фанатизма" :)
