package ejerciciosargentinaprograma.tpintegrador;

public class errorPartidoException extends Exception {
        private final String[] linea;

    public errorPartidoException(String[] linea) {
        this.linea = linea;
    }
        
}
