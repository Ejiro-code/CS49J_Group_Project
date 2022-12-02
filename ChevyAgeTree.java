public class ChevyAgeTree {
    ChevyNode root;
    private ChevyNode addRecursive(ChevyNode current, ChevyNode n) {
        if (current == null) {
            return new ChevyNode(n.car);
        }

        if (n.year <= current.year) {
            current.left = addRecursive(current.left, n);
        } else {
            current.right = addRecursive(current.right, n);
        }
        return current;
    }
    public void add(ChevyNode n) {
        root = addRecursive(root, n);
    }

    void printAscendingRecursive(ChevyNode current){
        if (current.left != null){
            printAscendingRecursive(current.left);
        }
        System.out.println("$" + current.year + " - " + current.year + " Chevy " + current.model);
        if(current.right != null) {
            printAscendingRecursive(current.right);
        } else {return;}
    }
    void printAscending(){
        printAscendingRecursive(root);
    }
}
