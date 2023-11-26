# 2023-07-otus-spring-AV
Otus 2023 Spring course. 
  Spring Integration: Endpoints и Flow Components

1. Application calls FeedService.
2. FeedServiceImp получается курсы валют от ЦБР в виде xml, парсит в ValCurs и выдает в виде результата.
3. ValCurs передаются в IntegrationFlow rateFlow, где конвертируется в List<RateDto>

TODO (can be added in next ):
- Filtering.
- Load data to DB
