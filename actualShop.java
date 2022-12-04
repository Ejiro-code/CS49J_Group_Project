import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class actualShop implements ActionListener {
    Toyota vehicle = new Toyota("toyota.txt");
    Honda vehicle1 = new Honda();

    Ford vehicle2 = new Ford();

    Chevy vehicle3 = new Chevy();
    private String[] cars;

    int carV = 0;
    JFrame frame = new JFrame();
    JLabel mainBranch = new JLabel();
    //JLabel options = new JLabel("Please select from one of the following: ");
    JPanel pan1 = new JPanel();
    JPanel mainWin = new JPanel();
    //JButton allCars = new JButton();
    JButton allCars = new JButton("All Cars");
    JButton prices = new JButton("Price Range");
    JButton year = new JButton("Cars by their Years");
    JButton sell = new JButton("Sell your Car");
    JButton rand = new JButton("Random Car");

    JButton enter = new JButton("Search");
    JTextField min = new JTextField("", 1);
    JTextField max = new JTextField("",1);


    JTextField y = new JTextField("year",1);
    JTextField price = new JTextField("price",1);
    JTextField model = new JTextField("model",1);
    JButton submit = new JButton("Submit");

    public actualShop(int carVal) {
        carV = carVal;
        if(carV == 0){
            cars = vehicle.allCars();
            mainBranch.setText("Welcome to Toyota Motors");
        }
        else if(carV == 1){
            cars = vehicle1.allCars();
            mainBranch.setText("Welcome to Honda Motors");
        }
        else if(carV == 2){
            cars = vehicle2.allCars();
            mainBranch.setText("Welcome to Ford Motors");
        }
        else if (carV == 3) {
            cars = vehicle3.allCars();
            mainBranch.setText("Welcome to Chevrolet");
        }

        mainBranch.setBounds(200,0,200,35);
        mainBranch.setForeground(Color.WHITE);


        //allcars.setBounds();
        allCars.setFocusable(false);
        prices.setFocusable(false);
        year.setFocusable(false);
        sell.setFocusable(false);
        rand.setFocusable(false);
        pan1.setBounds(0,0, 150, 500);
        pan1.setBackground(Color.GRAY);
        pan1.add(allCars);
        pan1.add(prices);
        pan1.add(year);
        pan1.add(sell);
        pan1.add(rand);


        allCars.addActionListener(this);
        prices.addActionListener(this);
        year.addActionListener(this);
        sell.addActionListener(this);
        rand.addActionListener(this);

        mainWin.setBounds(150, 40, 350, 460);
        //mainWin.setBackground(Color.CYAN);

        frame.add(mainBranch);
        //frame.add(options);
        frame.add(pan1);
        frame.add(mainWin);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }


    public void getMinMax(){
        mainWin.removeAll();
        mainWin.revalidate();
        mainWin.repaint();

        min.setBounds(20,0, 50, 30);
        max.setBounds(60,0,50,30);
        //min.setFont(min.getFont().deriveFont(Font.BOLD, 50));
        min.setColumns(10);
        max.setColumns(10);
        enter.addActionListener(this);

        mainWin.add(min);
        mainWin.add(max);
        mainWin.add(enter);
        mainWin.revalidate();
        mainWin.repaint();
    }
    public void sortPrice(int min, int max){
        //Toyota vehicles = new Toyota();
        String [] c = vehicle.sortPrice(min, max);
         if (carV == 1) {
            c = vehicle1.sortPrice(min, max);
        }else if (carV == 2) {
             c = vehicle2.sortPrice(min, max);
        }else if (carV == 3) {
             c = vehicle3.sortPrice(min, max);
        }

        mainWin.removeAll();
        mainWin.revalidate();
        mainWin.repaint();

        JLabel text = new JLabel("Results: ");
        mainWin.add(text);
        for(int i = 0; i < c.length; i++){
            JLabel word = new JLabel(c[i]);
            word.setFont(new Font("MV Boli", Font.BOLD,15));
            //word.setBounds(150,40,50,35);
            mainWin.add(word);
        }
        mainWin.revalidate();
        mainWin.repaint();
    }
    public void sortYear(){
        mainWin.removeAll();
        mainWin.revalidate();
        mainWin.repaint();
        //JLabel line1 = new JLabel("");
        String[] word = vehicle.sortYear();

        if (carV == 1) {
            word = vehicle1.sortYear();
        }else if (carV == 2) {
            word = vehicle2.sortYear();
        }else if (carV == 3) {
            word = vehicle3.sortYear();
        }

        //System.out.println();
        JLabel text = new JLabel("Cars sorted by year: ");
        text.setBounds(0,0, 200,35);
        mainWin.add(text);

        for(int i = 0; i < word.length; i++){
            JLabel next = new JLabel("Car #"+ (i+1)+": "+word[i] + "  ");
            next.setFont(new Font("MV Boli", Font.BOLD,15));
            //next.setBounds(150,40,80,35);
            mainWin.add(next);

        }
        mainWin.revalidate();
        mainWin.repaint();
    }
    public void allVehicles(){
        mainWin.removeAll();
        JLabel line1 = new JLabel();

        //String[] c = vehicle.allToyotas();
        if(carV == 0){
            line1.setText("Here's a list of all Toyota Vehicles: ");
        } else if (carV == 1) {
            line1.setText("Here's a list of all Honda Vehicles: ");
        }else if (carV == 2) {
            line1.setText("Here's a list of all Ford Vehicles: ");
        }else if (carV == 3) {
            line1.setText("Here's a list of all Chevy Vehicles: ");
        }

        line1.setBounds(0,0, 200,35);
        mainWin.add(line1);
        mainWin.revalidate();
        mainWin.repaint();
        for(int i = 0; i < cars.length; i++){
            JLabel word = new JLabel(cars[i]);
            word.setFont(new Font("MV Boli", Font.BOLD,15));
            //word.setBounds(150,40,50,35);
            mainWin.add(word);

        }
        mainWin.revalidate();
        mainWin.repaint();
    }

    public void newCar(){
        mainWin.removeAll();
        mainWin.revalidate();
        mainWin.repaint();

        JLabel line1 = new JLabel("Please enter in the following details:");
        line1.setBounds(0,0, 200,35);
        mainWin.add(line1);


        y.setBounds(20,0, 70, 30);
        price.setBounds(20,30,70,30);
        model.setBounds(20,60,70,30);
        //min.setFont(min.getFont().deriveFont(Font.BOLD, 50));
        y.setColumns(10);
        price.setColumns(10);
        model.setColumns(10);

        submit.setBounds(20,80,30,30);
        submit.addActionListener(this);


        mainWin.add(y);
        mainWin.add(price);
        mainWin.add(model);
        mainWin.add(submit);
        mainWin.revalidate();
        mainWin.repaint();
    }

    public void randomCar(){
        mainWin.removeAll();
        mainWin.revalidate();
        mainWin.repaint();

        JLabel line1 = new JLabel();




        String[] c = vehicle.allCars();

        if (carV == 1) {
            c = vehicle1.allCars();
            line1.setText("Random Honda Vehicle");
        }else if (carV == 2) {
            c = vehicle2.allCars();
            line1.setText("Random Ford Vehicle");
        }else if (carV == 3) {
            c = vehicle3.allCars();
            line1.setText("Random Chevy Vehicle");
        }
        line1.setBounds(0,0, 200,35);
        mainWin.add(line1);

        JLabel ans = new JLabel(c[vehicle.randomCar()]);
        ans.setFont(new Font("MV Boli", Font.BOLD,15));
        mainWin.add(ans);
        mainWin.revalidate();
        mainWin.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == allCars){
            allVehicles();
        } else if (e.getSource() == prices) {
            getMinMax();
        } else if (e.getSource() == year) {
            sortYear();
        } else if (e.getSource() == sell) {
            submit.setEnabled(true);
            newCar();
        } else if (e.getSource() == rand) {
            randomCar();
        }
        if(e.getSource() == enter){
            sortPrice(Integer.valueOf(min.getText()), Integer.valueOf(max.getText()));
        }
        if(e.getSource() == submit){
            submit.setEnabled(false);
            if(carV == 0){
                vehicle.soldCar(Integer.valueOf(price.getText()),Integer.valueOf(y.getText()),model.getText());
            }
            if (carV == 1) {
                vehicle1.soldCar(Integer.valueOf(price.getText()),Integer.valueOf(y.getText()),model.getText());
            }else if (carV == 2) {
                vehicle2.soldCar(Integer.valueOf(price.getText()),Integer.valueOf(y.getText()),model.getText());
            }else if (carV == 3) {
                vehicle3.soldCar(Integer.valueOf(price.getText()),Integer.valueOf(y.getText()),model.getText());
            }

            JLabel submitted = new JLabel("Thank you");
            submitted.setBounds(20,100,60,30);
            submitted.setBackground(Color.GREEN);
            mainWin.add(submitted);
            mainWin.revalidate();
            mainWin.repaint();

        }
    }
}
