package com.home.arbolbinario.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.arbolbinario.cache.ProxyCache;
import com.home.arbolbinario.model.Nodo;
import com.home.arbolbinario.service.NodoArbolBinarioService;

/**
 * @author Daniel Alejandro Rojas
 *
 */
@Service
public class NodoArbolBinarioServiceImpl implements NodoArbolBinarioService {

	/**
	 * 
	 */
	@Autowired
	private ProxyCache proxyCache;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.home.arbolbinario.service.NodoArbolBinarioService#reiniciarArbol()
	 */
	@Override
	public void reiniciarArbol() {
		proxyCache.init();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.home.arbolbinario.service.NodoArbolBinarioService#
	 * insertarNodoArbolBinario(java.lang.Long)
	 */
	@Override
	public void insertarArbolBinario(Long numeroNodo) {
		Nodo nodoRaiz = null;
		nodoRaiz = proxyCache.getNodoArbolBinario();
		if (nodoRaiz == null) {
			proxyCache.init();
		} else if (nodoRaiz.getNumero() == null) {
			nodoRaiz.setNumero(numeroNodo);
		} else {
			insertarNodoArbol(numeroNodo, nodoRaiz);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.home.arbolbinario.service.NodoArbolBinarioService#insertarNodoArbol(java.
	 * lang.Long)
	 */
	@Override
	public void insertarNodoArbol(Long numeroNodo, Nodo nodoArbol) {
		if (nodoArbol.getNumero().equals(numeroNodo)) {
			throw new IllegalArgumentException(
					String.format("El número %s ya había sido ingresado en el árbol binario", numeroNodo));
		} else {
			if (nodoArbol.getNumero() < numeroNodo) {
				if (nodoArbol.getNodoIzquierdo() != null) {
					insertarNodoArbol(numeroNodo, nodoArbol.getNodoIzquierdo());
				} else {
					Nodo nuevoNodoArbol = new Nodo();
					nuevoNodoArbol.setNumero(numeroNodo);
					nodoArbol.setNodoIzquierdo(nuevoNodoArbol);
				}
			} else {
				if (nodoArbol.getNodoDerecho() != null) {
					insertarNodoArbol(numeroNodo, nodoArbol.getNodoDerecho());
				} else {
					Nodo nuevoNodoArbol = new Nodo();
					nuevoNodoArbol.setNumero(numeroNodo);
					nodoArbol.setNodoDerecho(nuevoNodoArbol);
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.home.arbolbinario.service.NodoArbolBinarioService#
	 * recorrerArbolNodoInorden(java.util.List)
	 */
	@Override
	public void recorrerArbolNodoInorden(List<Long> lstNodos) {
		Nodo nodoRaiz = null;
		nodoRaiz = proxyCache.getNodoArbolBinario();
		arbolInorden(lstNodos, nodoRaiz);
	}

	/**
	 * @param lstNodos
	 * @param nodo
	 */
	private void arbolInorden(List<Long> lstNodos, Nodo nodo) {
		if (nodo != null) {
			arbolInorden(lstNodos, nodo.getNodoIzquierdo());
			lstNodos.add(nodo.getNumero());
			arbolInorden(lstNodos, nodo.getNodoDerecho());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.home.arbolbinario.service.NodoArbolBinarioService#obtenerAncestroComun()
	 */
	@Override
	public Long obtenerAncestroComun(Long numNodo1, Long numNodo2) {
		Long nodoAncestroComun = null;
		Nodo nodoRaiz = null;
		List<Long> lstAncestrosNodo1 = null;
		List<Long> lstAncestrosNodo2 = null;

		nodoRaiz = proxyCache.getNodoArbolBinario();
		if (nodoRaiz == null) {
			throw new IllegalArgumentException("El árbol se encuentra vacío");
		} else {
			lstAncestrosNodo1 = new ArrayList<>();
			busquedaArbolBinario(lstAncestrosNodo1, nodoRaiz, numNodo1);
			lstAncestrosNodo2 = new ArrayList<>();
			busquedaArbolBinario(lstAncestrosNodo2, nodoRaiz, numNodo2);
		}
		for (Long p : lstAncestrosNodo1) {
			nodoAncestroComun = lstAncestrosNodo2.stream().filter(q -> p.equals(q)).findFirst().orElse(null);
			if (nodoAncestroComun != null) {
				break;
			}
		}
		return nodoAncestroComun;
	}

	/**
	 * @param lstNodos
	 * @param nodo
	 */
	private void busquedaArbolBinario(List<Long> lstNodos, Nodo nodo, Long numeroNodo) {
		if (nodo != null) {
			lstNodos.add(0, nodo.getNumero());
			if (nodo.getNumero() > numeroNodo) {
				if (nodo.getNodoDerecho() != null) {
					busquedaArbolBinario(lstNodos, nodo.getNodoDerecho(), numeroNodo);
				} else {
					throw new IllegalArgumentException(
							String.format("El número %s NO existe en el árbol binario", numeroNodo));
				}
			} else if (nodo.getNumero() < numeroNodo) {
				if (nodo.getNodoIzquierdo() != null) {
					busquedaArbolBinario(lstNodos, nodo.getNodoIzquierdo(), numeroNodo);
				} else {
					throw new IllegalArgumentException(
							String.format("El número %s NO existe en el árbol binario", numeroNodo));
				}
			}
		}
	}

}
