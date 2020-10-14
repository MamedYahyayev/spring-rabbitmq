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

    @Value("${spring.rabbitmq.news.all.queue}")
    private String allQueue;

    @Value("${spring.rabbitmq.news.exchange}")
    private String topicExchange;

    @Value("${spring.rabbitmq.news.bbc.binding.key}")
    private String bbcBindingKey;

    @Value("${spring.rabbitmq.news.abc.binding.key}")
    private String abcBindingKey;

    @Value("${spring.rabbitmq.news.cnn.binding.key}")
    private String cnnBindingKey;

    @Value("${spring.rabbitmq.news.all.binding.key}")
    private String allBindingKey;

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
    public Queue allQueue() {
        return new Queue(allQueue);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(topicExchange);
    }

    @Bean
    public Binding bbcBinding(@Qualifier("bbcQueue") Queue queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with(bbcBindingKey);
    }

    @Bean
    public Binding abcBinding(@Qualifier("abcQueue") Queue queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with(abcBindingKey);
    }

    @Bean
    public Binding cnnBinding(@Qualifier("cnnQueue") Queue queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with(cnnBindingKey);
    }

    @Bean
    public Binding allBinding(@Qualifier("allQueue") Queue queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with(allBindingKey);
    }

}
