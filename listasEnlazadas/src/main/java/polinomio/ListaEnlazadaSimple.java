package polinomio;

import java.util.List;

public class ListaEnlazadaSimple {

    Nodo nodoPrimero;
    int tamanio;

    public ListaEnlazadaSimple() {
        this.nodoPrimero = null;
        this.tamanio = 0;
    }

    public boolean estaVacia() {
        return nodoPrimero == null;
    }

    public int getintamanio() {
        return tamanio;
    }

    public void agregarInicio(int[] valorNodo) {
        Nodo nuevoNodo = new Nodo(valorNodo);

        if (estaVacia()) {
            nodoPrimero = nuevoNodo;
        } else {
            nuevoNodo.setSiguienteNodo(nodoPrimero);
            nodoPrimero = nuevoNodo;
        }

        tamanio++;
    }

    public Nodo getNodoPrimero() {
        return nodoPrimero;
    }

    public void setNodoPrimero(Nodo nodoPrimero) {
        this.nodoPrimero = nodoPrimero;
    }

    public void setintamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public void concatenarListas(ListaEnlazadaSimple lista2) {
        if (lista2.estaVacia()) {
            return;
        }
        if (estaVacia()) {
            nodoPrimero = lista2.getNodoPrimero();
            tamanio = lista2.getintamanio();
        } else {
            Nodo nodoActual = nodoPrimero;
            while (nodoActual.getSiguienteNodo() != null) {
                nodoActual = nodoActual.getSiguienteNodo();
            }
            nodoActual.setSiguienteNodo(lista2.getNodoPrimero());
            tamanio += lista2.getintamanio();
        }
        lista2.clear();
    }


    public void agregarFinal(int[] valorNodo) {
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

    public void addAll(List<int[]> elementos) {
        for (int[] elemento : elementos) {
            agregarInicio(elemento);
        }
    }

    public void clear(){
        nodoPrimero = null;
    }


    public int getValor(int x) {
        int resultado = 0;
        Nodo nodoActual = nodoPrimero;
        int contador = 0;

        while (nodoActual != null) {
            nodoActual.setValorX(x);
            resultado += nodoActual.getValorNodo();
            nodoActual = nodoActual.getSiguienteNodo();

            contador++;
        }
        return resultado;
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
