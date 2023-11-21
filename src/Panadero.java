//TODO El panadero instanciará una barra de pan y la dejará en el mostrador
public class Panadero extends Thread{
    private Panaderia panaderia;

    public Panadero(Panaderia panaderia) {
        this.panaderia = panaderia;
    }

    @Override
    public void run() {

    }
}
