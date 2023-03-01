package ppss.ejercicio1;

import java.util.Calendar;

public class GestorLlamadasTestable extends GestorLlamadas{

    private static final double TARIFA_NOCTURNA=10.5;
    private static final double TARIFA_DIURNA=20.8;

    int hora;

    public GestorLlamadasTestable(int hora){
        this.hora = hora;
    }

    @Override
    public int getHoraActual(){
        return hora;
    }

}
