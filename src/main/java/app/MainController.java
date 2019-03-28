package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "app.datamapper")
@EntityScan("app/entity")
public class MainController {

    public static void main(String[] args) {
        SpringApplication.run(MainController.class, args);
    }

}
