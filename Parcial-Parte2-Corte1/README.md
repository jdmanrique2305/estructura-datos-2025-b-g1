# Sistema de Biblioteca – Unidad 1 (Estructuras de Datos en Java)

## Descripción corta
Este sistema de gestión de biblioteca en Java permite:
- Registrar un catálogo de libros (altas y bajas).
- Administrar préstamos y devoluciones.
- Mantener un historial de operaciones (altas, bajas, préstamos y devoluciones).
- Consultar libros y listar préstamos activos.

El programa se ejecuta en consola, con un menú interactivo y métodos organizados.

## 🔹 Razones de elección de estructuras y complejidad

### Catálogo de libros → **Array 1D + Matriz 2D**
- **Por qué:** 
- tamaño limitado, acceso rápido por índice.
- **Complejidad:**
  - Inserción (alta)
  - Búsqueda por título 
  - Búsqueda por código  

### Préstamos activos → **Lista enlazada simple**
- **Por qué:**
- inserciones y eliminaciones frecuentes, sin necesidad de mover elementos.
- **Complejidad:**
  - Insertar préstamo
  - Eliminar préstamo 
  - Recorrer lista 

### Historial de operaciones → **Lista doblemente enlazada**
- **Por qué:** 
- permite recorrer hacia adelante y atrás fácilmente.
- **Complejidad:**
  - Insertar operación 
  - Recorrer historial 

### Programación estructurada
- Métodos separados cargarLibro, prestarLibro, devolverLibro,
- Menú principal con while y switch.
