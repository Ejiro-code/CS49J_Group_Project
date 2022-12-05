import java.io.*;
import java.util.*;

public class Honda extends Vehicle {

    File hondaFile;
    HondaBST priceBST;
    public Honda() {
        this.hondaFile = new File("honda.txt");
        this.priceBST = new HondaBST();
    }

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
        Scanner sc = null;
        try {
            sc = new Scanner(hondaFile);
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

    @Override
    public String[] sortPrice(int min, int max) {
        ArrayList<HondaCar> sortListWithBST = priceBST.printAscending();
        ArrayList<HondaCar> priceFilter = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getPrice() <= max && cars.get(i).getPrice() >= min) {
                priceFilter.add(sortListWithBST.get(i));
            }
        }

        String[] sortedHondaList = new String[sortListWithBST.size()];
        for (int i = 0; i < priceFilter.size(); i++) {
            sortedHondaList[i] = priceFilter.get(i).getYear() + "," + priceFilter.get(i).getModel() + "," + priceFilter.get(i).getPrice();
        }
        System.out.println(Arrays.toString(sortedHondaList));
        return sortedHondaList;
    }

    @Override
    public String[] sortYear() {
        Scanner sc = null;
        try {
            sc = new Scanner(hondaFile);
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

        Collections.sort(carsByYear);
        // converts from linked list to object array:
        Object[] temp = carsByYear.toArray();
        // converts from object array to string array:
        String[] yearList = Arrays.copyOf(temp, temp.length, String[].class);
        //System.out.println(Arrays.toString(yearList));
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
            FileWriter addHonda = new FileWriter(hondaFile,true);
            PrintWriter out = new PrintWriter(addHonda);
            out.println(car.getYear() + "," + car.getPrice() + "," + car.getModel());

            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}