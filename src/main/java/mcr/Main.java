package mcr;

import java.awt.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");
        // Je vais essayer de faire une structure fenêtre qui ressemble à la principale de la donnée

        // Creating instance of JFrame
        JFrame frame = new JFrame();

        // Eeeeh

        JLabel clientLabel = new JLabel("client");
        JComboBox clientComboBox = new JComboBox();
        clientComboBox.addItem("Boucher Guy");  // just for testing
        JButton detailsButton = new JButton("Details");

        JLabel creditsLabel = new JLabel("credits");
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
        clientLabel.setBounds(50, 200, 120, 30);
        clientComboBox.setBounds(150, 200, 180, 30);
        detailsButton.setBounds(350, 200, 200, 30);

        creditsLabel.setBounds(50, 250, 120, 30);
        creditsField.setBounds(100, 250, 80, 30);
        addButton.setBounds(200, 250, 120, 30);

        flightLabel.setBounds(20, 300, 50, 30);
        flightComboBox.setBounds(60, 300, 80, 30);
        flightClassComboBox.setBounds(220, 300, 120, 30);
        bookCashButton.setBounds(400, 300, 120, 30);
        bookMilesButton.setBounds(550, 300, 120, 30);

        statusButton.setBounds(20, 370, 50, 30);
        quitButton.setBounds(60, 370, 80, 30);


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
        frame.setSize(800, 700);

        // using no layout managers
        frame.setLayout(null);

        // making the frame visible
        frame.setVisible(true);
    }
}