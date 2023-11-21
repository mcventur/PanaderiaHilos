//TODO El panadero instanciará una barra de pan y la dejará en el mostrador
public class Panadero extends Thread{
    private final int ITERACIONES = 50;
    private Panaderia panaderia;
    private static int contadorPanaderos = 1;

    public Panadero(Panaderia panaderia) {
        super("Panadero" + contadorPanaderos++);
        this.panaderia = panaderia;
    }

    @Override
    public void run() {
        for (int i = 0; i < ITERACIONES; i++) {
            panaderia.añadirBarraMostrador(new BarraPan());
        }
    }
}
