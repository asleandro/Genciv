package com.genciv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GencivApplication {

	public static void main(String[] args) {
		SpringApplication.run(GencivApplication.class, args);
		System.out.print("está funcionando");
	}

}
