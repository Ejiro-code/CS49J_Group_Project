public class ChevyNode {
    int price;
    int year;
    String model;
    ChevyCar car;
    ChevyNode left, right;

    public ChevyNode(ChevyCar c) {
        this.price = c.getPrice();
        this.year = c.getYear();
        this.model = c.getModel();
        this.car = c;
        left = right = null;
    }
}
