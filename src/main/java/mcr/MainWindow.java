package mcr;

import java.awt.*;
import javax.swing.*;

// is it useful to make a singleton class out of this ?
public class MainWindow {
    private static MainWindow instance = null;

    private JFrame frame;
    private MainWindow(){
        // Creating instance of JFrame
        JFrame frame = new JFrame();

        frame.setTitle("Clients manager");

        // Eeeeh

        JLabel clientLabel = new JLabel("Client");
        JComboBox clientComboBox = new JComboBox();
        clientComboBox.addItem("Boucher Guy");  // just for testing
        JButton detailsButton = new JButton("Details");

        JLabel creditsLabel = new JLabel("Credits");
        JTextField creditsField = new JTextField();
        JButton addButton = new JButton("Add");

        JLabel flightLabel = new JLabel("Flight");
        JComboBox flightComboBox = new JComboBox();
        flightComboBox.addItem("LX1 (1200 miles)");  // just for testing
        JComboBox flightClassComboBox = new JComboBox();
        flightClassComboBox.addItem("Economy 300$");  // just for testing
        JButton bookCashButton = new JButton("Book (cash)");
        JButton bookMilesButton = new JButton("Book (miles)");

        JButton statusButton = new JButton("Statuses");
        JButton quitButton = new JButton("Quit");

        // x axis, y axis, width, height
        clientLabel.setBounds(50, 50, 80, 30);
        clientComboBox.setBounds(100, 50, 130, 30);
        detailsButton.setBounds(240, 50, 100, 30);

        creditsLabel.setBounds(50, 100, 80, 30);
        creditsField.setBounds(100, 100, 115, 30);
        addButton.setBounds(225, 100, 120, 30);

        flightLabel.setBounds(20, 150, 50, 30);
        flightComboBox.setBounds(80, 150, 135, 30);
        flightClassComboBox.setBounds(235, 150, 120, 30);
        bookCashButton.setBounds(365, 150, 120, 30);
        bookMilesButton.setBounds(500, 150, 120, 30);

        statusButton.setBounds(20, 200, 100, 30);
        quitButton.setBounds(130, 200, 80, 30);

        // adding button in JFrame
        frame.add(clientLabel);
        frame.add(clientComboBox);
        frame.add(detailsButton);

        frame.add(creditsLabel);
        frame.add(creditsField);
        frame.add(addButton);

        frame.add(flightLabel);
        frame.add(flightComboBox);
        frame.add(flightClassComboBox);
        frame.add(bookCashButton);
        frame.add(bookMilesButton);

        frame.add(statusButton);
        frame.add(quitButton);

        // 400 width and 500 height
        frame.setSize(700, 350);

        // using no layout managers
        frame.setLayout(null);

        // making the frame visible
        frame.setVisible(true);
        this.frame = frame;
    }

    public static MainWindow getInstance() {
        if (instance == null){
            instance = new MainWindow();
        }
        return instance;
    }
    public void sayHello(){
        System.out.println("Hello :D");
    }

    public void setVisible(boolean value){
        frame.setVisible(value);
    }
}
