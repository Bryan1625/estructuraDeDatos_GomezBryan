package parcial1_1;

public class Secuencia {

    static String[] secuencia = {
            "AEDRTYU",
            "FYUIHVG",
            "AYUIHNM",
            "IPUIHOL"
};
    public static void main(String[] args) {
        if(hayRepetidos(0,'a',0)){
            System.out.println("si se repiten mas de 4 caracteres en la diagonal principal");
        }else {
            System.out.println("no se repiten mas de 4 caracteres en la diagonal principal");
        }
    }

    public static boolean hayRepetidos(int i, char letra, int repetidos) {
        if (i >= 0 && i < secuencia.length && i < secuencia[i].length()) {
            if (repetidos == 4) {
                return true;
            } else if (secuencia[i].charAt(i) == letra) {
                return hayRepetidos(i + 1, letra, repetidos + 1);
            } else {
                letra = secuencia[i].charAt(i);
                return hayRepetidos(i + 1, letra, 0);
            }
        }
        return false;
    }

}
