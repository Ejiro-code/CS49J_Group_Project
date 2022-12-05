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
    public void randomCar() {
        Random rand = new Random();
        int randNum = rand.nextInt(15);
        System.out.println(cars.get(randNum).getYear());
        System.out.println(cars.get(randNum).getPrice());
        System.out.println(cars.get(randNum).getModel());

    }
    @Override
    public String[] allCars() {
        String[] info = new String[cars.size()];
        String eachCar = null;

        for(int i = 0; i < cars.size(); i++){
            eachCar = "Year: " + cars.get(i).getYear() + "Price: " + cars.get(i).getPrice() + ", Model: " + cars.get(i).getModel();
            info[i] = eachCar;
        }
        return info;
    }
    @Override
    public String[] sortPrice(int min, int max) {
        ArrayList<String> carArray = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            String car = null;
            if (cars.get(i).getPrice() <= max && cars.get(i).getPrice() >= min) {
                car = cars.get(i).getPrice() + cars.get(i).getYear() + cars.get(i).getModel();
                carArray.add(car);
            }
        }
        String[] car1 = new String[carArray.size()];
        for (int i = 0; i < carArray.size(); i++) {
            car1[i] = carArray.get(i);
        }
        return car1;
    }

    @Override
    public String[] sortYear() {
        Node root = new Node(cars.get(0).getYear());
        BST d = new BST(root);
        for(int i = 0; i < cars.size(); i++){
            d.insert(cars.get(i).getYear());
        }
        d.display(root);

        return new String[root.data];
    }
    @Override
    public void soldCar(int price, int year, String model) {
        FordCar car = new FordCar();
        car.setModel(model);
        car.setPrice(price);
        car.setYear(year);

        cars.add(car);

        try {
            FileWriter fw = new FileWriter("ford.txt",true);
            PrintWriter out = new PrintWriter(fw);
            out.println(car.getYear()+","+car.getPrice()+","+car.getModel());
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}


