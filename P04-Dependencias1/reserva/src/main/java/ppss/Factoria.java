package ppss;

public class Factoria {
    private static Operacion servicio = null;
    public static Operacion create(){
        if(servicio != null){
            return servicio;
        } else {
            return new Operacion();
        }
    }

    static void setOperacion (Operacion s){
        servicio = s;
    }

}
