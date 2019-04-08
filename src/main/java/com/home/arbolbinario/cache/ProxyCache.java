package com.home.arbolbinario.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.home.arbolbinario.model.Nodo;

/**
 * @author Daniel Alejandro Rojas
 *
 */
@Component
public class ProxyCache {

	/**
	 * 
	 */
	@Autowired
	private GestionCache gestionCache;

	/**
	 * @return
	 */
	public Nodo getNodoArbolBinario() {
		return gestionCache.getNodoArbolBinario();
	}

	/**
	 * 
	 */
	public void init() {
		gestionCache.init();
	}

}
