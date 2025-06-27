package Materia.Models;

public class Node {
    private Node refIzquierda;
    private Node refDerecha;
    private int Value;
    private int heigth;


    public Node(int Value) {
        this.Value = Value;
        this.refIzquierda = null;
        this.refDerecha = null;
    }

    public Node getRefIzquierda() {
        return refIzquierda;
    }



    public void setRefIzquierda(Node refIzquierda) {
        this.refIzquierda = refIzquierda;
    }



    public Node getRefDerecha() {
        return refDerecha;
    }



    public void setRefDerecha(Node refDerecha) {
        this.refDerecha = refDerecha;
    }



    public int getValue() {
        return Value;
    }



    public void setValue(int value) {
        Value = value;
    }

    public int getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    @Override
    public String toString() {
        return "Node [Value=" + Value + "]";
    }

   

    

}
