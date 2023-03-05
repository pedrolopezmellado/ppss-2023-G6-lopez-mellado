package apartadoC;

import org.easymock.EasyMock;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.testng.AssertJUnit.assertEquals;

public class GestorPedidosTest {

    @Test
    void generarFacturaC1() throws FacturaException {
        GestorPedidos gestor = new GestorPedidos();
        Cliente cliente = new Cliente("cliente1", 20);
        Buscador buscadorMock = EasyMock.strictMock(Buscador.class);
        Assertions.assertDoesNotThrow(() ->
                EasyMock.expect(buscadorMock.elemPendientes(cliente)).andReturn(10));
        EasyMock.replay();
        Factura expectedResult = new Factura();
        expectedResult.setIdCliente("cliente1");
        expectedResult.setTotal_factura(200);

        Factura resultado = gestor.generarFactura(cliente, buscadorMock);
        EasyMock.verify(buscadorMock);
        assertAll(
                ()-> assertEquals(expectedResult.getIdCliente(), resultado.getIdCliente()),
                () -> assertEquals(expectedResult.getTotal_factura(), resultado.getTotal_factura())
        );
    }

    @Test
    void generarFacturaC2() {
        GestorPedidos gestor = new GestorPedidos();
        Cliente cliente = new Cliente("cliente1", 20);
        Buscador buscadorMock = EasyMock.strictMock(Buscador.class);
        Assertions.assertDoesNotThrow(() ->
                EasyMock.expect(buscadorMock.elemPendientes(cliente)).andReturn(0));
        EasyMock.replay();
        Factura expectedResult = new Factura();
        expectedResult.setIdCliente("cliente1");
        expectedResult.setTotal_factura(200);

        assertThrows(FacturaException.class, () -> gestor.generarFactura(cliente, buscadorMock));
        EasyMock.verify(buscadorMock);
    }

}
