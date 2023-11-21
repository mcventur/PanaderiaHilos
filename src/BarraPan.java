/**
 * Modela una barra de pan, con un Tipo y un peso en Kgs
 */
public class BarraPan {
    private TipoBarraPan tipo;



    /**
     * Constructor
     */
    public BarraPan() {
        this.tipo = TipoBarraPan.getAleatorio();
    }

    public TipoBarraPan getTipo() {
        return tipo;
    }

    public void setTipo(TipoBarraPan tipo) {
        this.tipo = tipo;
    }


    @Override
    public String toString() {
        return "BarraPan{" +
                "tipo=" + tipo +
                '}';
    }
}
