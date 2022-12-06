public class Main {
    public static void main(String[] args) {
        Honda s = new Honda();
        Ford f = new Ford();
        Chevy c = new Chevy("chevy.txt");

        //When Niko and Ashton wrap up their methods, they can uncomment the next two lines respectively
        //s.something("honda.txt");
        //f.something("ford.txt");
        //Dean doesn't have a method that reads the file as of yet
        mainWindow win = new mainWindow();
    }
}