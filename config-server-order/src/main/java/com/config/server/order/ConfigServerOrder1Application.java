package com.config.server.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author Vuntla Rekhasree
 *
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerOrder1Application {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerOrder1Application.class, args);
	}

}
