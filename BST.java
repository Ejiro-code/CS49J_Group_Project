import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * class for the node
 */
class Node {
    public int data;
    Node left;
    Node right;
    //constructor for the data
    public Node(int data) {
        this.data = data;
    }
}
class BST {
    public Node root;

    public BST(Node root) {
        this.root = root;
    }
    //sorts through tree to find car years.
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
    //recursive method to insert data into the tree.
    private Node insertRec(Node root, int data) {
        // creates new node if tree is empty.
        if(root == null){
            root = new Node(data);
            return root;
        }
        //inserts data to left subtree if it's less than the root.
        if (data < root.data)
            root.left = insertRec(root.left, data);
        //inserts data to right subtree if it's more than the root.
        else if (data > root.data)
            root.right = insertRec(root.right, data);

        return root;
    }
    //displays data from left and right subtree.
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