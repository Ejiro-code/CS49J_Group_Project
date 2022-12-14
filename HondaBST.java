import java.util.ArrayList;

public class HondaBST {
    public HondaNode root;

    public HondaBST(HondaNode r){
        root = r;
    }

    //the recursive method that preforms insertion of data into the tree
    private HondaNode addRecursive(HondaNode current, HondaNode h) {
        if (current == null) {
            return new HondaNode(h.honda);
        }

        if (h.year <= current.year) {
            current.left = addRecursive(current.left, h);
        } else if (h.year > current.year) {
            current.right = addRecursive(current.right, h);
        } else {
            // value already exists
            return current;
        }
        return current;
    }

    //recursion of the root node:
    public void add (HondaNode h){
        root = addRecursive(root, h);
    }

    void printAscendingRecursive(HondaNode current, ArrayList<HondaCar> sortedList){
        if (current.left != null){
            printAscendingRecursive(current.left, sortedList);
        }
        sortedList.add(current.honda);
        if(current.right != null) {
            printAscendingRecursive(current.right, sortedList);
        } else {
            return;
        }
    }
}