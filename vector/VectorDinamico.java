package vector;

import java.util.Arrays;

/** Vector (arreglo dinámico): crece automáticamente cuando se llena. */
public class VectorDinamico<T> {
    private Object[] datos = new Object[4];
    private int tamano = 0;

    public void agregar(T elemento) {
        if (tamano == datos.length) {
            datos = Arrays.copyOf(datos, datos.length * 2);
        }
        datos[tamano++] = elemento;
    }

    @SuppressWarnings("unchecked")
    public T obtener(int indice) {
        validar(indice);
        return (T) datos[indice];
    }

    public void establecer(int indice, T elemento) {
        validar(indice);
        datos[indice] = elemento;
    }

    @SuppressWarnings("unchecked")
    public T eliminar(int indice) {
        validar(indice);
        T eliminado = (T) datos[indice];
        for (int i = indice; i < tamano - 1; i++) {
            datos[i] = datos[i + 1];
        }
        datos[--tamano] = null;
        return eliminado;
    }

    public int tamano() { return tamano; }
    public int capacidad() { return datos.length; }

    private void validar(int indice) {
        if (indice < 0 || indice >= tamano) {
            throw new IndexOutOfBoundsException("Índice " + indice + " fuera de rango (tamaño " + tamano + ")");
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(datos, tamano));
    }

    /** Posición de la primera aparición del elemento, o -1 si no está. */
    public int indiceDe(T elemento) {
        for (int i = 0; i < tamano; i++) {
            if (datos[i].equals(elemento)) return i;
        }
        return -1;
    }

    /** Inserta un elemento en la posición dada, corriendo los demás hacia la derecha. */
    public void insertar(int indice, T elemento) {
        if (indice < 0 || indice > tamano) {
            throw new IndexOutOfBoundsException("Índice " + indice + " fuera de rango (tamaño " + tamano + ")");
        }
        if (tamano == datos.length) {
            datos = Arrays.copyOf(datos, datos.length * 2);
        }
        for (int i = tamano; i > indice; i--) {
            datos[i] = datos[i - 1];
        }
        datos[indice] = elemento;
        tamano++;
    }

    /** Invierte el orden de los elementos sin crear otro arreglo. */
    public void invertir() {
        for (int i = 0, j = tamano - 1; i < j; i++, j--) {
            Object temporal = datos[i];
            datos[i] = datos[j];
            datos[j] = temporal;
        }
    }
}
