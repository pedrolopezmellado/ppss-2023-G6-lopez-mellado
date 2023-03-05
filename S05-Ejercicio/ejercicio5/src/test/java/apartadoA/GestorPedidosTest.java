package apartadoA;

import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.testng.AssertJUnit.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;


public class GestorPedidosTest {

    @Test
    void generarFacturaC1() throws FacturaException {
        Cliente cliente = new Cliente("cliente1", 20);
        BuscadorStub buscador = new BuscadorStub(10);
        GestorPedidosTestable sut = new GestorPedidosTestable();
        sut.setBuscador(buscador);

        Factura expectedResult = new Factura();
        expectedResult.setIdCliente("cliente1");
        expectedResult.setTotal_factura(200);
        assertAll(
                ()-> assertEquals(expectedResult.getIdCliente(), sut.generarFactura(cliente).getIdCliente()),
                () -> assertEquals(expectedResult.getTotal_factura(), sut.generarFactura(cliente).getTotal_factura())
        );
    }


    @Test
    void generarFacturaC2() throws FacturaException {
        Cliente cliente = new Cliente("cliente1", 20);
        BuscadorStub buscador = new BuscadorStub(0);
        GestorPedidosTestable sut = new GestorPedidosTestable();
        sut.setBuscador(buscador);

        Factura expectedResult = new Factura();
        expectedResult.setIdCliente("cliente1");
        expectedResult.setTotal_factura(200);
        assertThrows(FacturaException.class, ()-> sut.generarFactura(cliente));
    }


}
