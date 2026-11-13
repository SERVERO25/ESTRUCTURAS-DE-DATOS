# Estructuras de datos en Java

Implementaciones propias de las estructuras vistas en clase, cada una con un programa de ejemplo,
su explicación (con costos O(·)) y pruebas automáticas.

| Estructura | Tipo | Carpeta |
|---|---|---|
| Árbol binario de búsqueda | no lineal | [src/arbol](src/arbol) |
| Mapa (tabla hash) | no lineal | [src/mapa](src/mapa) |
| Conjunto | no lineal | [src/conjunto](src/conjunto) |
| Grafo | no lineal | [src/grafo](src/grafo) |
| Vector | lineal | [src/vector](src/vector) |

Además: [GUIA_ESTUDIO.md](GUIA_ESTUDIO.md) y las pruebas en [src/pruebas](src/pruebas).

## Cómo ejecutar
Desde la raíz (requiere Java 17 o superior):

```bash
javac -encoding UTF-8 -d out src/*/*.java

java -cp out arbol.PruebaArbol
java -cp out mapa.PruebaMapa
java -cp out conjunto.PruebaConjunto
java -cp out grafo.PruebaGrafo
java -cp out vector.PruebaVector

java -cp out pruebas.PruebasAutomaticas
```

## Mejoras añadidas a cada estructura
| Estructura | Métodos nuevos |
|---|---|
| Árbol | `minimo`, `maximo`, `porNiveles`, `contarHojas` |
| Mapa | `valores`, `obtenerOPorDefecto` |
| Conjunto | `diferencia`, `diferenciaSimetrica`, `esSubconjunto` |
| Grafo | `hayCamino`, `caminoMasCorto`, `grado` |
| Vector | `indiceDe`, `insertar`, `invertir` |

## Autor
(Daniel Garcia)
