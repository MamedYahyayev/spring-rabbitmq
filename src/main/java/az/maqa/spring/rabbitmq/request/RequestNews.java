package az.maqa.spring.rabbitmq.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestNews {
    private String newsMessage;
    private Date newsDate;
    private RequestReporter reporter;
}
