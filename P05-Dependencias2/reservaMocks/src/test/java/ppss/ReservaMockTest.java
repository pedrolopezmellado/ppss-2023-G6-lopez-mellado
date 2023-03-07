package ppss;

import org.easymock.EasyMock;
import org.testng.annotations.Test;
import ppss.excepciones.IsbnInvalidoException;
import ppss.excepciones.JDBCException;
import ppss.excepciones.ReservaException;
import ppss.excepciones.SocioInvalidoException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ReservaMockTest {

    @Test
    void realizarReservaC1(){

        Reserva reserva = EasyMock.partialMockBuilder(Reserva.class)
                .addMockedMethod("compruebaPermisos")
                .strictMock();

        EasyMock.expect(reserva.compruebaPermisos("xxxx", "xxxx", Usuario.BIBLIOTECARIO))
                .andReturn(false);

        EasyMock.replay(reserva);

        String [] isbns = {"33333"};

        ReservaException exception = assertThrows(ReservaException.class,
                () -> reserva.realizaReserva("xxxx", "xxxx", "Pepe", isbns));
    }

    @Test
    void realizarReservaC2(){

        String [] isbns = {"22222", "33333"};

        FactoriaBOs factoria = EasyMock.strictMock(FactoriaBOs.class);

        IOperacionBO operacion = EasyMock.strictMock(IOperacionBO.class);

        EasyMock.expect(factoria.getOperacionBO()).andReturn(operacion);

        EasyMock.replay(factoria);

        Reserva reserva = EasyMock.partialMockBuilder(Reserva.class)
                .addMockedMethods("compruebaPermisos", "getFactoria")
                .strictMock();

        EasyMock.expect(reserva.compruebaPermisos("ppss", "ppss", Usuario.BIBLIOTECARIO))
                .andReturn(true);
        EasyMock.expect(reserva.getFactoria()).andReturn(factoria);

        EasyMock.replay(reserva);

        assertDoesNotThrow(() -> reserva.realizaReserva("ppss", "ppss", "Pepe", isbns));

        EasyMock.verify(factoria, reserva);
    }




}
