package listaSimpleGenerica;

import java.util.ArrayList;
import java.util.List;

public class ListaEnlazadaSimple<T> {

    Nodo nodoPrimero;
    int tamanio;

    public ListaEnlazadaSimple() {
        this.nodoPrimero = null;
        this.tamanio = 0;
    }

    public boolean estaVacia() {
        return nodoPrimero == null;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void agregarInicio(T valorNodo) {
        Nodo<T> nuevoNodo = new Nodo(valorNodo);

        if (estaVacia()) {
            nodoPrimero = nuevoNodo;
        } else {
            nuevoNodo.setSiguienteNodo(nodoPrimero);
            nodoPrimero = nuevoNodo;
        }

        tamanio++;
    }

    public void agregarFinal(int valorNodo) {
        Nodo<T> nuevoNodo = new Nodo(valorNodo);

        if (estaVacia()) {
            nodoPrimero = nuevoNodo;
        } else {
            Nodo<T> nodoActual = nodoPrimero;
            while (nodoActual.getSiguienteNodo() != null) {
                nodoActual = nodoActual.getSiguienteNodo();
            }
            nodoActual.setSiguienteNodo(nuevoNodo);
        }

        tamanio++;
    }

    public boolean buscar(T valor) {
        Nodo<T> nodoActual = nodoPrimero;

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


    public void eliminarPorReferencia(T valor) {
        if(buscar(valor)){
            if(nodoPrimero.getValorNodo()== valor){
                nodoPrimero = nodoPrimero.getSiguienteNodo();
            }else{
                Nodo<T> aux = nodoPrimero;

                while(aux.getSiguienteNodo().getValorNodo() != valor){
                    aux = aux.getSiguienteNodo();
                }
                Nodo<T> siguiente = aux.getSiguienteNodo().getSiguienteNodo();
                aux.setSiguienteNodo(siguiente);
            }
            tamanio--;
        }
    }

    public void addAll(List<T> elementos) {
        for (T elemento : elementos) {
            agregarInicio(elemento);
        }
    }

    public void clear(){
        nodoPrimero = null;
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

    //eliminar nodo por numero o referencia, eliminar posicion

    /*
    agregarInicio
agregarFinal
Agregar //Agregar dado una posición especifica
obtenerValorNodo
obtenerNodo
obtenerPosicionNodo
indiceValido
estaVacia
eliminarPrimero
eliminarUltimo
Eliminar       //Eliminar dado el valor de un nodo
modificarNodo
ordenarLista
imprimirLista
Iterator
borrarLista //borrar toda la lista

     */
}
