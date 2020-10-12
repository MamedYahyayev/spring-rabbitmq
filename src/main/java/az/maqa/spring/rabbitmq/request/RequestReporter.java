package az.maqa.spring.rabbitmq.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestReporter {
    private String name;
    private String surname;
}
