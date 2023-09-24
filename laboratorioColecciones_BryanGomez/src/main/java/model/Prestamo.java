package model;

import java.util.*;

public class Prestamo {

    private int id;

    private HashMap<Integer,DetallePrestamo> detalles;

    public void agregarDetalle(DetallePrestamo detalle){
        detalles.put(detalle.getId(),detalle);
    }

    public DetallePrestamo obtenerDetallePrestamo(int id) {
        return detalles.get(id);
    }

    public ArrayList<DetallePrestamo> getDetalles() {
        ArrayList<DetallePrestamo> listaDetalles = new ArrayList<>();

        Iterator<Map.Entry<Integer, DetallePrestamo>> iterator = detalles.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, DetallePrestamo> detalle = iterator.next();
            listaDetalles.add(detalle.getValue());
        }

        return listaDetalles;
    }

    public Prestamo() {
        detalles = new HashMap<>();
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
