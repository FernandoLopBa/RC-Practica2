# Práctica 2 - mini wget

El objetivo de esta práctica es crear un mini cliente que permita descargar el contenido de una página web a partir de una dirección IP o un dominio, utilizando el verbo `GET` de HTTP.

## Herramientas:
- Clojure
- Sockets de java

## Tareas a realizar por los integrantes del equipo

En el siguiente listado entre corchetes se indicará cuál de los tres integrantes del equipo deberá realizar la tarea (identificados por las letras A, B y C, o "Todos" para indicar que los tres deberán realizar la tarea).

1. [Todos] Investigar el funcionamiento del protocolo HTTP.
2. [A] Crear una función que reciba una string que represente una dirección o dominio y devuelva una string que cumple con el protocolo HTTP para hacer la petición GET a ese dominio, debe incluir al menos cinco headers.
3. [B] Crear una función que recibe una string que representa una petición GET de HTTP válida y la realiza, debe considerar el manejo de excepciones para posibles problemas de red y debe devolver una string con la respuesta del servidor.
4. [C] Crear una función que reciba una string y un nombre de archivo y cree un nuevo archivo con el nombre dado y con el contenido de la string.
5. [C] Crear una función que se invocará desde la terminal (usando `clj -X`) pasándole una dirección o dominio y un nombre de archivo y utilice las funciones creadas por A y B para realizar la petición GET y escribir la respuesta en un archivo.

## Entregables

- Código fuente del programa
- Un documento (pdf, txt o md) con la respuesta a los siguientes incisos:
  1. ¿Qué es un UserAgent?
  2. Menciona 8 headers de HTTP y la utilidad que aportan
  3. ¿Qué es un web crawler y para qué lo usarías?

Extras:

  4. Investiga el uso de la herramienta hydra y menciona alguno de sus usos
  5. ¿Qué es el phishing? ¿cómo podrías evitarlo?
  6. Si algún atacante malicioso se apoderara de los datos de todas tus peticiones GET de HTTP, ¿qué información podría obtener e inferir de tí?

## Ayuda
### Interop con Clojure

Clojure soporta completamente cualquier biblioteca escrita en Java, se pueden crear clases, implementar interfaces y nuevos objetos desde Clojure, a esta capacidad de interactuar con su lenguaje host se le llama interoperabilidad o interop.

Algunas traducciones básicas de Java a Clojure son:

Crear un objeto:
```java
new Object(param1, param1);
```

```clojure
(Object. param1 param2)
```

Obtener un atributo de un objeto:
```java
miObjeto.param
```

```clojure
(.-param mi-objeto)
```

Ejecutar un método de un objeto:
```java
miObjeto.método(p1, p2, p3)
```

```clojure
(.método mi-objeto p1 p2 p3)
```

Para mayor rererencia consultar [Clojure Interop](https://clojure.org/reference/java_interop).

### Sockets

Hay un ejemplo funcional de sockets de java a través de Clojure en este proyecto donde se crea un cliente y un servidor que se comunican, se puede modificar para hacer pruebas.


### Ejemplo en Java
https://stackoverflow.com/questions/32086560/get-request-with-java-sockets
