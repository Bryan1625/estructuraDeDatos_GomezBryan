package distanciarepetidos;

import listaSimple.Nodo;

import java.util.ArrayList;

public class ListaEnlazadaSimple {

    Nodo nodoPrimero;
    int tamanio;
    int clave;

    public ListaEnlazadaSimple() {
        this.nodoPrimero = null;
        this.tamanio = 0;
        clave = 0;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
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

        while (contador < indice) {
            nodoActual = nodoActual.getSiguienteNodo();
            contador++;
        }
        return nodoActual.getValorNodo();
    }
}
