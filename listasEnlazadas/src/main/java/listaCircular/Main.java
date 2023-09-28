package listaCircular;

public class Main {
    public static void main(String[] args) {
        ListaSimpleCircular<Integer> lista = new ListaSimpleCircular<>();
        lista.agregarInicio(4);
        lista.agregarInicio(1);
        lista.agregarInicio(2);
        lista.agregarInicio(7);
        lista.agregarInicio(5);
        lista.agregarInicio(9);
        lista.agregarInicio(0);

        //9
        int resultado = lista.buscarObjeto(7);
        if(resultado!=-1){
            System.out.println(resultado);
        }else {
            System.out.println("El objeto no fue encontrado");
        }
        lista.insertar(3,3);
        resultado = lista.buscarObjeto(3);
        if(resultado!=-1){
            System.out.println(resultado);
        }else {
            System.out.println("El objeto no fue encontrado");
        }
    }
}
