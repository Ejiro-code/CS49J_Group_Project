import java.io.*;
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

    public String[] allCars(){
        String[] hondaInfo = new String[cars.size()];
        String eachHonda = null;

        System.out.println("This is out inventory of Honda vehicles:");
        for(int i = 0; i < cars.size(); i++){
            eachHonda = "Year: " + cars.get(i).getYear() + ", Price: $" + cars.get(i).getPrice() + ", Model: " + cars.get(i).getModel();
            hondaInfo[i] = eachHonda;
            System.out.println(hondaInfo[i]);
        }

        return hondaInfo;
    }

    public int randomCar() {
        File hondaList = new File("honda.txt");
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

        //System.out.println("Total Number of Lines: " + count);
        Random rand = new Random();
        int randNum = rand.nextInt(count);

        System.out.print("The " + cars.get(randNum).getYear());
        System.out.print(" Honda " + cars.get(randNum).getModel() + " was selected, ");
        System.out.println("with a starting price of $" + cars.get(randNum).getPrice() + ".");

        return 0;
    }

    //@Override
    public void sortPrice(int min, int max) {

    }

    @Override
    public String[] sortYear() {
        File hondaList = new File("honda3.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(hondaList);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        String eachCar = new String();
        LinkedList<HondaCar> carsByYear = new LinkedList<HondaCar>();
        while (sc.hasNextLine()){
            eachCar = sc.nextLine();
            carsByYear.add(eachCar);
        }
        sc.close();

        Collections.sort(carsByYear);
        String[] yearList = new String[carsByYear.size()];

        for (int i = 0; i < carsByYear.size(); i++) {
            yearList[i]= carsByYear.get(i).getYear() + "," + carsByYear.get(i).getPrice() + "," + carsByYear.get(i).getModel();
        }

        System.out.println(yearList);
        return yearList;
    }

    //@Override
    public void soldCar(int price, int year, String model) {
        HondaCar car = new HondaCar();
        car.setModel(model);
        car.setPrice(price);
        car.setYear(year);

        cars.add(car);

        try {
            FileWriter addHonda = new FileWriter("honda3.txt",true);
            PrintWriter out = new PrintWriter(addHonda);
            out.println(car.getYear() + "," + car.getPrice() + "," + car.getModel());

            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

