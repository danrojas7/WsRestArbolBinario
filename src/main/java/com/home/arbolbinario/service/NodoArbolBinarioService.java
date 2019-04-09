package com.home.arbolbinario.service;

import java.util.List;

import com.home.arbolbinario.model.Nodo;

/**
 * Clase interfaz para el servicio, en la cual se define el prototipo de las
 * clases que se van a utilizar en la implementación del servicio
 * 
 * @author Daniel Alejandro Rojas
 *
 */
public interface NodoArbolBinarioService {

	/**
	 * Método que realiza el reinicio de la caché de SpringBoot, en la cual se
	 * encuentra almacenada la estructura del árbol binario (se almacena el nodo
	 * raíz)
	 */
	public void reiniciarArbol();

	/**
	 * Método que realiza la inserción un número, en un nodo determinado dentro del
	 * árbol binario
	 * 
	 * @param numeroNodo Número del nodo a insertar dentro del nodo del árbol
	 *                   binario
	 */
	public void insertarArbolBinario(Long numeroNodo);

	/**
	 * Método que realiza la inserción del nodo dentro del árbol, lo realiza
	 * mediante recorrido por recursión
	 * 
	 * @param numeroNodo Número de nodo a insertar
	 * @param nodoArbol  Nodo dentro del árbol binario en el que se encuentra al
	 *                   momento de la ejecución del método de manera recursiva
	 */
	public void insertarNodoArbol(Long numeroNodo, Nodo nodoArbol);

	/**
	 * Método que realiza el recorrido del árbol binario almacenado en caché, en
	 * algoritmo inorden de manera recursiva
	 * 
	 * @param lstNodos Listado de nodos
	 */
	public void recorrerArbolNodoInorden(List<Long> lstNodos);

	/**
	 * Método que retorna el nodo ancestro en común entre dos nodos, los números
	 * proporcionados deben de haberse insertado anteriormente dentro del árbol
	 * binario
	 * 
	 * @param numNodo1 Número de nodo 1 al cual se va a hallar el ancestro en común
	 * @param numNodo2 Número de nodo 2 al cual se va a hallar el ancestro en común
	 * @return Número del nodo que corresponde al ancestro en común
	 */
	public Long obtenerAncestroComun(Long numNodo1, Long numNodo2);

}
