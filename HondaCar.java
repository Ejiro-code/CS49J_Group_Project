public class HondaCar implements VehicleBuild{
    private int year;
    private int price;
    private String model;

    public HondaCar(int year, int price, String model) {
        this.year = year;
        this.price = price;
        this.model = model;
    }
    public HondaCar(){}

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
        return model;
    }
}