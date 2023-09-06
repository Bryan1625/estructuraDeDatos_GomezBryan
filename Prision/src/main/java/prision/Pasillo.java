package prision;

public class Pasillo extends Espacio{


    private TipoPasillo tipo;


    public Pasillo(TipoPasillo tipo){

        this.tipo = tipo;
    }

    public Pasillo(){

    }


    public TipoPasillo getTipo() {
        return tipo;
    }

    public void setTipo(TipoPasillo tipo) {
        this.tipo = tipo;
    }
}
