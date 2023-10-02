package polinomio;

import listaSimpleGenerica.Persona;

public class Main {

    public static void main(String[] args) {
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();

        agregarTermino(2, 3, lista);
        agregarTermino(3, 2, lista);
        agregarTermino(1, 0, lista);

        int resultado = calcularResultado(2, lista);
        System.out.println("Resultado para x=2: " + resultado);
    }

    public static void agregarTermino(int coeficiente, int potencia, ListaEnlazadaSimple lista){
        int[] aux ={coeficiente, potencia, 0};
        lista.agregarInicio(aux);
    }

    public static int calcularResultado(int x, ListaEnlazadaSimple lista){
        return lista.getValor(x);
    }

}
