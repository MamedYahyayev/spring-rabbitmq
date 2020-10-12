package az.maqa.spring.rabbitmq.controller;


import az.maqa.spring.rabbitmq.model.News;
import az.maqa.spring.rabbitmq.request.RequestNews;
import az.maqa.spring.rabbitmq.service.NewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @PostMapping
    public ResponseEntity<News> publishNews(@RequestBody RequestNews requestNews) {
        News news = newsService.publishNews(requestNews);
        return ResponseEntity.ok(news);
    }

    @GetMapping("/{id}")
    public ResponseEntity<News> sendNewsToCompany(@PathVariable String id) {
        News news = newsService.sendNewsToCompany(id);
        return ResponseEntity.ok(news);
    }
}
