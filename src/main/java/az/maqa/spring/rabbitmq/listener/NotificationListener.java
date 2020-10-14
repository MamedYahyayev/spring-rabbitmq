package az.maqa.spring.rabbitmq.listener;

import az.maqa.spring.rabbitmq.model.Notification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RabbitListener(queues = "rabbit-queue")
public class NotificationListener {

    @Autowired
    private RabbitTemplate template;

    @RabbitHandler
    public void handleMessage(Notification notification) {
        log.info("Message received...");
        log.info(notification.toString());
    }
}
