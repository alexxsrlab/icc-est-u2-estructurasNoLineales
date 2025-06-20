package Materia.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Materia.Models.Node;

public class BinaryTree {
    private Node root;
    private int size;
    private Stack<Node> desequilibrado;

    public BinaryTree() {
        this.root = null;
        this.size = 0;
        this.desequilibrado = new Stack<Node>();
    }

    public void insert(int Value) {
        root = insertRec(root, Value);
    }

    private Node insertRec(Node padre, int Value) {
        if (padre == null) {
            size++;
            return new Node(Value);
        }

        if (Value < padre.getValue()) {
            Node newNode = insertRec(padre.getRefIzquierda(), Value);
            padre.setRefIzquierda(newNode);
        } else if (Value > padre.getValue()) {
            padre.setRefDerecha(insertRec(padre.getRefDerecha(), Value));
        }
        return padre;
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

    /*
     * public void Preorder() {
     * System.out.println();
     * printPreoder(root);
     * System.out.println();
     * }
     * 
     * private void printPreoder(Node node) {
     * if (node != null) {
     * System.out.print(node.getValue() + " , ");
     * printPreoder(node.getRefIzquierda());
     * printPreoder(node.getRefDerecha());
     * }
     * }
     * 
     * public void Postorder() {
     * System.out.println();
     * printPostorder(root);
     * System.out.println();
     * }
     * 
     * private void printPostorder(Node node) {
     * if (node != null) {
     * printPostorder(node.getRefIzquierda());
     * printPostorder(node.getRefDerecha());
     * System.out.print(node.getValue() + " , ");
     * }
     * }
     * 
     * 
     * 
     * 
     * public boolean findeValue(int value) {
     * return findeValueRecursive(root, value);
     * }
     * 
     * private boolean findeValueRecursive(Node node, int value) {
     * if (node == null) {
     * return false;
     * }
     * if (node.getValue() == value) {
     * return true;
     * }
     * if (value < node.getValue()) {
     * return findeValueRecursive(node.getRefIzquierda(), value);
     * } else {
     * return findeValueRecursive(node.getRefDerecha(), value);
     * }
     * }
     */
    public int getHeight(Node node) {
        if (node == null)
            return 0;
        int leftHeight = getHeight(node.getRefIzquierda());
        int rightHeight = getHeight(node.getRefDerecha());
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int getBalanceFactor(Node node) {
        if (node == null)
            return 0;
        return getHeight(node.getRefIzquierda()) - getHeight(node.getRefDerecha());
    }

    public void printInorderWithHeight() {
        desequilibrado.clear();
        System.out.println();
        printInorderHeightRec(root);
        System.out.println();
    }

    private void printInorderHeightRec(Node node) {
        if (node != null) {
            printInorderHeightRec(node.getRefIzquierda());
            int height = getHeight(node);
            int bf = getBalanceFactor(node);
            if (Math.abs(bf) > 1) {
                desequilibrado.push(node);
            }
            String mark = (Math.abs(bf) > 1) ? "*" : "";
            System.out.print(node.getValue() + "(h=" + height + ")" + mark + " , ");
            printInorderHeightRec(node.getRefDerecha());
        }
    }

    public void printInorderWithBalanceFactor() {
        desequilibrado.clear();
        System.out.println();
        printInorderBalanceRec(root);
        System.out.println();
    }

    private void printInorderBalanceRec(Node node) {
        if (node != null) {
            printInorderBalanceRec(node.getRefIzquierda());
            int bf = getBalanceFactor(node);
            if (Math.abs(bf) > 1) {
                desequilibrado.push(node);
            }
            String mark = (Math.abs(bf) > 1) ? "*" : "";
            System.out.print(node.getValue() + "(bf=" + bf + ")" + mark + " , ");
            printInorderBalanceRec(node.getRefDerecha());
        }
    }

    public void printBalanceWithDesequilibrados() {
        desequilibrado.clear();
        System.out.print("Arbol InOrder con factor de equlibrio\n");

        printBalanceAndCollectDesequilibrados(root);

        if (!desequilibrado.isEmpty()) {
            System.out.print("\nNodos desequlibrados ");
            List<Node> lista = new ArrayList<>(desequilibrado);
            for (int i = 0; i < lista.size(); i++) {
                Node n = lista.get(i);
                int bf = getBalanceFactor(n);
                System.out.print(n.getValue() + "(fE = " + bf + ")");
                if (i < lista.size() - 1) {
                    System.out.print(" y ");
                }
            }
        }
        System.out.println();
    }

    private void printBalanceAndCollectDesequilibrados(Node node) {
        if (node != null) {
            printBalanceAndCollectDesequilibrados(node.getRefIzquierda());
            int bf = getBalanceFactor(node);
            if (Math.abs(bf) > 1) {
                desequilibrado.push(node);
            }
            System.out.print(node.getValue() + " (bf = " + bf + ") , ");
            printBalanceAndCollectDesequilibrados(node.getRefDerecha());
        }
    }

    public boolean findeValue(int value) {
        return findeValueRecursive(root, value);
    }

    private boolean findeValueRecursive(Node node, int value) {
        if (node == null)
            return false;
        if (node.getValue() == value)
            return true;
        return value < node.getValue()
                ? findeValueRecursive(node.getRefIzquierda(), value)
                : findeValueRecursive(node.getRefDerecha(), value);
    }

    public int getSize() {
        return size;
    }

    public void printSize() {
        System.out.println("Peso del árbol: " + size);
    }

    public boolean isBalanced() {
        desequilibrado.clear();
        checkBalance(root);
        return desequilibrado.isEmpty();
    }

    private void checkBalance(Node node) {
        if (node != null) {
            checkBalance(node.getRefIzquierda());
            int bf = getBalanceFactor(node);
            if (Math.abs(bf) > 1) {
                desequilibrado.push(node);
            }
            checkBalance(node.getRefDerecha());
        }
    }

    public int getHeight() {
        return getHeight(root);
    }
}
