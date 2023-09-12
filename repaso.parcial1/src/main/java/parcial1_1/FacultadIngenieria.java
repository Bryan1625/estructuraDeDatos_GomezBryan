package parcial1_1;

import java.util.ArrayList;
import java.util.List;

public class FacultadIngenieria {
    static String[][] ingenieria = {
            {"","","","","","1","",""},
            {"","1","1","","1","1","","1"},
            {"","","1","","","","",""},
            {"1","","","","","1","1",""},
            {"1","","1","1","","1","1",""},
            {"","","","","","","",""},
            {"1","","1","","1","1","","1"}
    };

    public static void main(String[] args) {
        imprimirSolucionesMain();
    }
    
    public static void imprimirSolucionesMain(){
        imprimirSoluciones(0,0);
    }

    public static void imprimirSoluciones(int i, int j) {
        if(i<0 || j<0 || i>=ingenieria.length || j>=ingenieria[i].length || ingenieria[i][j].contentEquals("1") || ingenieria[i][j].contentEquals("V")){
            return;
        } else if (i==6 && j==6) {
            ingenieria[i][j]="V";
            imprimirMatriz(ingenieria);
            System.out.println();
            ingenieria[i][j]="";
        } else if (ingenieria[i][j].contentEquals("")) {
            ingenieria[i][j]="V";
            //abajo,izquierda,arriba, derecha
            imprimirSoluciones(i+1,j);
            imprimirSoluciones(i,j-1);
            imprimirSoluciones(i-1,j);
            imprimirSoluciones(i,j+1);
            ingenieria[i][j]="";
        }else{
            System.out.println("error en los parametros de fila o columna");
        }
    }


    public static void imprimirMatriz(String[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }


}
