package com.softwaremind.crew;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Crew application entry point class.
 *
 * @author daba
 * @since 06.04.2018
 */
@SpringBootApplication
public class CrewApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(CrewApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
	}
}
