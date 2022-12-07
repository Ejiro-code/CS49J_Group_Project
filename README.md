# CS49J_Group_Project
Team Members - Ejiro, Ashton, Niko, and Dean.

How to Run 
Once the zip file is downloaded, unpack the zip file and save the document into the directory accessed by your IDE of preference. On your IDE open up the project and click, then run on the “main” file to startup the application.

Abstract class - 
allCars() - Each class is required to print out all cars for specific brand
sortPrice(int min, int max) - All brands required to list out vehicles within specific price range
sortYear() - Each class sorts the cars by year
soldCar() - Adds a new car to the list of cars as well as starter file

Interface
Requires getters for variables within the class that extends it.

Toyota extends abstract class
Constructor - reads the file passed in its parameter and proceeds to scan each line, taking each individual, comma-separated element, and placing them in their respective variables before finally storing the new car object in our array of toyota cars.

allCars() - returns a string array with each element containing details about its respective car.

randomCar() - randomCar returns an int between 0 and cars.size() which we use in the GUI
To obtain a random toyota car

sortPrice(int min, int max) - reads through the toyota car arrayList and returns a string array of prices ranging from min to max.

mergeSort() - Recursively divides array in half
helper() - uses comparisons to continuously sort smaller arrays

sortYear() - uses the merge sort method to sort an integer array containing all the years within the file. Hash map is used to assign each year to its corresponding model so both values can be stored in the string array which we then return.

soldCar(int price, int year, String model) - New toyota car object is created using parameters and added to the arraylist of toyota cars as well as appended to the starting file.

ToyotaCar implements interface
Variables: year (year car was produced), price, and model

constructor - assigns values within incoming parameters to our private variables
setYear, setPrice, setModel - setters for our three private variables.
getYear, getPrice, getModel - getters for our three variables.

Honda extends the abstract class Vehicle

Honda() - This acts as the constructor for the class, passing in the honda text file that has all of the Honda cars, declaring a variable to store this file for use in the other methods, scanning the file, and storing each line (each car, comma separated) of the file into a declared ArrayList named cars.

allCars() - A String array that prints and returns all of the information of each car in the ArrayList in the order it was initially put in the text file

randomCar() - Returns a randomly selected number between 0 and the number that is the size of the ArrayList, which is utilized in the GUI

sortPrice(int min, int max) - Sorts the ArrayList of cars in order by year, making use of a binary search tree, and then filters out all of the cars that fall outside of the bounds of the minimum and maximum price that the user inputs in the GUI

HondaNode() - stores all information of a HondaCar into a node
HondaBST() - recursively orders all of the Honda cars in ascending order by year

sortYear(int price, int year, String model) - Uses a LinkedList to store all of the cars, and then uses collections.sort to order all of the cars in ascending order by year. The sorted LinkedList is then converted into an Object array, and then into a String array so it can be returned

soldCar() - Allows the user to input a new Honda car to be added to the ArrayList of cars, as well as written back into the original text file

HondaCar implements the interface VehicleBuild

Variables - year (int of the year the car’s retail year), price (int of the MSRP price or used buy price, depending on the year), and model (String of the model of the car)

Constructor - Assigns values to the private variables 
setYear(), setPrice(), and setModel() - the setters for our private variables
getYear(), getPrice(), and getModel() - the getters for our private variables


Ford extends the abstract class Vehicle

Ford() - This is the constructor of the class and passes in the ford.txt file that has the ford cars in it. Scanner then scans each element that is separated by a comma in the file and then places it into the array list of ford cars. 

randomCar() - This method picks a random number from 0 to the cars.size() and returns said random car. 

allCars() - This method creates a string array that contains the vehicle's respective elements.

sortPrice() - This method creates an array list and then a for loop goes through the file given the cars.size()(size of the file). The if statement gets the users price max and min and the word car will display the cars that fit within the users input.

sortYear() - This method creates a binary search tree and the Node root creates a node which
consists of the year and model of the first and then the for loop iterates through the file and then stores all the years and models in the string array which it then prints.

soldCar() - This method lets the user create a new car (Ford car) and write that car back to the file.

Ford.Car implements the interface Vehicle build

FordCar() - Setting the instance variables. Year of car. Price of car. Model of car.

Constructor assigns values to private variables
setYear, setPrice, setModel - setters for our three private variables.
getYear, getPrice, getModel - getters for our three variables.

BST class

Node() - Class for the node sets the instance variables data, model, left and right

BST() - This creates an array list. 

sortYear() - This method is iterating through the tree using recursion and as it’s going through the tree it's using inorder traversal to print the values in ascending order. Sol.add is then storing the information into the array list. 

results() - this method is taking the array list with the values that were put into it from the sortYear method and storing them into a string array to make it easier for the GUI. 

insertRec() - this method is creating a new node if the tree is empty, and then inserts the values in the left subtree if it's less than the root and and the right subtree if it's greater than the root. 

display() - displays the data from the left and right subtree. 


Chevy extends the abstract class Vehicle

public Chevy(String filename) initializes a BST that will sort by price, a BST that will sort by age, a file with the specified file name which will store the cars, and an ArrayList that stores the cars. Will also add any cars already on an existing file to the trees and ArrayList

public int randomCar() returns a random int that corresponds to a line of the file

public String[] allCars() returns a String array where each element is a line of the file, reformatted for easier reading
public String[] sortPrice(int min, int max) returns a String array sorted by ascending price of the car, if the price is within the bounds specified in the arguments

public String[] sortYear() returns a String array sorted by ascending year of the car

public void soldCar(int price, int year, String model) adds a car with the specified values to the file, arrayList, and both BSTs

private void addCar(ChevyCar temp) adds the car to the file (can’t be called directly, only gets called by soldCar

ChevyCar implements VehicluBuild

public ChevyCar(int year, int price, String model) sets the year, price, and model

public String getModel(), public int getPrice(), and public int getYear() return the model, price, and year respectively

public void getModel(), public void getPrice(), and public void getYear() set the model, price, and year respectively

ChevyNode

public ChevyNode(ChevyCar c) creates a node with data given by the car passed in the function argument, with the left and right nodes being null

ChevyAgeTree

private ChevyNode addRecursive(ChevyNode current, ChevyNode n) Adds the node to the tree in the proper place. If the current node is null, it puts the node there. If the given node’s year is less than or equal to the current node’s year, it recursively calls the function with the left node. If the given node’s year is greater than the current node’s year, it recursively calls the function with the left node.

public void add(ChevyNode n) adds the node to the tree by calling addRecursive with the root of the tree and the given ChevyNode

void printAscendingRecursive(ChevyNode current, ArrayList<ChevyCar> sortedArr) inorder iterates through the tree and adds the ChevyCars in ascending order of year to the ArrayList that was passed in as an argument.

ArrayList<ChevyCar> printAscending() calls the printAscendingRecursive method with the root of the tree and an empty ArrayList. After printAscrendingRecursive populates the ArrayList, printAscending returns the list

ChevyPriceTree

private ChevyNode addRecursive(ChevyNode current, ChevyNode n) Adds the node to the tree in the proper place. If the current node is null, it puts the node there. If the given node’s price is less than or equal to the current node’s price, it recursively calls the function with the left node. If the given node’s price is greater than the current node’s price, it recursively calls the function with the left node.

public void add(ChevyNode n) adds the node to the tree by calling addRecursive with the root of the tree and the given ChevyNode

void printAscendingRecursive(ChevyNode current, ArrayList<ChevyCar> sortedArr) inorder iterates through the tree and adds the ChevyCars in ascending order of price to the ArrayList that was passed in as an argument.

ArrayList<ChevyCar> printAscending() calls the printAscendingRecursive method with the root of the tree and an empty ArrayList. After printAscrendingRecursive populates the ArrayList, printAscending returns the list
