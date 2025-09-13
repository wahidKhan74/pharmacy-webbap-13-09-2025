package com.medico.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
	}

}

// @SpringBootApplication = @Configuration  + @EnableAutoConfiguration + @ComponentScan

// @Configuration = Marks the class as a configuration class (like a replacement for XML config in Spring).
// @EnableAutoConfiguration = It Look at the classpath and auto-configure beans for spring project
// @ComponentScan = Scans for Spring components in the current package and sub-packages.