package com.tarea.btree;

public class BTree {

    /**
     * Atributos:
     * int order orden del arbol
     * int root to-do el arbol tiene una raiz
     */
    private int order; //Orden del arbol
    private BNode root; //To  do arbol tiene una raiz

    /**
     * Constructor que inicializa el orden del arbol
     *
     * @param order del arbol
     */
    public BTree(int order) {
        this.order = order;
        root = new BNode(order, null);
    }

    /**
     * Metodo recursivo de busqueda de una llave
     *
     * @param root raiz del arbol
     * @param key  valor de la llave
     * @return root/null/search
     */
    private BNode search(BNode root, int key) {
        int i = 0;
        while (i < root.getCount() && key > root.getKey()[i]) {
            i++;
        }
        if (i <= root.getCount() && key == root.getKey()[i]) {
            return root;
        }
        if (root.isLeaf()) {
            return null;
        } else {
            return search(root.getChildIndex(i), key);
        }
    }

    /**
     * Metodo de division del arbol
     *
     * @param x nodo de referencia
     * @param i valor de la llave
     * @param y nodo de referencia
     */
    public void split(BNode x, int i, BNode y) {
        BNode z = new BNode(order, null);
        z.setLeaf(y.isLeaf());
        z.setCount(order - 1);
        for (int j = 0; j < order - 1; j++) {
            z.getKey()[j] = y.getKey()[j + order];
        }
        if (!y.isLeaf()) {
            for (int k = 0; k < order; k++) {
                z.getChild()[k] = y.getChild()[k + order];
            }
        }
        y.setCount(order - 1);
        for (int j = x.getCount(); j > i; j++) {
            x.getChild()[j + 1] = x.getChild()[j];
        }
        x.getChild()[i + 1] = z;
        for (int j = x.getCount(); j > i; j--) {
            x.getKey()[j + 1] = x.getKey()[j];
        }
        y.getKey()[i] = y.getKey()[order - 1];
        y.getKey()[order - 1] = 0;
        for (int j = 0; j < order - 1; j++) {
            y.getKey()[j + order] = 0;
        }
        x.setCount(x.getCount() + 1);
    }

    /**
     * Metodo publico insertar
     *
     * @param t   arbol donde se va insertar
     * @param key valor de la llave
     */
    public void insert(BTree t, int key) {
        BNode r = t.root;
        if (r.getCount() == 2 * order - 1) { //Si esta lleno
            BNode s = new BNode(order, null); //Nuevo nodo
            //Comienzo para inicializar el nodo
            t.root = s;
            s.setLeaf(false);
            s.setCount(0);
            s.getChild()[0] = r;
            //Fin de la inicializacion del nodo
            split(s, 0, r); //Dividimos la raiz
            insertRecursive(s, key); //Llamamos el metodo de insertar
        } else {
            insertRecursive(r, key); //Llamamos el metodo de insertar
        }
    }

    /**
     * Metodo recursivo de insertar en el arbol
     *
     * @param x   nodo de referencia
     * @param key valor de la llave
     */
    private void insertRecursive(BNode x, int key) {
        int i = x.getCount();
        if (x.isLeaf()) {
            while (i > 1 && key < x.getKey()[i - 1]) {
                x.getKey()[i] = x.getKey()[i - 1];
                i--;
            }
            x.getKey()[i] = key;
            x.setCount(x.getCount() + 1);
        } else {
            int j = 0;
            while (j < x.getCount() && key > x.getKey()[j]) {
                j++;
            }
            if (x.getChildIndex(j).getCount() == order * 2 - 1) {
                split(x, j, x.getChildIndex(j));
                if (key > x.getKey()[j]) {
                    j++;
                }
            }
            insertRecursive(x.getChildIndex(j), key);
        }
    }

    /**
     * Metodo publico que muestra el arbol
     */
    public void print() {
        printRecursive(root);
    }

    /**
     * Metodo recursivo que muestra el arbol
     *
     * @param n de referencia del arbol
     */
    private void printRecursive(BNode n) {
        for (int i = 0; i < n.getCount(); i++) {
            System.out.println(n.getValue(i) + " ");
        }
        if (!n.isLeaf()) {
            for (int j = 0; j <= n.getCount(); j++) {
                if (n.getChildIndex(j) != null) {
                    System.out.println();
                    printRecursive(n.getChildIndex(j));
                }
            }
        }
    }

    /**
     * Metodo de eliminar un nodo
     *
     * @param t
     * @param key
     */
    public void delete(BTree t, int key) {
        BNode temp = new BNode(order, null);
        temp = search(t.root, key);
        if (temp.isLeaf() && temp.getCount() > order - 1) {
            int i = 0;
            while (key > temp.getValue(i)) {
                i++;
            }
            for (int j = i; j < 2 * order - 2; j++) {
                temp.getKey()[j] = temp.getValue(j + 1);
            }
            temp.setCount(temp.getCount() - 1);
        } else {
            System.out.println("Este nodo no es una hojaa o tiene menos del tamanno menos una llaves");
        }
    }
}
