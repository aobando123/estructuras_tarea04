package com.tarea.gestor;

import com.tarea.avltree.AVLTree;

public class AVLManager {

    /**
     * Atributo
     */
    private static final AVLTree tmpTree = new AVLTree();

    /**
     * Constructor por defecto
     */
    public AVLManager() {
    }

    /**
     * Insertar en un arbol AVL
     *
     * @param x valor que se va a insertar
     */
    public void insert(int x) {
        tmpTree.insertAVL(x);
    }

    /**
     * Mostrar en preOrden
     */
    public void preOrden() {
        tmpTree.preOrden();
    }

    /**
     * Mostrar en inOrden
     */
    public void inOrden() {
        tmpTree.inOrden();
    }

    /**
     * Mostrar en postOrden
     */
    public void postOrden() {
        tmpTree.postOrden();
    }
}
