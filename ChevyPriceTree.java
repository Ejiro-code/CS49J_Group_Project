import java.util.ArrayList;

public class ChevyPriceTree {
    ChevyNode root;
    private ChevyNode addRecursive(ChevyNode current, ChevyNode n) {
        if (current == null) {
            return new ChevyNode(n.car);
        }

        if (n.price <= current.price) {
            current.left = addRecursive(current.left, n);
        } else {
            current.right = addRecursive(current.right, n);
        }
        return current;
    }
    public void add(ChevyNode n) {
        root = addRecursive(root, n);
    }

    void printAscendingRecursive(ChevyNode current, ArrayList<ChevyCar> sortedArr){
        if (current.left != null){
            printAscendingRecursive(current.left, sortedArr);
        }
        sortedArr.add(current.car);
        if(current.right != null) {
            printAscendingRecursive(current.right, sortedArr);
        } else {return;}
    }
    ArrayList<ChevyCar> printAscending(){
        ArrayList<ChevyCar> sortedArr = new ArrayList<ChevyCar>();
        printAscendingRecursive(root, sortedArr);
        return sortedArr;
    }
}
