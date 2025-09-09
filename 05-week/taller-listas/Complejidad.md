#  Análisis de Complejidad de Operaciones en Listas


## Lista Simple
| Operación              | Complejidad | Explicación |
|-------------------------|-------------|-------------|
| Insertar al inicio      | **O(1)**    | Solo se crea un nodo y se apunta la cabeza al nuevo nodo. |
| Insertar al final       | **O(n)**    | Se debe recorrer la lista completa hasta el último nodo. |
| Insertar en posición    | **O(n)**    | En el peor caso, hay que recorrer hasta la posición indicada. |
| Eliminar al inicio      | **O(1)**    | Solo se mueve la cabeza al siguiente nodo. |
| Eliminar al final       | **O(n)**    | Es necesario recorrer la lista para llegar al penúltimo nodo. |
| Eliminar en posición    | **O(n)**    | Hay que recorrer hasta la posición anterior a la que se quiere eliminar. |

---

## Lista Doblemente Enlazada
| Operación              | Complejidad | Explicación |
|-------------------------|-------------|-------------|
| Insertar al inicio      | **O(1)**    | Se enlaza el nuevo nodo al inicio y se actualiza la cabeza. |
| Insertar al final       | **O(1)**    | Se usa un puntero a la cola, evitando recorrer la lista. |
| Insertar en posición    | **O(n)**    | Puede requerir recorrer hasta la posición deseada. |
| Eliminar al inicio      | **O(1)**    | Solo se actualiza la cabeza al siguiente nodo. |
| Eliminar al final       | **O(1)**    | Se actualiza el puntero de la cola directamente. |
| Eliminar en posición    | **O(n)**    | Requiere recorrer la lista hasta la posición indicada. |

---

## Lista Circular
| Operación              | Complejidad | Explicación |
|-------------------------|-------------|-------------|
| Insertar al inicio      | **O(1)**    | Se enlaza el nuevo nodo antes de la cabeza y se ajusta el puntero de la cola. |
| Insertar al final       | **O(1)**    | Si se mantiene un puntero a la cola, se enlaza en constante tiempo. |
| Insertar en posición    | **O(n)**    | Puede requerir recorrer varios nodos hasta llegar a la posición. |
| Eliminar al inicio      | **O(1)**    | Se mueve la cabeza al siguiente y se actualiza la cola. |
| Eliminar al final       | **O(n)**    | Se debe recorrer hasta el penúltimo nodo. |
| Eliminar en posición    | **O(n)**    | Es necesario recorrer hasta la posición deseada. |

---

## Caso Práctico: Cola de Pacientes (Ejercicio 6)
El sistema se implementa como una **cola con lista simple**.  

| Operación              | Complejidad | Explicación |
|-------------------------|-------------|-------------|
| Ingresar paciente       | **O(1)**    | Se agrega al final usando puntero `fin`. |
| Atender paciente        | **O(1)**    | Se elimina al inicio moviendo `frente`. |
| Mostrar cola            | **O(n)**    | Se recorre toda la lista de espera. |
