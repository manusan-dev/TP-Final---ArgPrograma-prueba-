package ejerciciosargentinaprograma.tpintegrador;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PronosticoTest {
    
    public PronosticoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    
    @Test
    public void testPuntos() {
        Equipo equipo1 = new Equipo("Boca","Boca");
        Equipo equipo2 = new Equipo("Racing","Racing");
        Equipo equipo3 = new Equipo("River","River");
        Equipo equipo4 = new Equipo("Independiente","Independiente");
        
        Partido partido1 = new Partido(equipo1, equipo2, 2, 2);
        Partido partido2 = new Partido(equipo3, equipo4, 3, 1);
        Partido partido3 = new Partido(equipo1, equipo3, 1, 2);
        Partido partido4 = new Partido(equipo4, equipo2, 3, 2);
        
        Pronostico pron1 = new Pronostico(partido1, equipo1, ResultadoEnum.EMPATE);
        Pronostico pron2 = new Pronostico(partido2, equipo3, ResultadoEnum.PERDEDOR);
        Pronostico pron3 = new Pronostico(partido3, equipo1, ResultadoEnum.EMPATE);
        Pronostico pron4 = new Pronostico(partido4, equipo2, ResultadoEnum.GANADOR);
        
        System.out.println("puntos");
        Pronostico instance = null;
        int expResult = 2;
        int result = pron1.puntos() + pron2.puntos() + pron3.puntos() + pron4.puntos();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testPuntos2() {
        Equipo equipo1 = new Equipo("Boca","Boca");
        Equipo equipo2 = new Equipo("Racing","Racing");
        Equipo equipo3 = new Equipo("River","River");
        Equipo equipo4 = new Equipo("Independiente","Independiente");
        
        Partido partido1 = new Partido(equipo1, equipo2, 2, 2);
        Partido partido2 = new Partido(equipo3, equipo4, 3, 1);
        Partido partido3 = new Partido(equipo1, equipo3, 1, 2);
        Partido partido4 = new Partido(equipo4, equipo2, 3, 2);
        
        Pronostico pron1 = new Pronostico(partido1, equipo1, ResultadoEnum.EMPATE);
        Pronostico pron2 = new Pronostico(partido2, equipo3, ResultadoEnum.PERDEDOR);
        Pronostico pron3 = new Pronostico(partido3, equipo1, ResultadoEnum.EMPATE);
        Pronostico pron4 = new Pronostico(partido4, equipo2, ResultadoEnum.GANADOR);
        
        System.out.println("puntos");
        Pronostico instance = null;
        int expResult = 1;
        int result = pron1.puntos() + pron2.puntos() + pron3.puntos() + pron4.puntos();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testPuntos3() {
        Equipo equipo1 = new Equipo("Boca","Boca");
        Equipo equipo2 = new Equipo("Racing","Racing");
        Equipo equipo3 = new Equipo("River","River");
        Equipo equipo4 = new Equipo("Independiente","Independiente");
        
        Partido partido1 = new Partido(equipo1, equipo2, 2, 2);
        Partido partido2 = new Partido(equipo3, equipo4, 3, 1);
        Partido partido3 = new Partido(equipo1, equipo3, 1, 2);
        Partido partido4 = new Partido(equipo4, equipo2, 3, 2);
        
        Pronostico pron1 = new Pronostico(partido1, equipo1, ResultadoEnum.GANADOR);
        Pronostico pron2 = new Pronostico(partido2, equipo3, ResultadoEnum.PERDEDOR);
        Pronostico pron3 = new Pronostico(partido3, equipo1, ResultadoEnum.GANADOR);
        Pronostico pron4 = new Pronostico(partido4, equipo2, ResultadoEnum.GANADOR);
        
        System.out.println("puntos");
        Pronostico instance = null;
        int expResult = 1;
        int result = pron1.puntos() + pron2.puntos() + pron3.puntos() + pron4.puntos();
        assertEquals(expResult, result);
    }
    
}


