package texto;

import fuentes.*;
import memento.*;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class Texto {
    private String contenido = "";
    private JLabel label;
    private JFrame frame;
    private JTextPane editorTexto;
    private String fuenteActual = "Arial";
    private int size = 10;

    private final Caretaker caretaker = new Caretaker();

    public Texto(FuenteFlyweight fuente) {
        inicializarFrame(fuente);
    }

    private void inicializarFrame(FuenteFlyweight fuenteInicial) {
        frame = new JFrame("Editor con Flyweight y Memento");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));

        editorTexto = new JTextPane();
        editorTexto.setPreferredSize(new Dimension(600, 200));
        editorTexto.setFont(new Font("Arial", Font.PLAIN, 14));
        editorTexto.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        JScrollPane scrollPane = new JScrollPane(editorTexto);
        scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);

        label = new JLabel(contenido, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, size));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Boton Guardar 
        JButton btnGuardar = new JButton("Guardar estado");
        btnGuardar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnGuardar.addActionListener(e -> guardar());

        // Boton Deshacer
        JButton btnDeshacer = new JButton("Deshacer");
        btnDeshacer.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnDeshacer.addActionListener(e -> restaurar());

        panelCentral.add(Box.createVerticalGlue());
        panelCentral.add(scrollPane);
        panelCentral.add(Box.createVerticalStrut(10));
        panelCentral.add(btnGuardar);
        panelCentral.add(Box.createVerticalStrut(10));
        panelCentral.add(btnDeshacer);
        panelCentral.add(Box.createVerticalStrut(20));
        panelCentral.add(label);
        panelCentral.add(Box.createVerticalGlue());
        frame.add(panelCentral, BorderLayout.CENTER);

        // Panel inferior de fuente y size 
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.Y_AXIS));

        JPanel panelFuentes = new JPanel(new FlowLayout());
        panelFuentes.add(new JLabel("Cambiar Fuente:"));
        String[] fuentes = {"Arial", "Times New Roman", "Courier New"};
        for (String nombreFuente : fuentes) {
            JButton btn = new JButton(nombreFuente);
            btn.addActionListener(e -> cambiarFuente(nombreFuente));
            panelFuentes.add(btn);
        }

        JPanel panelSize = new JPanel(new FlowLayout());
        panelSize.add(new JLabel("Cambiar tamaño:"));
        int[] sizes = {10, 20, 30};
        for (int s : sizes) {
            JButton btnSize = new JButton(String.valueOf(s));
            btnSize.addActionListener(e -> cambiarSize(s));
            panelSize.add(btnSize);
        }

        panelInferior.add(panelFuentes);
        panelInferior.add(panelSize);
        frame.add(panelInferior, BorderLayout.SOUTH);

        fuenteInicial.mostrarFuente(label, contenido);
        frame.setVisible(true);
    }

    private void cambiarFuente(String nombreFuente) {
        this.fuenteActual = nombreFuente;
        aplicarCambios();
    }

    private void cambiarSize(int size) {
        this.size = size;
        aplicarCambios();
    }

    private void aplicarCambios() {
        contenido = editorTexto.getText();
        Fuente fuente = FuentesFactory.getFuente(fuenteActual, size);
        fuente.mostrarFuente(label, contenido);
        aplicarEstiloEditor();
    }

    private void aplicarEstiloEditor() {
        StyledDocument doc = editorTexto.getStyledDocument();
        SimpleAttributeSet attrs = new SimpleAttributeSet();
        StyleConstants.setFontFamily(attrs, fuenteActual);
        StyleConstants.setFontSize(attrs, size);
        doc.setCharacterAttributes(0, doc.getLength(), attrs, false);
    }

   

    public void guardar() {
        contenido = editorTexto.getText();
        Memento m = new Memento(contenido, fuenteActual, size);
        caretaker.guardar(m);
        System.out.println("Estado guardado: " + fuenteActual + ", tamaño " + size);
    }

    public void restaurar() {
        Memento m = caretaker.deshacer();
        if (m != null) {
            this.contenido = m.getContenido();
            this.fuenteActual = m.getFuente();
            this.size = m.getSize();
            editorTexto.setText(contenido);
            aplicarCambios();
            System.out.println("Estado restaurado: " + fuenteActual + ", tamaño " + size);
        } else {
            System.out.println("No hay estados previos para deshacer.");
        }
    }
}
