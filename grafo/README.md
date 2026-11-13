# Grafo

**Qué es:** vértices conectados por aristas. Versión no dirigida con listas de adyacencia.

**Operaciones y costo:**

| Operación | Costo |
|---|---|
| `agregarVertice, agregarArista, grado` | O(1) promedio |
| `anchura, profundidad, hayCamino, caminoMasCorto` | O(V + A) |

`V` = vértices, `A` = aristas. `caminoMasCorto` usa BFS y guarda de qué vértice se llegó a cada uno.

**Cuándo usarlo:** mapas y rutas, redes, dependencias entre tareas.

## Archivos
- `Grafo.java`: implementación.
- `PruebaGrafo.java`: ejemplo con zonas de un hotel y ruta más corta entre ellas.
