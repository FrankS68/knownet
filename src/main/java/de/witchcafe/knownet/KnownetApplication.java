package de.witchcafe.knownet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "de.witchcafe")
public class KnownetApplication {

	public static void main(String[] args) {
		SpringApplication.run(KnownetApplication.class, args);
	}

	// resources/META-INF/resources
}
