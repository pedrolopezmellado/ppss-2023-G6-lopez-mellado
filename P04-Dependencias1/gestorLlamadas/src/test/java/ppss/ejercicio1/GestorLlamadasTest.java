package ppss.ejercicio1;


import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class GestorLlamadasTest {

    @Test
    void calculaConsumoC1(){

        GestorLlamadasTestable gestor = new GestorLlamadasTestable(15);
        Double resultadoEsperado = 208.0;
        assertEquals(resultadoEsperado, gestor.calculaConsumo(10));
    }

    @Test
    void calculaConsumoC2(){

        GestorLlamadasTestable gestor = new GestorLlamadasTestable(22);
        Double resultadoEsperado = 105.0;
        assertEquals(resultadoEsperado, gestor.calculaConsumo(10));
    }
}
