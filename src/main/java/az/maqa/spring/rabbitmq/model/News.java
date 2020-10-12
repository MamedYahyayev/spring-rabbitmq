package az.maqa.spring.rabbitmq.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class News implements Serializable {

    @Id
    private String newsId;
    private String newsMessage;
    private Date newsDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private NewsReporter reporter;

    public News(String newsMessage, Date newsDate) {
        this.newsMessage = newsMessage;
        this.newsDate = newsDate;
    }
}
