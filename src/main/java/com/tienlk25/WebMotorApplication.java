package com.tienlk25;

import javax.sound.midi.Soundbank;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
//@EnableJpaAuditing
public class WebMotorApplication implements CommandLineRunner{
 
	public static void main(String[] args) {
		SpringApplication.run(WebMotorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("============= T I E N L K 2 5 =============");
		
	}
}
