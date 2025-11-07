
package fuentes;

import javax.swing.*;
import java.awt.*;

public class Fuente implements FuenteFlyweight {
    private final String nombre;
    private final int size;

    public Fuente(String nombre, int size) {
        this.nombre = nombre;
        this.size = size;
    }

    @Override
    public void mostrarFuente(JLabel label, String texto) {
        label.setText(texto);
        label.setFont(new Font(nombre, Font.PLAIN, size));
    }
}
