package com.example.springbootrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Actuator Endpoints:
http://localhost:8080/actuator
http://localhost:8080/actuator/info
http://localhost:8080/actuator/health
http://localhost:8080/actuator/env
http://localhost:8080/actuator/metrics
http://localhost:8080/actuator/heapdump
 */

@SpringBootApplication
public class SpringBootRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApplication.class, args);
	}

}
