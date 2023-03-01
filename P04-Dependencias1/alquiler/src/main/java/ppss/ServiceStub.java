package ppss;

public class ServiceStub implements IService{
    float resultado;

    public ServiceStub(int salida){
        this.resultado = salida;
    }

    @Override
    public float consultaPrecio(TipoCoche tipo){
        return resultado;
    }
}
