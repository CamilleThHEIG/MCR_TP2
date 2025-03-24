package mcr;

import mcr.account.Client;
import mcr.account.Publisher;
import mcr.display.ClientDetailsWindow;

import java.awt.*;
import java.util.LinkedList;
import java.util.Map;
import javax.swing.*;

public class MainWindow implements Subscriber{
    private JFrame frame;
    private Flight selectedFlight;
    private Ticket selectedTicket;

    public MainWindow(LinkedList<Client> clients, LinkedList<Flight> flights){
        // Creating instance of JFrame
        JFrame frame = new JFrame();

        frame.setTitle("Clients manager");

        // Eeeeh

        JLabel clientLabel = new JLabel("Client");
        JComboBox clientComboBox = new JComboBox();
        for(Client client : clients){
            clientComboBox.addItem(client);
        }
        JButton detailsButton = new JButton("Details");
        detailsButton.addActionListener(e -> {
            Client selectedClient = (Client) clientComboBox.getSelectedItem();
            if (selectedClient != null) {
                new ClientDetailsWindow(selectedClient);
            }
        });

        JLabel creditsLabel = new JLabel("Credits");
        JTextField creditsField = new JTextField();
        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> {
            Client selectedClient = (Client) clientComboBox.getSelectedItem();
            try {
                int amount = Integer.parseInt(creditsField.getText());
                selectedClient.addCredit(amount);
                creditsField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Veuillez entrer un nombre valide !");
            }
        });

        JLabel flightLabel = new JLabel("Flight");
        JComboBox flightComboBox = new JComboBox();
        for(Flight flight : flights){
            if(selectedFlight == null){
                selectedFlight = flight;
            }
            flightComboBox.addItem(flight);
        }

        JComboBox flightClassComboBox = new JComboBox();
        for(Map.Entry<Ticket, Double> entry : this.selectedFlight.getTicketsPrice().entrySet()) {
            flightClassComboBox.addItem(entry.getKey() + " " + entry.getValue());
        }
        JButton bookCashButton = new JButton("Book (cash)");
        bookCashButton.addActionListener(e -> {
            Client selectedClient = (Client) clientComboBox.getSelectedItem();
            if (selectedClient != null) {
                selectedClient.bookWithCredits(selectedFlight, selectedTicket);
            }
        });

        JButton bookMilesButton = new JButton("Book (miles)");
        bookMilesButton.addActionListener(e -> {
            Client selectedClient = (Client) clientComboBox.getSelectedItem();
            if (selectedClient != null) {

            }
        });

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

    public void sayHello(){
        System.out.println("Hello :D");
    }

    public void setVisible(boolean value){
        frame.setVisible(value);
    }

    @Override
    public void update(Publisher publisher) {

    }
}
