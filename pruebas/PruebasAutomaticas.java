package pruebas;

import arbol.ArbolBusqueda;
import conjunto.Conjunto;
import grafo.Grafo;
import java.util.Arrays;
import mapa.TablaHash;
import vector.VectorDinamico;

/** Pruebas automáticas: cada verificación imprime OK o FALLO. */
public class PruebasAutomaticas {
    private static int ok = 0, fallos = 0;

    private static void verificar(String nombre, boolean condicion) {
        if (condicion) { ok++; System.out.println("OK     " + nombre); }
        else { fallos++; System.out.println("FALLO  " + nombre); }
    }

    public static void main(String[] args) {
        probarArbol();
        probarMapa();
        probarConjunto();
        probarGrafo();
        probarVector();
        System.out.println("\nResultado: " + ok + " correctas, " + fallos + " fallidas");
        if (fallos > 0) System.exit(1);
    }

    private static void probarArbol() {
        ArbolBusqueda<Integer> a = new ArbolBusqueda<>();
        for (int n : new int[]{5, 3, 8, 1, 4, 9, 5}) a.insertar(n); // el 5 repetido no cuenta
        verificar("Árbol: no admite repetidos", a.tamano() == 6);
        verificar("Árbol: inorden ordenado", a.inorden().equals(Arrays.asList(1, 3, 4, 5, 8, 9)));
        verificar("Árbol: por niveles", a.porNiveles().equals(Arrays.asList(5, 3, 8, 1, 4, 9)));
        verificar("Árbol: altura 3", a.altura() == 3);
        verificar("Árbol: 3 hojas", a.contarHojas() == 3);
        verificar("Árbol: mínimo y máximo", a.minimo() == 1 && a.maximo() == 9);
        a.eliminar(5); // raíz con dos hijos
        verificar("Árbol: eliminar raíz", a.inorden().equals(Arrays.asList(1, 3, 4, 8, 9)) && a.tamano() == 5);
        verificar("Árbol vacío: mínimo null", new ArbolBusqueda<Integer>().minimo() == null);
    }

    private static void probarMapa() {
        TablaHash<String, Integer> m = new TablaHash<>();
        for (int i = 0; i < 50; i++) m.poner("k" + i, i); // fuerza varios agrandamientos
        boolean todas = true;
        for (int i = 0; i < 50; i++) if (m.obtener("k" + i) != i) todas = false;
        verificar("Mapa: 50 claves tras agrandar", todas && m.tamano() == 50);
        m.poner("k1", 100);
        verificar("Mapa: actualizar no duplica", m.obtener("k1") == 100 && m.tamano() == 50);
        verificar("Mapa: eliminar", m.eliminar("k2") && !m.contieneClave("k2") && !m.eliminar("k2"));
        verificar("Mapa: valores y claves del mismo tamaño", m.valores().size() == m.claves().size());
        verificar("Mapa: valor por defecto", m.obtenerOPorDefecto("no existe", -1) == -1);
    }

    private static void probarConjunto() {
        Conjunto<Integer> a = new Conjunto<>(), b = new Conjunto<>();
        for (int n : new int[]{1, 2, 3}) a.agregar(n);
        for (int n : new int[]{2, 3, 4}) b.agregar(n);
        verificar("Conjunto: repetido devuelve false", !a.agregar(1));
        verificar("Conjunto: unión", a.union(b).tamano() == 4);
        verificar("Conjunto: intersección", a.interseccion(b).tamano() == 2);
        verificar("Conjunto: diferencia", a.diferencia(b).tamano() == 1 && a.diferencia(b).contiene(1));
        Conjunto<Integer> sim = a.diferenciaSimetrica(b);
        verificar("Conjunto: diferencia simétrica", sim.tamano() == 2 && sim.contiene(1) && sim.contiene(4));
        Conjunto<Integer> pequeno = new Conjunto<>();
        pequeno.agregar(2);
        verificar("Conjunto: subconjunto", pequeno.esSubconjunto(a) && !a.esSubconjunto(pequeno));
    }

    private static void probarGrafo() {
        Grafo g = new Grafo();
        g.agregarArista("A", "B");
        g.agregarArista("B", "C");
        g.agregarArista("A", "D");
        g.agregarVertice("Z");
        verificar("Grafo: anchura", g.anchura("A").equals(Arrays.asList("A", "B", "D", "C")));
        verificar("Grafo: profundidad", g.profundidad("A").equals(Arrays.asList("A", "B", "C", "D")));
        verificar("Grafo: hay camino", g.hayCamino("D", "C") && !g.hayCamino("A", "Z"));
        verificar("Grafo: camino más corto", g.caminoMasCorto("D", "C").equals(Arrays.asList("D", "A", "B", "C")));
        verificar("Grafo: sin camino -> vacío", g.caminoMasCorto("A", "Z").isEmpty());
        verificar("Grafo: grado", g.grado("A") == 2 && g.grado("Z") == 0);
    }

    private static void probarVector() {
        VectorDinamico<Integer> v = new VectorDinamico<>();
        for (int i = 1; i <= 5; i++) v.agregar(i);
        verificar("Vector: crece al doble (4 -> 8)", v.capacidad() == 8 && v.tamano() == 5);
        v.insertar(0, 0);
        verificar("Vector: insertar al inicio", v.toString().equals("[0, 1, 2, 3, 4, 5]"));
        v.invertir();
        verificar("Vector: invertir", v.toString().equals("[5, 4, 3, 2, 1, 0]"));
        verificar("Vector: indiceDe", v.indiceDe(3) == 2 && v.indiceDe(99) == -1);
        verificar("Vector: eliminar", v.eliminar(0) == 5 && v.tamano() == 5);
        boolean lanzo = false;
        try { v.obtener(10); } catch (IndexOutOfBoundsException e) { lanzo = true; }
        verificar("Vector: índice inválido lanza excepción", lanzo);
    }
}
