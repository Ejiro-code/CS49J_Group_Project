import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.io.File;


public class Ford extends Vehicle{
    public static ArrayList<FordCar> cars = new ArrayList<>(15);
    public static void something(String fileName) {
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

    }

    @Override
    public String[] allCars() {
        return new String[0];
    }

    @Override
    public String[] sortPrice(int min, int max) {
        return new String[0];
    }

    @Override
    public void sortYear() {
        Node root = new Node(cars.get(0).getYear());
        BST d = new BST(root);
        for(int i = 0; i < cars.size(); i++){
            d.insert(cars.get(i).getYear());
        }
        d.display(root);

    }

    @Override
    public void soldCar(int price, int year, String model) {

    }
}
