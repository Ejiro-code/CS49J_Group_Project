import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Toyota extends Vehicle{
    public static ArrayList<ToyotaCar> cars = new ArrayList<>(3);

    public static void something(String fileName){
        File toyota = new File(fileName);
        Scanner in;

            try {
                in = new Scanner(toyota);


            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            while (in.hasNextLine()) {
                ToyotaCar car1 = new ToyotaCar();
                String currentLine = in.nextLine();
                Scanner readLine = new Scanner(currentLine);
                readLine.useDelimiter(",");

                if (readLine.hasNext()) {
                    String current = readLine.next();
                    int y = Integer.valueOf(current);
                    car1.setYear(y);
                }
                if (readLine.hasNext()) {
                    String current = readLine.next();
                    int y = Integer.valueOf(current);
                    car1.setPrice(y);
                }

                if (readLine.hasNext()) {
                    String current = readLine.next();
                    car1.setModel(current);
                }

                cars.add(car1);
            }

    }

    public String[] allCars(){
        String[] info = new String[cars.size()];
        String eachCar = null;


        for(int i = 0; i < cars.size(); i++){
            eachCar = "Year: " + cars.get(i).getYear() + "Price: " + cars.get(i).getPrice() + ", Model: " + cars.get(i).getModel();
            info[i] = eachCar;
        }
        return info;
    }
    public void randomCar() {
        Random rand = new Random();
        int randNum = rand.nextInt(cars.size());
        System.out.println(cars.get(randNum).getYear());
        System.out.println(cars.get(randNum).getPrice());
        //System.out.println(cars.get(randNum).getMake());
        System.out.println(cars.get(randNum).getModel());

        //return randNum;
    }

    @Override
    public String[] sortPrice(int min, int max) {
        ArrayList<String> initialArr = new ArrayList<>();
        String word = null;
        for(int i = 0; i < cars.size(); i++){
            if(cars.get(i).getPrice() >= min && cars.get(i).getPrice() <= max){
                word = cars.get(i).getPrice() + "~  " +cars.get(i).getModel() + " " + cars.get(i).getYear();
                initialArr.add(word);
            }

        }
        String[] p = new String[initialArr.size()];
        for(int i = 0; i < initialArr.size(); i++){
            p[i] = initialArr.get(i);
        }
        return p;
    }

    @Override
    public void sortYear() {
        HashMap<Integer, List<String>> map = new HashMap<>();

        for(ToyotaCar vehicle : cars){
            if(map.containsKey(vehicle.getYear()) == false){
                map.put(vehicle.getYear(), new ArrayList<String>(Arrays.asList(vehicle.getModel())));
            }
            else{
                map.get(vehicle.getYear()).add(vehicle.getModel());
            }

        }
        for (Integer i : map.keySet()) {
            System.out.println("key: " + i + " value: " + map.get(i));
        }

    }

    @Override
    public void soldCar(int price, int year, String model) {

    }
    //sort by price range
    //sort by year using hash map

}
