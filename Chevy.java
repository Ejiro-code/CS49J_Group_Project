import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
    public void sortPrice(int min, int max) {

    }

    @Override
    public void sortYear() {

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
