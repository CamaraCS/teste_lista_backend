package com.lista.compras.listacompras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan("com.lista.compras.listacompras")
@EnableJpaRepositories(basePackages="com.lista.compras.listacompras.repository")
public class ListaComprasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListaComprasApplication.class, args);
	}
}
