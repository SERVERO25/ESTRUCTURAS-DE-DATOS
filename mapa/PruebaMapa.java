package mapa;

public class PruebaMapa {
    public static void main(String[] args) {
        // Parte 1: inventario
        TablaHash<String, Integer> inventario = new TablaHash<>();
        inventario.poner("toallas", 120);
        inventario.poner("sábanas", 90);
        inventario.poner("jabones", 300);

        System.out.println("Toallas en stock -> " + inventario.obtener("toallas"));
        System.out.println("¿Hay almohadas? " + inventario.contieneClave("almohadas"));
        System.out.println("Almohadas (con valor por defecto) -> " + inventario.obtenerOPorDefecto("almohadas", 0));

        inventario.poner("toallas", 100); // actualiza el valor
        System.out.println("Toallas actualizadas -> " + inventario.obtener("toallas"));
        inventario.eliminar("sábanas");
        System.out.println("Productos: " + inventario.tamano());
        System.out.println("Claves: " + inventario.claves());
        System.out.println("Cantidades: " + inventario.valores());

        // Parte 2: contar repeticiones (uso clásico de un mapa)
        String[] tiposHabitacion = {"sencilla", "doble", "sencilla", "suite", "doble", "sencilla"};
        TablaHash<String, Integer> conteo = new TablaHash<>();
        for (String tipo : tiposHabitacion) {
            conteo.poner(tipo, conteo.obtenerOPorDefecto(tipo, 0) + 1);
        }
        for (String tipo : conteo.claves()) {
            System.out.println("Reservas de " + tipo + ": " + conteo.obtener(tipo));
        }
    }
}
