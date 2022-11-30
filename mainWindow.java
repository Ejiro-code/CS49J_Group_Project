import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainWindow implements ActionListener {
    JFrame frame = new JFrame();
    JButton search = new JButton("Search");
    JLabel carName = new JLabel("Car Brand:");
    JTextField brand = new JTextField();

    public mainWindow() {
        carName.setBounds(60, 100, 75, 25);
        brand.setBounds(135, 100, 120, 25);
        search.setBounds(135, 135, 100, 25);
        search.addActionListener(this);
        search.setFocusable(false);

        frame.add(carName);
        frame.add(brand);
        frame.add(search);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == search){
            String text = brand.getText();

            if(text.equals("Toyota")){
                actualShop shop = new actualShop();
                System.out.println("We made it");
            }
        }


    }
}
