package estructuras;

public class ListaSimple<T> {
    private Nodo<T> nodoPrimero;
    private int tamanio;

    public ListaSimple() {
        nodoPrimero = null;
        tamanio = 0;
    }

    public void agregarInicio(T valor) {
        Nodo<T> nodo;
        if(nodoPrimero == null){
            nodoPrimero = new Nodo<>(valor);
        }else{
            nodo = new Nodo<>(valor);
            nodo.setSiguienteNodo(nodoPrimero);
            nodoPrimero = nodo;
        }
    }

    public void agregarFinal(T valor) {
        Nodo<T> nodo;
        if(nodoPrimero == null){
            nodoPrimero = new Nodo<>(valor);
        }else{
            nodo = nodoPrimero;
            while(nodo.getSiguienteNodo() != null){
                nodo = nodo.getSiguienteNodo();
            }
            nodo.setSiguienteNodo(new Nodo<>(valor));
        }
    }

}
