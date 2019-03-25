package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "app.datamapper")
@EntityScan("app/entity")
@RestController("/mycan")
public class MainController {

    public static void main(String[] args) {
        SpringApplication.run(MainController.class, args);
    }

}
