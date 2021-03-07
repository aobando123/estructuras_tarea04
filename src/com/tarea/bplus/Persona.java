package com.tarea.bplus;

import java.io.Serializable;


public class Persona implements Serializable{
    private String cedula;
    private String nombre;

    public Persona(String pCedula, String pNombre) {
        this.cedula = pCedula;
        this.nombre = pNombre;

    }

    /**
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param pCedula the cedula to set
     */
    public void setCedula(String pCedula) {
        this.cedula = pCedula;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param pNombre the nombre to set
     */
    public void setNombre(String pNombre) {
        this.nombre = pNombre;
    }

    @Override
    public String toString(){
        return "Cedula :"+this.cedula+" - Nombre:"+this.nombre;
    }
}
