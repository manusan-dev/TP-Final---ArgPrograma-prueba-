package ejerciciosargentinaprograma.tpintegrador;

import java.util.ArrayList;
import java.util.List;

public class Ronda {

    private String nro;
    private List<Partido> partidos;
    private List<Pronostico> pronosticos;
    private List<Partido> listaPartidos = new ArrayList();

    public Ronda(String nro, List<Partido> partidos) {
        this.nro = nro;
        this.partidos = partidos;
    }

    public Ronda() {

    }
}
