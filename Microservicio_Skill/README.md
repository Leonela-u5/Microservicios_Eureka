Archivo: skill.md
# Skill: Arquitectura de Microservicios con Eureka y Spring Boot

## Objetivo del Skill

Generar automáticamente una arquitectura completa de microservicios utilizando Spring Boot 3, Java 21, Gradle y Spring Cloud Netflix Eureka siguiendo buenas prácticas de desarrollo backend, arquitectura por capas y desacoplamiento entre componentes.

La solución debe generar automáticamente 3 proyectos independientes:

1. eureka-server
2. producto-service
3. cliente-service

Todos los servicios deben ser funcionales, ejecutables y registrados automáticamente en Eureka Server.

==================================================
TECNOLOGÍAS OBLIGATORIAS
========================

* Java 21
* Spring Boot 3.x
* Gradle
* Spring Cloud Netflix Eureka
* Spring Web
* Validation API
* Visual Studio Code compatible
* application.properties

==================================================
PROYECTO 1 — EUREKA SERVER
==========================

Nombre del proyecto:
eureka-server

Paquete base:
com.leonela.eureka_server

OBJETIVO:
Crear un servidor de descubrimiento Eureka para registrar microservicios.

DEPENDENCIAS:

* Spring Web
* Eureka Server

CONFIGURACIÓN:

Puerto:
8761

application.properties:

spring.application.name=eureka-server
server.port=8761
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false

CLASE PRINCIPAL:

* EurekaServerApplication
* @EnableEurekaServer
* @SpringBootApplication

El servidor debe iniciar correctamente y visualizarse en:
http://localhost:8761

==================================================
PROYECTO 2 — PRODUCTO-SERVICE
=============================

Nombre del proyecto:
producto-service

Paquete base:
com.leonela.producto_service

OBJETIVO:
Generar un microservicio REST para gestión de productos.

DEPENDENCIAS:

* Spring Web
* Eureka Discovery Client
* Validation

CONFIGURACIÓN:

Puerto:
8081

application.properties:

spring.application.name=producto-service
server.port=8081
eureka.client.service-url.defaultZone=http://localhost:8761/eureka

==================================================
ARQUITECTURA OBLIGATORIA
========================

com.leonela.producto_service
│
├── controller
├── service
├── repository
├── dto
├── model
├── exception

==================================================
MODELO
======

Entidad:
Producto

Campos:

* Long id
* String nombre
* Double precio
* Integer stock

==================================================
DTO
===

Crear:
ProductoDTO

==================================================
ENDPOINTS OBLIGATORIOS
======================

1. GET
   /productos

2. GET BY ID
   /productos/{id}

3. POST
   /productos

4. PUT
   /productos/{id}

5. PATCH
   /productos/{id}

6. DELETE
   /productos/{id}

==================================================
PAGINACIÓN
==========

Implementar paginación manual:

?page=0&size=5

==================================================
VALIDACIONES
============

Usar:
@Valid

Validar:

* nombre obligatorio
* precio positivo
* stock positivo

==================================================
RESPUESTAS HTTP
===============

Usar:
ResponseEntity

==================================================
EXCEPCIONES
===========

Implementar:

* ResourceNotFoundException
* GlobalExceptionHandler

==================================================
REPOSITORIO
===========

Usar únicamente:
ArrayList

NO usar:

* MySQL
* PostgreSQL
* JPA
* Hibernate

==================================================
PROYECTO 3 — CLIENTE-SERVICE
============================

Nombre del proyecto:
cliente-service

Paquete base:
com.leonela.cliente_service

OBJETIVO:
Generar un microservicio REST profesional para gestión de clientes.

DEPENDENCIAS:

* Spring Web
* Eureka Discovery Client
* Validation

CONFIGURACIÓN:

Puerto:
8082

application.properties:

spring.application.name=cliente-service
server.port=8082
eureka.client.service-url.defaultZone=http://localhost:8761/eureka

==================================================
ARQUITECTURA OBLIGATORIA
========================

com.leonela.cliente_service
│
├── controller
├── service
├── repository
├── dto
├── model
├── exception

==================================================
MODELO
======

Entidad:
Cliente

Campos:

* Long id
* String nombre
* String correo
* String telefono

==================================================
DTO
===

Crear:
ClienteDTO

==================================================
ENDPOINTS OBLIGATORIOS
======================

1. GET
   /clientes

2. GET BY ID
   /clientes/{id}

3. POST
   /clientes

4. PUT
   /clientes/{id}

5. PATCH
   /clientes/{id}

6. DELETE
   /clientes/{id}

==================================================
PAGINACIÓN
==========

Implementar paginación manual:

?page=0&size=5

==================================================
VALIDACIONES
============

Usar:
@Valid

Validar:

* nombre obligatorio
* correo válido
* teléfono obligatorio

==================================================
RESPUESTAS HTTP
===============

Usar:
ResponseEntity

==================================================
EXCEPCIONES
===========

Implementar:

* ResourceNotFoundException
* GlobalExceptionHandler

==================================================
REPOSITORIO
===========

Usar únicamente:
ArrayList

NO usar:

* MySQL
* PostgreSQL
* JPA
* Hibernate

==================================================
REGLAS GENERALES DE DESARROLLO
==============================

1. Utilizar arquitectura desacoplada
2. Los controladores NO deben retornar entidades directamente
3. Utilizar DTOs
4. Usar inyección de dependencias por constructor
5. Implementar ControllerAdvice global
6. Código limpio y organizado
7. Todos los imports incluidos
8. Código listo para ejecutar
9. Compatible con Visual Studio Code

==================================================
REGISTRO EN EUREKA
==================

Ambos microservicios deben registrarse automáticamente en Eureka Server.

Resultado esperado en:
http://localhost:8761

Servicios registrados:

* PRODUCTO-SERVICE
* CLIENTE-SERVICE

==================================================
ANÁLISIS AUTOMÁTICO
===================

Además del código generado, explicar:

1. Funcionamiento del Skill utilizado
2. Arquitectura generada automáticamente
3. Función de cada capa:

   * controller
   * service
   * repository
   * dto
   * exception
4. Ventajas de usar Skills para generar microservicios
5. Diferencias frente a una implementación manual
6. Flujo de comunicación dentro del ecosistema Eureka

==================================================
RESULTADO FINAL ESPERADO
========================

El Skill debe generar:

* Estructura completa de carpetas
* build.gradle de cada proyecto
* application.properties
* Eureka Server funcional
* CRUD completo
* Paginación
* DTOs
* Validaciones
* Manejo de excepciones
* Código ejecutable
* Integración completa con Eureka

