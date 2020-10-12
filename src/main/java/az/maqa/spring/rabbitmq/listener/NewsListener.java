package az.maqa.spring.rabbitmq.listener;

import az.maqa.spring.rabbitmq.model.News;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class NewsListener {

    @RabbitListener(queues = "bbc-news-queue")
    public void bbcNewsListener(News news) {
        Date receiveDate = new Date();
        log.info("News Received Time: {} , News:{}", receiveDate, news);
    }

    @RabbitListener(queues = "abc-news-queue")
    public void abcNewsListener(News news) {
        Date receiveDate = new Date();
        log.info("News Received Time: {} , News:{}", receiveDate, news);
    }

    @RabbitListener(queues = "cnn-news-queue")
    public void cnnNewsListener(News news) {
        Date receiveDate = new Date();
        log.info("News Received Time: {} , News:{}", receiveDate, news);
    }
}
