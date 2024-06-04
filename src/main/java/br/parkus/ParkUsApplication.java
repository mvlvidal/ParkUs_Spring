package br.parkus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class ParkUsApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ParkUsApplication.class, args);	
	}
}
