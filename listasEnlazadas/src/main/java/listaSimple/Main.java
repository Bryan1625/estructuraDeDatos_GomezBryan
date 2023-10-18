package listaSimple;

import listaSimpleGenerica.Persona;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();
        lista.agregarInicio(1);
        lista.agregarInicio(4);
        lista.agregarInicio(3);
        lista.agregarInicio(3);
        lista.agregarInicio(2);
        lista.agregarInicio(5);
        lista.agregarInicio(7);

        //4
        ListaEnlazadaSimple impares = obtenerImpares(lista);

        //1
        ListaEnlazadaSimple resultado = obtenerPosicionesImpares(lista);
        imprimirLista(resultado);
        //3
        resultado = eliminarPares(lista);
        imprimirLista(resultado);

        imprimirLista(impares);
        System.out.println("lista:");
        imprimirLista(lista);
        System.out.println("invertida");
        imprimirLista(invertirLista(lista));

        int buscado=3;
        System.out.println(obtenerCantidadRepeticiones(lista, buscado)+"");

        if(lista.equivalente(lista))
            System.out.println("correcto");

        if(lista.equivalente(new ListaEnlazadaSimple()))
            System.out.println("incorrecto");
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

    public static void imprimirLista(ListaEnlazadaSimple lista){
        for (int i = 0; i < lista.getTamanio(); i++) {
            System.out.println(lista.getValor(i)+" ");
        }
    }

    public static ListaEnlazadaSimple eliminarPares(ListaEnlazadaSimple lista){
        for (int i = 0; i < lista.getTamanio(); i++) {
            if(lista.getValor(i)%2==0){
                lista.eliminarPorReferencia(i);
            }
        }
        return lista;
    }

    public static ListaEnlazadaSimple obtenerImpares(ListaEnlazadaSimple lista){
        ListaEnlazadaSimple aux = new ListaEnlazadaSimple();
        for (int i = 0; i < lista.getTamanio(); i++) {
            if(lista.getValor(i)%2!=0){
                aux.agregarInicio(lista.getValor(i));
            }
        }
        return aux;
    }

    public static int obtenerCantidadRepeticiones(ListaEnlazadaSimple lista, int n){
        int aux=0;
        for (int i = 0; i < lista.getTamanio(); i++) {
            if(lista.getValor(i)==n){
                aux++;
            }
        }
        return aux;
    }

    public static ListaEnlazadaSimple invertirLista(ListaEnlazadaSimple lista){
        ListaEnlazadaSimple resultado = new ListaEnlazadaSimple();
        for (int i = lista.getTamanio()-1; i >= 0; i--) {
            resultado.agregarFinal(lista.getValor(i));
        }
        return resultado;
    }
}
