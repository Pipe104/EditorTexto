import fuentes.*;
import texto.Texto;

public class Main {
    public static void main(String[] args) {
        FuenteFlyweight fuenteInicial = FuentesFactory.getFuente("Arial", 14);
        new Texto(fuenteInicial);
    }
}
