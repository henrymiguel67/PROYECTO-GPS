# GPSTracker Demo

Aplicación web desarrollada con Spring Boot y Java para gestionar usuarios, clientes, vehículos, puestos, visitantes, rondas y reportes en un entorno de demostración.

## Características

- Backend REST con Spring Boot
- Persistencia con Spring Data JPA y MySQL
- Frontend simple con HTML, CSS y JavaScript
- Gestión de módulos operativos para vigilancia y control
- Documentación API con Swagger/OpenAPI

## Requisitos

- Java 25
- Maven 3.9+
- MySQL Server

## Configuración

1. Crear una base de datos en MySQL llamada `gpstrack_demo`.
2. Ajustar las credenciales en [src/main/resources/application.properties](src/main/resources/application.properties).
3. Asegurarse de que el servidor MySQL esté disponible en `localhost:3306`.

## Ejecución

Desde la raíz del proyecto:

```bash
./mvnw spring-boot:run
```

O en Windows:

```bash
mvnw.cmd spring-boot:run
```

La aplicación quedará disponible en:

- http://localhost:8080

## Pruebas

```bash
./mvnw test
```

## Estructura del proyecto

- `src/main/java` - controladores, servicios, entidades y repositorios
- `src/main/resources` - configuración, scripts SQL y recursos estáticos
- `src/test/java` - pruebas del proyecto

## API

La documentación Swagger queda disponible en:

- http://localhost:8080/swagger-ui.html

## Notas

El proyecto usa `data.sql` y `spring.jpa.defer-datasource-initialization=true` para inicializar datos al arrancar, siempre que la configuración de MySQL esté lista.
