public class FordCar implements VehicleBuild {
    private int year;
    private int price;
    private String model;

    public FordCar(int year, int price, String model){
        this.year = year;
        this.price = price;
        this.model = model;
    }

    public FordCar() {

    }

    public void setYear(int year){
        this.year  = year;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public void setModel(String model){
        this.model = model;
    }
    @Override
    public String getModel() {
        return model;
    }
    @Override
    public int getPrice() {
        return price;
    }
    @Override
    public int getYear() {
        return year;
    }
}
