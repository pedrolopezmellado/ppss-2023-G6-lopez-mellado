package ppss;

import org.testng.annotations.Test;

import java.time.LocalDate;

import static org.testng.AssertJUnit.assertEquals;

public class AlquilaCochesTest {

    @Test
    void calculaPrecioC1() throws MensajeException, CalendarioException {

        LocalDate fechaInicio = LocalDate.of(2023, 5, 10);
        int dias = 10;
        Ticket resultado = new Ticket();
        resultado.setPrecio_final(75);

        AlquilaCochesTestable alquila = new AlquilaCochesTestable();
        CalendarioStub calendario = new CalendarioStub(false);
        alquila.calendario = calendario;
        ServiceStub service = new ServiceStub(10);
        alquila.serServicio(service);

        assertEquals(resultado, alquila.calculaPrecio(TipoCoche.TURISMO, fechaInicio, dias));

    }

    @Test
    void calculaPrecioC2() throws MensajeException, CalendarioException {

        LocalDate fechaInicio = LocalDate.of(2023, 6, 19);
        int dias = 7;
        Ticket resultado = new Ticket();
        resultado.setPrecio_final(62.5F);

        AlquilaCochesTestable alquila = new AlquilaCochesTestable();
        CalendarioStub calendario = new CalendarioStub(false);
        alquila.calendario = calendario;
        ServiceStub service = new ServiceStub(10);
        alquila.serServicio(service);

        assertEquals(resultado, alquila.calculaPrecio(TipoCoche.CARAVANA, fechaInicio, dias));

    }

    @Test
    void calculaPrecioC3() throws MensajeException, CalendarioException {

        LocalDate fechaInicio = LocalDate.of(2023, 4, 17);
        int dias = 8;
        Ticket resultado = new Ticket();
        resultado.setPrecio_final(62.5F);

        AlquilaCochesTestable alquila = new AlquilaCochesTestable();
        CalendarioStub calendario = new CalendarioStub(false);
        alquila.calendario = calendario;
        ServiceStub service = new ServiceStub(10);
        alquila.serServicio(service);

        assertEquals(resultado, alquila.calculaPrecio(TipoCoche.CARAVANA, fechaInicio, dias));

    }
}
