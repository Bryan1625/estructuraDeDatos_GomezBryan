package prision;

import java.util.ArrayList;

import static prision.TipoPasillo.*;

public class Main {

    public static void main(String[] args) {
        Prision prision = new Prision();
        prision.setPisos(new ArrayList<>());
        Espacio[][] piso1 = new Espacio[5][6];
        llenarPiso(piso1);
        Piso piso = new Piso();
        piso.setNivel(1);
        piso.setCeldas(piso1);
        prision.agregarPiso(piso);
        ArrayList <Celda> celdasVacias = encontrarCeldasVaciasMain(prision);
        System.out.println("se encontraron "+celdasVacias.size()+" celdas vacias.");
    }


    public static ArrayList<Celda> encontrarCeldasVaciasMain(Prision prision){
        return prision.econtrarCeldasVacias(0);
    }
    public static void llenarPiso(Espacio[][] piso){
        for (int i = 0; i < piso.length; i++) {
            for (int j = 0; j < piso[i].length; j++) {
                if (j==0){
                    if (i<5){
                    Celda celda = new Celda();
                    celda.setPrisionero(new Persona());
                    piso[i][j] = celda;
                    }
                }else if(i == 0){
                    if(j<4){
                        Celda celda = new Celda();
                        celda.setPrisionero(new Persona());
                        piso[i][j] = celda;
                    }
                }else if(j==4){
                    if(i<2){
                        Celda celda = new Celda();
                        celda.setPrisionero(new Persona());
                        piso[i][j] = celda;
                    }
                }else if(j==2){
                    if (i>1){
                        Celda celda = new Celda();
                        celda.setPrisionero(new Persona());
                        piso[i][j] = celda;
                    }
                }else{
                    Pasillo pasillo = new Pasillo();
                    if(j==0 && i==4){
                        pasillo.setTipo(entrada);
                        piso[i][j] = pasillo;
                    } else if (i==0 && j==5) {
                        pasillo.setTipo(salida);
                        piso[i][j] = pasillo;
                    }else{
                        pasillo.setTipo(normal);
                        piso[i][j] = pasillo;
                    }
                }
            }
        }
        Celda celda = new Celda();
        celda.setPrisionero(new Persona());
        piso[4][3] = celda;
        celda.setPrisionero(null);
        piso[0][0] = celda;
    }
}
