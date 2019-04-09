package com.home.arbolbinario.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.arbolbinario.model.RespuestaServicio;
import com.home.arbolbinario.service.impl.NodoArbolBinarioServiceImpl;

/**
 * Clase controller del microservicio, en la que se definen los métodos del Api
 * Rest que se van a consumir
 * 
 * @author Daniel Alejandro Rojas
 *
 */
@RestController
@RequestMapping("/arbolbinario")
public class ArbolBinarioController {

	/**
	 * Clase service con la lógica de manipulación del árbol binario
	 */
	@Autowired
	private NodoArbolBinarioServiceImpl nodoArbolBinService;

	/**
	 * Método que realiza la inserción un número, en un nodo determinado dentro del
	 * árbol binario
	 * 
	 * @param numeroNodo Número del nodo a insertar dentro del nodo del árbol
	 *                   binario
	 * @return Mensaje de respuesta informando de la inserción correcta o no, junto
	 *         con el recorrido del árbol en inorden
	 */
	@GetMapping("/insertarNodoArbol{numeroNodo}")
	public ResponseEntity<RespuestaServicio> insertarNodoArbolBinario(@PathVariable("numeroNodo") Long numeroNodo) {
		RespuestaServicio respuesta = null;

		respuesta = new RespuestaServicio();
		try {
			if (numeroNodo == null) {
				throw new IllegalArgumentException("Debe ingresar un número válido");
			} else {
				nodoArbolBinService.insertarArbolBinario(numeroNodo);
				List<Long> lstNodoInorden = new ArrayList<>();
				nodoArbolBinService.recorrerArbolNodoInorden(lstNodoInorden);
				respuesta.setEstado(0);
				respuesta.setDescripcion("Inserción exitosa");
				respuesta.setInformacion(lstNodoInorden);
				return new ResponseEntity<>(respuesta, HttpStatus.OK);
			}
		} catch (Exception e) {
			respuesta.setEstado(0);
			respuesta.setDescripcion(String.format("Inserción NO exitosa, detalle del error: %s", e.getMessage()));
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Método que retorna el nodo ancestro en común entre dos nodos, los números
	 * proporcionados deben de haberse insertado anteriormente dentro del árbol
	 * binario
	 * 
	 * @param numNodo1 Número de nodo 1 al cual se va a hallar el ancestro en común
	 * @param numNodo2 Número de nodo 2 al cual se va a hallar el ancestro en común
	 * @return Número del nodo que corresponde al ancestro en común
	 */
	@GetMapping("/obtenerAncestroComun/{numeroNodo1}/{numeroNodo2}")
	public ResponseEntity<RespuestaServicio> obtenerAncestroComun(@PathVariable("numeroNodo1") Long numeroNodo1,
			@PathVariable("numeroNodo2") Long numeroNodo2) {
		RespuestaServicio respuesta = null;

		respuesta = new RespuestaServicio();
		try {
			if (numeroNodo1 == null || numeroNodo2 == null) {
				throw new IllegalArgumentException("Debe ingresar un número válido");
			} else {
				respuesta.setEstado(0);
				respuesta.setDescripcion("Transacción exitosa");
				respuesta.setInformacion(nodoArbolBinService.obtenerAncestroComun(numeroNodo1, numeroNodo2));
				return new ResponseEntity<>(respuesta, HttpStatus.OK);
			}
		} catch (Exception e) {
			respuesta.setEstado(0);
			respuesta.setDescripcion(String.format("Búsqueda NO exitosa, detalle del error: %s", e.getMessage()));
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Método que realiza el reinicio de la caché de SpringBoot, en la cual se
	 * encuentra almacenada la estructura del árbol binario (se almacena el nodo
	 * raíz)
	 * 
	 * @return Objeto instancia de la clase de respuesta predefinida del servicio,
	 *         en la que se informa si se borró el árbol binario almacenado en la
	 *         caché
	 */
	@GetMapping("/reiniciarArbolBinario")
	public ResponseEntity<RespuestaServicio> reiniciarArbolBinario() {
		RespuestaServicio respuesta = null;

		respuesta = new RespuestaServicio();
		try {
			nodoArbolBinService.reiniciarArbol();
			respuesta.setEstado(0);
			respuesta.setDescripcion("Transacción exitosa");
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta.setEstado(0);
			respuesta.setDescripcion(
					String.format("Reinicio de árbol NO exitoso, detalle del error: %s", e.getMessage()));
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
