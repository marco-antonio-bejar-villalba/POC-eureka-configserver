package org.marco.poc.poceurekaconfigserver.serviceserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceServerApplication.class, args);
	}

}
