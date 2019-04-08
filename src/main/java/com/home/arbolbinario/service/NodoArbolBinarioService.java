package com.home.arbolbinario.service;

import java.util.List;

import com.home.arbolbinario.model.Nodo;

/**
 * @author Daniel Alejandro Rojas
 *
 */
public interface NodoArbolBinarioService {

	/**
	 * 
	 */
	public void reiniciarArbol();

	/**
	 * @param numeroNodo
	 */
	public void insertarArbolBinario(Long numeroNodo);

	/**
	 * @param numeroNodo
	 * @param nodoArbol
	 */
	public void insertarNodoArbol(Long numeroNodo, Nodo nodoArbol);

	/**
	 * @param lstNodos
	 */
	public void recorrerArbolNodoInorden(List<Long> lstNodos);

	
	/**
	 * @param numNodo1
	 * @param numNodo2
	 * @return
	 */
	public Long obtenerAncestroComun(Long numNodo1, Long numNodo2);

}
