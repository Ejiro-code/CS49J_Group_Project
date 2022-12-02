public class ChevyPriceTree {
    ChevyNode root;
    private ChevyNode addRecursive(ChevyNode current, int price) {
        if (current == null) {
            return new ChevyNode(price);
        }

        if (price < current.price) {
            current.left = addRecursive(current.left, price);
        } else if (price > current.price) {
            current.right = addRecursive(current.right, price);
        } else {
            return current;
        }

        return current;
    }
    public void add(int price) {
        root = addRecursive(root, price);
    }

    void printAscendingRecursive(ChevyNode current){
        if (current.left != null){
            printAscendingRecursive(current.left);
        }
        System.out.println(current.price + " " + current.make + " " + current.model + " " + current.price);
        if(current.right != null) {
            printAscendingRecursive(current.right);
        } else {return;}
    }
    void printAscending(){
        printAscendingRecursive(root);
    }
}
