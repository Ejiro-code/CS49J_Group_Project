import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class actualShop implements ActionListener {
    Toyota vehicle = new Toyota();
    HondaCar vehicle1 = new HondaCar();
    private String[] cars;
    JFrame frame = new JFrame();
    JLabel toyota = new JLabel("Welcome to Toyota");
    //JLabel options = new JLabel("Please select from one of the following: ");
    JPanel pan1 = new JPanel();
    JPanel mainWin = new JPanel();
    //JButton allCars = new JButton();
    JButton allCars = new JButton("All Cars");
    JButton prices = new JButton("Price Range");
    JButton year = new JButton("Cars by their Years");
    JButton sell = new JButton("Sell your Car");

    JButton enter = new JButton("Search");
    JTextField min = new JTextField("", 1);
    JTextField max = new JTextField("",1);

    public actualShop(int carVal) {
        if(carVal == 0){
            cars = vehicle.allCars();
        }
        else if(carVal == 1){
            cars = vehicle1.allCars();
        }

        toyota.setBounds(200,0,200,35);
        toyota.setForeground(Color.WHITE);


        //allcars.setBounds();
        allCars.setFocusable(false);
        prices.setFocusable(false);
        year.setFocusable(false);
        sell.setFocusable(false);
        pan1.setBounds(0,0, 150, 500);
        pan1.setBackground(Color.GRAY);
        pan1.add(allCars);
        pan1.add(prices);
        pan1.add(year);
        pan1.add(sell);


        allCars.addActionListener(this);
        prices.addActionListener(this);
        year.addActionListener(this);
        sell.addActionListener(this);

        mainWin.setBounds(150, 40, 350, 460);
        //mainWin.setBackground(Color.CYAN);

        frame.add(toyota);
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
        //String[] c = vehicle.sortPrice(min, max);
        mainWin.removeAll();
        mainWin.revalidate();
        mainWin.repaint();

        JLabel text = new JLabel("Results: ");
        mainWin.add(text);
        for(int i = 0; i < cars.length; i++){
            JLabel word = new JLabel(cars[i]);
            word.setFont(new Font("MV Boli", Font.BOLD,15));
            //word.setBounds(150,40,50,35);
            mainWin.add(word);
        }
        mainWin.revalidate();
        mainWin.repaint();
    }
    public void sortYear(){
        mainWin.removeAll();
    }
    public void allVehicles(){
        mainWin.removeAll();
        JLabel line1 = new JLabel("Here's a list of all Toyota Vehicles: ");
        line1.setBounds(0,0, 200,35);
        mainWin.add(line1);
        mainWin.revalidate();
        mainWin.repaint();

        //String[] c = vehicle.allToyotas();
        for(int i = 0; i < cars.length; i++){
            JLabel word = new JLabel(cars[i]);
            word.setFont(new Font("MV Boli", Font.BOLD,15));
            //word.setBounds(150,40,50,35);
            mainWin.add(word);

        }
        mainWin.revalidate();
        mainWin.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == allCars){
            allVehicles();
        } else if (e.getSource() == prices) {
            getMinMax();
        }
        if(e.getSource() == enter){
            sortPrice(Integer.valueOf(min.getText()), Integer.valueOf(max.getText()));
        }
    }
}
