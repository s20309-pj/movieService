package pl.edu.pjwstk.matyliano;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class MatylianoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MatylianoApplication.class, args);
    }

}
