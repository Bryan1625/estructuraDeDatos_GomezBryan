package parcial1_2;

public class MultiplicacionDivideYVenceras {

    public static void main(String[] args) {
        int[] arreglo = {1,2,3,4,5,6,7,8,9,10};

        System.out.println(calcularMultiplicacion(0, arreglo.length-1, arreglo));
    }

    public static int calcularMultiplicacion(int inicio, int fin, int[] arreglo){
        if(inicio==fin){
            return arreglo[inicio];
        } else if (inicio < fin) {
            int mitad = (fin+inicio)/2;
            return calcularMultiplicacion(inicio, mitad, arreglo)*calcularMultiplicacion(mitad+1, fin, arreglo);
        }else{
            return 0;
        }
    }
}
