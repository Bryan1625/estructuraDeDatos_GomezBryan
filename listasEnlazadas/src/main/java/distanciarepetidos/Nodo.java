package distanciarepetidos;

public class Nodo {

    int valorNodo;
    Nodo siguienteNodo;

    public Nodo(int valorNodo) {
        this.valorNodo = valorNodo;
        this.siguienteNodo = null;
    }

    public int getValorNodo() {
        return valorNodo;
    }

    public Nodo getSiguienteNodo() {
        return siguienteNodo;
    }

    public void setSiguienteNodo(Nodo siguienteNodo) {
        this.siguienteNodo = siguienteNodo;
    }

    public void setValorNodo(int valorNodo) {
        this.valorNodo = valorNodo;
    }
}