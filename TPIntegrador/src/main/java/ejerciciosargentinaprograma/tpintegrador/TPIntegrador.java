package ejerciciosargentinaprograma.tpintegrador;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TPIntegrador {

    public static void main(String[] args) throws errorPartidoException {
        /* inicializar en la lectura de datos */
        int puntos = 0, i = 0;
        int ronda = 0;
        String jug = "";
        List<Partido> partidoList = new ArrayList();
        List<Partido> partidoRondaList = new ArrayList();
        List<Jugador> jugadores = new ArrayList();
        List<String> datosIngresoPartido = new ArrayList();

        Properties props = new Properties();
        boolean aceptarPuntosExtra = false;

        try {

            FileInputStream file = new FileInputStream("src\\main\\java\\ejerciciosargentinaprograma\\tpintegrador\\config.ini");
            props.load(file);
            aceptarPuntosExtra = Boolean.parseBoolean(props.getProperty("aplicarPuntosExtra"));
            System.out.println("Puntos extras aplicados: " + aceptarPuntosExtra);
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        /* intento conexion */
 /*try{
              Connection
                      con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tpintegrador","root","admin");
              Statement stmt=con.createStatement();
              System.out.println("Conexion exitosa");
              //USO DE LA DB
             
        
        /* Leer los partidos */
        try {
            try {
                for (String linea : Files.readAllLines(Paths.get("src\\main\\java\\ejerciciosargentinaprograma\\tpintegrador\\resultados.csv.txt"))) {
                    int k;
                    /* En esta asignación y en el if me aseguro de que se este tratando de la misma ronda, cuando cambia la agrego en la lista de rondas con los partidos leidos */

                    String[] campos = linea.split("\\;");

                    Partido linPart = new Partido(campos);

                    int rondaf = Integer.parseInt(campos[0]);
                    if (rondaf != ronda && i > 0) {
                        Ronda rondaList = new Ronda(String.valueOf(ronda), partidoRondaList);
                        partidoRondaList.clear();
                    }
                    System.out.println(linea);
                    /* Leo partido */
                    ronda = Integer.parseInt(campos[0]);

                    String eq1 = campos[1];
                    int golesEquipo1 = Integer.parseInt(campos[2]);
                    int golesEquipo2 = Integer.parseInt(campos[3]);
                    String eq2 = campos[4];

                    Equipo equipo1 = new Equipo(eq1, eq1);
                    Equipo equipo2 = new Equipo(eq2, eq2);

                    Partido partido = new Partido(equipo1, equipo2, golesEquipo1, golesEquipo2);

                    partidoList.add(partido);
                    partidoRondaList.add(partido);
                    i++;
                }
                /* Agrego la última ronda, que por el formato del for queda leida pero no guardada */
                Ronda rondaList = new Ronda(String.valueOf(ronda), partidoRondaList);

                i = 0;
                /* Leo pronostico */
                for (String linea2 : Files.readAllLines(Paths.get("src\\main\\java\\ejerciciosargentinaprograma\\tpintegrador\\pronostico.csv.txt"))) {
                    /* En esta asignación y en el if me aseguro de que se este tratando del mismo jugador, cuando cambia lo agrego en la lista de jugadores con los puntos obtenidos */
                    String[] campos = linea2.split("\\;");
                    String jugProx = campos[0];
                    if (!jugProx.equals(jug) && i > 0) {
                        Jugador jugador = new Jugador(jug, puntos);
                        jugadores.add(jugador);
                        puntos = 0;
                        i = 0;
                    }

                    jug = campos[0];
                    System.out.println(linea2);
                    String equiPro = campos[1];

                    Equipo equipoPronostico = new Equipo(equiPro, equiPro);

                    /* Si es X en el primero queda GANADOR, en el segundo EMPATE  */
                    String gana = campos[2];
                    String empata = campos[3];
                    String pierde = campos[4];
                    ResultadoEnum res = null;
                    if (gana.equals("X")) {
                        res = ResultadoEnum.GANADOR;
                    }
                    if (empata.equals("X")) {
                        res = ResultadoEnum.EMPATE;
                    }
                    if (pierde.equals("X")) {
                        res = ResultadoEnum.PERDEDOR;
                    }
                    //  System.out.println(res);
                    Pronostico pron = new Pronostico(partidoList.get(i), equipoPronostico, res);

                    puntos = puntos + pron.puntos();

                    if (aceptarPuntosExtra) {
                        if (pron.puntosExtra(puntos, partidoList.size())) {
                            puntos = puntos + 3;
                        }
                    }

                    i++;
                }

                /* Agrego el ultimo jugador leido, que por el formato del for queda leido pero no guardado */
                Jugador jugador = new Jugador(jug, puntos);
                jugadores.add(jugador);

                System.out.println("-------------\nResultados:\n");

                /* For para barrer resultados de cada jugador */
                for (Jugador juga : jugadores) {
                    System.out.println(juga.getNombre() + ": " + juga.getPuntos());

                }
            } catch (errorPartidoException err) {
                System.out.println("Error: los campos de partido brindados son incorrectos");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //       con.close();
        //          System.out.println("Conexion cerrada");
//         }catch (Exception e){ System.out.println(e);}

    }
}
