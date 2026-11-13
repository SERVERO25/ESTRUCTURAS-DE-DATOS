package vector;

public class PruebaVector {
    public static void main(String[] args) {
        VectorDinamico<String> tareas = new VectorDinamico<>();
        for (String t : new String[]{"Check-in", "Limpieza", "Inventario", "Nómina", "Reservas"}) {
            tareas.agregar(t);
        }
        System.out.println("Tareas: " + tareas);
        System.out.println("Tamaño: " + tareas.tamano() + ", capacidad: " + tareas.capacidad());

        tareas.establecer(1, "Lavandería");
        System.out.println("Posición 1: " + tareas.obtener(1));
        System.out.println("Posición de Nómina: " + tareas.indiceDe("Nómina"));
        System.out.println("Posición de Mantenimiento: " + tareas.indiceDe("Mantenimiento"));

        tareas.insertar(0, "Apertura");
        System.out.println("Tras insertar al inicio: " + tareas);
        tareas.invertir();
        System.out.println("Invertido: " + tareas);
        System.out.println("Elimina la posición 0: " + tareas.eliminar(0));
        System.out.println("Tareas: " + tareas);
    }
}
