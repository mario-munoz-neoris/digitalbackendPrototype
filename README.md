# tr-digitalbackend-utils

Digital@Femsa
- Digital Backend -
Libreria <digitalbackend-utils>

## Tabla de Contenidos
1. [Información General](#información-general)
2. [Tecnologias](#tecnologias)
3. [Instalación](#instalación)
4. [Dependencias](#dependencias)
### Información General
***
Libreria que contiene las utilerias comunes para el proyecto <DigitalBackend> como son: 
* Log - Utileria que concentra la logica del loggeo de transacciones y errores
* DateTime - Utileria para obtener el tiempo actual
* Cadenas - Utileria para gestion de cadenas de texto
* Mask - Utileria para enmascarar datos sensibles en los logs
* UUID - Libreria para generar el digital_id

### Tecnologias
***
A list of technologies used within the project:
* Java: Version 17 
* Spring-Boot: Version 2.7.6
* log4j: Version 2.17.0

### Instalación
***
* Agregar esto al pom.xml: 
```
<dependency>
  <groupId>com.femsa.digital.backend</groupId>
  <artifactId>digitalbackend-utils</artifactId>
  <version>1.0-SNAPSHOT</version>
</dependency>
```
* Correr en linea de comando: 
```
$ mvn install
```
## Dependencias
***
Esta libreria depende de :
* [digitalbackend-exceptions](https://github.com/digitaltitransversal/tr-digitalbackend-exceptions)
