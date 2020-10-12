package az.maqa.spring.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:news.properties")
public class RabbitMqNewsConfig {

    @Value("${spring.rabbitmq.news.bbc.queue}")
    private String bbcQueue;

    @Value("${spring.rabbitmq.news.abc.queue}")
    private String abcQueue;

    @Value("${spring.rabbitmq.news.cnn.queue}")
    private String cnnQueue;

    @Value("${spring.rabbitmq.news.exchange}")
    private String topicExchange;

    @Value("${spring.rabbitmq.news.bbc.routing.key}")
    private String bbcRoutingKey;

    @Value("${spring.rabbitmq.news.abc.routing.key}")
    private String abcRoutingKey;

    @Value("${spring.rabbitmq.news.cnn.routing.key}")
    private String cnnRoutingKey;

    @Bean
    public Queue bbcQueue() {
        return new Queue(bbcQueue);
    }

    @Bean
    public Queue abcQueue() {
        return new Queue(abcQueue);
    }

    @Bean
    public Queue cnnQueue() {
        return new Queue(cnnQueue);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(topicExchange);
    }

    @Bean
    public Binding bbcBinding(@Qualifier("bbcQueue") Queue queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with(bbcRoutingKey);
    }

    @Bean
    public Binding abcBinding(@Qualifier("abcQueue") Queue queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with(abcRoutingKey);
    }

    @Bean
    public Binding cnnBinding(@Qualifier("cnnQueue") Queue queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with(cnnRoutingKey);
    }

}
