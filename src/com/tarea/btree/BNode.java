package com.tarea.btree;

public class BNode {

    /**
     * Atributos:
     * int t determina el orden del arbol
     * int count numero de llaves del nodo
     * int[] key arreglo de los valores de la llave
     * BNode[] child arreglo de las referencias
     * boolean leaf si el nodo es arbol o no
     * BNode parent padre del nodo actual
     */
    private int t;
    private int count;
    private final int[] key;
    private BNode[] child;
    private boolean leaf;
    private BNode parent;

    /**
     * Constructor que inicializa las variables
     *
     * @param t      determina el orden del arbol
     * @param parent padre del nodo actual
     */
    public BNode(int t, BNode parent) {
        this.t = t;
        this.parent = parent;
        this.key = new int[2 * t - 1];
        this.child = new BNode[2 * t];
        this.leaf = true;
        this.count = 0;
    }

    /**
     * Get value
     *
     * @param index que retorna una llave especifica
     * @return key[index]
     */
    public int getValue(int index) {
        return this.key[index];
    }

    /**
     * Get count
     *
     * @return count
     */
    public int getCount() {
        return count;
    }

    /**
     * Set count
     *
     * @param count numero de llaves del nodo
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Get key
     *
     * @return key
     */
    public int[] getKey() {
        return key;
    }

    /**
     * Get child
     *
     * @return child
     */
    public BNode[] getChild() {
        return child;
    }

    /**
     * Get child
     *
     * @param index posicion de un hijo
     * @return child[index]
     */
    public BNode getChildIndex(int index) {
        return child[index];
    }

    /**
     * Get leaf
     *
     * @return leaf
     */
    public boolean isLeaf() {
        return leaf;
    }

    /**
     * Set leaf
     *
     * @param leaf hoja del arbol
     */
    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }
}
