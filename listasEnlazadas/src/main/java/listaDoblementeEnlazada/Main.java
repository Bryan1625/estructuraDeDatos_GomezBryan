package listaDoblementeEnlazada;

import listaSimpleGenerica.ListaEnlazadaSimple;

public class Main {
    public static void main(String[] args) {
        ListaDoble<Integer> lista = new ListaDoble<>();
        lista.agregarInicio(1);
        lista.agregarInicio(2);
        lista.agregarInicio(3);
        lista.agregarInicio(4);
        lista.agregarInicio(5);
        ListaDoble<Persona> personas = new ListaDoble<>();
        personas.agregarInicio(new Persona(2314));
        personas.agregarInicio(new Persona(213));
        personas.agregarInicio(new Persona(13351));
        personas.agregarInicio(new Persona(12));
        personas.agregarInicio(new Persona(23142314));
        personas.agregarInicio(new Persona(23145));

        //6
        imprimirHaciaAtras(lista);

        //8
        ListaDoble<Persona> resultado = obtenerPersonasCedulaDigitosPar(personas);
        imprimirListaPersonas(resultado);

    }

    private static ListaDoble<Persona> obtenerPersonasCedulaDigitosPar(ListaDoble<Persona> personas) {
        ListaDoble<Persona> aux = new ListaDoble<>();
        ListaDoble<Persona>.IteradorListaDoble iterator = personas.iteratorListaDoble();
        while (iterator.hasNext()){
            Persona persona = iterator.next();
            if(cantidadDigitosPar(persona.getCedula())){
                aux.agregarInicio(persona);
            }
        }
        return aux;
    }

    public static void imprimirListaPersonas(ListaDoble<Persona> personas){
        for (int i = 0; i < personas.getTamanio(); i++) {
            System.out.println(personas.obtener(i).getCedula()+" ");
        }
    }

    private static void imprimirHaciaAtras(ListaDoble<Integer> lista) {
        ListaDoble<Integer>.IteradorListaDoble iterator = lista.iteratorListaDoble();
        while (iterator.hasPrevious()) {
            Integer elemento = iterator.previous();
            System.out.print(elemento + "\t");
        }
        System.out.println();
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
