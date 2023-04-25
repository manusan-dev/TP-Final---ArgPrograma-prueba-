package ejerciciosargentinaprograma.tpintegrador;

import java.util.List;


public class Pronostico {
    private Partido partido;
    private Equipo equipo;
    private ResultadoEnum resultado;

    public Pronostico(Partido partido, Equipo equipo, ResultadoEnum resultado) {
        this.partido = partido;
        this.equipo = equipo;
        this.resultado = resultado;
    }

    

    public Partido getPartido() {
        return partido;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public ResultadoEnum getResultado() {
        return resultado;
    }
    
    public int puntos() {
        if (resultado.equals(partido.resultado(equipo)) ) {
            return 1;
        } else {
            return 0;
        }
    }
    
    
    public boolean puntosExtra(int puntos, int cantidadPartidos) {
        return puntos >= cantidadPartidos ? true : false;

    }
    
}
