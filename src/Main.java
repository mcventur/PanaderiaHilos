
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Panaderia panaderia = new Panaderia();
        Panadero p = new Panadero(panaderia);
        Vendedor v = new Vendedor(panaderia);

        p.start();
        v.start();

    }
}
