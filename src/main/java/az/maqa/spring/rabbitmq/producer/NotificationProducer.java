package az.maqa.spring.rabbitmq.producer;

import az.maqa.spring.rabbitmq.model.Notification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.UUID;

@Service
@Slf4j
public class NotificationProducer {

    @Autowired
    private RabbitTemplate template;

    @Value("${spring.rabbitmq.routing.name}")
    private String routingKey;

    @Value("${spring.rabbitmq.exchange.name}")
    private String exchange;

    @PostConstruct
    public void init() {
        Notification notification = new Notification();
        notification.setNotificationId(UUID.randomUUID().toString());
        notification.setCreatedAt(new Date());
        notification.setMessage("Hello World");
        notification.setIsSeen(Boolean.FALSE);
        notification.setRoutingKey(routingKey);
        sendToQueue(notification);
    }

    public void sendToQueue(Notification notification) {
        log.info("Notification sent...  ID: " + notification.getNotificationId());
        template.convertAndSend(exchange, routingKey, notification);
    }
}
