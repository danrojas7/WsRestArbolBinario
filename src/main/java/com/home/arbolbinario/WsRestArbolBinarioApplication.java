package com.home.arbolbinario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Clase principal de inicialización del microservicio en SpringBoot
 * 
 * @author Daniel Alejandro Rojas
 *
 */
@EnableCaching
@SpringBootApplication
public class WsRestArbolBinarioApplication {

	/**
	 * Método main que es el punto de entrada del microservicio en SpringBoot
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(WsRestArbolBinarioApplication.class, args);
	}

}
