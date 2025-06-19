package com.workExample.checkInventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CheckInventoryApplication {

	public static void main(String[] args) {

		SpringApplication.run(CheckInventoryApplication.class, args);
		System.out.println("CheckInventoryApplication is running!");

	}

}
