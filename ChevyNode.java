public class ChevyNode {
    int price;
    int year;
    ChevyCar car;
    ChevyNode left, right;

    public ChevyNode(ChevyCar c) {
        this.price = c.getPrice();
        this.year = c.getYear();
        this.car = c;
        left = right = null;
    }
}
