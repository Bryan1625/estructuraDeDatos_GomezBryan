package prision;

import java.util.ArrayList;
import java.util.List;

import static prision.TipoPasillo.*;

public class Prision {
    private String nombre;
    private List<Piso> pisos;

    public Prision() {
    }

    public ArrayList<Celda> econtrarCeldasVacias(int piso){
        Piso aux = pisos.get(piso);
        Pasillo pasillo;
        int fila =0;
        int columna=0;
        for (int i = 0; i < aux.getCeldas().length; i++) {
            for (int j = 0; j < aux.getCeldas()[i].length; j++) {
                if(aux.getCeldas()[i][j] instanceof Pasillo){
                    if(((Pasillo)aux.getCeldas()[i][j]).getTipo() == entrada){
                        fila = i;
                        columna = j;
                    }
                }
            }
        }

        return aux.encontrarCeldasVacias(fila,columna,new ArrayList<Celda>());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Piso> getPisos() {
        return pisos;
    }

    public void setPisos(List<Piso> pisos) {
        this.pisos = pisos;
    }

    public void agregarPiso(Piso piso){
        pisos.add(piso);
    }

    public void eliminarPiso(Piso piso){
        pisos.remove(piso);
    }


}
