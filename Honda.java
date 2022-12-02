import java.io.FileNotFoundException;
import java.io.File;
import java.util.*;

public class Honda extends Vehicle {
    public static ArrayList<HondaCar> cars = new ArrayList<>(15);

    public static void something(String fileName) {
        File honda = new File(fileName);

        Scanner in;
        {
            try {
                in = new Scanner(honda);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            while (in.hasNextLine()) {
                HondaCar car = new HondaCar();
                String currentLine = in.nextLine();
                Scanner readLine = new Scanner(currentLine);
                readLine.useDelimiter(",");

                if (readLine.hasNext()) {
                    String current = readLine.next();
                    int y = Integer.valueOf(current);
                    car.setYear(y);
                }
                if (readLine.hasNext()) {
                    String current = readLine.next();
                    int y = Integer.valueOf(current);
                    car.setPrice(y);
                }

                if (readLine.hasNext()) {
                    String current = readLine.next();
                    car.setModel(current);
                }

                cars.add(car);
                readLine.close();
            }
        }
    }


    public void randomCar() {
        File hondaList = new File("hondacars.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(hondaList);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // read each line and
        // count number of lines
        int count = 0;
        while(sc.hasNextLine()) {
            sc.nextLine();
            count++;
        }

        sc.close();

        System.out.println("Total Number of Lines: " + count);
        Random rand = new Random();
        int randNum = rand.nextInt(count);

        System.out.print("The " + cars.get(randNum).getYear());
        System.out.print(" Honda " + cars.get(randNum).getModel() + " was selected, ");
        System.out.println("with a starting price of $" + cars.get(randNum).getPrice() + ".");
    }

    @Override
    public void sortPrice(int min, int max) {

    }

    @Override
    public void sortYear() {
        File hondaList = new File("hondacars.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(hondaList);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        String eachCar = new String();
        LinkedList<String> carsByYear = new LinkedList<String>();
        while (sc.hasNextLine()){
            eachCar = sc.nextLine();
            carsByYear.add(eachCar);
        }
        sc.close();


        int count = 0;
        Collections.reverse(carsByYear);
        Iterator i = carsByYear.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }

    @Override
    public void soldCar(int price, int year, String model) {

    }
}