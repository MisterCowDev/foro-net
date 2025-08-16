ForoNet

ForoNet es un proyecto de demostración que simula el funcionamiento interno de un foro de posteos. Permite registrar, listar y gestionar tópicos creados por usuarios, mostrando cómo se interactúa con la base de datos y cómo se asegura la persistencia de datos usando Spring Boot, JPA y Flyway.

Tecnologías y dependencias utilizadas

Java 17 en adelante

Spring Boot 3

Maven

Lombok: para reducir boilerplate de getters, setters y constructores.

Spring Web: para crear endpoints REST.

Spring Boot DevTools: para recarga automática durante el desarrollo.

Spring Data JPA: para persistencia de datos con Hibernate.

Flyway Migration: para versionar y migrar la base de datos.

MySQL Driver: conexión con base de datos MySQL.

Validation: validaciones de campos en DTOs usando @Valid y anotaciones como @NotBlank.

Spring Security: para seguridad básica y control de acceso.

1) Configuración de la base de datos

CREATE DATABASE foro_net;

2) Configurar conexión en application.properties

   spring.application.name=foro-net

spring.datasource.url=jdbc:mysql://localhost:3306/foro_net
spring.datasource.username=root
spring.datasource.password=${DB_PASSWORD} # Reemplaza ${DB_PASSWORD} por tu contraseña

spring.jpa.show-sql=true

# Token secreto para la seguridad (JWT)
api.security.token.secret=${JWT_SECRET:123456}

Migraciones con Flyway

Todas las tablas se crean mediante migraciones SQL versionadas.

Carpeta de migraciones: src/main/resources/db/migration.

Ejemplo de migración inicial para topicos:
