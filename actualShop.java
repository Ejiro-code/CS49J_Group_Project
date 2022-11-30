import javax.swing.*;
import java.awt.*;

public class actualShop {
    Toyota vehicle = new Toyota();
    JFrame frame = new JFrame();
    JLabel toyota = new JLabel("Welcome to Toyota");
    JLabel options = new JLabel("Please select from one of the following: ");


    public actualShop() {
        toyota.setBounds(200,0,200,35);
        toyota.setForeground(Color.WHITE);
        options.setBounds(0, 30, 75, 35);
        options.setForeground(Color.WHITE);

        frame.add(toyota);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void setMinMax(){

    }
    public void sortPrice(){

    }
    public void sortYear(){

    }
    public void purchase(){

    }

}
