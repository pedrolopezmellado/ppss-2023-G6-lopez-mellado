package apartadoA;

public class GestorPedidosTestable extends GestorPedidos{

    BuscadorStub buscador;

    @Override
    public BuscadorStub getBuscador(){
        return buscador;
    }

    public void setBuscador(BuscadorStub b){
        this.buscador = b;
    }
}
