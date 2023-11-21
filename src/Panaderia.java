/**
 * Modela una panaderia con varias barras de pan
 * Para darle más emoción, lo hacemos con un array, sin controlar que sobrepasemos su tamaño
 * Cuando la panadería cierre, todos los hilos (clientes y panadero) dejarán de trabajar sobre ella
 */
//TODO La lógica de añadir y vender es correcta.
// Pero requieren cambios para que se respeten las condiciones del ejercicio en un sistema concurrente
public class Panaderia {
    private final int CAPACIDAD_MOSTRADOR = 5;
    private boolean panaderiaCerrada = false;
    private BarraPan[] mostrador = new BarraPan[CAPACIDAD_MOSTRADOR];
    private int barrasActuales = 0;

    /**
     * Añade una barra de pan al final del mostrador
     */
    public void añadirBarraMostrador(BarraPan barra){
        mostrador[barrasActuales] = barra;
        barrasActuales++;
    }

    public void venderBarraPan(){
        BarraPan vendida =  mostrador[barrasActuales];
        barrasActuales--;
    }




}
