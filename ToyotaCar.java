import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ToyotaCar extends Vehicle{
    //Toyota car1 = new Honda(2002, 100000, "Honda", "Accord");
    public static ArrayList<Toyota> cars = new ArrayList<>(3);

    public static void something(String fileName){
        File toyota = new File(fileName);
        Scanner in;

            try {
                in = new Scanner(toyota);


            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            int counter1 = 0, counter2 = 0, count3 = 0, count4 = 0;

            while (in.hasNextLine()) {
                Toyota car1 = new Toyota();
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


    public void randomCar() {
        Random rand = new Random();
        int randNum = rand.nextInt(3);
        System.out.println(cars.get(randNum).getYear());
        System.out.println(cars.get(randNum).getPrice());
        //System.out.println(cars.get(randNum).getMake());
        System.out.println(cars.get(randNum).getModel());

        //return randNum;
    }

    @Override
    public void sortPrice(int min, int max) {
        for(int i = 0; i < cars.size(); i++){
            if(cars.get(i).getPrice() >= min && cars.get(i).getPrice() <= max){
                System.out.println(cars.get(i).getModel() + " " + cars.get(i).getYear());
            }
        }
    }

    @Override
    public void sortYear() {
        HashMap<Integer, List<String>> map = new HashMap<>();

        for(Toyota vehicle : cars){
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
