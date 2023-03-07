package ppss;

import org.easymock.EasyMock;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.testng.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FicheroTextoTest {

    @Test
    void contarCaracteresC1() {

        FileReader file = EasyMock.strictMock(FileReader.class);

        EasyMock.expect(
                assertDoesNotThrow(() -> file.read())).andReturn(0)
                .andReturn(1)
                .andThrow(new IOException());

        EasyMock.replay(file);

        FicheroTexto ficheroTexto = new FicheroTexto();

        FicheroException exception = assertThrows(FicheroException.class,
                () -> ficheroTexto.contarCaracteres("src/test/resources/ficheroC1.txt"));
        assertEquals("src/test/resources/ficheroC1.txt (Error al leer el archivo)", exception.getMessage());

        EasyMock.verify(file);
    }

    @Test
    void contarCaracteresC2() {

        FileReader file = EasyMock.strictMock(FileReader.class);

        EasyMock.expect(
                assertDoesNotThrow(() -> file.read())).andReturn(0)
                .andReturn(1)
                .andReturn(2)
                .andReturn(-1);

        EasyMock.expect(
                assertDoesNotThrow(() -> file.close())).andThrow(new IOException());

        EasyMock.replay(file);

        FicheroTexto ficheroTexto = new FicheroTexto();

        FicheroException exception = assertThrows(FicheroException.class,
                () -> ficheroTexto.contarCaracteres("src/test/resources/ficheroC1.txt"));
        assertEquals("src/test/resources/ficheroC1.txt (Error al leer el archivo)", exception.getMessage());
    }
}
