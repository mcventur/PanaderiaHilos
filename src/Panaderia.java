import java.util.concurrent.Semaphore;

/**
 * Modela una panaderia con varias barras de pan
 * Para darle más emoción, lo hacemos con un array, sin controlar que sobrepasemos su tamaño
 * Cuando la panadería cierre, todos los hilos (clientes y panadero) dejarán de trabajar sobre ella
 */

public class Panaderia {
    private final int CAPACIDAD_MOSTRADOR = 5;
    private BarraPan[] mostrador = new BarraPan[CAPACIDAD_MOSTRADOR];
    private int barrasActuales = 0;

    //El productor tiene, de inicio, capacidad para 5 hilos dejando barras en el mostrador
    private Semaphore semaforo_productor = new Semaphore(CAPACIDAD_MOSTRADOR);

    //El consumidor de inicio no tiene barras para vender
    private Semaphore semaforo_consumidor = new Semaphore(0);

    /**
     * Añade una barra de pan al final del mostrador
     */
    public void añadirBarraMostrador(BarraPan barra) {
        try {
            //Para poder dejar una barra, compruebo si hay sitio con el semáforo correspondiente
            semaforo_productor.acquire();
        } catch (InterruptedException e) {
        }

        mostrador[barrasActuales] = barra;
        barrasActuales++;


        //Una vez fabricada la barra, aumento en 1 la capacidad de hilos vendedores
        semaforo_consumidor.release();
        System.out.println("Añadida barra al mostrador: " + barra);
    }

    public void venderBarraPan() {
        try {
            //Intento coger turno de consumidor. Si no me toca, espero
            semaforo_consumidor.acquire();
        } catch (InterruptedException e) {
        }

        BarraPan vendida;
        barrasActuales--;
        vendida = mostrador[barrasActuales];

        //Cuando haya hecgo efectiva la venta, libero un turno para los productores
        semaforo_productor.release();
        System.out.println("Vendida barra: " + vendida);
    }

}
