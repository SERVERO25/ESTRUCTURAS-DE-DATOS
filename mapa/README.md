# Mapa (tabla hash)

**Qué es:** guarda pares clave -> valor. Una función hash convierte la clave en una posición del arreglo. Si dos claves caen en la misma posición, se encadenan en una lista.

**Operaciones y costo:**

| Operación | Costo |
|---|---|
| `poner, obtener, contieneClave, eliminar, obtenerOPorDefecto` | O(1) promedio |
| `claves, valores` | O(n) |

La tabla se agranda al doble cuando se llena al 75 %, así las cadenas se mantienen cortas.

**Cuándo usarlo:** buscar datos por clave, contar repeticiones, diccionarios. En Java equivale a `HashMap`.

## Archivos
- `TablaHash.java`: implementación.
- `PruebaMapa.java`: ejemplo con inventario del hotel y conteo de reservas por tipo de habitación.
