package mediaydesviacion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();
        agregarElementosArchivo(lista);
        double media = calcularMedia(lista);
        double desviacion = calcularDesviacionEstandar(lista, media);
        System.out.println("Lista:");
        imprimirLista(lista);
        System.out.println("media: "+media);
        System.out.println("desviacion estandar: "+desviacion);
    }

    private static double calcularDesviacionEstandar(ListaEnlazadaSimple lista, double media) {
        double desviacion = calcularDesviacion(lista, media);
        return Math.sqrt(desviacion);
    }

    private static double calcularDesviacion(ListaEnlazadaSimple lista, double media) {
        double sumatoria = 0;
        for (int i = 0; i < lista.getTamanio(); i++) {
            double valor = lista.getValor(i)-media;
            sumatoria += Math.pow(valor,2);
        }
        return sumatoria/ (lista.getTamanio()-1);
    }


    private static double calcularMedia(ListaEnlazadaSimple lista) {
        int sumatoria = 0;
        for (int i = 0; i < lista.getTamanio(); i++) {
            sumatoria += lista.getValor(i);
        }
        return (sumatoria+0.0)/(lista.getTamanio()+0.0);
    }

    public static void imprimirLista(ListaEnlazadaSimple lista){
        for (int i = 0; i < lista.getTamanio(); i++) {
            System.out.println(lista.getValor(i)+" ");
        }
    }

    public static void agregarElementosArchivo(ListaEnlazadaSimple listaEnlazada){
        File archivo = new File("src/main/java/mediaydesviacion/numeros.txt");
        String contenido= "";
        try {
            Scanner scanner = new Scanner(archivo);

            while (scanner.hasNext()){
                contenido += scanner.nextLine();
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        String[] texto = contenido.split(",");
        ArrayList<Integer> lista = obtenerNumeros(texto);
        listaEnlazada.addAll(lista);
    }

    public static ArrayList<Integer> obtenerNumeros(String[] texto){
        ArrayList<Integer> numeros = new ArrayList<>();
        for (int i = 0; i < texto.length; i++) {
            numeros.add(Integer.parseInt(texto[i]));
        }
        return numeros;
    }
}
