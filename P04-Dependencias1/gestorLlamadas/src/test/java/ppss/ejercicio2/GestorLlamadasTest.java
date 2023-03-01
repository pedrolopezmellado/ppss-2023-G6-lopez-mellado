package ppss.ejercicio2;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class GestorLlamadasTest {

    @Test
    void gestorLlamadasC1(){
        int minutos = 10;
        int hora = 15;
        double resultadoEsperado = 208.0;

        CalendarioStub calendario = new CalendarioStub(hora);

        GestorLlamadas gestor = new GestorLlamadas();

        assertEquals(resultadoEsperado, gestor.calculaConsumo(minutos, calendario));
    }

    @Test
    void gestorLlamadasC2(){
        int minutos = 10;
        int hora = 22;
        double resultadoEsperado = 105.0;

        CalendarioStub calendario = new CalendarioStub(hora);

        GestorLlamadas gestor = new GestorLlamadas();

        assertEquals(resultadoEsperado, gestor.calculaConsumo(minutos, calendario));
    }
}
