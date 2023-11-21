/**
 * Modela una panaderia con varias barras de pan
 * Para darle más emoción, lo hacemos con un array, sin controlar que sobrepasemos su tamaño o accedamos a un índice negativo
 * La lógica de las funciones añadir y vender es correcta. Hay que sincronizarlas
 */
//TODO
// Se requieren retoques y controles para que se respeten las condiciones del ejercicio en un sistema concurrente
public class Panaderia {
    private final int CAPACIDAD_MOSTRADOR = 5;
    private BarraPan[] mostrador = new BarraPan[CAPACIDAD_MOSTRADOR];
    private int barrasActuales = 0;

    /**
     * Añade una barra de pan al final del mostrador
     */
    public void añadirBarraMostrador(BarraPan barra) {
        mostrador[barrasActuales] = barra;
        barrasActuales++;
        System.out.println("Añadida barra al mostrador: " + barra);
    }

    /**
     * Vende la última barra añadida y actualiza el contador
     */
    public void venderBarraPan() {
        barrasActuales--;
        BarraPan vendida = mostrador[barrasActuales];
        System.out.println("Vendida barra: " + vendida);
    }

}
