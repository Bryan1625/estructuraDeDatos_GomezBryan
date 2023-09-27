package listaSimpleGenerica;

public class Main {

    public static void main(String[] args) {
        ListaEnlazadaSimple<Integer> lista = new ListaEnlazadaSimple<>();
        lista.agregarInicio(1);
        lista.agregarInicio(4);
        lista.agregarInicio(3);
        lista.agregarInicio(2);
        lista.agregarInicio(5);
        lista.agregarInicio(7);

        System.out.println(lista.getValor(3));

        ListaEnlazadaSimple<Integer> resultado = obtenerPosicionesImpares(lista);
    }

    private static ListaEnlazadaSimple<Integer> obtenerPosicionesImpares(ListaEnlazadaSimple<Integer> lista){
        ListaEnlazadaSimple<Integer> aux = new ListaEnlazadaSimple<>();
        for (int i = 0; i < lista.getTamanio(); i++) {
            if(i%2!=0){
                aux.agregarFinal(lista.getValor(i));
            }
        }
        return aux;
    }
}
