package parcial1_1;

public class Secuencia {

    static String[] secuencia = {
            "AEDRTYU",
            "FYUIHVG",
            "AYUIHNM",
            "IPUIHOL"
};
    public static void main(String[] args) {
        if(hayRepetidos(0,0,true,'a')){
            System.out.println("si hay");
        }else {
            System.out.println("no hay");
        }
    }

    public static boolean hayRepetidos(int i, int j, boolean aux, char letra){
        if(secuencia[i].length()<=secuencia[j].charAt(i) || aux==false){
            return false;
        } else if (i==0 && j==0) {
            letra = secuencia[j].charAt(i);
        } else if (i>=0 && j>=0) {
            if(secuencia[j].charAt(i)==letra){
                aux = true;
                return hayRepetidos(i,j,aux,letra);
            }else{
                return false;
            }
        }else {
            System.out.println("error en los indices suministrados");
        }
    return aux;
    }
}
