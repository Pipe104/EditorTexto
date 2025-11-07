
package fuentes;
import java.util.HashMap;
import java.util.Map;

public class FuentesFactory {
    private static final Map<String, Fuente> fuentes = new HashMap<>();

    public static Fuente getFuente(String nombre, int size) {

        String key = nombre + "-" + size;
        Fuente fuente = fuentes.get(key);

        //Comprueba si ya existe la fuente para no crear una fuente igual
        if (fuente == null) {
            fuente = new Fuente(nombre, size);
            fuentes.put(key, fuente);
            System.out.println("Fuente creada y agregada: " + key);
        } else {
            System.out.println("Fuente reutilizada desde: " + key);
        }

        return fuente;
    }
}