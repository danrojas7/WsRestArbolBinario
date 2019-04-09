package com.home.arbolbinario.model;

/**
 * Clase Nodo del árbol binario, que va a soportar la estructura de datos del
 * árbol binario
 * 
 * @author Daniel Alejandro Rojas
 *
 */
public class Nodo {

	private Long numero;

	private Nodo nodoIzquierdo;

	private Nodo nodoDerecho;

	public Nodo() {
		super();
	}

	public final Long getNumero() {
		return numero;
	}

	public final void setNumero(Long numero) {
		this.numero = numero;
	}

	public final Nodo getNodoIzquierdo() {
		return nodoIzquierdo;
	}

	public final void setNodoIzquierdo(Nodo nodoIzquierdo) {
		this.nodoIzquierdo = nodoIzquierdo;
	}

	public final Nodo getNodoDerecho() {
		return nodoDerecho;
	}

	public final void setNodoDerecho(Nodo nodoDerecho) {
		this.nodoDerecho = nodoDerecho;
	}

}
