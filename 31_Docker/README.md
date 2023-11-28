# 31-Docker

FeedServiceImp:
- Loads currency rates for the last 8 days from https://www.cbr.ru/development/SXML/ in loop for each day:
- get List of ValCurs 
- load to IntegrationFlow
- convert to List of CurrencyDto
- Load to DB using 
