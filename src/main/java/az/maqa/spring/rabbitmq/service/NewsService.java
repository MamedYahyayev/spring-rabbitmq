package az.maqa.spring.rabbitmq.service;

import az.maqa.spring.rabbitmq.model.News;
import az.maqa.spring.rabbitmq.request.RequestNews;

public interface NewsService {
    News publishNews(RequestNews requestNews);

    News sendNewsToCompany(String id);
}
