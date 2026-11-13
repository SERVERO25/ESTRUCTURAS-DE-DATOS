package arbol;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** Árbol binario de búsqueda: menores a la izquierda, mayores a la derecha. */
public class ArbolBusqueda<T extends Comparable<T>> {

    private static class Nodo<T> {
        T dato;
        Nodo<T> izquierdo, derecho;
        Nodo(T dato) { this.dato = dato; }
    }

    private Nodo<T> raiz;
    private int tamano = 0;

    public void insertar(T dato) {
        raiz = insertar(raiz, dato);
    }

    private Nodo<T> insertar(Nodo<T> nodo, T dato) {
        if (nodo == null) {
            tamano++;
            return new Nodo<>(dato);
        }
        int cmp = dato.compareTo(nodo.dato);
        if (cmp < 0) nodo.izquierdo = insertar(nodo.izquierdo, dato);
        else if (cmp > 0) nodo.derecho = insertar(nodo.derecho, dato);
        // si es igual no se inserta (sin repetidos)
        return nodo;
    }

    public boolean contiene(T dato) {
        Nodo<T> actual = raiz;
        while (actual != null) {
            int cmp = dato.compareTo(actual.dato);
            if (cmp == 0) return true;
            actual = (cmp < 0) ? actual.izquierdo : actual.derecho;
        }
        return false;
    }

    public void eliminar(T dato) {
        raiz = eliminar(raiz, dato);
    }

    private Nodo<T> eliminar(Nodo<T> nodo, T dato) {
        if (nodo == null) return null;
        int cmp = dato.compareTo(nodo.dato);
        if (cmp < 0) {
            nodo.izquierdo = eliminar(nodo.izquierdo, dato);
        } else if (cmp > 0) {
            nodo.derecho = eliminar(nodo.derecho, dato);
        } else {
            tamano--;
            if (nodo.izquierdo == null) return nodo.derecho;
            if (nodo.derecho == null) return nodo.izquierdo;
            // dos hijos: se reemplaza por el menor del subárbol derecho
            Nodo<T> sucesor = nodo.derecho;
            while (sucesor.izquierdo != null) sucesor = sucesor.izquierdo;
            nodo.dato = sucesor.dato;
            tamano++; // el siguiente eliminar vuelve a restar
            nodo.derecho = eliminar(nodo.derecho, sucesor.dato);
        }
        return nodo;
    }

    public int altura() { return altura(raiz); }

    private int altura(Nodo<T> nodo) {
        if (nodo == null) return 0;
        return 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));
    }

    public int tamano() { return tamano; }

    // Recorridos
    public List<T> inorden() {
        List<T> lista = new ArrayList<>();
        inorden(raiz, lista);
        return lista;
    }
    private void inorden(Nodo<T> n, List<T> l) {
        if (n == null) return;
        inorden(n.izquierdo, l);
        l.add(n.dato);
        inorden(n.derecho, l);
    }

    public List<T> preorden() {
        List<T> lista = new ArrayList<>();
        preorden(raiz, lista);
        return lista;
    }
    private void preorden(Nodo<T> n, List<T> l) {
        if (n == null) return;
        l.add(n.dato);
        preorden(n.izquierdo, l);
        preorden(n.derecho, l);
    }

    public List<T> postorden() {
        List<T> lista = new ArrayList<>();
        postorden(raiz, lista);
        return lista;
    }
    private void postorden(Nodo<T> n, List<T> l) {
        if (n == null) return;
        postorden(n.izquierdo, l);
        postorden(n.derecho, l);
        l.add(n.dato);
    }

    /** Devuelve el menor dato del árbol (o null si está vacío). */
    public T minimo() {
        if (raiz == null) return null;
        Nodo<T> actual = raiz;
        while (actual.izquierdo != null) actual = actual.izquierdo;
        return actual.dato;
    }

    /** Devuelve el mayor dato del árbol (o null si está vacío). */
    public T maximo() {
        if (raiz == null) return null;
        Nodo<T> actual = raiz;
        while (actual.derecho != null) actual = actual.derecho;
        return actual.dato;
    }

    /** Recorrido por niveles (en anchura): de arriba hacia abajo, de izquierda a derecha. */
    public List<T> porNiveles() {
        List<T> lista = new ArrayList<>();
        if (raiz == null) return lista;
        Queue<Nodo<T>> cola = new LinkedList<>();
        cola.add(raiz);
        while (!cola.isEmpty()) {
            Nodo<T> n = cola.poll();
            lista.add(n.dato);
            if (n.izquierdo != null) cola.add(n.izquierdo);
            if (n.derecho != null) cola.add(n.derecho);
        }
        return lista;
    }

    /** Cuenta los nodos hoja (los que no tienen hijos). */
    public int contarHojas() { return contarHojas(raiz); }

    private int contarHojas(Nodo<T> n) {
        if (n == null) return 0;
        if (n.izquierdo == null && n.derecho == null) return 1;
        return contarHojas(n.izquierdo) + contarHojas(n.derecho);
    }
}
