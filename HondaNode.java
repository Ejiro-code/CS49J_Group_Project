public class HondaNode {
    int year, price;
    String model;
    HondaCar honda;
    HondaNode left, right;

    HondaNode(HondaCar h) {
        this.year = h.getYear();
        this.price = h.getPrice();
        this.model = h.getModel();
        this.honda = h;
        left = null;
        right = null;
    }

    public HondaNode() {
    }
}