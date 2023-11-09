package binarios;

public class Arbol {
    Nodo raiz;


    public void recorrerPreorden(){
        recorrerPreorden(raiz);
    }

    private void recorrerPreorden(Nodo nodo) {
        if(nodo==null){
            return;
        }else{
            System.out.println(""+nodo);
            recorrerPreorden(nodo.nodoIzquierdo);
            recorrerPreorden(nodo.nodoDerecho);
        }
    }


}
