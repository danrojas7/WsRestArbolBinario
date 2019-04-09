package com.home.arbolbinario.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.home.arbolbinario.model.Nodo;

/**
 * Clase controladora de la caché de SpringBoot, en la que se almacena la
 * estructura de datos del árbol binario que se está insertando
 * 
 * @author Daniel Alejandro Rojas
 *
 */
@Component
public class GestionCache {

	/**
	 * Clase controladora de la caché
	 */
	@Autowired
	private CacheManager cacheManager;

	/**
	 * Nodo raíz del árbol binario, en la cual viene soportada la estructura de
	 * datos del árbol binario que se está almacenando
	 */
	private Nodo nodoArbolBinario;

	/**
	 * Método que retorna de la caché del árbol binario, el nodo raíz en donde viene
	 * soportada la estructura de datos
	 * 
	 * @return Nodo raíz del árbol binario
	 */
	@Cacheable("nodoArbolBinario")
	public Nodo getNodoArbolBinario() {
		return this.nodoArbolBinario;
	}

	/**
	 * Método que borra de la caché, el nodo raízo del árbol binario
	 */
	@CacheEvict(value = "nodo", allEntries = true)
	private void clearNodoArbolBinarioCache() {
		Cache cache = cacheManager.getCache("nodoArbolBinario");
		if (cache != null) {
			cache.clear();
		}
	}

	/**
	 * Método que inicializa el nodo raíz del árbol binario
	 */
	@EventListener(ApplicationReadyEvent.class)
	public void init() {
		this.nodoArbolBinario = new Nodo();
		clearNodoArbolBinarioCache();
	}

}
