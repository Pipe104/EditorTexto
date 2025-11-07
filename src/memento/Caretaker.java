package memento;

import java.util.Stack;

public class Caretaker {
    private final Stack<MementoInterfaz> historial = new Stack<>();

    public void guardar(MementoInterfaz m) {
        historial.push(m);
    }

    public MementoInterfaz deshacer() {
        if (!historial.isEmpty()) {
            return historial.pop();
        }
        return null;
    }
}
