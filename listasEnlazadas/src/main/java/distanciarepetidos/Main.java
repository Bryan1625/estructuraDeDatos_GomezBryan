package distanciarepetidos;

public class Main {
    public static void main(String[] args) {
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();
        lista.agregarFinal(3);
        lista.agregarFinal(1);
        lista.agregarFinal(2);
        lista.agregarFinal(4);
        lista.agregarFinal(7);
        lista.agregarFinal(1);
        lista.agregarFinal(5);
        lista.agregarFinal(2);
        lista.agregarFinal(8);
        lista.agregarFinal(3);
        lista.agregarFinal(1);

        System.out.println("Lista: ");
        imprimirLista(lista);

        int distancia = obtenerDistanciaMaxima(lista,1);
        System.out.println("Distancia maxima: "+distancia);
    }

    public static int obtenerDistanciaMaxima(ListaEnlazadaSimple lista, int clave){
        return obtenerDistanciaMaximaRecursivo(lista,clave,0,0,0);
    }

    public static int obtenerDistanciaMaximaRecursivo(ListaEnlazadaSimple lista, int clave, int max, int con, int indice){
        if(indice<0 || indice>= lista.getTamanio()){
            return max;
        } else if (max != 0) {
            if(lista.getValor(indice) ==  clave){
                con++;
                if(max < con){
                    max = con;
                }
                con = 0;
            }else{
                con++;
            }
        }else{
            if(lista.getValor(indice) ==  clave){
                max = 1;
            }
        }
        return obtenerDistanciaMaximaRecursivo(lista, clave, max, con, indice+1);
    }

    public static void imprimirLista(ListaEnlazadaSimple lista){
        for (int i = 0; i < lista.getTamanio(); i++) {
            System.out.println(lista.getValor(i)+" ");
        }
    }
}
