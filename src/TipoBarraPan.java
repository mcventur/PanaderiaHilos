public enum TipoBarraPan {
    INTEGRAL, ARTESANA, MASA_MADRE;

    /**
     * Devuelve un tipo de barra aleatorio
     */
    public static TipoBarraPan getAleatorio(){
        TipoBarraPan[] tipos = values();
        int posAleatoria = (int)(Math.random() * tipos.length);
        return tipos[posAleatoria];
    }
}
