package az.maqa.spring.rabbitmq.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class NewsListener {

    @RabbitListener(queues = "bbc-news-queue")
    public void bbcNewsListener(String news) {
        Date receiveDate = new Date();
        log.info("BBC News Received Time: {} , News:{}", receiveDate, news);
    }

    @RabbitListener(queues = "abc-news-queue")
    public void abcNewsListener(String news) {
        Date receiveDate = new Date();
        log.info("ABC News Received Time: {} , News:{}", receiveDate, news);
    }

    @RabbitListener(queues = "cnn-news-queue")
    public void cnnNewsListener(String news) {
        Date receiveDate = new Date();
        log.info("CNN News Received Time: {} , News:{}", receiveDate, news);
    }


    @RabbitListener(queues = "all-news-queue")
    public void allNewsListener(String news) {
        Date receiveDate = new Date();
        log.info("ALL News Received Time: {} , News:{}", receiveDate, news);
    }
}
