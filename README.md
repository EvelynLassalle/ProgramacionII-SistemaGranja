# ProgramacionII-SistemaGranja
## Organización del proyecto

El Sistema de Gestión de Granja y Huerta es un proyecto desarrollado en Java 17, utilizando Maven y MySQL, como trabajo colaborativo de Programación II.

### Arquitectura

El proyecto utiliza una arquitectura por capas:

- `modelo`: clases que representan los elementos del sistema.
- `dao`: operaciones de acceso a la base de datos.
- `servicio`: reglas de negocio y validaciones.
- `vista`: interacción con el usuario mediante consola.
- `conexion`: conexión con MySQL.

### Forma de trabajo

Cada integrante desarrollará funcionalidades asignadas mediante GitHub Issues.

1. Seleccionar el Issue asignado.
2. Crear una rama de trabajo a partir de `main`.
3. Desarrollar la funcionalidad correspondiente.
4. Verificar que el proyecto compile y probar los cambios.
5. Realizar un commit con una descripción clara.
6. Subir la rama a GitHub.
7. Crear un Pull Request para revisión.

No realizar modificaciones directamente sobre la rama principal (`main`).

### Módulos

- Gestión de animales
- Gestión de huerta
- Administración
- Insumos y ventas
- Usuarios y mantenimiento

### Estado del proyecto

Etapa inicial: definición de la estructura, construcción del modelo de clases UML e implementación progresiva de funcionalidades.