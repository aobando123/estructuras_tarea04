package com.tarea.bplus;

import java.io.Serializable;

/**
 *
 * @author krysthyan
 */
public class Elemento<Clave> implements Serializable{
    private Clave clave;
    private int posicion;

    protected Elemento(Clave clave, int posicion) {
        this.clave = clave;
        this.posicion = posicion;
    }

    public Clave getClave() {
        return clave;
    }

    public void setClave(Clave clave) {
        this.clave = clave;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }


}

