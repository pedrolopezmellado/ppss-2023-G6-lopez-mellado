package apartadoB;

import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;
import org.easymock.EasyMock;

import static org.easymock.EasyMock.anyObject;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.testng.AssertJUnit.assertEquals;

public class GestorPedidosTest {


    @Test
    void generarFacturaC1() throws FacturaException {

        GestorPedidos gestorPedidos = new GestorPedidos();
        Buscador buscadorStub = EasyMock.niceMock(Buscador.class);

        Cliente cliente = new Cliente("cliente1", 20);
        EasyMock.expect(buscadorStub.elemPendientes(anyObject())).andStubReturn(10);
        EasyMock.replay(buscadorStub);

        Factura expectedResult = new Factura();
        expectedResult.setIdCliente("cliente1");
        expectedResult.setTotal_factura(200);

        Factura resultado = gestorPedidos.generarFactura(cliente, buscadorStub);
        assertAll(
                ()-> assertEquals(expectedResult.getIdCliente(), resultado.getIdCliente()),
                () -> assertEquals(expectedResult.getTotal_factura(), resultado.getTotal_factura())
        );
    }

    @Test
    void generarFacturaC2() {

        GestorPedidos gestorPedidos = new GestorPedidos();
        Buscador buscadorStub = EasyMock.niceMock(Buscador.class);

        Cliente cliente = new Cliente("cliente1", 20);
        EasyMock.expect(buscadorStub.elemPendientes(anyObject())).andStubReturn(0);
        EasyMock.replay(buscadorStub);

        Factura expectedResult = new Factura();
        expectedResult.setIdCliente("cliente1");
        expectedResult.setTotal_factura(200);

        assertThrows(FacturaException.class,
                () -> gestorPedidos.generarFactura(cliente, buscadorStub));
    }
}
