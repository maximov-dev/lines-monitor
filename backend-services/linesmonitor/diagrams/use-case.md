@startuml
left to right direction
skinparam linetype polyline
skinparam linetype ortho

' --- Объявление актеров ---
together {
actor "Конечный пользователь" as EU #LightGreen
actor "Разработчик" as Dev #LightBlue
actor "Инженер по производительности" as PE #Turquoise
actor "Менеджер проекта\n(Project Manager)" as PM #Pink
actor "DevOps / CI-CD\nEngineer" as DevOps #Orange
}


rectangle "Система измерения производительности веб-приложений" as System {

'
' --- JS-библиотека (клиент) ---
'
rectangle "JS-библиотека\n(клиент)" as JSClient {
usecase "Сбор метрик" as UC_CaptureMetrics
usecase "Отправка метрик" as UC_SendMetrics
}

'
' --- Фронтенд (Web UI) ---
'
rectangle "Фронтенд сервиса" as Frontend {
usecase "Интеграция JS-библиотеки" as UC_IntegrateJS
usecase "Управление проектами" as UC_ManageProjects
usecase "Управление окружениями" as UC_ManageEnv
usecase "Управление конфигурациями" as UC_ManageConfigs
usecase "Запуск тестов" as UC_ExecuteTests
usecase "Просмотр результатов\nи отчетов" as UC_ViewResults
usecase "Настройка оповещений" as UC_ConfigureAlerts
}

'
' --- Бэкенд ---
'
rectangle "Бэкенд" as Backend {
usecase "Прием и сохранение метрик" as UC_ReceiveStore
usecase "Анализ метрик" as UC_AnalyzeMetrics
usecase "Генерация отчетов" as UC_GenerateReports
usecase "Обработка оповещений" as UC_ProcessAlerts
}
}

'
' --- Связи акторов с вариантами использования ---
'

' Конечный пользователь (EndUser) взаимодействует лишь с сайтом, на котором установлена JS-библиотека.
EU --> UC_CaptureMetrics : "Посещает веб-приложение"
UC_CaptureMetrics --> UC_SendMetrics

' Разработчик
Dev --> UC_IntegrateJS
Dev --> UC_ManageEnv
Dev --> UC_ManageConfigs
Dev --> UC_ExecuteTests
Dev --> UC_ViewResults

' Инженер по производительности
PE --> UC_ManageEnv
PE --> UC_ManageConfigs
PE --> UC_ExecuteTests
PE --> UC_ViewResults
PE --> UC_ConfigureAlerts

' Менеджер проекта
PM --> UC_ManageProjects
PM --> UC_ViewResults
PM --> UC_ConfigureAlerts

' DevOps / CI-CD
DevOps --> UC_ExecuteTests
DevOps --> UC_ViewResults
DevOps --> UC_ConfigureAlerts

'
' --- Связи между Use Cases в разных блоках ---
'

' JS-клиент -> Бэкенд
UC_SendMetrics --> UC_ReceiveStore

' Из фронтенда можно инициировать тесты, которые тоже могут что-то отправлять бэкенду (например, синтетические результаты).
UC_ExecuteTests --> UC_ReceiveStore

' Далее бэкенд обрабатывает и анализирует данные
UC_ReceiveStore --> UC_AnalyzeMetrics
UC_AnalyzeMetrics --> UC_GenerateReports

' Настройка оповещений во фронтенде -> обработка на бэкенде
UC_ConfigureAlerts --> UC_ProcessAlerts

' Результат анализа может вызывать оповещения
UC_AnalyzeMetrics --> UC_ProcessAlerts


@enduml
