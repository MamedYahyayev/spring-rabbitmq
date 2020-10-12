package az.maqa.spring.rabbitmq.producer;

import az.maqa.spring.rabbitmq.model.News;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@Slf4j
public class NewsProducer {

    @Autowired
    private RabbitTemplate template;

    @Value("${spring.rabbitmq.news.exchange}")
    private String topicExchange;

    @Value("${spring.rabbitmq.news.bbc.routing.key}")
    private String bbcRoutingKey;

    @Value("${spring.rabbitmq.news.abc.routing.key}")
    private String abcRoutingKey;

    @Value("${spring.rabbitmq.news.cnn.routing.key}")
    private String cnnRoutingKey;


    public void sendNews(News news) {
        String[] routeKeys = new String[]{
                bbcRoutingKey, abcRoutingKey, cnnRoutingKey
        };

        for(String keys: routeKeys){
            template.convertAndSend(topicExchange, keys, news);
            log.info("News Sending.... with key: {}", keys);
        }

    }

}
