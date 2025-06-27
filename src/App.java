import Materia.Controllers.*;
import Materia.Models.Node;

public class App {
    public static void main(String[] args) throws Exception {
        
        System.out.println("Ariel Badillo");
        AVLTree avl = new AVLTree();

        avl.insert(5);
        avl.insert(20);
        avl.insert(15);








        /*
        BinaryTree ab = new BinaryTree();
        ab.insert(50);
        ab.insert(17);
        ab.insert(76);
        ab.insert(9);
        ab.insert(23);
        ab.insert(54);
        ab.insert(14);
        ab.insert(19);
        
         * System.out.print("Pre-Order");
         * ab.Preorder();
         * System.out.print("Post-Order");
         * ab.Postorder();
         * 
         * 
         * 
         * if (ab.findeValue(23)){
         * System.out.println("Encontro el valor 23");
         * }else{
         * System.out.println("No encontro el valor 23");
         * }
         * 
         * if (ab.findeValue(77)){
         * System.out.println("Encontro el valor 77");
         * }else{
         * System.out.println("No encontro el valor 77");
         * }
         

        System.out.println();
        ab.printSize();
        System.out.println("Altura del árbol: " + ab.getHeight());
        System.out.println();
        System.out.print("In-Order");
        ab.Inorder();
        System.out.print("Arbol InOrder con alturas");
        ab.printInorderWithHeight();
        System.out.print("Arbol InOrder con factor de equlibrio");
        ab.printInorderWithBalanceFactor();
        System.out.println("Arbol esta equilibrado = " + ab.isBalanced());
        boolean existe = ab.findeValue(15);
        System.out.println("Existe el nodo 15= " + existe);
        System.out.println("Agregamos valor = 15");
        ab.insert(15);
        System.out.println("Arbol esta equilibrado = " + ab.isBalanced());
        ab.printBalanceWithDesequilibrados();
        */
    }
}
