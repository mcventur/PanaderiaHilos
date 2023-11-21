
public class Main {
    public static void main(String[] args) throws InterruptedException {
        //Tiempo que dormiremos el hilo principal para que panadero y vendedores se sincronicen
        final int NUM_PANADEROS = 1;
        final int NUM_VENDEDORES = 1;

        Panaderia panaderia = new Panaderia();
        Panadero[] hilosPanadero = new Panadero[NUM_PANADEROS];
        Vendedor[] hilosVendedor = new Vendedor[NUM_VENDEDORES];

        //TODO Crear tantos panaderos y vendedores como se indica en las constantes, y ponerlos a hacer su trabajo
        for (int i = 0; i < NUM_PANADEROS; i++) {
            hilosPanadero[i] = new Panadero(panaderia);
        }
        for (int i = 0; i < NUM_VENDEDORES; i++) {
            hilosVendedor[i] = new Vendedor(panaderia);
        }

        for (Panadero panadero : hilosPanadero) {
            panadero.start();
        }
        for (Vendedor vendedor : hilosVendedor) {
            vendedor.start();
        }

        panaderia.cerrar();
    }
}
