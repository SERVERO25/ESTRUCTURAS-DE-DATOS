package conjunto;

public class PruebaConjunto {
    public static void main(String[] args) {
        Conjunto<Integer> ocupadasLunes = new Conjunto<>();
        ocupadasLunes.agregar(101);
        ocupadasLunes.agregar(102);
        ocupadasLunes.agregar(205);
        ocupadasLunes.agregar(101); // repetida: no se agrega

        Conjunto<Integer> ocupadasMartes = new Conjunto<>();
        ocupadasMartes.agregar(102);
        ocupadasMartes.agregar(301);

        System.out.println("Lunes: " + ocupadasLunes + " (tamaño " + ocupadasLunes.tamano() + ")");
        System.out.println("Martes: " + ocupadasMartes);
        System.out.println("Ocupadas algún día (unión): " + ocupadasLunes.union(ocupadasMartes));
        System.out.println("Ocupadas ambos días (intersección): " + ocupadasLunes.interseccion(ocupadasMartes));
        System.out.println("Solo el lunes (diferencia): " + ocupadasLunes.diferencia(ocupadasMartes));
        System.out.println("Cambian de un día al otro (dif. simétrica): "
                + ocupadasLunes.diferenciaSimetrica(ocupadasMartes));

        Conjunto<Integer> habitacionesVip = new Conjunto<>();
        habitacionesVip.agregar(102);
        System.out.println("¿VIP está incluido en lunes? " + habitacionesVip.esSubconjunto(ocupadasLunes));
        System.out.println("¿Lunes tiene la 301? " + ocupadasLunes.contiene(301));
    }
}
