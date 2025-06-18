package Materia.Controllers;

import Materia.Models.Node;

public class BinaryTree {
    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(int Value) { /// Mandamos el 50
        ///// null, 50
        root = insertRec(root, Value);
    }

    private Node insertRec(Node padre, int Value) {
        if (padre == null) {
            return new Node(Value);
        }

        if (Value < padre.getValue()) {
            // Si se cumple me voy a la izquierda
            Node newNode = insertRec(padre.getRefIzquierda(), Value);
            padre.setRefIzquierda(newNode);
        } else if (Value > padre.getValue()) {
            padre.setRefDerecha(insertRec(padre.getRefDerecha(), Value));
        }
        return padre;
    }

    public void Preorder() {
        System.out.println();
        printPreoder(root);
        System.out.println();
    }

    private void printPreoder(Node node) {
        if (node != null) {
            System.out.print(node.getValue() + " , ");
            printPreoder(node.getRefIzquierda());
            printPreoder(node.getRefDerecha());
        }
    }

    public void Inorder() {
        System.out.println();
        printInorder(root);
        System.out.println();
    }

    private void printInorder(Node node) {
        if (node != null) {
            printInorder(node.getRefIzquierda());
            System.out.print(node.getValue() + " , ");
            printInorder(node.getRefDerecha());
        }
    }

    public void Postorder() {
        System.out.println();
        printPostorder(root);
        System.out.println();
    }

    private void printPostorder(Node node) {
        if (node != null) {
            printPostorder(node.getRefIzquierda());
            printPostorder(node.getRefDerecha());
            System.out.print(node.getValue() + " , ");
        }
    }

    public boolean findeValue(int value) {
        return findeValueRecursive(root, value);
    }

    private boolean findeValueRecursive(Node node, int value) {
        if (node == null) {
            return false; 
        }
        if (node.getValue() == value) {
            return true; 
        }
        if (value < node.getValue()) {
            return findeValueRecursive(node.getRefIzquierda(), value);
        } else {
            return findeValueRecursive(node.getRefDerecha(), value);
        }
    }
}
