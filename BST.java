import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
class Node {
    public int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}
class BST {
    public Node root;

    public BST(Node root) {
        this.root = root;
    }
    public void sortYear(Node node) {
        if (node != null) {
            sortYear(node.left);

            System.out.print(node.data + "");

            sortYear(node.right);
        }
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }
    private Node insertRec(Node root, int data) {
        if(root == null){
            root = new Node(data);
            return root;
        }
        if (data < root.data)
            root.left = insertRec(root.left, data);

        else if (data > root.data)
            root.right = insertRec(root.right, data);

        return root;
    }
    public void display(Node node){
        if(node.left != null){
            display(node.left);
        }
        System.out.println(node.data);

        if(node.right != null){
            display(node.right);
        }
    }
}