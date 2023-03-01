package ppss;

import org.testng.annotations.Test;
import ppss.excepciones.IsbnInvalidoException;
import ppss.excepciones.ReservaException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.testng.AssertJUnit.assertEquals;

public class ReservaTest {

    @Test
    void realizarReservaC1(){
        String login = "xxxx";
        final String password = "xxxx";
        final String socio = "Luis";
        final String [] isbn = {"11111"};

        final Reserva reserva = new Reserva();
        OperacionStub operacionStub = new OperacionStub();
        operacionStub.setResultado(null);
        Factoria.setOperacion(operacionStub);
        ReservaException exception = assertThrows(ReservaException.class,
                () -> reserva.realizaReserva(login, password, socio, isbn));

        assertEquals("ERROR de permisos", exception.getMessage());
    }

    @Test
    void realizarReservaC2(){
        String login = "ppss";
        final String password = "ppss";
        final String socio = "Luis";
        final String [] isbn = {"11111", "22222"};

        final Reserva reserva = new Reserva();
        OperacionStub operacionStub = new OperacionStub();
        operacionStub.setResultado(null);
        Factoria.setOperacion(operacionStub);
        assertDoesNotThrow(() -> reserva.realizaReserva(login, password, socio, isbn));

    }

    @Test
    void realizarReservaC3(){
        String login = "ppss";
        final String password = "ppss";
        final String socio = "Luis";
        final String [] isbn = {"11111", "33333", "44444"};

        final Reserva reserva = new Reserva();
        OperacionStub operacionStub = new OperacionStub();
        operacionStub.setResultado(null);
        Factoria.setOperacion(operacionStub);
        ReservaException exception = assertThrows(ReservaException.class,
                () -> reserva.realizaReserva(login, password, socio, isbn));

        assertEquals("ISBN invalido:33333;ISBN invalido:44444", exception.getMessage());
    }

    @Test
    void realizarReservaC4(){
        String login = "ppss";
        final String password = "ppss";
        final String socio = "Pepe";
        final String [] isbn = {"11111"};

        final Reserva reserva = new Reserva();
        OperacionStub operacionStub = new OperacionStub();
        operacionStub.setResultado(null);
        Factoria.setOperacion(operacionStub);
        ReservaException exception = assertThrows(ReservaException.class,
                () -> reserva.realizaReserva(login, password, socio, isbn));

        assertEquals("Socio invalido", exception.getMessage());
    }

    @Test
    void realizarReservaC5(){
        String login = "ppss";
        final String password = "ppss";
        final String socio = "Luis";
        final String [] isbn = {"11111", "22222"};

        final Reserva reserva = new Reserva();
        OperacionStub operacionStub = new OperacionStub();
        operacionStub.setResultado(null);
        Factoria.setOperacion(operacionStub);
        ReservaException exception = assertThrows(ReservaException.class,
                () -> reserva.realizaReserva(login, password, socio, isbn));

        assertEquals("CONEXION invalida", exception.getMessage());
    }
}
