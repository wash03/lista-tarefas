package com.example.listadetarefasapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ListaTarefasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListaTarefasApplication.class, args);
	}

}
