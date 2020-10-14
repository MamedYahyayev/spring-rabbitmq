package az.maqa.spring.rabbitmq.producer;

import az.maqa.spring.rabbitmq.model.News;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NewsProducer {

    @Autowired
    private RabbitTemplate template;

    @Value("${spring.rabbitmq.news.exchange}")
    private String topicExchange;

    @Value("${spring.rabbitmq.news.bbc.studio.routing.key}")
    private String bbcStudioRoutingKey;

    @Value("${spring.rabbitmq.news.abc.studio.routing.key}")
    private String abcStudioRoutingKey;

    @Value("${spring.rabbitmq.news.cnn.studio.routing.key}")
    private String cnnStudioRoutingKey;

    @Value("${spring.rabbitmq.news.bbc.routing.key}")
    private String bbcRoutingKey;

    @Value("${spring.rabbitmq.news.abc.routing.key}")
    private String abcRoutingKey;

    @Value("${spring.rabbitmq.news.cnn.routing.key}")
    private String cnnRoutingKey;

    @Value("${spring.rabbitmq.news.america.abc.routing.key}")
    private String americaAbcRoutingKey;

    @Value("${spring.rabbitmq.news.spain.cnn.routing.key}")
    private String spainCnnRoutingKey;

    public void sendNews(News news) {
        String[] routeKeys = new String[]{
                bbcRoutingKey, abcRoutingKey, cnnRoutingKey,
                bbcStudioRoutingKey, abcStudioRoutingKey, cnnStudioRoutingKey,
                americaAbcRoutingKey, spainCnnRoutingKey
        };

        for (String key : routeKeys) {
            template.convertAndSend(topicExchange, key, "routing key: " + key + " " + news);
            log.info("News Sending.... with key: {}", key);
        }

    }

}
