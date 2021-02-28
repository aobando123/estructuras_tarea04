package com.tarea;

import com.tarea.gestor.RedBlackTreeGestor;

public class Main {

    public static void main(String[] args) {
        RedBlackTreeGestor bst = new RedBlackTreeGestor();
        bst.insert(8);
        bst.insert(18);
        bst.insert(5);
        bst.insert(15);
        bst.insert(17);
        bst.insert(25);
        bst.insert(40);
        bst.insert(80);
        bst.delete(25);
        bst.prettyPrint();
	// write your code here
    }
}
