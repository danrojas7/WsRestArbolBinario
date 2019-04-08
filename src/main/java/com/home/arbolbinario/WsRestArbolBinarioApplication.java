package com.home.arbolbinario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author Daniel Alejandro Rojas
 *
 */
@EnableCaching
@SpringBootApplication
public class WsRestArbolBinarioApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(WsRestArbolBinarioApplication.class, args);
	}

}
