# CurrencyLimitTracker

*CurrencyLimitTracker* - это микросервис, разработанный для отслеживания расходов в различных валютах, установки и контроля месячных лимитов, автоматического маркирования транзакций, превышающих установленные лимиты, и предоставления клиентам информации о превышении лимитов.

## Особенности:

- Получение информации о расходных операциях в реальном времени и сохранение ее в базе данных.
- Хранение месячных лимитов для расходов в USD с разделением по категориям товаров и услуг.
- Запрос данных биржевых курсов для валютных пар KZT/USD, RUB/USD и их хранение в базе данных.
- Автоматическое помечание транзакций, превысивших установленные лимиты.
- Возможность установки нового лимита с автоматической установкой текущей даты.
- Предоставление списка транзакций, превысивших лимит, с указанием суммы лимита и валюты.

## Установка и запуск:
Копируем в свою машину:
```http
git clone https://github.com/Akello-web/CurrencyLimitTracker.git
```

Внутри проекта запускаем через:
```http
  docker-compose up
```

## API Endpoints

#### Get current exchange rate API

```http
  POST /rates
```
#### Set monthly limit

```http
  POST /limits
```
#### Get all monthly limit existed

```http
  GET /limits
```

#### Make a transaction

```http
  POST /transactions
```

#### Get all exceeded transactions

```http
  POST /transactions
```

## База данных

CurrencyLimitTracker использует PostgerSQL для хранения данных о транзакциях и месячных лимитах.
Также использует Liquibase для миграции данных.

## Технологии

- Java
- Spring Boot
- Spring WEB
- Spring Data JPA
- MapStruct
- PostgreSQL
- Gradle
- Liquibase Migrations

