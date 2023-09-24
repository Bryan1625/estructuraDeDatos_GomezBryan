import java.util.HashMap;

public class Prestamo {

    private int id;

    private HashMap<Integer,DetallePrestamo> detalles;

    public void agregarDetalle(DetallePrestamo detalle){
        detalles.put(detalle.getId(),detalle);
    }

    public DetallePrestamo obtenerDetallePrestamo(int id) {
        return detalles.get(id);
    }

    public Prestamo() {
    }

    public Prestamo (int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }
}
