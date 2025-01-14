# API Biblioteca

## Descripción
Esta API proporciona una plataforma para gestionar la información relacionada con **autores**, **libros**, **usuarios** y **reservas** en una biblioteca. Utiliza **Java** y **Spring Boot** para implementar una arquitectura **RESTful**. La API permite realizar operaciones CRUD en estos recursos, con excepciones personalizadas y una estructura limpia y modular que favorece la escalabilidad.

## Características
- CRUD completo para **autores**, **libros**, **usuarios** y **reservas**.
- Gestión de excepciones personalizadas para recursos no encontrados y acceso no autorizado.
- Mapeo de entidades utilizando **Hibernate** y **JPA**.
- Conexión a base de datos **SQL Server** configurada en el archivo `application.properties`.
- Soporte para la documentación de la API con **Swagger**.
- Fácil de extender y personalizar según necesidades.

## Tecnologías
- **Java** 17+
- **Spring Boot** 3.x
- **Spring Data JPA** (para acceso a datos)
- **SQL Server** (base de datos)
- **Swagger** (para documentación de la API)
- **Maven** (gestor de dependencias)
- **JUnit** (para pruebas)

## Instalación

1. Clona este repositorio:
   ```bash
   git clone https://github.com/ArnieAF/ApiRest.git
   
2. Navega al directorio del proyecto
   ```bash
   cd ApiRest
   
3. Si usas Maven, ejecuta el siguiente comando para instalar las dependencias:
   ```bash
   mvn install
   
4. Configura tu base de datos en el archivo src/main/resources/application.properties. Asegúrate de que los valores de las propiedades como spring.datasource.url, spring.datasource.username, y spring.datasource.password estén correctamente configurados. Ejemplo:
   

5. Ejecuta las migraciones para crear las tablas necesarias en la base de datos (si usas Hibernate, se realiza automáticamente).


6. Lanza la aplicación con el siguiente comando:
   ```bash
   mvn spring-boot:run


## Uso de la API
Endpoints principales:
1. Autores

- GET /api/authors: Obtiene todos los autores.
- GET /api/authors/{id}: Obtiene un autor por su ID.
- POST /api/authors: Crea un nuevo autor.
- PUT /api/authors/{id}: Actualiza un autor existente.
- DELETE /api/authors/{id}: Elimina un autor.
2. Libros

- GET /api/books: Obtiene todos los libros.
- GET /api/books/{id}: Obtiene un libro por su ID.
- POST /api/books: Crea un nuevo libro.
- PUT /api/books/{id}: Actualiza un libro existente.
- DELETE /api/books/{id}: Elimina un libro.
3. Usuarios

- GET /api/users: Obtiene todos los usuarios.
- GET /api/users/{id}: Obtiene un usuario por su ID.
- POST /api/users: Crea un nuevo usuario.
- PUT /api/users/{id}: Actualiza un usuario existente.
- DELETE /api/users/{id}: Elimina un usuario.
4. Reservas

- GET /api/reservations: Obtiene todas las reservas.
- GET /api/reservations/{id}: Obtiene una reserva por su ID.
- POST /api/reservations: Crea una nueva reserva.
- PUT /api/reservations/{id}: Actualiza una reserva existente.
- DELETE /api/reservations/{id}: Elimina una reserva.
