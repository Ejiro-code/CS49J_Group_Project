import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Chevy extends Vehicle{
    /**
     * Initializes a ChevyPriceTree, a ChevyAgeTree, a File, and an ArrayList
     * Also prints the cars in the File. Reads what cars already exist in the file
     * and adds them to the trees and the ArrayList
     * @param filename
     */
    public Chevy(String filename) {
        this.priceTree = new ChevyPriceTree();
        this.ageTree = new ChevyAgeTree();
        this.chevyFile = new File(filename);
        this.chevyCarsArrL = new ArrayList<ChevyCar>();

        try {
            Scanner s = new Scanner(chevyFile);
            ArrayList<ChevyCar> arr = new ArrayList<ChevyCar>();
            while (s.hasNextLine()){
                ChevyCar c = new ChevyCar();
                Scanner line = new Scanner(s.nextLine());
                String[] singleLine = new String[3];
                line.useDelimiter(",");
                /*int i = 0;
                while (line.hasNext()){
                    singleLine[i] = line.next();
                    i++;
                }*/
                if (line.hasNext()) {
                    c.setYear(line.nextInt());
                }
                if (line.hasNext()) {
                    c.setPrice(line.nextInt());
                }
                if (line.hasNext()) {
                    c.setModel(line.next());
                }
                arr.add(c);
            }
            for (int i = 0; i < arr.size(); i++){
                System.out.println(arr.get(i).getYear() + " Chevy " + arr.get(i).getModel() + " - $" + arr.get(i).getPrice());
                ChevyNode tempNode = new ChevyNode(arr.get(i));
                priceTree.add(tempNode);
                ageTree.add(tempNode);
                chevyCarsArrL.add(arr.get(i));
            }
        } catch(FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    ChevyPriceTree priceTree;
    ChevyAgeTree ageTree;
    File chevyFile;
    ArrayList<ChevyCar> chevyCarsArrL;

//    @Override
    public int randomCar() {
        try {
            Scanner s = new Scanner(chevyFile);
            int size = 0;
            while (s.hasNextLine()){
                size++;
                s.nextLine();
            }
            Random r = new Random();
            return r.nextInt(size);
        } catch(FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String[] allCars() {
        try {
            Scanner s = new Scanner(chevyFile);
            ArrayList<String> arr = new ArrayList<String>();
            while (s.hasNextLine()){
                Scanner line = new Scanner(s.nextLine());
                String[] singleLine = new String[3];
                line.useDelimiter(",");
                /*int i = 0;
                while (line.hasNext()){
                    singleLine[i] = line.next();
                    i++;
                }
                arr.add(singleLine[0] + " Chevy " + singleLine[2] + " - $" + singleLine[1]);
                 */
                if (line.hasNext()) {
                    singleLine[0] = Integer.toString(line.nextInt());
                }
                if (line.hasNext()) {
                    singleLine[1] = Integer.toString(line.nextInt());
                }
                if (line.hasNext()) {
                    singleLine[2] = line.next();
                }
                arr.add(singleLine[0] + " Chevy " + singleLine[2] + " - $" + singleLine[1]);
            }
            String[] carList = new String[arr.size()];
            for (int i = 0; i < arr.size(); i++){
                carList[i] = arr.get(i);
            }
            return carList;
        } catch(FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String[] sortPrice(int min, int max) {
        ArrayList<ChevyCar> aList = priceTree.printAscending();
        ArrayList<ChevyCar> withinBoundsList = new ArrayList<ChevyCar>();
        for (int i = 0; i < aList.size(); i++){
            if (aList.get(i).getPrice() >= min && aList.get(i).getPrice() <= max){
                withinBoundsList.add(aList.get(i));
            }
        }
        String[] arr = new String[withinBoundsList.size()];
        for (int i = 0; i < withinBoundsList.size(); i++){
            arr[i] = withinBoundsList.get(i).getYear() + " Chevy " + withinBoundsList.get(i).getModel() + " - $" + withinBoundsList.get(i).getPrice();
        }
        return arr;
    }

    @Override
    public String[] sortYear() {
        ArrayList<ChevyCar> aList = ageTree.printAscending();
        String[] arr = new String[aList.size()];
        for (int i = 0; i < aList.size(); i++){
            arr[i] = aList.get(i).getYear() + " Chevy " + aList.get(i).getModel() + " - $" + aList.get(i).getPrice();
        }
        return arr;
    }

    @Override
    public void soldCar(int price, int year, String model) {
        ChevyCar temp = new ChevyCar(year, price, model);
        addCar(temp);
        ChevyNode tempNode = new ChevyNode(temp);
        priceTree.add(tempNode);
        ageTree.add(tempNode);
        chevyCarsArrL.add(temp);
    }

    private void addCar(ChevyCar temp) {
        try {
            FileWriter f = new FileWriter("chevy.txt",true);
            PrintWriter p = new PrintWriter(f);
            p.print("\n" + temp.getYear() + "," + temp.getPrice() + "," + temp.getModel());
            //it's important that you close the printWriter object
            p.close();
            /*FileWriter writer = new FileWriter("chevy.txt");
            writer.write(temp.getYear() + "," + temp.getPrice() + "," + temp.getModel());
            writer.close();*/
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
