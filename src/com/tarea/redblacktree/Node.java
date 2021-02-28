package com.tarea.redblacktree;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import java.security.Key;

public class Node {
    public int data; // holds the key
    public Node parent; // pointer to the parent
    public Node left; // pointer to left child
    public Node right; // pointer to right child
    public int color; // 1 . Red, 0 . Black

    public Node () {
        this.color = 0;
        this.left = null;
        this.right = null;
    }

    public Node (int key, Node TNULL) {
        this.parent = null;
        this.data = key;
        this.left = TNULL;
        this.right = TNULL;
        this.color = 1; // new node must be red


    }
}