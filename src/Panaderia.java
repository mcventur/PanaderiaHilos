/**
 * Modela una panaderia con varias barras de pan
 * Para darle más emoción, lo hacemos con un array, sin controlar que sobrepasemos su tamaño
 * Cuando la panadería cierre, todos los hilos (clientes y panadero) dejarán de trabajar sobre ella
 */
//TODO La lógica de añadir y vender es correcta.
// Pero requieren cambios para que se respeten las condiciones del ejercicio en un sistema concurrente
public class Panaderia {
    private final int CAPACIDAD_MOSTRADOR = 5;
    private boolean cerrada = false;
    private BarraPan[] mostrador = new BarraPan[CAPACIDAD_MOSTRADOR];
    private int barrasActuales = 0;

    /**
     * Añade una barra de pan al final del mostrador
     */
    public synchronized void añadirBarraMostrador(BarraPan barra) {
        while (barrasActuales >= CAPACIDAD_MOSTRADOR) {
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
        }
        mostrador[barrasActuales] = barra;
        barrasActuales++;
        notify();
        System.out.println("Añadida barra al mostrador: " + barra);
    }

    public synchronized void venderBarraPan() {
        while (barrasActuales == 0) {
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
        }

        barrasActuales--;
        BarraPan vendida = mostrador[barrasActuales];
        notify();
        System.out.println("Vendida barra: " + vendida);
    }

    public synchronized void cerrar() {
        cerrada = true;
        notifyAll();
    }

    public boolean isCerrada() {
        return cerrada;
    }
}
