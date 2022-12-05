import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * class for the node
 */
class Node {
    public int data;
    public String model;
    Node left;
    Node right;
    //constructor for the data
    public Node(int data, String model) {
        this.data = data;
        this.model = model;
    }
}

/**
 *
 */
class BST {
    public Node root;
    public ArrayList<String> sol = new ArrayList<String>();

    public BST(Node root) {
        this.root = root;
    }

    /**
     * This method sorts through the subtrees to find car years.
     * @param node
     */
    public void sortYear(Node node) {
        if (node != null) {
            sortYear(node.left);

            //System.out.print(node.data + "");
            sol.add(String.valueOf(node.data) + ", " + node.model);

            sortYear(node.right);
        }
    }

    public String[] results(){
        String[] arr = new String[sol.size()];

        for(int i = 0; i < sol.size();i++){
            arr[i] = String.valueOf(sol.get(i));
        }

        return arr;
    }

    public void insert(int data, String model) {
        root = insertRec(root, data, model);
    }

    /**
     * recursive method to insert data into the tree.
     * @param root used to display car years in tree.
     * @param data used to test if car year values are less or more than root.
     * @return returns roots and places them in tree.
     */
    private Node insertRec(Node root, int data, String model) {
        // creates new node if tree is empty.
        if(root == null){
            root = new Node(data, model);
            return root;
        }
        //inserts data to left subtree if it's less than the root.
        if (data < root.data)
            root.left = insertRec(root.left, data, model);
        //inserts data to right subtree if it's more than the root.
        else if (data > root.data)
            root.right = insertRec(root.right, data, model);

        return root;
    }

    /**
     * displays data from left and right subtree.
     * @param node
     */

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