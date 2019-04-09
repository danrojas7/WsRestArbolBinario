# WsRestArbolBinario
Microservicio que realiza la inserción de un árbol binario, y también realiza la búsqueda entre dos nodos dados, un ancestro en común.

Mediante la URL
http://localhost:8080/swagger-ui.html#/arbol-binario-controller

Se puede acceder a los métodos de la API, en los que se pueden ejecutar los siguientes métodos:

Tipo Método:        GET
Nombre del método:  insertarNodoArbolBinario
Ruta del método:    /arbolbinario/insertarNodoArbol{numeroNodo}

Método que realiza la inserción del número ingresado como parámetro, dentro de un nodo determinado en el árbol binario, si la inserción es exitosa, mostrará mediante un estado y descripción, además de la lista de nodos del árbol binario en inorden.

Tipo Método:        GET
Nombre del método:  obtenerAncestroComun
Ruta del método:    /arbolbinario/obtenerAncestroComun/{numeroNodo1}/{numeroNodo2}

Método que obtiene el número del nodo que es ancestro en común entro los dos nodos ingresados como parámetros


Tipo Método:        GET
Nombre del método:  reiniciarArbolBinario
Ruta del método:    /arbolbinario/reiniciarArbolBinario

Método que borra el árbol binario ya ingresado de la caché de SpringBoot, para que se pueda ingresar un nuevo árbol binario