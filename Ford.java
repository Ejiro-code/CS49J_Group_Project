import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;
public class Ford extends Vehicle{
    public static ArrayList<FordCar> cars = new ArrayList<>(15);
    public static void file(String fileName) {
        File Ford = new File(fileName);
        Scanner in;
        try {
            in = new Scanner(Ford);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (in.hasNextLine()) {
            FordCar car = new FordCar();
            String currentLine = in.nextLine();
            Scanner readLine = new Scanner(currentLine);
            readLine.useDelimiter(",");
            if (readLine.hasNext()) {
                String first = readLine.next();
                int c = Integer.valueOf(first);
                car.setYear(c);
            }
            if (readLine.hasNext()) {
                String first = readLine.next();
                int c = Integer.valueOf(first);
                car.setPrice(c);
            }
            if (readLine.hasNext()) {
                String first = readLine.next();
                car.setModel(first);
            }
            cars.add(car);
        }
    }

    @Override
    public void randomCar() {
        Random rand = new Random();
        int randNum = rand.nextInt(15);
        System.out.println(cars.get(randNum).getYear());
        System.out.println(cars.get(randNum).getPrice());
        System.out.println(cars.get(randNum).getModel());
        //return randNum;
    }

    @Override
    public void sortPrice(int min, int max) {

    }

    @Override
    public void sortYear() {

    }

    @Override
    public void soldCar(int price, int year, String model) {

    }
}
