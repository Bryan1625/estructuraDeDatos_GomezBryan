package listaSimpleGenerica;

public class Main {

    public static void main(String[] args) {
        ListaEnlazadaSimple<Persona> lista = new ListaEnlazadaSimple<>();
        lista.agregarInicio(new Persona(11111));
        lista.agregarInicio(new Persona(42232));
        lista.agregarInicio(new Persona(3121));
        lista.agregarInicio(new Persona(234321));
        lista.agregarInicio(new Persona(673254));
        lista.agregarInicio(new Persona(1384615));

        ListaEnlazadaSimple<Persona> lista2 = new ListaEnlazadaSimple<>();
        lista2.agregarInicio(new Persona(123413));
        lista2.agregarInicio(new Persona(13324));
        lista2.agregarInicio(new Persona(245353));
        lista2.agregarInicio(new Persona(14235413));
        lista2.agregarInicio(new Persona(123443));
        lista2.agregarInicio(new Persona(436343413));

        //2
        ListaEnlazadaSimple<Persona> resultado = obtenerPersonaCedulaConDigitosPar(lista);
        imprimirListaPersonas(resultado);

        //10
        concatenarListasEnlazadasSimples(lista,lista2);
        imprimirListaPersonas(lista);
    }

    private static void concatenarListasEnlazadasSimples(ListaEnlazadaSimple<Persona> lista, ListaEnlazadaSimple<Persona> lista2) {
        lista.concatenarListas(lista2);
    }

    public static ListaEnlazadaSimple<Persona> obtenerPersonaCedulaConDigitosPar(ListaEnlazadaSimple<Persona> lista){
        ListaEnlazadaSimple<Persona> aux = new ListaEnlazadaSimple<>();
        for (int i = 0; i < lista.getTamanio(); i++) {
            if(cantidadDigitosPar(lista.getValor(i).getCedula())){
                aux.agregarInicio(lista.getValor(i));
            }
        }
        return aux;
    }

    public static void imprimirListaPersonas(ListaEnlazadaSimple<Persona> personas){
        for (int i = 0; i < personas.getTamanio(); i++) {
            System.out.println(personas.getValor(i).getCedula()+" ");
        }
    }

    public static boolean cantidadDigitosPar(int num) {
        int cantidadDigitos = 0;

        while (num != 0) {
            cantidadDigitos++;
            num /= 10;
        }

        return cantidadDigitos % 2 == 0;
    }


}
