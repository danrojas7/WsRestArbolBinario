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
 * @author Daniel Alejandro Rojas
 *
 */
@RestController
@RequestMapping("/arbolbinario")
public class ArbolBinarioController {

	/**
	 * 
	 */
	@Autowired
	private NodoArbolBinarioServiceImpl nodoArbolBinService;

	/**
	 * @param numeroNodo
	 * @return
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
	 * @param numeroNodo1
	 * @param numeroNodo2
	 * @return
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
	 * @return
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
