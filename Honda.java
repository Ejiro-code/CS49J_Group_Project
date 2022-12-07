import java.io.*;
import java.util.*;

public class Honda extends Vehicle {

    public static ArrayList<HondaCar> cars = new ArrayList<>();
    File hondaFile;

    public Honda() {
        this.hondaFile = new File("honda.txt");

        Scanner in;
        {
            try {
                in = new Scanner(hondaFile);
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
        Random rand = new Random();
        int randNum = rand.nextInt(cars.size());
        return randNum;
    }

    @Override
    public String[] sortPrice(int min, int max) {
        ArrayList<HondaCar> s = new ArrayList<>();
        int j = 0;
        HondaNode firstCar;

        while(cars.get(j).getPrice() < min || cars.get(j).getPrice() > max){
            j++;
        }

        firstCar = new HondaNode(cars.get(j));
        HondaBST some = new HondaBST(firstCar);

        for (int i = j+1; i < cars.size(); i++) {
            if(cars.get(i).getPrice() >= min && cars.get(i).getPrice() <= max){
                some.add(new HondaNode(cars.get(i)));
            }
        }

        some.printAscendingRecursive(firstCar,s);
        String[] solution = new String[s.size()];

        for(int i = 0; i<s.size(); i++){
            solution[i] = s.get(i).getYear() + "- " + s.get(i).getPrice() + ", " + s.get(i).getModel();
        }
        return solution;
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