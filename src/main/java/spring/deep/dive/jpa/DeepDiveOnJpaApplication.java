package spring.deep.dive.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DeepDiveOnJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeepDiveOnJpaApplication.class, args);
    }



}
