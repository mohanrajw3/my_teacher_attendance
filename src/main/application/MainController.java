package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "application.datamapper")
public class MainController {

    public static void main(String[] args) {
        SpringApplication.run(MainController.class, args);
    }

}
