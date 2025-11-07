import fuentes.*;
import memento.*;
import texto.Texto;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        FuenteFlyweight fuenteInicial = FuentesFactory.getFuente("Arial", 14);
        Texto texto = new Texto(fuenteInicial);
        Caretaker caretaker = new Caretaker();

        // Interfaz de botones simple fuera del Originator
        JFrame control = new JFrame("Control de Memento");
        control.setSize(300, 150);
        control.setLayout(new java.awt.FlowLayout());
        control.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btnGuardar = new JButton("Guardar estado");
        JButton btnDeshacer = new JButton("Deshacer");

        btnGuardar.addActionListener(e -> {
            caretaker.guardar(texto.crearMemento());
            System.out.println("Estado guardado.");
        });

        btnDeshacer.addActionListener(e -> {
            MementoInterfaz m = caretaker.deshacer();
            if (m != null) {
                texto.restaurar(m);
                System.out.println("Estado restaurado.");
            } else {
                System.out.println("No hay estados previos.");
            }
        });

        control.add(btnGuardar);
        control.add(btnDeshacer);
        control.setVisible(true);
    }
}
