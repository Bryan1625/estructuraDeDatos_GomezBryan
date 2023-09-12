package parcial1_2;

import static parcial1_2.Ciudad.imprimirMatriz;

public class Transpuesta {

    public static void main(String[] args) {
        String[][] matriz = {
                {"1","3","5","7"},
                {"2","4","6","8"}
        };
        String[][] resultado = new String[1][1];
        imprimirMatriz(devolverTranspuesta(matriz, 0, 0, resultado));
    }


    public static String[][] devolverTranspuesta(String[][] matriz, int i, int j, String[][] resultado){
        if (i==0 && j==0) {
            resultado= new String[matriz[i].length][matriz.length];
            resultado[j][i]= matriz[i][j];
        } else if (i<0 || j<0 || i>=matriz.length || j>=matriz[i].length) {
            return resultado;
        } else{
            resultado[j][i]= matriz[i][j];
            if(i==matriz.length-1){
                return devolverTranspuesta(matriz, 0, j+1, resultado);
            }else{
                return devolverTranspuesta(matriz, i+1, j, resultado);
            }
        }
        return devolverTranspuesta(matriz, i+1, j, resultado);
    }
}
