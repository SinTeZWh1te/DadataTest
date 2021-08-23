# Реализация клиента DaData для BGBilling

* Скомпилировать, что компилируется (client+common)
* Покладить в либы клиента, чтобы раннер скачал.
* В конфиг сервера добавить нечто вроде

```
dynservice:ru.test.bgbilling.dadata.common.DadataService=ru.test.bgbilling.dadata.server.service.DadataServiceImpl
dadata.token=<token>
```
* Пользоваться

P.S. Предоставляется as-is, работоспособность не гарантируется.