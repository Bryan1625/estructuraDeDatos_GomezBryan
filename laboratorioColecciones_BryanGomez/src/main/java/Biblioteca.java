import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Biblioteca {
    private final String nombre = "Biblioteca";
    private HashMap<Integer, Prestamo> prestamos;
    private TreeSet<Bibliotecario> bibliotecarios;
    private HashSet<Estudiante> estudiantes;

    public void agregarPrestamo(Prestamo prestamo) {
        prestamos.put(prestamo.getId(), prestamo);
    }

    public Prestamo obtenerPrestamo(int id) {
        return prestamos.get(id);
    }

    public void agregarBibliotecario(Bibliotecario b){
        bibliotecarios.add(b);
    }

    public Bibliotecario obtenerBibliotecario(int id){
        for (Bibliotecario b : bibliotecarios) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    public void agregarEstudiante(Estudiante e){
        estudiantes.add(e);
    }

    public Estudiante obtenerEstudiante(int id){
        for (Estudiante e : estudiantes) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public Biblioteca() {
        prestamos = new HashMap<>();
        bibliotecarios = new TreeSet<>();
        estudiantes = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }
}
