import org.w3c.dom.Node;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainWindow implements ActionListener {
    JFrame frame = new JFrame();
    JButton search = new JButton("Search");

    JRadioButton Toyota = new JRadioButton("Toyota");
    JRadioButton Honda = new JRadioButton("Honda");
    JRadioButton Ford = new JRadioButton("Ford");
    JRadioButton Chevrolet = new JRadioButton("Chevrolet");
    JLabel carName = new JLabel("Car Brand:");
    JTextField brand = new JTextField();

    public mainWindow() {
        //carName.setBounds(60, 100, 75, 25);
        //brand.setBounds(135, 100, 120, 25);
        //search.setBounds(135, 135, 100, 25);
        //search.addActionListener(this);
        //search.setFocusable(false);

        ///**
        ButtonGroup buts = new ButtonGroup();
        buts.add(Toyota);
        buts.add(Honda);
        buts.add(Ford);
        buts.add(Chevrolet);
         //*/

        Toyota.setBounds(110, 50, 120, 25);
        Honda.setBounds(110, 70, 120, 25);
        Ford.setBounds(110, 90, 120, 25);
        Chevrolet.setBounds(110, 110, 120, 25);

        Toyota.addActionListener(this);
        Honda.addActionListener(this);
        Ford.addActionListener(this);
        Chevrolet.addActionListener(this);


        frame.add(carName);
        frame.add(brand);
        frame.add(search);
        frame.add(Toyota);
        frame.add(Honda);
        frame.add(Ford);
        frame.add(Chevrolet);
        //frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Toyota){
            //String text = brand.getText();

            //if(text.equals("Toyota")){
            actualShop shop = new actualShop(0);
                //System.out.println("We made it");
            //}
        }
        else if(e.getSource() == Honda){
            actualShop shop = new actualShop(1);
        }
        else if(e.getSource() == Ford){
            actualShop shop = new actualShop(2);
        }
        else if(e.getSource() == Chevrolet){
            actualShop shop = new actualShop(3);
        }


    }
}
