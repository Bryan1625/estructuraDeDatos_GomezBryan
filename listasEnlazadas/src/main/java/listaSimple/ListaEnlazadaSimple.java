package listaSimple;

import java.util.ArrayList;

public class ListaEnlazadaSimple {

    Nodo nodoPrimero;
    int tamanio;

    public Nodo getNodoPrimero() {
        return nodoPrimero;
    }

    public void setNodoPrimero(Nodo nodoPrimero) {
        this.nodoPrimero = nodoPrimero;
    }

    public ListaEnlazadaSimple() {
        this.nodoPrimero = null;
        this.tamanio = 0;
    }

    public ListaEnlazadaSimple clonar(){
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();
        Nodo nodoActual = nodoPrimero;

        while (nodoActual != null) {
            lista.agregarFinal(nodoActual.getValorNodo());
            nodoActual = nodoActual.getSiguienteNodo();
        }
        return lista;
    }

    public boolean equivalente(ListaEnlazadaSimple lista){
        boolean aux = true;
        Nodo nodoActual = nodoPrimero;
        Nodo nodoLista = lista.getNodoPrimero();

        if(tamanio==lista.getTamanio()){
        while (nodoActual != null) {
            if(nodoActual.getValorNodo()!=nodoLista.getValorNodo()){
                aux = false;
            }
            nodoActual = nodoActual.getSiguienteNodo();
            nodoLista = nodoLista.getSiguienteNodo();
        }}else{
            aux = false;
        }
        return aux;
    }

    public boolean estaVacia() {
        return nodoPrimero == null;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void agregarInicio(int valorNodo) {
        Nodo nuevoNodo = new Nodo(valorNodo);

        if (estaVacia()) {
            nodoPrimero = nuevoNodo;
        } else {
            nuevoNodo.setSiguienteNodo(nodoPrimero);
            nodoPrimero = nuevoNodo;
        }

        tamanio++;
    }

    public void agregarFinal(int valorNodo) {
        Nodo nuevoNodo = new Nodo(valorNodo);

        if (estaVacia()) {
            nodoPrimero = nuevoNodo;
        } else {
            Nodo nodoActual = nodoPrimero;
            while (nodoActual.getSiguienteNodo() != null) {
                nodoActual = nodoActual.getSiguienteNodo();
            }
            nodoActual.setSiguienteNodo(nuevoNodo);
        }

        tamanio++;
    }

    public boolean buscar(int valor) {
        Nodo nodoActual = nodoPrimero;

        while (nodoActual != null) {
            if (nodoActual.getValorNodo() == valor) {
                // Se encontró el elemento en la lista.
                return true;
            }
            nodoActual = nodoActual.getSiguienteNodo();
        }

        // El elemento no se encontró en la lista.
        return false;
    }

    public void eliminarPorReferencia(int valor) {
        if(buscar(valor)){
            if(nodoPrimero.getValorNodo()== valor){
                nodoPrimero = nodoPrimero.getSiguienteNodo();
            }else{
                Nodo aux = nodoPrimero;

                while(aux.getSiguienteNodo().getValorNodo() != valor){
                    aux = aux.getSiguienteNodo();
                }
                Nodo siguiente = aux.getSiguienteNodo().getSiguienteNodo();
                aux.setSiguienteNodo(siguiente);
            }
            tamanio--;
        }
    }

    public void addAll(ArrayList<Integer> elementos) {
        for (Integer elemento : elementos) {
            agregarInicio(elemento);
        }
    }


    public int getValor(int indice) {
        if (indice < 0 || indice >= tamanio || estaVacia()) {
            throw new IndexOutOfBoundsException("Índice fuera de rango o lista vacía");
        }

        Nodo nodoActual = nodoPrimero;
        int contador = 0;

        while (contador < indice && nodoActual.siguienteNodo != null) {
            nodoActual = nodoActual.getSiguienteNodo();
            contador++;
        }
        return nodoActual.getValorNodo();
    }
}
