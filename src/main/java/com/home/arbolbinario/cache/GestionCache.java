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
 * @author Daniel Alejandro Rojas
 *
 */
@Component
public class GestionCache {

	/**
	 * 
	 */
	@Autowired
	private CacheManager cacheManager;

	/**
	 * 
	 */
	private Nodo nodoArbolBinario;

	/**
	 * @return
	 */
	@Cacheable("nodoArbolBinario")
	public Nodo getNodoArbolBinario() {
		return this.nodoArbolBinario;
	}

	/**
	 * 
	 */
	@CacheEvict(value = "nodo", allEntries = true)
	private void clearNodoArbolBinarioCache() {
		Cache cache = cacheManager.getCache("nodoArbolBinario");
		if (cache != null) {
			cache.clear();
		}
	}

	/**
	 * 
	 */
	@EventListener(ApplicationReadyEvent.class)
	public void init() {
		this.nodoArbolBinario = new Nodo();
		clearNodoArbolBinarioCache();
	}

}
