package ejerciciosargentinaprograma.tpintegrador;

import java.util.List;


public class Partido {
    Equipo equipo1;
    Equipo equipo2;
    int golesEquipo1;
    int golesEquipo2;

    public Partido(Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2) {        
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
        
    }
    

    public Equipo getEquipo1() {
        return equipo1;
    }
    
    String[] linea;

    public Partido(String[] linea) throws errorPartidoException {
        this.linea = linea;
        if (esEntero(linea[2], linea[3]) == false || linea.length>5){
            throw new errorPartidoException(linea);
        }
    }
    
    
    public static boolean esEntero(String gol1, String gol2) throws NumberFormatException {

        boolean resultado;
        try {
            Integer.parseInt(gol1);
            Integer.parseInt(gol2);
            resultado = true;
            
        } catch (NumberFormatException error) {
            resultado = false;
        }

        return resultado;
    }
    
    
    /* Comparo los goles de un equipo enviado y le asigno un resultado de tipo ResultadoEnum y despues comparar 
        por ej: ARGENTINA.EMPATE (pronostico) vs ARGENTINA.RESULTADO (partido) */
    public ResultadoEnum resultado(Equipo equi){
        
        /* Declaro variables de tipo GANADOR, PERDEDOR O EMPATE para retornarlas como salida, asigno EMPATE solo para inicializar */
        ResultadoEnum  result = ResultadoEnum.EMPATE;
        int golesEqui, golesRival;
        
        /* Asigno cuantos goles hizo el equipo y cuantos el rival para comparar */
        golesEqui = golesEquipo1;
        golesRival = golesEquipo2;
        
        /* Comparo los resultados */
        if (golesEqui > golesRival){
            result = ResultadoEnum.GANADOR;
        }
        
        if (golesRival > golesEqui){
            result = ResultadoEnum.PERDEDOR;
        }
        
        if (golesRival == golesEqui){
            result = ResultadoEnum.EMPATE;
        }
        
        /* Devuelvo el resultado, va a ser de tipo resultado GANADOR / PERDEDOR / EMPATE */
        return result;
        
    }
    
    
    
    
}
