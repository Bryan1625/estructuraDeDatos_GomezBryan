package com.example.controladorprocesos.model;

public class Tarea {
    private String nombre;
    private String descripcion;
    private boolean obligatoria;
    private double tiempoMinutos;

    public Tarea(String nombre, String descripcion, boolean obligatoria, double tiempoMinutos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.obligatoria = obligatoria;
        this.tiempoMinutos = tiempoMinutos;
    }

    public Tarea() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isObligatoria() {
        return obligatoria;
    }

    public void setObligatoria(boolean obligatoria) {
        this.obligatoria = obligatoria;
    }

    public double getTiempoMinutos() {
        return tiempoMinutos;
    }

    public void setTiempoMinutos(double tiempoMinutos) {
        this.tiempoMinutos = tiempoMinutos;
    }

    public void realizarTarea(){
        try {
            Thread.sleep((long) (tiempoMinutos * 60000L));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
