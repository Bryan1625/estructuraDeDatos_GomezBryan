package polinomio;

public class Nodo {

    int[] valorNodo;
    Nodo siguienteNodo;

    public Nodo(int[] valorNodo) {
        this.valorNodo = valorNodo;
        this.siguienteNodo = null;
    }

    public void setCoeficiente(int c){
        valorNodo[0] = c;
    }
    public int getCoeficiente(){
        return valorNodo[0];
    }

    public int getPotencia(){
        return valorNodo[1];
    }

    public void setPotencia(int p){
        valorNodo[1] = p;
    }
    public void setValorX(int x){
        valorNodo[2] = x;
    }

    public int getValorX(){
        return valorNodo[2];
    }

    public String getTermino(){
        int coeficiente = getCoeficiente();
        String signo = (coeficiente < 0) ? "-" : "+";
        return signo + Math.abs(coeficiente) + "(" + getValorX() + ")" + getPotencia();
    }


    public int getValorNodo() {
        return (int) (valorNodo[0]*Math.pow(valorNodo[2],valorNodo[1]));
    }

    public Nodo getSiguienteNodo() {
        return siguienteNodo;
    }

    public void setSiguienteNodo(Nodo siguienteNodo) {
        this.siguienteNodo = siguienteNodo;
    }

    public void setValorNodo(int[] valorNodo) {
        this.valorNodo = valorNodo;
    }
}