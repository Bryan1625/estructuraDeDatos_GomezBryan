package parcial1_1;

import java.util.ArrayList;
import java.util.List;

public class Nodo {

    public static void main(String[] args) {
        List <Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);

        System.out.println(devolverNumero(lista,0));
    }

    private static int devolverNumero(List<Integer> lista, int i) {

        if(lista.isEmpty()){
            return 0;
        } else if (i == lista.size()-1) {
            if(i+1== lista.get(i)){
                return 0;
            } else if (i+1 < lista.get(i)) {
                return 1;
            }else {
                return -1;
            }
        }else{
            return devolverNumero(lista, i+1);
        }
    }
}
