package zoologico;

import java.util.ArrayList;
import java.util.List;

public class Zoologico<A, P> {
    ArrayList<A> animales = new ArrayList<>();
    ArrayList<P> personas = new ArrayList<>();

    public void addAnimal(A animal){
        animales.add(animal);
    }

    //solo pueden ladrar los perros y hay solo una lista de animales
    public String ladrar(List<? extends Perro> lista){
        String ladridos="";
        for (Perro perro:lista) {
            ladridos += perro.ladrar();
        }
        return ladridos;
    }

    /*
    si a es mayo que b, entonces se retorna a, de lo contrario se retorna b
    public T max(){
        return (a>b) ? a:B;
     */
}
