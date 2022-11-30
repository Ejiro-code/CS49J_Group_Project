public class ToyotaCar implements VehicleBuild{
    private int year;
    private int price;
    //private String make;
    private String model;

    public ToyotaCar(int year, int price, String model) {
        this.year = year;
        this.price = price;
        this.model = model;
    }
    public ToyotaCar(){

    }

    public void setYear(int y){
        this.year  = y;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setModel(String model) {
        this.model = model;
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
