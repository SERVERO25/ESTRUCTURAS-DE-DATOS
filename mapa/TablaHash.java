package mapa;

import java.util.ArrayList;
import java.util.List;

/** Mapa (tabla hash) con encadenamiento: guarda pares clave -> valor. */
public class TablaHash<K, V> {

    private static class Entrada<K, V> {
        K clave;
        V valor;
        Entrada<K, V> siguiente;
        Entrada(K clave, V valor) { this.clave = clave; this.valor = valor; }
    }

    private Entrada<K, V>[] cubetas;
    private int tamano = 0;

    @SuppressWarnings("unchecked")
    public TablaHash() {
        cubetas = (Entrada<K, V>[]) new Entrada[8];
    }

    private int indice(K clave, int longitud) {
        return (clave.hashCode() & 0x7fffffff) % longitud;
    }

    public void poner(K clave, V valor) {
        int i = indice(clave, cubetas.length);
        for (Entrada<K, V> e = cubetas[i]; e != null; e = e.siguiente) {
            if (e.clave.equals(clave)) {   // la clave ya existe: se actualiza
                e.valor = valor;
                return;
            }
        }
        Entrada<K, V> nueva = new Entrada<>(clave, valor);
        nueva.siguiente = cubetas[i];
        cubetas[i] = nueva;
        tamano++;
        if (tamano > cubetas.length * 0.75) agrandar();
    }

    public V obtener(K clave) {
        int i = indice(clave, cubetas.length);
        for (Entrada<K, V> e = cubetas[i]; e != null; e = e.siguiente) {
            if (e.clave.equals(clave)) return e.valor;
        }
        return null;
    }

    public boolean contieneClave(K clave) {
        int i = indice(clave, cubetas.length);
        for (Entrada<K, V> e = cubetas[i]; e != null; e = e.siguiente) {
            if (e.clave.equals(clave)) return true;
        }
        return false;
    }

    public boolean eliminar(K clave) {
        int i = indice(clave, cubetas.length);
        Entrada<K, V> anterior = null;
        for (Entrada<K, V> e = cubetas[i]; e != null; e = e.siguiente) {
            if (e.clave.equals(clave)) {
                if (anterior == null) cubetas[i] = e.siguiente;
                else anterior.siguiente = e.siguiente;
                tamano--;
                return true;
            }
            anterior = e;
        }
        return false;
    }

    public List<K> claves() {
        List<K> lista = new ArrayList<>();
        for (Entrada<K, V> cabeza : cubetas) {
            for (Entrada<K, V> e = cabeza; e != null; e = e.siguiente) {
                lista.add(e.clave);
            }
        }
        return lista;
    }

    public int tamano() { return tamano; }

    @SuppressWarnings("unchecked")
    private void agrandar() {
        Entrada<K, V>[] viejas = cubetas;
        cubetas = (Entrada<K, V>[]) new Entrada[viejas.length * 2];
        for (Entrada<K, V> cabeza : viejas) {
            for (Entrada<K, V> e = cabeza; e != null; e = e.siguiente) {
                int i = indice(e.clave, cubetas.length);
                Entrada<K, V> copia = new Entrada<>(e.clave, e.valor);
                copia.siguiente = cubetas[i];
                cubetas[i] = copia;
            }
        }
    }

    /** Devuelve todos los valores guardados en la tabla. */
    public List<V> valores() {
        List<V> lista = new ArrayList<>();
        for (Entrada<K, V> cabeza : cubetas) {
            for (Entrada<K, V> e = cabeza; e != null; e = e.siguiente) {
                lista.add(e.valor);
            }
        }
        return lista;
    }

    /** Devuelve el valor de la clave, o el valor por defecto si la clave no existe. */
    public V obtenerOPorDefecto(K clave, V porDefecto) {
        return contieneClave(clave) ? obtener(clave) : porDefecto;
    }
}
