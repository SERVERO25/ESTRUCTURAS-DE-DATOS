package grafo;

public class PruebaGrafo {
    public static void main(String[] args) {
        Grafo hotel = new Grafo();
        hotel.agregarArista("Recepción", "Lobby");
        hotel.agregarArista("Recepción", "Oficina");
        hotel.agregarArista("Lobby", "Restaurante");
        hotel.agregarArista("Oficina", "Bodega");
        hotel.agregarArista("Restaurante", "Cocina");
        hotel.agregarArista("Bodega", "Cocina"); // entrada de servicio
        hotel.agregarVertice("Piscina"); // zona sin conexión

        System.out.println("Conexiones: " + hotel);
        System.out.println("Anchura desde Recepción:     " + hotel.anchura("Recepción"));
        System.out.println("Profundidad desde Recepción: " + hotel.profundidad("Recepción"));
        System.out.println("¿Camino Bodega -> Cocina? " + hotel.hayCamino("Bodega", "Cocina"));
        System.out.println("¿Camino Recepción -> Piscina? " + hotel.hayCamino("Recepción", "Piscina"));
        System.out.println("Ruta más corta Recepción -> Cocina: " + hotel.caminoMasCorto("Recepción", "Cocina"));
        System.out.println("Ruta Recepción -> Piscina: " + hotel.caminoMasCorto("Recepción", "Piscina"));
        System.out.println("Conexiones directas de Recepción: " + hotel.grado("Recepción"));
    }
}
