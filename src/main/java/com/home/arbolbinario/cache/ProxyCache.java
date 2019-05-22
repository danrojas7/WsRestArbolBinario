package com.home.arbolbinario.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.home.arbolbinario.model.Nodo;

/**
 * Clase fachada para la administración de la caché del árbol binario
 * 
 * @author Daniel Alejandro Rojas
 *
 */
@Component
public class ProxyCache {

	/**
	 * Clase componente administradora de la caché del árbol binario
	 */
	@Autowired
	private GestionCache gestionCache;

	/**
	 * Método que obtiene de la caché el nodo raíz del árbol binario almacenado
	 * 
	 * @return
	 */
	public synchronized Nodo getNodoArbolBinario() {
		return gestionCache.getNodoArbolBinario();
	}

	/**
	 * Método init de la clase controladora de la caché, en la que se instancia un
	 * nuevo nodo raíz a la espera de almacenar más elementos en el árbol binario
	 */
	public synchronized void init() {
		gestionCache.init();
	}

}
