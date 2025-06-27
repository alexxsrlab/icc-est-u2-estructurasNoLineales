package Materia.Controllers;

import Materia.Models.Node;

public class AVLTree {
    private Node root;

    public AVLTree() {
        this.root = null;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node node, int value) {
        if (node == null) {
            Node newNode = new Node(value);
            newNode.setHeigth(1);
            System.out.println("Nodo insertado -> " + value + " con balance " + getBalance(newNode));
            return newNode;
        }

        if (value <= node.getValue()) {
            Node newNode = insertRec(node.getRefIzquierda(), value);
            node.setRefIzquierda(newNode);
        } else if (value > node.getValue()) {
            node.setRefDerecha(insertRec(node.getRefDerecha(), value));
        } else {
            return node; // Valor duplicado
        }

        // Actualizar altura
        System.out.println("Nodo actual -> " + node.getValue());
        int altura = Math.max(heigth(node.getRefIzquierda()), heigth(node.getRefDerecha())) + 1;
        node.setHeigth(altura);
        System.out.println("\tAltura -> " + altura);

        // Obtener el balance
        int balance = getBalance(node);
        System.out.println("\tBalance -> " + balance);

        // Rotaciones si está desbalanceado

        // Izquierda - Izquierda
        if (balance > 1 && node.getRefIzquierda() != null && value < node.getRefIzquierda().getValue()) {
            System.out.println("Rotacion simple a la Derecha");
            return derechaRotation(node);
        }

        // Derecha - Derecha
        if (balance < -1 && node.getRefDerecha() != null && value > node.getRefDerecha().getValue()) {
            System.out.println("Rotacion simple a la Izquierda");
            return izquierdaRotation(node);
        }

        // Caso Izquierda - Derecha
        if (balance > 1 && node.getRefIzquierda() != null && value > node.getRefIzquierda().getValue()) {
            System.out.println("Cambio (Izquierda-Derecha)");
            System.out.println("Rotacion simple a la Izquierda");
            node.setRefIzquierda(izquierdaRotation(node.getRefIzquierda()));
            System.out.println("Rotacion simple a la Derecha");
            return derechaRotation(node);
        }

        // Caso Derecha - Izquierda
        if (balance < -1 && node.getRefDerecha() != null && value < node.getRefDerecha().getValue()) {
            System.out.println("Cambio (Derecha-Izquierda)");
            System.out.println("Rotacion simple a la Derecha");
            node.setRefDerecha(derechaRotation(node.getRefDerecha()));
            System.out.println("Rotacion simple a la Izquierda");
            return izquierdaRotation(node);
        }

        return node;
    }

    // Altura de un nodo
    private int heigth(Node node) {
        if (node == null) {
            return 0;
        }
        return node.getHeigth();
    }

    // Obtener balance de un nodo
    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return heigth(node.getRefIzquierda()) - heigth(node.getRefDerecha());
    }

    // Rotación a la izquierda
    private Node izquierdaRotation(Node x) {
        Node y = x.getRefDerecha();
        Node temp = y.getRefIzquierda();

        System.out.println("Rotación IZQ en nodo: " + x.getValue() + ", con balance = " + getBalance(x));

        y.setRefIzquierda(x);
        x.setRefDerecha(temp);

        x.setHeigth(Math.max(heigth(x.getRefIzquierda()), heigth(x.getRefDerecha())) + 1);
        y.setHeigth(Math.max(heigth(y.getRefIzquierda()), heigth(y.getRefDerecha())) + 1);

        System.out.println("Nueva raíz después de la rotación: " + y.getValue());

        return y;
    }

    // Rotación a la derecha
    private Node derechaRotation(Node y) {
        Node x = y.getRefIzquierda();
        Node temp = x.getRefDerecha();

        System.out.println("Rotación DER en nodo: " + y.getValue() + ", con balance = " + getBalance(y));

        x.setRefDerecha(y);
        y.setRefIzquierda(temp);

        y.setHeigth(Math.max(heigth(y.getRefIzquierda()), heigth(y.getRefDerecha())) + 1);
        x.setHeigth(Math.max(heigth(x.getRefIzquierda()), heigth(x.getRefDerecha())) + 1);

        System.out.println("Nueva raíz después de la rotación: " + x.getValue());

        return x;
    }

    // Método para imprimir el árbol en orden
    public void printInOrder() {
        System.out.print("Árbol (In-Order): ");
        printInOrderRec(root);
        System.out.println();
    }

    private void printInOrderRec(Node node) {
        if (node != null) {
            printInOrderRec(node.getRefIzquierda());
            System.out.print(node.getValue() + " ");
            printInOrderRec(node.getRefDerecha());
        }
    }
}
