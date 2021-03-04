package com.tarea.gestor;

import com.tarea.btree.BTree;

public class BManager {

    /**
     * Atributos
     */
    private static final BTree tmpTree = new BTree(5);

    /**
     * Constructor por defecto
     */
    public BManager() {
    }

    /**
     * Metodo para insertar en el arbol B
     *
     * @param x valor que se va a insertar
     */
    public void insert(int x) {
        tmpTree.insert(tmpTree, x);
    }

    /**
     * Metodo para mostrar el arbol
     */
    public void print() {
        tmpTree.print();
    }

    /**
     * Metodo para eliminar del arbol
     *
     * @param x
     */
    public void delete(int x) {
        tmpTree.delete(tmpTree, x);
    }
}
