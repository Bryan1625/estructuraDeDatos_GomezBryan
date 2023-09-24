package model;

public class Bibliotecario extends Persona implements Comparable<Bibliotecario>{


    @Override
    public int compareTo(Bibliotecario o) {
        if(getId()<o.getId()){
            return 1;
        }else{
            return -1;
        }
    }

}
