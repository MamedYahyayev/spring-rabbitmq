package az.maqa.spring.rabbitmq.listener;

import az.maqa.spring.rabbitmq.model.Notification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationListener {

    @RabbitListener(queues = "rabbit-queue")
    public void handleMessage(Notification notification) {
        log.info("Message received...");
        System.out.println(notification);
    }
}
