# Guía de estudio (para sustentar el trabajo)

## 1. Qué cambió respecto al código base
Cada estructura tiene métodos nuevos, un ejemplo distinto y pruebas automáticas.
Si el profesor pregunta "¿qué hiciste tú?", esta es la respuesta: ver la tabla del README principal.

## 2. Cómo funciona cada método nuevo
**Árbol**
- `minimo` / `maximo`: el menor está en el extremo izquierdo y el mayor en el derecho; solo se baja por un lado.
- `porNiveles`: usa una cola. Se saca un nodo, se guarda y se encolan sus hijos. Visita por niveles.
- `contarHojas`: recursivo. Si un nodo no tiene hijos vale 1; si no, suma las hojas de ambos lados.

**Mapa**
- `valores`: igual que `claves`, pero devuelve el valor de cada entrada.
- `obtenerOPorDefecto`: evita que `obtener` devuelva `null` cuando la clave no existe. Permite contar sin `if`.

**Conjunto**
- `diferencia(A, B)`: lo que está en A y no en B.
- `diferenciaSimetrica`: unión menos intersección (lo que está en uno solo de los dos).
- `esSubconjunto`: todos los elementos de A están en B.

**Grafo**
- `hayCamino`: hace un recorrido en anchura desde el origen y mira si el destino aparece.
- `caminoMasCorto`: BFS que guarda el "padre" de cada vértice; al llegar al destino se reconstruye la ruta hacia atrás.
  BFS garantiza menos aristas porque explora por capas.
- `grado`: cantidad de vecinos del vértice.

**Vector**
- `indiceDe`: búsqueda lineal; devuelve -1 si no está.
- `insertar`: si está lleno duplica la capacidad, corre los elementos a la derecha y coloca el nuevo.
- `invertir`: intercambia el primero con el último, el segundo con el penúltimo, etc.

## 3. Preguntas probables y respuestas cortas
1. **¿Por qué el árbol puede ser lento?** Si se insertan datos ya ordenados queda como una lista (altura n) y las operaciones pasan de O(log n) a O(n).
2. **¿Qué es una colisión en la tabla hash?** Dos claves distintas dan la misma posición. Aquí se resuelve con encadenamiento (lista en cada cubeta).
3. **¿Por qué la tabla se agranda al 75 %?** Para que las cadenas sigan cortas y buscar siga siendo casi O(1).
4. **¿Por qué el conjunto usa un mapa?** Las claves de un mapa ya son únicas; el conjunto solo usa las claves.
5. **BFS vs DFS:** BFS usa cola y encuentra el camino con menos aristas; DFS usa pila y se interna lo más posible.
6. **¿Por qué agregar al vector es O(1) amortizado?** Casi siempre es una asignación; copiar todo al duplicar ocurre pocas veces.
7. **Diferencia entre `ArrayList` y `Vector` de Java:** `Vector` es sincronizado (seguro entre hilos) y por eso más lento.
8. **¿Qué recorrido da los datos ordenados en un BST?** El inorden.

## 4. Cómo demostrar que funciona
```bash
javac -encoding UTF-8 -d out src/*/*.java
java -cp out pruebas.PruebasAutomaticas
```
Debe terminar con `0 fallidas`.

## 5. Para ir más allá
Cambia los ejemplos por tus propios datos (clases como `Huesped` o `Producto` que implementen `Comparable`)
y practica explicar el código sin leerlo. Es lo que más se valora al sustentar.
