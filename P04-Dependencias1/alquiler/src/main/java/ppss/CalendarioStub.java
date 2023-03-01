package ppss;

import java.time.LocalDate;

public class CalendarioStub extends Calendario{

    private Boolean resultado;

    public CalendarioStub(Boolean resultado){
        this.resultado = resultado;
    }

    @Override
    public Boolean es_festivo(LocalDate l){
        return resultado;
    }
}
