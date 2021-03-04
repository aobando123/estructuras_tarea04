package com.tarea.avltree;

public class AVLNode {

    /**
     * Atributos:
     * int data es el valor que se va a guardar en el arbol.
     * int bf factor de equilibrio del arbol.
     * AVLNode left hijo izquierdo del arbol.
     * AVLNode right hijo derecho del arbol
     */
    private int data, bf;
    private AVLNode letf, right;

    /**
     * Constructor que inicializa data
     *
     * @param data dato que se va a insertar en el arbol
     */
    public AVLNode(int data) {
        this.data = data;
        this.bf = 0;
        this.letf = null;
        this.right = null;
    }

    /**
     * Get data
     *
     * @return data
     */
    public int getData() {
        return data;
    }

    /**
     * Get bf
     *
     * @return bf
     */
    public int getBf() {
        return bf;
    }

    /**
     * Set bf
     *
     * @param bf factor de equilibrio del arbol
     */
    public void setBf(int bf) {
        this.bf = bf;
    }

    /**
     * Get left
     *
     * @return left
     */
    public AVLNode getLetf() {
        return letf;
    }

    /**
     * Set left
     *
     * @param letf hijo izquierdo del arbol
     */
    public void setLetf(AVLNode letf) {
        this.letf = letf;
    }

    /**
     * Get right
     *
     * @return right
     */
    public AVLNode getRight() {
        return right;
    }

    /**
     * Set right
     *
     * @param right hijo derecho del arbol
     */
    public void setRight(AVLNode right) {
        this.right = right;
    }
}
