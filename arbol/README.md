# Árbol binario de búsqueda (BST)

**Qué es:** estructura jerárquica de nodos. Cada nodo tiene máximo dos hijos: los menores van a la izquierda y los mayores a la derecha.

**Operaciones y costo:**

| Operación | Costo |
|---|---|
| `insertar, contiene, eliminar` | O(h) |
| `minimo, maximo` | O(h) |
| `altura, contarHojas, recorridos, porNiveles` | O(n) |

`h` es la altura: O(log n) si el árbol está equilibrado, O(n) en el peor caso (datos ya ordenados).

**Cuándo usarlo:** búsquedas rápidas en datos ordenados, jerarquías como carpetas o menús.

## Archivos
- `ArbolBusqueda.java`: implementación.
- `PruebaArbol.java`: ejemplo con nombres de huéspedes en orden alfabético.
