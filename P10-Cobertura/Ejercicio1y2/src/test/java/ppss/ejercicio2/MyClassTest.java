package ppss.ejercicio2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyClassTest {

    @Test
    public void calcularKeyOK() {
        ejercicio2.MyClass myclass = new ejercicio2.MyClass();

        myclass.setId(2);
        myclass.setSecret(5);
        myclass.setName("My secret key");

        Assertions.assertEquals(myclass.calculateKey(),10);
    }

}
