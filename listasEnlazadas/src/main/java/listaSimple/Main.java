package listaSimple;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();
        lista.agregarInicio(1);
        lista.agregarInicio(4);
        lista.agregarInicio(3);
        lista.agregarInicio(2);
        lista.agregarInicio(5);
        lista.agregarInicio(7);

        System.out.println(lista.getValor(3));

        ListaEnlazadaSimple resultado = obtenerPosicionesImpares(lista);
    }

    private static ListaEnlazadaSimple obtenerPosicionesImpares(ListaEnlazadaSimple lista){
        ListaEnlazadaSimple aux = new ListaEnlazadaSimple();
        for (int i = 0; i < lista.getTamanio(); i++) {
            if(i%2!=0){
                aux.agregarFinal(lista.getValor(i));
            }
        }
        return aux;
    }
}
