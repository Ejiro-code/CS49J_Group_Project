public class Honda implements VehicleBuild{
    private int year;
    private int price;
    private String make;
    private String model;

    public Honda(int year, int price, String make, String model) {
        this.year = year;
        this.price = price;
        this.make = make;
        this.model = model;
    }

   // @Override
    public String getMake() {
        return this.make;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String getModel() {
        return this.model;
    }


}
