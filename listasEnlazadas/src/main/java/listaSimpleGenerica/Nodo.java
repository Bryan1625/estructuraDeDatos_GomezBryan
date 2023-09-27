package listaSimpleGenerica;

public class Nodo<T> {

    T valorNodo;
    Nodo siguienteNodo;

    public Nodo(T valorNodo) {
        this.valorNodo = null;
        this.siguienteNodo = null;
    }

    public T getValorNodo() {
        return valorNodo;
    }

    public Nodo getSiguienteNodo() {
        return siguienteNodo;
    }

    public void setSiguienteNodo(Nodo siguienteNodo) {
        this.siguienteNodo = siguienteNodo;
    }

    public void setValorNodo(T valorNodo) {
        this.valorNodo = valorNodo;
    }
}