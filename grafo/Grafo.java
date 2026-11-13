package grafo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/** Grafo no dirigido representado con listas de adyacencia. */
public class Grafo {
    private final Map<String, List<String>> adyacentes = new LinkedHashMap<>();

    public void agregarVertice(String vertice) {
        adyacentes.putIfAbsent(vertice, new ArrayList<>());
    }

    public void agregarArista(String a, String b) {
        agregarVertice(a);
        agregarVertice(b);
        adyacentes.get(a).add(b);
        adyacentes.get(b).add(a);
    }

    /** Recorrido en anchura: visita primero los vecinos más cercanos (usa una cola). */
    public List<String> anchura(String inicio) {
        List<String> orden = new ArrayList<>();
        Set<String> visitados = new HashSet<>();
        Deque<String> cola = new ArrayDeque<>();
        cola.add(inicio);
        visitados.add(inicio);
        while (!cola.isEmpty()) {
            String actual = cola.poll();
            orden.add(actual);
            for (String vecino : adyacentes.get(actual)) {
                if (visitados.add(vecino)) cola.add(vecino);
            }
        }
        return orden;
    }

    /** Recorrido en profundidad: se interna lo más posible antes de retroceder (usa una pila). */
    public List<String> profundidad(String inicio) {
        List<String> orden = new ArrayList<>();
        Set<String> visitados = new HashSet<>();
        Deque<String> pila = new ArrayDeque<>();
        pila.push(inicio);
        while (!pila.isEmpty()) {
            String actual = pila.pop();
            if (!visitados.add(actual)) continue;
            orden.add(actual);
            List<String> vecinos = adyacentes.get(actual);
            for (int i = vecinos.size() - 1; i >= 0; i--) {
                if (!visitados.contains(vecinos.get(i))) pila.push(vecinos.get(i));
            }
        }
        return orden;
    }

    @Override
    public String toString() { return adyacentes.toString(); }

    /** Indica si existe un camino entre dos vértices. */
    public boolean hayCamino(String origen, String destino) {
        if (!adyacentes.containsKey(origen) || !adyacentes.containsKey(destino)) return false;
        return anchura(origen).contains(destino);
    }

    /** Cantidad de vecinos directos de un vértice (0 si no existe). */
    public int grado(String vertice) {
        List<String> vecinos = adyacentes.get(vertice);
        return vecinos == null ? 0 : vecinos.size();
    }

    /** Camino con menos aristas entre dos vértices (lista vacía si no hay camino). Usa BFS. */
    public List<String> caminoMasCorto(String origen, String destino) {
        List<String> camino = new ArrayList<>();
        if (!adyacentes.containsKey(origen) || !adyacentes.containsKey(destino)) return camino;
        Map<String, String> padre = new HashMap<>();
        Set<String> visitados = new HashSet<>();
        Deque<String> cola = new ArrayDeque<>();
        cola.add(origen);
        visitados.add(origen);
        while (!cola.isEmpty()) {
            String actual = cola.poll();
            if (actual.equals(destino)) break;
            for (String vecino : adyacentes.get(actual)) {
                if (visitados.add(vecino)) {
                    padre.put(vecino, actual);
                    cola.add(vecino);
                }
            }
        }
        if (!visitados.contains(destino)) return camino;
        for (String nodo = destino; nodo != null; nodo = padre.get(nodo)) {
            camino.add(0, nodo); // se reconstruye de atrás hacia adelante
        }
        return camino;
    }
}
