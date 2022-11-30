import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.Random;

public class HondaCar extends Vehicle {
    Honda car1 = new Honda(2002, 100000, "Honda", "Accord");
    public static ArrayList<Honda> cars = new ArrayList<>(3);

    public static void something(String fileName) {
        File honda = new File(fileName);
        Scanner in;
        int[] year = new int[3], prices = new int[3];
        String[] make = new String[3];
        String[] model = new String[3];


        {
            try {
                in = new Scanner(honda);


            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            int counter1 = 0, counter2 = 0, count3 = 0, count4 = 0;

            while (in.hasNextLine()) {
                String currentLine = in.nextLine();
                Scanner readLine = new Scanner(currentLine);
                readLine.useDelimiter(",");

                if (readLine.hasNext()) {
                    String current = readLine.next();
                    int y = Integer.valueOf(current);
                    year[counter1] = y;
                    counter1++;
                }
                if (readLine.hasNext()) {
                    String current = readLine.next();
                    int y = Integer.valueOf(current);
                    prices[counter2] = y;
                    counter2++;
                }
                if (readLine.hasNext()) {
                    String current = readLine.next();
                    //int y = Integer.valueOf(current);
                    make[count3] = current;
                    count3++;
                }
                if (readLine.hasNext()) {
                    String current = readLine.next();
                    //int y = Integer.valueOf(current);
                    model[count4] = current;
                    count4++;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            Honda car1 = new Honda(year[i], prices[i], make[i], model[i]);
            cars.add(car1);
        }

        for (Honda aCar : cars) {
            System.out.println(aCar.getYear());
            System.out.println(aCar.getPrice());
            System.out.println(aCar.getMake());
            System.out.println(aCar.getModel());
            System.out.println();
        }

    }


    public void randomCar() {
        Random rand = new Random();
        int randNum = rand.nextInt(3);
        System.out.println(cars.get(randNum).getYear());
        System.out.println(cars.get(randNum).getPrice());
        System.out.println(cars.get(randNum).getMake());
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

