package parcial1_2;

public class Ciudad {

    static String[][] ciudad = {
            {"","","","","","1","",""},
            {"","1","1","","1","1","","1"},
            {"","","1","","","","",""},
            {"1","","","","","1","1",""},
            {"1","","1","1","","1","1",""},
            {"","","","","","","",""},
            {"1","","1","","1","1","","1"}
    };

    public static void main(String[] args) {
        imprimirSolucionMain(5,7);
    }

    public static void imprimirSolucionMain(int i, int j){
        imprimirSolucion(0,0,i,j);
    }

    public static void imprimirSolucion(int i, int j, int iFinal, int jFinal) {
        if(i<0 || j<0 || i>= ciudad.length || j>= ciudad[i].length || ciudad[i][j].contentEquals("1") || ciudad[i][j].contentEquals("0")){
            return;
        } else if (i==iFinal && j==jFinal) {
            ciudad[i][j]="0";
            imprimirMatriz(ciudad);
            System.out.println();
            ciudad[i][j]="";
        } else if (ciudad[i][j].contentEquals("")) {
            ciudad[i][j]="0";
            //derecha,arriba, izquierda, abajo
            imprimirSolucion(i,j+1,iFinal,jFinal);
            imprimirSolucion(i-1,j,iFinal,jFinal);
            imprimirSolucion(i,j-1,iFinal,jFinal);
            imprimirSolucion(i+1,j,iFinal,jFinal);
            ciudad[i][j]="";
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
