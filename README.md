# Academic Management API

REST API desarrollada con **Spring Boot** para gestionar información académica como alumnos, docentes, materias, grupos e inscripciones.

El proyecto está diseñado para demostrar buenas prácticas de desarrollo backend, incluyendo arquitectura por capas, principios SOLID, manejo centralizado de excepciones, validación de datos y documentación automática de la API con Swagger/OpenAPI.

---

# Objetivo del proyecto

Este proyecto tiene como objetivo simular el backend de un sistema académico permitiendo:

- Gestión de alumnos
- Gestión de docentes
- Gestión de materias
- Gestión de grupos
- Gestión de inscripciones
- Validación de datos en las solicitudes
- Manejo global de excepciones
- Documentación automática de la API

---

# Tecnologías utilizadas

- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- Hibernate
- Spring Validation
- H2 Database
- Swagger / OpenAPI
- Maven

---

# Arquitectura del proyecto

El proyecto sigue una arquitectura organizada en capas para mantener una clara separación de responsabilidades.

Controller → Maneja las peticiones HTTP y expone los endpoints REST.

Application → Contiene los servicios y la lógica de negocio.

Domain → Define las entidades del dominio y enumeraciones.

Infrastructure → Maneja la persistencia de datos y configuración de la aplicación.

Shared → Contiene utilidades y clases compartidas entre capas.

---

## Estructura del proyecto

```text
src/main/java
├── application
│   ├── dto
│   │   ├── request
│   │   └── response
│   └── service
├── controller
├── domain
│   ├── model
│   └── enums
├── infrastructure
│   ├── config
│   └── repository
└── shared
```
# Requisitos

- Java 17
- Maven 3.8+

---

# Cómo ejecutar el proyecto

Clonar el repositorio:


git clone https://github.com/marcomanrique1405/academic-management-api.git


Entrar al proyecto:


cd academic-management-api


Ejecutar la aplicación:


mvn spring-boot:run


La API se ejecutará en:


http://localhost:8081


---

# Documentación de la API

Swagger UI disponible en:


http://localhost:8081/swagger-ui.html


OpenAPI JSON disponible en:


http://localhost:8081/v3/api-docs


---

# Autor

Marco Manrique

Java Backend Developer  
Spring Boot | REST APIs | PostgreSQL
