# Conjunto (Set)

**Qué es:** colección que no permite elementos repetidos. Está construida sobre la tabla hash de `src/mapa`.

**Operaciones y costo:**

| Operación | Costo |
|---|---|
| `agregar, contiene, eliminar` | O(1) promedio |
| `union, interseccion, diferencia, diferenciaSimetrica, esSubconjunto` | O(n) |

Cada elemento es una clave de la tabla hash; el valor (`true`) no se usa.

**Cuándo usarlo:** quitar duplicados, comprobar pertenencia. En Java equivale a `HashSet`.

## Archivos
- `Conjunto.java`: implementación.
- `PruebaConjunto.java`: ejemplo con habitaciones ocupadas por día.
