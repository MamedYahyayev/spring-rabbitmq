package az.maqa.spring.rabbitmq.repository;

import az.maqa.spring.rabbitmq.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, String> {

}
