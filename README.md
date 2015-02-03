# Ejemplo de cliente de carrito
## Objetivo
Este es un proyecto de ejemplo que puede usarse para probar los servicios REST desarrollados por los alumnos.
## Implementación
Esta aplicación contiene código en el lado del cliente para implementar un carrito simple. También incluye 2 servicios de ejemplo (login y consulta de productos). La idea es que el alumno implemente tanto la lógica de dichos servicios como los servicios restantes.

Más datos:
* La aplicación está escrita usando jQuery Mobile para el lado del cliente y Spring Boot + Spring Rest del lado del servidor.
* El formato usado para los mensajes es JSON.
* Se asume que la aplicación es stateful. Por ejemplo, una vez ejecutado el login, la aplicación debería almacenar el usuario en la sesión, del lado del servidor.
* El login es el único servicio que usa POST en lugar de GET, dado que no es recomendable mostrar información sensible como usuario o password en la URL.
* Este es el link a la demo: http://carrito-bootcamp.appspot.com.
* Se utiliza Maven para generar el proyecto. Para correrlo desde eclipse, debe crearse un proyecto ejecutando mvn eclipse:eclipse.
* Se puede probar localmente ejecutando la clase `com.globant.carrito.CarritoApplication` y accediendo a http://localhost:8080

## Servicios

### Login
**URL:** `POST services/login`

**Requerimiento:**

    {
      "username": "bart",
      "password": "simpson"
    }

**Respuesta:**

    {
      "ok": true
    }

### Logout
**URL:** `GET services/logout`

**Requerimiento:**
Nada, no va ningún mensaje.

**Respuesta:**

    {
      "ok": true
    }

### Refrescar carrito

**URL:** `GET services/cart`

**Respuesta:**

    { "results" : [
    	{
    		"productId": 123,
    		"productName": "Coca Cola",
    		"quantity": 2,
    		"amount": 31.00
    	},
    	{
    		"productId": 456,
    		"productName": "Fernet 750cc",
    		"quantity": 1,
    		"amount": 75.83
    	}
    ]}

### Refrescar productos

**URL:** `GET services/products`

**Respuesta:**

    { "results" : [
    	{
    		"id": 123,
    		"name": "Coca Cola",
       		"price": 15.50
    	},
    	{
    		"id": 456,
    		"name": "Fernet 750cc",
    		"price": 75.83
    	},
    	{
    		"id": 789,
    		"name": "Quilmes 1l",
    		"price": 13.26
    	}
    ]}

### Agregar producto al carrito

**URL:** `GET services/add/{product id}`

**Respuesta:**

    {
      "ok": true
    }
### Remover producto del carrito

**URL:** `GET services/remove/{product id}`

**Respuesta:**

    {
      "ok": true
    }

### Checkout

**URL:** `GET services/checkout`

**Respuesta:**

    {
      "ok": true
    }

