import org.easymock.EasyMock;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import ppss.Calendario;
import ppss.GestorLlamadas;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.partialMockBuilder;
import static org.testng.AssertJUnit.assertEquals;

public class GestorLlamadasTest {

    @Test
    void calculaConsumoC1(){
        final Calendario calendarioMock = EasyMock.mock(Calendario.class);
        Assertions.assertDoesNotThrow(() ->
                EasyMock.expect(calendarioMock.getHoraActual())
                        .andReturn(10));
        EasyMock.replay(calendarioMock);
        GestorLlamadas gestor = partialMockBuilder(GestorLlamadas.class)
                .addMockedMethod("getCalendario")
                .strictMock();
        expect(gestor.getCalendario()).andReturn(calendarioMock);
        EasyMock.replay(gestor);
        assertEquals(457.6, gestor.calculaConsumo(22));
        EasyMock.verify(calendarioMock, gestor);
    }

    @Test
    void calculaConsumoC2(){
        final Calendario calendarioMock = EasyMock.mock(Calendario.class);
        Assertions.assertDoesNotThrow(() ->
                EasyMock.expect(calendarioMock.getHoraActual())
                        .andReturn(21));
        EasyMock.replay(calendarioMock);
        GestorLlamadas gestor = partialMockBuilder(GestorLlamadas.class)
                .addMockedMethod("getCalendario")
                .strictMock();
        expect(gestor.getCalendario()).andReturn(calendarioMock);
        EasyMock.replay(gestor);
        assertEquals(136.5, gestor.calculaConsumo(13));
        EasyMock.verify(calendarioMock, gestor);
    }
}
