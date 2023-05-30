package ppss.ejercicio2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LockIT {

    @Test
    public void unlockOK() {
        ejercicio2.MyClass certificado = new ejercicio2.MyClass();

        certificado.setName("Clave");
        certificado.setId(2);
        certificado.setSecret(5);

        ejercicio2.Lock candado = new ejercicio2.Lock(10);
        Assertions.assertEquals(true, candado.unlock(certificado.calculateKey()));
    }

    @Test
    public void unlockFailed() {
        ejercicio2.MyClass certificado = new ejercicio2.MyClass();

        certificado.setName("Clave");
        certificado.setId(2);
        certificado.setSecret(6);

        ejercicio2.Lock candado = new ejercicio2.Lock(10);
        Assertions.assertEquals(false, candado.unlock(certificado.calculateKey()));
    }
}
