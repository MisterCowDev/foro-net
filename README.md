
# ForoNet

ForoNet es un proyecto de demostración que simula el funcionamiento interno de un foro de posteos. Permite registrar, listar y gestionar tópicos creados por usuarios, mostrando cómo se interactúa con la base de datos y cómo se asegura la persistencia de datos usando Spring Boot, JPA y Flyway.
#
Tecnologías y dependencias utilizadas

* Java 17 en adelante
* Spring Boot 3
* Maven
* Lombok: para reducir boilerplate de getters, setters y constructores.
* Spring Web: para crear endpoints REST.
* Spring Boot DevTools: para recarga automática durante el desarrollo.
* Spring Data JPA: para persistencia de datos con Hibernate.
* Flyway Migration: para versionar y migrar la base de datos.
* MySQL Driver: conexión con base de datos MySQL.
* Validation: validaciones de campos en DTOs usando @Valid y anotaciones como @NotBlank.
* Spring Security: para seguridad básica y control de acceso.
#
1) Configuración de la base de datos

CREATE DATABASE foro_net;

2) Configurar conexión en application.properties

spring.application.name=foro-net

spring.datasource.url=jdbc:mysql://localhost:3306/foro_net 

spring.datasource.username=root spring.datasource.password=${DB_PASSWORD} # Reemplaza ${DB_PASSWORD} por tu contraseña

spring.jpa.show-sql=true

#

# Migraciones con Flyway

* Todas las tablas se crean mediante migraciones SQL versionadas.
* Carpeta de migraciones: src/main/resources/db/migration.
* Ejemplo de migración inicial para topicos:

CREATE TABLE topicos (

    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    mensaje TEXT NOT NULL,
    fecha_creacion DATETIME NOT NULL,
    status VARCHAR(20) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    curso VARCHAR(100) NOT NULL
);

Endpoints de TopicoController

1) Registrar un tópico

POST /topicos

{

  "titulo": "Problema con Spring Boot",

  "mensaje": "No se conecta a MySQL",

  "autor": "Pocho",

  "curso": "Java Spring Boot"

}

2) Listar tópicos activos con paginación

GET /topicos

{
  "content": [
    {

      "id": 1,

      "titulo": "Problema con Spring Boot",

      "mensaje": "No se conecta a MySQL",

      "fechaCreacion": "2025-08-16T20:00:00",

      "autor": "Pocho",

      "curso": "Java Spring Boot"

    }
  ],
  "pageable": { ... },

  "totalElements": 5,

  "totalPages": 3,

  "last": false,
  ...
}

3) Obtener datos de un tópico por ID
GET /topicos/{id}

{
  "id": 1,

  "titulo": "Problema con Spring Boot",

  "mensaje": "No se conecta a MySQL",

  "fechaCreacion": "2025-08-16T20:00:00",

  "autor": "Pocho",

  "curso": "Java Spring Boot"
}

4) Actualizar un tópico
PUT /topicos

{
  "id": 1,

  "titulo": "Problema actualizado",

  "mensaje": "Se solucionó la conexión",

  "autor": "Pocho",

  "curso": "Java Spring Boot"
}

5) Eliminar (desactivar) un tópico
DELETE /topicos/{id}

Path Variable: id → ID del tópico.
