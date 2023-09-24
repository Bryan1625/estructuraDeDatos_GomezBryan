package cajaObjetos;

import javax.management.modelmbean.InvalidTargetObjectTypeException;
import java.util.ArrayList;
import java.util.List;

public class Caja<T extends Comparable<T>> {

    List<T> caja;

    public void agregarObjeto(T objeto){
        caja.add(objeto);
    }

    public void eliminarObjeto(T objeto){
        if(caja.contains(objeto)){
            caja.remove(objeto);
        }else{
            System.out.println("el objeto no se encuentra en la caja");
        }
    }
    public void remove(int index){
        caja.remove(index);
    }

    public void recorrer(){
        for (int i = 0; i < caja.size(); i++) {
            if(caja.get(i) instanceof String){
                String aux = (String) caja.get(i);
            }
        }
    }

    public Caja() {
        caja = new ArrayList<>();
    }

    public List<T> getCaja() {
        return caja;
    }

    public void setCaja(List<T> caja) {
        this.caja = caja;
    }
}
