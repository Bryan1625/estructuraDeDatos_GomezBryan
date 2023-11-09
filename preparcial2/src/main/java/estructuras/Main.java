package estructuras;

import static estructuras.ListaSimple.imprimirLista;

public class Main {
    public static void main(String[] args) {
        ListaSimple<Integer> listaSimple = new ListaSimple<>();
        listaSimple.agregarFinal(2);
        listaSimple.agregarFinal(3);
        listaSimple.agregarFinal(4);
        listaSimple.agregarFinal(5);
        listaSimple.agregarFinal(6);
        listaSimple.agregarFinal(7);

        listaSimple.invertirContenido(listaSimple);

        imprimirLista(listaSimple);
    }
}
