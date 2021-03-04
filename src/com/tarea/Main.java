package com.tarea;

import com.tarea.gestor.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final AVLManager AVLmanager = new AVLManager();
    private static final com.tarea.gestor.BManager BManager = new BManager();
    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
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
        showMenu();
    }

    private static void showMenu() throws IOException {
        int option;
        do {
            System.out.println("0. Salir");
            System.out.println("1. Agregar un nodo al arbol AVL");
            System.out.println("2. Recorrer arbol AVL en pre-oreden");
            System.out.println("3. Recorrer arbol AVL en in-oreden");
            System.out.println("4. Recorrer arbol AVL en post-oreden");
            System.out.println("5. Agregar un nodo al arbol B");
            System.out.println("6. Mostrar arbol B");
            System.out.println("7. Eliminar un nodo del arbol b");
            option = selectOption();
            executeOption(option);
        } while(option != 0);
    }

    private static int selectOption() throws IOException {
        int option;
        System.out.print("Seleccione una opcion ");
        option = Integer.parseInt(in.readLine());
        return option;
    }

    private static void executeOption(int option) throws IOException{
        switch (option) {
            case 0:
                System.out.println("Fin del programa");
                break;
            case 1:
                insertAVLTree();
                break;
            case 2:
                AVLmanager.preOrden();
                break;
            case 3:
                AVLmanager.inOrden();
                break;
            case 4:
                AVLmanager.postOrden();
                break;
            case 5:
                insertBTree();
                break;
            case 6:
                BManager.print();
                break;
            case 7:
                deleteBTree();
                break;
            default:
                System.out.println("Seleccione una opcion valida");
        }
    }

    private static void insertAVLTree() throws IOException{
        System.out.println("Digite el numero que desea agregar al arbol AVL");
        int x = Integer.parseInt(in.readLine());
        AVLmanager.insert(x);
    }

    private static void insertBTree() throws IOException{
        System.out.println("El arbol B tiene un nivel de grado 5");
        System.out.println("Digite el numero que desea agregar al arbol B");
        int x = Integer.parseInt(in.readLine());
        BManager.insert(x);
    }

    public static void deleteBTree() throws IOException{
        System.out.println("Digite el numero que desea eliminar del arbol");
        int x = Integer.parseInt(in.readLine());
        BManager.delete(x);
    }
}
