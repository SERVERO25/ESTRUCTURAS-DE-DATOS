package arbol;

public class PruebaArbol {
    public static void main(String[] args) {
        ArbolBusqueda<String> huespedes = new ArbolBusqueda<>();
        for (String h : new String[]{"Marta", "Carlos", "Zoe", "Ana", "Pedro", "Luis", "Sofía"}) {
            huespedes.insertar(h);
        }

        System.out.println("Huéspedes (alfabético): " + huespedes.inorden());
        System.out.println("Preorden:   " + huespedes.preorden());
        System.out.println("Postorden:  " + huespedes.postorden());
        System.out.println("Por niveles: " + huespedes.porNiveles());
        System.out.println("Altura: " + huespedes.altura() + ", tamaño: " + huespedes.tamano()
                + ", hojas: " + huespedes.contarHojas());
        System.out.println("Primero alfabéticamente: " + huespedes.minimo());
        System.out.println("Último alfabéticamente:  " + huespedes.maximo());
        System.out.println("¿Está Pedro? " + huespedes.contiene("Pedro"));

        huespedes.eliminar("Marta"); // la raíz, con dos hijos
        System.out.println("Tras eliminar a Marta: " + huespedes.inorden());
    }
}
