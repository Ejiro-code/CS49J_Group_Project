import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;

public class Chevy extends Vehicle{

    ChevyPriceTree priceTree = new ChevyPriceTree();
    ChevyAgeTree ageTree = new ChevyAgeTree();

    @Override
    public void randomCar() {

    }

    @Override
    public String[] allCars() {
        return new String[0];
    }

    @Override
    public String[] sortPrice(int min, int max) {
        ArrayList<ChevyCar> aList = priceTree.printAscending();
        ArrayList<ChevyCar> withinBoundsList = new ArrayList<ChevyCar>();
        for (int i = 0; i < aList.size(); i++){
            if (aList.get(i).getYear() >= min){
                if (aList.get(i).getYear() <= max){
                    withinBoundsList.add(aList.get(i));
                } else break;
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
    }

    private void addCar(ChevyCar temp) {
        File chevyFile = new File("chevy.txt");
        try {
            FileWriter writer = new FileWriter("chevy.txt");
            writer.write(temp.getYear() + "," + temp.getPrice() + "," + temp.getModel());
            writer.close();
        } catch (IOException e) {
            System.out.println("Error in writing to chevy.txt");
        }
    }
}
