package prision;

import java.util.ArrayList;
import java.util.List;

public class Piso {

    private int nivel;
    private Espacio[][] piso;
    int numeroPrisioneros = 14;

    public Piso() {
    }

    public ArrayList<Celda> encontrarCeldasVacias(int fila, int columna, ArrayList<Celda> celdasVacias) {
        if (fila <0 || fila >= piso.length || columna <0 || columna >= piso.length){
            return celdasVacias;
        }else if(piso[fila][columna] instanceof Celda){
            if(!piso[fila][columna].isPasada()){
            if(((Celda) piso[fila][columna]).getPrisionero() == null){
                celdasVacias.add((Celda) piso[fila][columna]);
            }
            piso[fila][columna].setPasada(true);
            }
            return celdasVacias;
        }else if(piso[fila][columna]instanceof Pasillo){
            //arriba
            celdasVacias = encontrarCeldasVacias(fila-1,columna,celdasVacias);
            //arriba-derecha
            celdasVacias = encontrarCeldasVacias(fila-1,columna+1,celdasVacias);
            //derecha
            celdasVacias = encontrarCeldasVacias(fila,columna+1,celdasVacias);
            //abajo-derecha
            celdasVacias = encontrarCeldasVacias(fila+1,columna+1,celdasVacias);
            //abajo
            celdasVacias = encontrarCeldasVacias(fila+1,columna,celdasVacias);
            //abajo-izquierda
            celdasVacias = encontrarCeldasVacias(fila+1,columna-1,celdasVacias);
            //izquierda
            celdasVacias = encontrarCeldasVacias(fila,columna-1,celdasVacias);
            //arriba-izquierda
            celdasVacias = encontrarCeldasVacias(fila-1,columna-1,celdasVacias);
        }else{

            System.out.println("error en los parametros de fila o columna");
        }
        return celdasVacias;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Espacio[][] getCeldas() {
        return piso;
    }

    public void setCeldas(Espacio[][] piso) {
        this.piso = piso;
    }

    public int getNumeroPrisioneros() {
        return numeroPrisioneros;
    }

    public void setNumeroPrisioneros(int numeroPrisioneros) {
        this.numeroPrisioneros = numeroPrisioneros;
    }
}
