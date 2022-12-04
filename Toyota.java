import java.io.*;
import java.util.*;

public class Toyota extends Vehicle{
    public static ArrayList<ToyotaCar> cars = new ArrayList<>();

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
//Should return a string array with each element containing details about its respective car
    public String[] allCars(){
        //our string array
        String[] info = new String[cars.size()];

        //regular string which will hold each line
        String eachCar = null;
        int year = 0;
        int price = 0;

        for(int i = 0; i < cars.size(); i++){
            year = cars.get(i).getYear();
            price = cars.get(i).getPrice();
            //storing details of the car in that string
            eachCar = "Car " + (i+1) + ": " + cars.get(i).getModel() + " " + year + " " + price;

            //adding that string to the array
            info[i] = eachCar;
        }
        return info;
    }

    //so randomCar returns an int between 0 and cars.size() which we use in the gui
    public int randomCar() {
        Random rand = new Random();
        int randNum = rand.nextInt(cars.size());

        return randNum;
    }

    @Override
    //this returns a string array of prices ranging from min to max
    public String[] sortPrice(int min, int max) {
        ArrayList<String> initialArr = new ArrayList<>();
        String word = null;
        for(int i = 0; i < cars.size(); i++){
            if(cars.get(i).getPrice() >= min && cars.get(i).getPrice() <= max){
                //the string word is what contains the line that we show to the user
                word = cars.get(i).getPrice() + "~  " +cars.get(i).getModel() + " " + cars.get(i).getYear();
                //I'm storing that line in the arraylist I made
                initialArr.add(word);
            }

        }
        //Now I'm moving those lines to a string array so I can ultimately return that
        String[] p = new String[initialArr.size()];
        for(int i = 0; i < initialArr.size(); i++){
            p[i] = initialArr.get(i);
        }
        return p;
    }

    public void mergeSort(int [] arr, int start, int end){
        if(start >= end){
            return;
        }
        int midpoint = (end + start)/2;
        mergeSort(arr, start, midpoint);
        mergeSort(arr, midpoint+1, end);
        helper(arr,start,end);
    }


    public void helper(int[]arr,int start,int end){
        int begin = start;
        int mid1 = (start+end)/2;
        int mid2 = (start+end)/2;
        int temp = 0;
        while(begin <= mid1){
            int t = begin;
            while(mid2 <= end){
                if(arr[t] > arr[mid2]){
                    temp = arr[t];
                    arr[t] = arr[mid2];
                    arr[mid2] = temp;
                    t = mid2;
                }
                mid2++;
            }
            begin++;
            mid2 = mid1;
        }
    }
    @Override
    public String[] sortYear() {
        int [] years = new int[cars.size()];
        for(int i = 0; i < cars.size();i++){
            years[i] = cars.get(i).getYear();
        }
        mergeSort(years,0, years.length-1);
        HashMap<Integer, List<String>> map = new HashMap<>();

        for(ToyotaCar vehicle : cars){
            if(map.containsKey(vehicle.getYear()) == false){
                map.put(vehicle.getYear(), new ArrayList<>(Arrays.asList(vehicle.getModel())));
            }
            else{
                map.get(vehicle.getYear()).add(vehicle.getModel());
            }

        }
        ArrayList<String> words = new ArrayList<>();

        for (Integer n : years) {
            int i = 0;
            if(map.containsKey(n)){
                words.add(n + " ~ " + map.get(n).get(i));

                i++;
                while(i < map.get(n).size()) {
                    words.add(n + " ~ " + map.get(n).get(i));
                    i++;
                }
                map.remove(n);
            }
        }
        String[] w = new String[words.size()];

        for(int i = 0; i < words.size(); i++){
            w[i] = words.get(i);
        }
        return w;

    }

    //This is where we append that new car to our respective files
    @Override
    public void soldCar(int price, int year, String model) {
        //create a new car
        ToyotaCar car1 = new ToyotaCar();
        car1.setYear(year);
        car1.setPrice(price);
        car1.setModel(model);
        //add that car to your current list of cars
        cars.add(car1);

        try {
            FileWriter fw = new FileWriter("toyota.txt",true);
            PrintWriter out = new PrintWriter(fw);
            out.println(car1.getYear()+","+car1.getPrice()+","+car1.getModel());
            //it's important that you close the printWriter object
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
