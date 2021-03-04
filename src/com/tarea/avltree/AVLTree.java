package com.tarea.avltree;

public class AVLTree {
    /**
     * Atrubutos:
     * AVLNode root raiz del arbol.
     */
    private AVLNode root;

    /**
     * Constructor por defecto que inicializa la raiz del arbol
     */
    public AVLTree() {
        root = null;
    }

    /**
     * Obtener el factor de equilibrio del arbol
     *
     * @param node referencia para calcular el factor de quilibrio
     * @return bf
     */
    private int obtainBF(AVLNode node) {
        if (node == null) {
            return -1;
        } else {
            return node.getBf();
        }
    }

    /**
     * Metodo publico de insercion
     *
     * @param data que se va a guardar
     */
    public void insertAVL(int data) {
        AVLNode newNode = new AVLNode(data);
        if (root == null) {
            root = newNode;
        } else {
            root = insertAVLRecursive(newNode, root);
        }
    }

    /**
     * Metodo recursivo de insercion
     *
     * @param newNode nuevo nodo que see va a insertar
     * @param subTree subarbol donde se va a insertar
     * @return newFather
     */
    private AVLNode insertAVLRecursive(AVLNode newNode, AVLNode subTree) {
        AVLNode newFather = subTree;
        if (newNode.getData() < subTree.getData()) {
            if (subTree.getLetf() == null) {
                subTree.setLetf(newNode);
            } else {
                subTree.setLetf(insertAVLRecursive(newNode, subTree.getLetf()));
                if ((obtainBF(subTree.getLetf()) - obtainBF(subTree.getRight()) == 2)) {
                    if (newNode.getData() < subTree.getLetf().getData()) {
                        newFather = simpleLeftRotation(subTree);
                    } else {
                        newFather = doubleLeftRotation(subTree);
                    }
                }
            }
        } else if (newNode.getData() > subTree.getData()) {
            if (subTree.getRight() == null) {
                subTree.setRight(newNode);
            } else {
                subTree.setRight(insertAVLRecursive(newNode, subTree.getRight()));
                if ((obtainBF(subTree.getRight()) - obtainBF(subTree.getLetf()) == 2)) {
                    if (newNode.getData() > subTree.getRight().getData()) {
                        newFather = simpleRightRotation(subTree);
                    } else {
                        newFather = doubleRightRotation(subTree);
                    }
                }
            }
        } else {
            System.out.println("El nodo esta duplicado");
        }
        //Actualizar el factor de equilibrio
        if ((subTree.getLetf() == null) && (subTree.getRight() != null)) {
            subTree.setBf(subTree.getRight().getBf() + 1);
        } else if ((subTree.getRight() == null) && (subTree.getLetf() != null)) {
            subTree.setBf(subTree.getLetf().getBf() + 1);
        } else {
            subTree.setBf(Math.max(obtainBF(subTree.getLetf()), obtainBF(subTree.getRight())) + 1);
        }
        return newFather;
    }

    /**
     * Rotacion simple izquierda
     *
     * @param node referencia para ver la rotacion
     * @return aux
     */
    private AVLNode simpleLeftRotation(AVLNode node) {
        AVLNode aux = node.getLetf();
        node.setLetf(aux.getRight());
        aux.setRight(node);
        node.setBf(Math.max(obtainBF(node.getLetf()), obtainBF(node.getRight())) + 1);
        aux.setBf(Math.max(obtainBF(aux.getLetf()), obtainBF(aux.getRight())) + 1);
        return aux;
    }

    /**
     * Rotacion simple derecha
     *
     * @param node referencia para ver la rotacion
     * @return aux
     */
    private AVLNode simpleRightRotation(AVLNode node) {
        AVLNode aux = node.getRight();
        node.setRight(aux.getLetf());
        aux.setLetf(node);
        node.setBf(Math.max(obtainBF(node.getLetf()), obtainBF(node.getRight())) + 1);
        aux.setBf(Math.max(obtainBF(aux.getLetf()), obtainBF(aux.getRight())) + 1);
        return aux;
    }

    /**
     * Rotacion doble izquierda
     *
     * @param node referencia para ver la rotacion
     * @return aux
     */
    private AVLNode doubleLeftRotation(AVLNode node) {
        AVLNode aux;
        node.setLetf(simpleRightRotation(node.getLetf()));
        aux = simpleLeftRotation(node);
        return aux;
    }

    /**
     * Rotacion doble derecha
     *
     * @param node referencia para ver la rotacion
     * @return aux
     */
    private AVLNode doubleRightRotation(AVLNode node) {
        AVLNode aux;
        node.setRight(simpleLeftRotation(node.getRight()));
        aux = simpleRightRotation(node);
        return aux;
    }

    /**
     * Metodo publico para el recorrido inOrder
     */
    public void inOrden() {
        inOrdenRecursive(root);
    }

    /**
     * Metodo recursivo para el recorrido inOrder
     */
    private void inOrdenRecursive(AVLNode node) {
        if (node != null) {
            inOrdenRecursive(node.getLetf());
            System.out.println(node.getData());
            inOrdenRecursive(node.getRight());
        }
    }

    /**
     * Metodo publico para el recorrido preOrden
     */
    public void preOrden() {
        preOrdenRecursive(root);
    }

    /**
     * Metodo recursivo para el recorrido preOrden
     */
    private void preOrdenRecursive(AVLNode node) {
        if (node != null) {
            System.out.println(node.getData());
            preOrdenRecursive(node.getLetf());
            preOrdenRecursive(node.getRight());
        }
    }

    /**
     * Metodo publico para el recorrido postOrden
     */
    public void postOrden() {
        postOrdenRecursive(root);
    }

    /**
     * Metodo recursivo para el recorrido postOrden
     */
    private void postOrdenRecursive(AVLNode node) {
        if (node != null) {
            postOrdenRecursive(node.getLetf());
            postOrdenRecursive(node.getRight());
            System.out.println(node.getData());
        }
    }
}
