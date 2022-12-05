import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.io.File;



public class Ford extends Vehicle{

    /**
     * this is creating an arraylist of the 15 cars from my ford.txt file
     */
    public static ArrayList<FordCar> cars = new ArrayList<>(15);

    /**
     *
     * @param fileName
     * creating a new file instance named Ford
     */
    public static void something(String fileName) {
        File Ford = new File(fileName);
        Scanner in;
        /**
         * this try/catch statement is checking to see if the new file Ford is
         * in fact a file, and will throw an exception otherwise.
         */
        try {
            in = new Scanner(Ford);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        /**
         * This while/if statement is iterating through the file and creating a new car(price, year, model) for every
         * line that is read in the file. In this case it is 15 because the arraylist is of size 15.
         */
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

    /**
     * This method is randomizing the cars in the file and printing it.
     */
    public void randomCar() {
        Random rand = new Random();
        int randNum = rand.nextInt(15);
        System.out.println(cars.get(randNum).getYear());
        System.out.println(cars.get(randNum).getPrice());
        System.out.println(cars.get(randNum).getModel());

    }

    /**
     * This method returns a string array that contains the vehicles respective elements.
     * @return
     */
    @Override
    public String[] allCars() {
        //the string array that the vehicle elements will be stored in
        String[] info = new String[cars.size()];
        String eachCar = null;
        //for loop  that will get the year, price and model and store it in the string array. info[i] adds it
        //to said array.
        for(int i = 0; i < cars.size(); i++){
            eachCar = "Year: " + cars.get(i).getYear() + "Price: " + cars.get(i).getPrice() + ", Model: " + cars.get(i).getModel();
            info[i] = eachCar;
        }
        return info;
    }

    /**
     * this method takes the min and max of a price the user enters and outputs the cars that are within that range of price.
     * @param min setting the min
     * @param max setting the max
     * @return returns the cars that are withing that range.
     */
    @Override
    public String[] sortPrice(int min, int max) {
        //creating an array list
        ArrayList<String> carArray = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            String car = null;
            //the word car is what will display given users input
            if (cars.get(i).getPrice() <= max && cars.get(i).getPrice() >= min) {
                car = cars.get(i).getPrice() + cars.get(i).getYear() + cars.get(i).getModel();
                //adds car to arraylist
                carArray.add(car);
            }
        }
        //taking lines in the arraylist and adding it to the string array so that the GUI can display it.
        String[] car1 = new String[carArray.size()];
        for (int i = 0; i < carArray.size(); i++) {
            car1[i] = carArray.get(i);
        }
        return car1;
    }

    /**
     * This method prints the prices in ascending order.
     * @return data from BST class.
     */
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

    /**
     * This method lets the user create a new car and add that car to the file.
     * @param price sets price of car
     * @param year sets year of car
     * @param model sets model of car
     */
    @Override
    public void soldCar(int price, int year, String model) {
        FordCar car = new FordCar();
        car.setModel(model);
        car.setPrice(price);
        car.setYear(year);

        cars.add(car);
        //writing new car back to the file
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


