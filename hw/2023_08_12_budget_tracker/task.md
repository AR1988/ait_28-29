# Требования к приложению для анализа пользовательских трат

## Описание
Целью данного проекта является разработка консольного приложения на Java, которое позволит пользователям вводить данные о своих тратам, а также анализировать их и генерировать отчеты на основе введенных данных. Пользователи смогут определить категорию и подкатегорию для каждой транзакции.

## Функциональные требования
### Ввод данных:

При запуске приложения пользователю предоставляется меню выбора действий.
Пользователь может ввести новую транзакцию: сумму и дату.
После ввода суммы и даты, пользователь выбирает категорию и подкатегорию из предопределенных списков.
После ввода категории и подкатегории генерируется уникальный ID для транзакции.

### Анализ трат:

Пользователь может запросить анализ своих трат за определенный период.
Пользователь вводит начальную и конечную дату периода.
Приложение анализирует траты за указанный период и генерирует отчет, который содержит:
Сводку по категориям и подкатегориям с указанием суммы потраченных средств.
Общую сумму потраченных средств за указанный период.
Сохранение данных:

Приложение сохраняет каждую введенную транзакцию в CSV файле для долгосрочного хранения.
При запуске приложения, оно читает ранее сохраненные данные из CSV файла.
Генерация отчетов:

После анализа трат за период, приложение генерирует отчет в текстовом формате.
Отчет содержит подробности анализа по категориям, подкатегориям и общей сумме.
Нефункциональные требования

## Язык программирования и технологии:

- Приложение должно быть реализовано на языке Java без использования сторонних зависимостей.
Интерфейс пользователя:

- Интерфейс приложения осуществляется через командную строку (консоль).
Управление данными:

- Данные о транзакциях сохраняются в CSV файле.
- Для генерации уникальных ID используется специальный механизм (например, счетчик).

## Обработка ошибок:

- Приложение должно обрабатывать некорректные вводы пользователя и предоставлять информативные сообщения об ошибках.

## Документация:

Код должен содержать комментарии для объяснения работы и функций.
Создайте краткую документацию для пользователей о том, как использовать приложение.