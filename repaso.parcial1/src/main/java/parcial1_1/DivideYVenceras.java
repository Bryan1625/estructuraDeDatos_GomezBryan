package parcial1_1;

public class DivideYVenceras {

    public static void main(String[] args) {
        int[] arreglo = {0,0,1,0,2,0};
        int ceros = comprobarCeros(0,0, arreglo);
        System.out.println(ceros);
        System.out.println(contarCerosDivideYVenceras(arreglo,0, arreglo.length-1));
    }

    private static int comprobarCeros(int i, int ceros, int[] arreglo) {
        if(i<0 || i>= arreglo.length){
            return ceros;
        }else if (arreglo[i]==0){
            return comprobarCeros(i+1, ceros+1, arreglo);
        }else{
            return comprobarCeros(i+1, ceros, arreglo);
        }
    }


    private static int contarCerosDivideYVenceras(int[] arreglo, int inicio, int fin) {
        if (inicio == fin) {
            if (arreglo[inicio] == 0) {
                return 1;
            } else {
                return 0;
            }
        } else if (inicio < fin) {
            int mitad = (inicio + fin) / 2;
            int cerosIzquierda = contarCerosDivideYVenceras(arreglo, inicio, mitad);
            int cerosDerecha = contarCerosDivideYVenceras(arreglo, mitad + 1, fin);
            return cerosIzquierda + cerosDerecha;
        } else {
            return 0;
        }
    }
}
