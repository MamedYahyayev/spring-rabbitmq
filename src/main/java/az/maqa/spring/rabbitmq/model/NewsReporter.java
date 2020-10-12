package az.maqa.spring.rabbitmq.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class NewsReporter implements Serializable {
    @Id
    private String id;
    private String name;
    private String surname;

    @OneToOne(mappedBy = "reporter")
    @JsonBackReference
    private News news;

    public NewsReporter(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

}
