public class FordCar implements VehicleBuild {
    private int year;
    private int price;
    private String model;

    /**
     * Setting the instance variables.
     * @param year year of car.
     * @param price price of car.
     * @param model model of car.
     */
    public FordCar(int year, int price, String model){
        this.year = year;
        this.price = price;
        this.model = model;
    }

    public FordCar() {

    }

    /**
     * setter to set the year.
     * @param year
     */
    public void setYear(int year){
        this.year  = year;
    }

    /**
     * setter to set the price
     * @param price
     */
    public void setPrice(int price){
        this.price = price;
    }

    /**
     * setter to set the model.
     * @param model
     */
    public void setModel(String model){
        this.model = model;
    }

    /**
     * Getter to get the model.
     * @return returns the car model.
     */
    @Override
    public String getModel() {
        return model;
    }

    /**
     * Getter to get the price.
     * @return returns the price.
     */
    @Override
    public int getPrice() {
        return price;
    }

    /**
     * Getter to get the year.
     * @return returns the year.
     */
    @Override
    public int getYear() {
        return year;
    }
}
