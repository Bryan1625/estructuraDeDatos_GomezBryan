package estructuras;

public class ListaSimple<T> {
    private Nodo<T> nodoPrimero;
    private int tamanio;

    public Nodo<T> getNodoPrimero() {
        return nodoPrimero;
    }

    public void setNodoPrimero(Nodo<T> nodoPrimero) {
        this.nodoPrimero = nodoPrimero;
    }

    public static void imprimirLista(ListaSimple<Integer> lista){
        for (int i = 0; i < lista.getTamanio(); i++) {
            System.out.println(lista.getValor(i)+" ");
        }
    }

    public boolean estaVacia() {
        return nodoPrimero == null;
    }

    public T getValor(int indice) {
        if (indice < 0 || indice >= tamanio || estaVacia()) {
            throw new IndexOutOfBoundsException("Índice fuera de rango o lista vacía");
        }

        Nodo<T> nodoActual = nodoPrimero;
        int contador = 0;

        while (contador < indice) {
            nodoActual = nodoActual.getSiguienteNodo();
            contador++;
        }
        return nodoActual.getValorNodo();
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

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


    public void invertirContenido(ListaSimple<T> lista){
        lista.invertirContenidoRecursivo(0,lista.nodoPrimero);
    }

    public void invertirContenidoRecursivo(int i, Nodo<T> nodoP){
        Nodo<T> nodo = nodoP;
        if(tamanio <= 1){
            return;
        }else if(i<tamanio && i>0){
            nodo = nodo.getSiguienteNodo();
            invertirContenidoRecursivo(i+1,nodo);
            nodo.setSiguienteNodo(nodoP);
        } else if (i == 0) {
            nodo = nodo.getSiguienteNodo();
            invertirContenidoRecursivo(i+1,nodo);
            nodo.siguienteNodo = null;
        }
    }
}
