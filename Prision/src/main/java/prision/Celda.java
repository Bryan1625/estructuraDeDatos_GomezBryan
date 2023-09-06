package prision;

import java.util.ArrayList;

public class Celda extends Espacio{
    private Persona prisionero;

    public Celda() {
    }

    public Persona getPrisionero() {
        return prisionero;
    }

    public void setPrisionero(Persona prisionero) {
        this.prisionero = prisionero;
    }
}
