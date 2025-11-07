package memento;

import java.util.ArrayList;

public class Caretaker {
    private final ArrayList<Memento> historial = new ArrayList<>();

    public void guardar(Memento memento) {
        historial.add(memento);
    }

    public Memento deshacer() {
        if (!historial.isEmpty()) {
            historial.remove(historial.size() - 1);
            if (!historial.isEmpty()) {
                return historial.get(historial.size() - 1);
            }
        }
        return null;
    }

    public boolean tieneHistorial() {
        return !historial.isEmpty();
    }
}
