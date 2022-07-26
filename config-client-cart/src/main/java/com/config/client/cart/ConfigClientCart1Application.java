package com.config.client.cart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * @author Vuntla Rekhasree
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientCart1Application {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientCart1Application.class, args);
	}

}
