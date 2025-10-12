# Análisis de Complejidad - Tabla Hash

## Complejidad Temporal

| Operación    | Caso Promedio | Peor Caso     | Explicación |
|--------------|---------------|---------------|-------------|
| **put**      | O(1)          | O(n)          | En promedio, inserción constante. En peor caso, todas las claves colisionan |
| **get**      | O(1)          | O(n)          | Búsqueda constante en promedio, lineal si hay muchas colisiones |
| **remove**   | O(1)          | O(n)          | Similar a get, depende de la distribución de claves |
| **containsKey** | O(1)       | O(n)          | Utiliza la misma lógica que get |
| **size**     | O(1)          | O(1)          | Solo retorna un contador |
| **isEmpty**  | O(1)          | O(1)          | Verificación simple |

## Complejidad Espacial

| Componente         | Complejidad | Explicación |
|--------------------|-------------|-------------|
| **Almacenamiento** | O(n + m)    | n elementos + m buckets |
| **Por elemento**   | O(1)        | Cada Entry ocupa espacio constante |

## Factores que Afectan el Rendimiento

### Caso Promedio O(1)
- Función hash que distribuye uniformemente
- Factor de carga mantenido bajo (< 0.75)
- Redimensionamiento automático

### Peor Caso O(n)
- Todas las claves generan el mismo hash
- La tabla se degenera en una lista enlazada
- Función hash de mala calidad

## Optimizaciones Implementadas

1. **Redimensionamiento Dinámico**: La tabla se redimensiona cuando el factor de carga supera 0.75
2. **Encadenamiento Separado**: Las colisiones se manejan con listas enlazadas
3. **Función Hash Simple**: Uso de hashCode() de Java con módulo para distribución

## Comparación con Otras Estructuras

| Estructura | Inserción | Búsqueda | Eliminación | Uso Recomendado |
|------------|-----------|----------|-------------|-----------------|
| **HashTable** | O(1)    | O(1)     | O(1)        | Búsquedas frecuentes |
| **ArrayList** | O(1)*   | O(n)     | O(n)        | Acceso por índice |
| **LinkedList**| O(1)    | O(n)     | O(n)        | Inserciones frecuentes |

*O(1) amortizado para inserción al final

## Evidencia Empírica
Los ejercicios prácticos demuestran que:
- Las operaciones mantienen tiempo constante para distribuciones normales
- El manejo de colisiones es eficiente incluso con hashes forzados
- El redimensionamiento preserva el rendimiento con crecimiento de datos