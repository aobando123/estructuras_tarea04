package com.tarea.gestor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.tarea.bplus.*;

public class BMasGestor<Clave extends Comparable<Clave>,Clase> {
    private ArbolBMas<Clave> arbol;
    private Repositorio<Clase> archivo;

    public BMasGestor(){
        this.arbol = null;
        this.archivo = null;
    }
    public BMasGestor(String path,String nombreArchivo, int separacion) throws ArbolException{
        this.arbol = new ArbolBMas(path,nombreArchivo + ".arb");
        this.archivo = new Repositorio(path,nombreArchivo + ".dat", separacion);
    }

    public BMasGestor(String path,String nombreArbol,String nombreArchivo,int separacion) throws ArbolException{
        this.archivo=new Repositorio(path,nombreArchivo+".dat",separacion);
        this.arbol=new ArbolBMas(path,nombreArbol+".arb");
    }

    public int agregar(Clave clave, Clase objeto) throws SerializadorException, ArbolException{
        Integer existencia = this.arbol.buscar(clave);
        if(existencia == null){
            int pos = archivo.escribir(objeto);
            arbol.agregar(clave, pos);
            return pos;
        }
        else{
            return 0;
        }
    }
    public Boolean agregar(Clave clave,int pos) throws ArbolException, SerializadorException{
        Integer existencia = this.arbol.buscar(clave);
        if(existencia == null){
            arbol.agregar(clave, pos);
            return true;
        }
        else{
            return false;
        }
    }

    public Boolean modificar(Clave clave, Clase objeto) throws SerializadorException{
        Integer existencia = this.arbol.buscar(clave);
        if(existencia != null){
            archivo.Modificar(existencia, objeto);
            return true;
        }
        else{
            return false;
        }
    }

    public Boolean exists(Clave clave) throws SerializadorException{
        Integer existencia = this.arbol.buscar(clave);
        if(existencia != null){
            return true;
        }
        else{
            return false;
        }
    }

    public Clase get(Clave clave) throws SerializadorException{
        Integer existencia = this.arbol.buscar(clave);
        if(existencia != null){
            return archivo.leer(existencia);
        }
        else{
            return null;
        }
    }

    public List<Clase> listar() throws SerializadorException{
        List<Elemento> listaPosicion = this.arbol.listar();
        if(listaPosicion == null){
            return null;
        }
        List<Clase> listaClase = new ArrayList<>();
        for(Elemento elemento: listaPosicion){
            listaClase.add(archivo.leer(elemento.getPosicion()));
        }
        return listaClase;
    }

    public Boolean eliminar(Clave clave) throws ArbolException, IOException, SerializadorException{
        // comprobamos la existencia de la clave en el arbol, el cual nos retorna
        // la posicion dond se encuentra almacenado el obejeto con la clave dada
        Integer existencia = this.arbol.buscar(clave);

        // por lo tanto si lo a encontrado existencia va ser diferente de cero caso contrario no se puede
        // eliminar ya que no existe dicha clave en el arbol.
        if(existencia != null){

            //eliminamos el elemento del arbol con la clave dada
            arbol.eliminar(clave);

            // eliminaos el objeto serializado con la posicion que no ha dado la variable existencia
            archivo.eliminar((int) existencia);
            return true;

        }
        else{
            return false;
        }
    }
}
