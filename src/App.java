import Materia.Controllers.*;

public class App {
    public static void main(String[] args) throws Exception {
        BinaryTree ab = new BinaryTree();
        ab.insert(50);
        ab.insert(17);
        ab.insert(76);
        ab.insert(9);
        ab.insert(23);
        ab.insert(54);
        ab.insert(14);
        ab.insert(19);
        System.out.print("Pre-Order");
        ab.Preorder();
        System.out.print("Post-Order");
        ab.Postorder();
        System.out.print("In-Order");
        ab.Inorder();
        
    }
}
