# LiteraturaAPI 📚

Proyecto de consola en Java que funciona como un catálogo de libros interactivo, utilizando la API de [Gutendex](https://gutendex.com/) para obtener datos de libros y autores. La aplicación permite buscar libros, guardarlos en una base de datos PostgreSQL y realizar diversas consultas sobre la información almacenada.

Este proyecto fue desarrollado como parte del Challenge de Alura Latam para el programa ONE Education.

---

## ✨ Características Principales

* **Buscar libro por título:** Busca libros en la API de Gutendex y los guarda en la base de datos local si no existen.
* **Listar libros registrados:** Muestra todos los libros guardados en la base de datos.
* **Listar autores registrados:** Muestra todos los autores almacenados.
* **Listar autores vivos:** Filtra y muestra los autores que estaban vivos en un año determinado.
* **Listar libros por idioma:** Permite ver la cantidad de libros y cuáles están disponibles en un idioma específico (ej: "es" para español, "en" para inglés).

---

## 🛠️ Tecnologías Utilizadas

* **Java 17:** Lenguaje de programación principal.
* **Spring Boot:** Framework para crear aplicaciones autocontenidas.
* **Spring Data JPA:** Para la persistencia de datos y comunicación con la base de datos.
* **Maven:** Gestor de dependencias y construcción del proyecto.
* **PostgreSQL:** Sistema de gestión de bases de datos relacional.
* **API Gutendex:** Fuente de datos para los libros y autores.
* **Jackson:** Para la manipulación de datos en formato JSON.

---

## 🚀 Cómo Empezar

Sigue estos pasos para configurar y ejecutar el proyecto en tu entorno local.

### **Prerrequisitos**

* Tener instalado **Java Development Kit (JDK) 17** o superior.
* Tener instalado **Apache Maven**.
* Tener **PostgreSQL** instalado y en ejecución.

### **Instalación y Configuración**

1.  **Clona el repositorio:**
    ```bash
    git clone <URL_DEL_REPOSITORIO>
    cd literaturaApi
    ```

2.  **Configura la base de datos:**
    * Crea una nueva base de datos en PostgreSQL llamada `literaturaApi`.
    * Abre el archivo `src/main/resources/application.properties`.
    * Modifica las siguientes líneas con tus credenciales de PostgreSQL si son diferentes:
        ```properties
        spring.datasource.url=jdbc:postgresql://localhost/literaturaApi
        spring.datasource.username=postgres
        spring.datasource.password=0303456
        ```

3.  **Ejecuta la aplicación:**
    Puedes ejecutar el proyecto directamente desde tu IDE (como IntelliJ IDEA o Eclipse) o usando el Maven Wrapper incluido:
    ```bash
    ./mvnw spring-boot:run
    ```
    En Windows, usa `mvnw.cmd` en lugar de `./mvnw`.

---

## Uso

Una vez que la aplicación esté en funcionamiento, verás un menú interactivo en la consola. Simplemente ingresa el número de la opción que deseas ejecutar y sigue las instrucciones.