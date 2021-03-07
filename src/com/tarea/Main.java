package com.tarea;

import com.tarea.bplus.*;
import com.tarea.gestor.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    private static final AVLManager AVLmanager = new AVLManager();
    private static final com.tarea.gestor.BManager BManager = new BManager();
    private static BMasGestor<String, Persona> personas;

    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException ,SerializadorException, ArbolException{
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

        try{
            personas=new BMasGestor("src/","personas",200);

            personas.agregar("Cedula1",new Persona("Cedula1","Nombre1"));
            personas.agregar("Cedula2",new Persona("Cedula2","Nombre2"));
            personas.agregar("Cedula3",new Persona("Cedula3","Nombre3"));
            personas.agregar("Cedula4",new Persona("Cedula4","Nombre4"));
            personas.agregar("Cedula5",new Persona("Cedula5","Nombre5"));
            personas.agregar("Cedula6",new Persona("Cedula6","Nombre6"));
            personas.agregar("Cedula7",new Persona("Cedula7","Nombre7"));
            personas.agregar("Cedula8",new Persona("Cedula8","Nombre8"));
            personas.agregar("Cedula9",new Persona("Cedula9","Nombre9"));
            personas.agregar("Cedula10",new Persona("Cedula10","Nombre10"));
        }
        catch (Exception ex) {
        System.out.println("Ha ocurrido  un error: "+ex.getMessage());
        }

        showMenu();
    }

    private static void showMenu() throws IOException , SerializadorException, ArbolException{
        int option;
        do {
            System.out.println("0. Salir");
            System.out.println("1. Agregar un nodo al arbol AVL");
            System.out.println("2. Recorrer arbol AVL en pre-orden");
            System.out.println("3. Recorrer arbol AVL en in-orden");
            System.out.println("4. Recorrer arbol AVL en post-orden");
            System.out.println("5. Agregar un nodo al arbol B");
            System.out.println("6. Mostrar arbol B");
            System.out.println("7. Eliminar un nodo del arbol B");
            System.out.println("8. Buscar una cedula en el arbol B+");
            System.out.println("9. Eliminar una persona del arbol B+");
            System.out.println("10. Listar objetos en el arbol B+");
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

    private static void executeOption(int option) throws IOException, SerializadorException, ArbolException{
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
            case 8:
                buscarEnBMas();
                break;
            case 9:
                borrarDeBMas();
                break;
            case 10:
                listarBMas();
                break;
            default:
                System.out.println("Seleccione una opcion valida");
        }
    }


    private static void listarBMas()throws IOException, SerializadorException{
        List<Persona> lista = personas.listar();
        System.out.println("\nLista de personas");
        lista.stream().forEach((persona) -> {
            System.out.println(persona.toString());
        });
    }

    private static void borrarDeBMas() throws IOException, SerializadorException, ArbolException{
        System.out.println("Ingrese la cedula que quiere eliminar");
        String cedula=in.readLine();
        if (personas.exists(cedula)) {
            personas.eliminar(cedula);
            System.out.println("La cedula ha sido eliminada");
        }
        else
            System.out.println("La cedula no se encontraba en el arbol");
    }

    private static void buscarEnBMas() throws IOException, SerializadorException{
        System.out.println("Ingrese la cedula que quiere buscar");
        String cedula=in.readLine();
        if (!personas.exists(cedula))
            System.out.println("La cedula no ha sido ingresada");
        else
            System.out.println("La cedula " + cedula + " ya se encuentra en el arbol");
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
