package ppss;

import java.time.LocalDate;

public class AlquilaCochesTestable extends AlquilaCoches{
    protected Calendario calendario = new Calendario();

    IService servicio;

    @Override
    public IService getServicio(){
        return servicio;
    }

    public void serServicio(IService s){
        this.servicio = s;
    }
}
