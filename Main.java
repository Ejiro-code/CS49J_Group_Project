public class Main {
    public static void main(String[] args) {
        Toyota j = new Toyota();
        HondaCar s = new HondaCar();
        //s.something("hondacars.txt");
        j.something("toyota.txt");
        j.randomCar();
        mainWindow win = new mainWindow();
    }
}