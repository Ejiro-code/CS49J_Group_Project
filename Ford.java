import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.io.File;
public class Ford extends Vehicle{

    /**
     * this is creating an arraylist of the 15 cars from my ford.txt file
     */
    public static ArrayList<FordCar> cars = new ArrayList<>();

    /**
     * Creating a new file instance named Ford.
     * @param fileName
     */
    public Ford(String fileName) {
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
     *This method picks a random car within the file.
     * @return returns random Ford Vehicle.
     */
    public int randomCar() {
        Random rand = new Random();
        int randNum = rand.nextInt(cars.size());

        return randNum;
    }

    /**
     * This method returns a string array that contains the vehicles respective elements.
     * @return returns info of each car.
     */
    @Override
    public String[] allCars() {
        //the string array that the vehicle elements will be stored in
        String[] info = new String[cars.size()];
        String eachCar = null;
        //for loop  that will get the year, price and model and store it in the string array. info[i] adds it
        //to said array.
        for(int i = 0; i < cars.size(); i++){
            eachCar = "Year: " + cars.get(i).getYear() + ", Model: " + cars.get(i).getModel() + ", Price: " + cars.get(i).getPrice();
            info[i] = eachCar;
        }
        return info;
    }

    /**
     * This method creates an array list and then a for loop goes through the file given the cars.size()(size of the file).
     * the if statement gets the price max and min and the word car is what will display given users input.
     *
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
                car = "Year: " + cars.get(i).getYear() + ", Price: " + cars.get(i).getPrice() + ", Model: " + cars.get(i).getModel();
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
     * This method creates a binary search tree and the Node root creates a node which
     * consists of the year and model of the first and then thr for loop itereates through
     * the file and then stores all the years and models in the string array which it then prints.
     * @return returns the sorted years with model.
     */
    @Override
    public String[] sortYear() {
        Node root = new Node(cars.get(0).getYear(), cars.get(0).getModel());
        BST d = new BST(root);
        for(int i = 1; i < cars.size();i++){
            d.insert(cars.get(i).getYear(), cars.get(i).getModel());
        }
        d.sortYear(root);
        String[] year = d.results();

        return year;
    }
    /**
     * This method lets the user create a new car and write that car back to the file.
     * @param price sets price of car
     * @param year sets year of car
     * @param model sets model of car
     * try statement writes the new car back to the file.
     */
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


