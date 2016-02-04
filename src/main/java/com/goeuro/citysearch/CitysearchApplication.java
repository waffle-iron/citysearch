package com.goeuro.citysearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan
@SpringBootApplication
public class CitysearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(CitysearchApplication.class, args);
	}
}
