# Vector (arreglo dinámico)

**Qué es:** arreglo que crece solo. Cuando se llena, crea uno el doble de grande y copia los datos.

**Operaciones y costo:**

| Operación | Costo |
|---|---|
| `obtener, establecer, tamano` | O(1) |
| `agregar` | O(1) amortizado |
| `insertar, eliminar, indiceDe, invertir` | O(n) |

Insertar y eliminar en medio cuestan O(n) porque hay que correr elementos.

**Cuándo usarlo:** acceso rápido por posición cuando la cantidad de datos cambia. En Java equivale a `ArrayList`.

## Archivos
- `VectorDinamico.java`: implementación.
- `PruebaVector.java`: ejemplo con lista de tareas del hotel.
