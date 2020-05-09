package com.DistributedComputingCA2.DistributedComputingCA2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@SpringBootApplication
@Configuration
@ComponentScan("com.DistributedComputingCA2/DistributedComputingCA2")
@ImportResource("classpath:com/DistributedComputingCA2/DistributedComputingCA2/spring-config.xml")
public class DistributedComputingCa2Application {	

	public static void main(String[] args) {
		SpringApplication.run(DistributedComputingCa2Application.class, args);
	}
	
	public void addCorsMappings(CorsRegistry registry) {
		  registry.addMapping("/api/**")
		   	  .allowedOrigins("https://localhost:5094", "http://localhost:8080")
			  .allowedMethods("POST", "GET",  "PUT", "OPTIONS", "DELETE")
			  .allowedHeaders("X-Auth-Token", "Content-Type")
			  .exposedHeaders("custom-header1", "custom-header2")
			  .allowCredentials(false)
			  .maxAge(4800);
		}

}