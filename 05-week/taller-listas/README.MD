# Taller de Listas Enlazadas

Este proyecto implementa diferentes estructuras de listas en Java (simple, doble, circular) con operaciones de **inserción y eliminación** en distintas posiciones.  

El objetivo es **comprender cómo funcionan las estructuras dinámicas**, analizar su **complejidad computacional** y aplicarlas en un caso práctico.  

## Ejercicios Implementados

## Ejercicio 1 — Lista Básica
- Implementación de una **lista simple** que permite:
  - Insertar elementos al final.
  - Mostrar todos los elementos.  
Sirve como introducción a la manipulación de nodos enlazados.

---

## Ejercicio 2 — Inserción Múltiple
- Se amplía la lista simple para insertar en **cualquier posición**.
- Incluye control de casos especiales:
  - Insertar al inicio.
  - Insertar al final.
  - Posiciones inválidas (se inserta al final).   
Refuerza el recorrido de listas y control de índices.

---

## Ejercicio 3 — Eliminación Controlada
- Se agrega la operación de **eliminar en una posición específica**.
- Control de errores:
  - Lista vacía.
  - Posiciones fuera de rango.  
Permite afianzar el manejo de memoria y validaciones.

---

## Ejercicio 4 — Lista Doblemente Enlazada
- Implementación de una lista con punteros **a anterior y siguiente**.
- Se prueba la eliminación en ambos extremos.  
Permite recorrer la lista en **dos direcciones** y optimizar inserciones/eliminaciones en los extremos.

---

## Ejercicio 5 — Lista Circular
- Conversión de la lista en **circular** (el último nodo apunta a la cabeza).
- Pruebas de inserción y eliminación en diferentes posiciones.  
Refuerza el concepto de estructuras que se autorreferencian.

---

## Ejercicio 6 — Caso Práctico (Consultorio Médico)
- Simulación de una **cola de pacientes** con operaciones en tiempo real:
  - Ingresar paciente (enqueue).
  - Atender paciente (dequeue).
  - Mostrar la lista de espera.
- Se utilizó una **lista simple con punteros a frente y fin** para implementar la cola.  
Ejemplo real de cómo aplicar listas en sistemas.

