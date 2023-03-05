package apartadoA;

public class BuscadorStub extends Buscador{
    int resultado;

    public BuscadorStub(int salida){
        this.resultado = salida;
    }

    @Override
    public int elemPendientes(Cliente cli){
        return resultado;
    }

}
