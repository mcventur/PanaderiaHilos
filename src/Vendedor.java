//TODO los vendedores venden barras de pan mientras la panaderia esté abierta
public class Vendedor extends Thread{
    private Panaderia panaderia;

    public Vendedor(Panaderia panaderia) {
        this.panaderia = panaderia;
    }

    @Override
    public void run() {

    }
}
