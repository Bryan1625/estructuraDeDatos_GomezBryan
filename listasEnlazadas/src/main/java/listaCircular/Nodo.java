package listaCircular;

public class Nodo<T> {

    T valorNodo;
    Nodo<T> siguienteNodo;

    public Nodo(T valorNodo) {
        this.valorNodo = valorNodo;
        this.siguienteNodo = null;
    }

    public T getValorNodo() {
        return valorNodo;
    }

    public Nodo<T> getSiguienteNodo() {
        return siguienteNodo;
    }

    public void setSiguienteNodo(Nodo<T> siguienteNodo) {
        this.siguienteNodo = siguienteNodo;
    }

    public void setValorNodo(T valorNodo) {
        this.valorNodo = valorNodo;
    }
}