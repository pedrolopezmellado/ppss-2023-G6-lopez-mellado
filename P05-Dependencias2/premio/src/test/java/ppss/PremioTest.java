package ppss;

import org.easymock.EasyMock;
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import static org.easymock.EasyMock.partialMockBuilder;
import static org.testng.AssertJUnit.assertEquals;

public class PremioTest {

    @Test
    void compruebaPremioC1() {
        ClienteWebService clienteMock = EasyMock.mock(ClienteWebService.class);
        EasyMock.expect(
                assertDoesNotThrow(() -> clienteMock.obtenerPremio())).andReturn("entrada final Champions");

        EasyMock.replay(clienteMock);

        Premio premio = partialMockBuilder(Premio.class)
                .addMockedMethod("generaNumero")
                .strictMock();
        EasyMock.expect(premio.generaNumero()).andReturn(0.07F);

        EasyMock.replay(premio);

        assertEquals("Premiado con entrada final Champions", premio.compruebaPremio(clienteMock));

        EasyMock.verify(clienteMock, premio);
    }

    @Test
    void compruebaPremioC2() {
        ClienteWebService clienteMock = EasyMock.mock(ClienteWebService.class);
        EasyMock.expect(
                assertDoesNotThrow(()-> clienteMock.obtenerPremio())).andThrow(new ClienteWebServiceException());

        EasyMock.replay(clienteMock);

        Premio premio = partialMockBuilder(Premio.class)
                .addMockedMethod("generaNumero")
                .strictMock();
        EasyMock.expect(premio.generaNumero()).andReturn(0.03F);

        EasyMock.replay(premio);

        assertEquals("No se ha podido obtener el premio", premio.compruebaPremio(clienteMock));

        EasyMock.verify(clienteMock, premio);
    }

    @Test
    void compruebaPremioC3() {
        ClienteWebService cliente = new ClienteWebService();
        Premio premio = partialMockBuilder(Premio.class)
                .addMockedMethod("generaNumero")
                .strictMock();
        EasyMock.expect(premio.generaNumero()).andReturn(0.3F);

        EasyMock.replay(premio);

        assertEquals("Sin premio", premio.compruebaPremio(cliente));

        EasyMock.verify(premio);
    }
}
