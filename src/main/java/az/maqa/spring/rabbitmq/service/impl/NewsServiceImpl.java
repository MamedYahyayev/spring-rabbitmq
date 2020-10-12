package az.maqa.spring.rabbitmq.service.impl;

import az.maqa.spring.rabbitmq.model.News;
import az.maqa.spring.rabbitmq.model.NewsReporter;
import az.maqa.spring.rabbitmq.producer.NewsProducer;
import az.maqa.spring.rabbitmq.repository.NewsRepository;
import az.maqa.spring.rabbitmq.request.RequestNews;
import az.maqa.spring.rabbitmq.service.NewsService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NewsServiceImpl implements NewsService {

    private final NewsRepository repository;
    private final NewsProducer producer;

    public NewsServiceImpl(NewsRepository repository, NewsProducer producer) {
        this.repository = repository;
        this.producer = producer;
    }

    @Override
    public News publishNews(RequestNews requestNews) {
        News news = new News(requestNews.getNewsMessage(), requestNews.getNewsDate());
        NewsReporter reporter = new NewsReporter(requestNews.getReporter().getName(), requestNews.getReporter().getSurname());
        news.setNewsId(UUID.randomUUID().toString());
        reporter.setId(UUID.randomUUID().toString());
        news.setReporter(reporter);
        return repository.save(news);
    }

    @Override
    public News sendNewsToCompany(String id) {
        News news = repository.findById(id).get();
        if (!news.getNewsMessage().isEmpty()) producer.sendNews(news);
        return news;
    }
}
