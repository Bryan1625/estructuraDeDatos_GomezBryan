package prision;

import java.util.ArrayList;

public abstract class Espacio {

    private boolean pasada; //booleano para mostrar si la revision ha pasado o no por el espacio

    public Espacio(){
        pasada = false;
    }

    public boolean isPasada() {
        return pasada;
    }

    public void setPasada(boolean pasada) {
        this.pasada = pasada;
    }
}
