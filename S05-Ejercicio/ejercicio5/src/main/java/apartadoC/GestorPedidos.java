package apartadoC;

public class GestorPedidos {

    public Factura generarFactura(Cliente cli, Buscador bus)
            throws FacturaException {
        Factura factura = new Factura();

        int numElems = bus.elemPendientes(cli);
        if (numElems>0) {
            //código para generar la factura
            factura.setIdCliente(cli.getIdCliente());
            float total = cli.getPrecioCliente()*numElems;
            factura.setTotal_factura(total);
        } else {
            throw new FacturaException("No hay nada pendiente de facturar");
        }
        return factura;
    }
}
