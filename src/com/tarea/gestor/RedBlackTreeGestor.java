package com.tarea.gestor;

import com.tarea.redblacktree.RedBlackTree;

public class RedBlackTreeGestor {
    private RedBlackTree rbTree;

    public RedBlackTreeGestor () {
        this.rbTree = new RedBlackTree();
    }

    public void insert(int value) {
        this.rbTree.insert(value);
    }

    public void delete(int value) {
        this.rbTree.deleteNode(value);
    }

    public void preOrden() {
        this.rbTree.preorder();
    }

    public void inOrden() {
        this.rbTree.inorder();
    }

    public void postOrder() {
        this.rbTree.postorder();
    }
    // print the tree structure on the screen
    public void prettyPrint() {
       this.rbTree.prettyPrint();
    }


}
