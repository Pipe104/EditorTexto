package memento;

public class Memento implements MementoInterfaz {
    private final String contenido;
    private final String fuente;
    private final int size;

    public Memento(String contenido, String fuente, int size) {
        this.contenido = contenido;
        this.fuente = fuente;
        this.size = size;
    }

    public String getContenido() {
        return contenido;
    }

    public String getFuente() {
        return fuente;
    }

    public int getSize() {
        return size;
    }
}
