package ppss;

import ppss.excepciones.IsbnInvalidoException;

public class OperacionStub extends Operacion{

    Exception resultado;

    public void setResultado(Exception ex){this.resultado = ex;}

    @Override
    public void operacionReserva(String socio, String isbn) {
        try {
            throw resultado;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
