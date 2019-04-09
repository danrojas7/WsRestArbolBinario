# WsRestArbolBinario
Microservicio que realiza la inserción de un árbol binario, y también realiza la búsqueda entre dos nodos dados, un ancestro en común.

Una vez compilado e inicializado el proyecto Maven, eediante la siguiente URL:<br>
http://localhost:8080/swagger-ui.html#/arbol-binario-controller<br>
Se puede acceder a los métodos de la API, en los que se pueden ejecutar los siguientes métodos:

<b>Tipo Método:</b>        GET<br>
<b>Nombre del método:</b>  insertarNodoArbolBinario<br>
<b>Ruta del método:</b>    /arbolbinario/insertarNodoArbol{numeroNodo}<br>

Método que realiza la inserción del número ingresado como parámetro, dentro de un nodo determinado en el árbol binario, si la inserción es exitosa, mostrará mediante un estado y descripción, además de la lista de nodos del árbol binario en inorden.

<b>Tipo Método:</b>        GET<br>
<b>Nombre del método:</b>  obtenerAncestroComun<br>
<b>Ruta del método:</b>    /arbolbinario/obtenerAncestroComun/{numeroNodo1}/{numeroNodo2}<br>

Método que obtiene el número del nodo que es ancestro en común entro los dos nodos ingresados como parámetros.


<b>Tipo Método:</b>        GET<br>
<b>Nombre del método:</b>  reiniciarArbolBinario<br>
<b>Ruta del método:</b>    /arbolbinario/reiniciarArbolBinario<br>

Método que borra el árbol binario ya ingresado de la caché de SpringBoot, para que se pueda ingresar un nuevo árbol binario.