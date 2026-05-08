# Microservicio 2 — Desarrollo Manual

Este microservicio fue desarrollado completamente de forma manual, sin utilizar generadores automáticos ni herramientas basadas en inteligencia artificial.

El objetivo es demostrar la comprensión de la arquitectura de microservicios, la creación de APIs REST y la integración dentro de un ecosistema distribuido utilizando Spring Boot y Eureka Server.

## Funcionalidades Implementadas

El microservicio incluye como mínimo los siguientes endpoints:

* GET → Listar todos los registros
* GET BY ID → Obtener un registro por identificador
* POST → Crear nuevos registros

El dominio implementado corresponde a la gestión de productos y clientes mediante servicios REST independientes.

---

# Integración con Eureka Server

Los microservicios fueron integrados correctamente con Eureka Server para permitir el registro y descubrimiento automático de servicios dentro del ecosistema.

Cada servicio se registra automáticamente al iniciar la aplicación y puede visualizarse desde:

```text id="eureka-link"
http://localhost:8761/
```

---

# Validaciones Realizadas

Se verificó que:

* Los microservicios se encuentran activos
* Los servicios aparecen registrados en Eureka
* Cada endpoint responde correctamente
* La arquitectura desacoplada funciona adecuadamente
* Existe comunicación básica dentro del ecosistema distribuido

---

# Tecnologías Utilizadas

* Java 21
* Spring Boot 3
* Spring Cloud Netflix Eureka
* Gradle
* REST API
* Visual Studio Code

---

# Objetivo Académico

Este proyecto fue desarrollado con fines académicos para reforzar conocimientos sobre:

* Arquitectura de microservicios
* Descubrimiento de servicios con Eureka
* Desarrollo manual de APIs REST
* Arquitectura por capas
* Integración de servicios distribuidos

