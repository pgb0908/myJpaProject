package bong.service.collector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CollectorApplication {
	// https://docs.spring.io/spring-boot/reference/features/profiles.html
	public static void main(String[] args) {
		SpringApplication.run(CollectorApplication.class, args);
	}

}
