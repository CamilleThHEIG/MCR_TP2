package mcr;

import mcr.account.Client;
import mcr.account.Publisher;
import mcr.display.ClientDetailsWindow;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Map;

public class MainWindow implements Subscriber {
    private JFrame frame;
    private Flight selectedFlight;
    private Ticket selectedTicketClass;
    private LinkedList<Client> clients;
    private LinkedList<Flight> flights;

    public MainWindow(LinkedList<Client> clients, LinkedList<Flight> flights) {
        this.clients = clients;
        this.flights = flights;
        this.selectedFlight = flights.getFirst();

        frame = new JFrame();
        frame.setTitle("Clients manager");

        // Client selection
        JLabel clientLabel = new JLabel("Client");
        JComboBox<Client> clientComboBox = new JComboBox<>();
        for (Client client : clients) {
            clientComboBox.addItem(client);
        }

        JButton detailsButton = new JButton("Details");
        detailsButton.addActionListener(e -> {
            Client selectedClient = (Client) clientComboBox.getSelectedItem();
            if (selectedClient != null) {
                new ClientDetailsWindow(selectedClient);
            }
        });

        // Credits management
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
                JOptionPane.showMessageDialog(frame, "Please enter a valid number!");
            }
        });

        // Flight booking
        JLabel flightLabel = new JLabel("Flight");
        JComboBox<Flight> flightComboBox = new JComboBox<>();
        for (Flight flight : flights) {
            flightComboBox.addItem(flight);
        }

        JComboBox<String> flightClassComboBox = new JComboBox<>();
        updateTicketClassesComboBox(flightComboBox, flightClassComboBox);

        flightComboBox.addActionListener(e -> {
            selectedFlight = (Flight) flightComboBox.getSelectedItem();
            updateTicketClassesComboBox(flightComboBox, flightClassComboBox);
        });

        flightClassComboBox.addActionListener(e -> {
            String selected = (String) flightClassComboBox.getSelectedItem();
            selectedTicketClass = parseTicket(selected);
        });

        JButton bookCashButton = new JButton("Book (cash)");
        bookCashButton.addActionListener(e -> {
            Client selectedClient = (Client) clientComboBox.getSelectedItem();
            if (selectedClient != null && selectedFlight != null && selectedTicketClass != null) {
                selectedClient.bookWithCredits(selectedFlight, selectedTicketClass);
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a client, flight and ticket class!");
            }
        });

        JButton bookMilesButton = new JButton("Book (miles)");
        bookMilesButton.addActionListener(e -> {
            Client selectedClient = (Client) clientComboBox.getSelectedItem();
            if (selectedClient != null && selectedFlight != null && selectedTicketClass != null) {
                //selectedClient.bookWithMiles(selectedFlight, selectedTicketClass);
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a client, flight and ticket class!");
            }
        });

        // Other buttons
        JButton statusButton = new JButton("Statuses");
        //statusButton.addActionListener(e -> new StatusesWindow(clients));

        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(e -> frame.dispose());

        // Layout setup
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

        // Add components to frame
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

        frame.setSize(700, 350);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    private void updateTicketClassesComboBox(JComboBox<Flight> flightComboBox, JComboBox<String> classComboBox) {
        classComboBox.removeAllItems();
        Flight flight = (Flight) flightComboBox.getSelectedItem();
        if (flight != null) {
            for (Map.Entry<Ticket, Double> entry : flight.getTicketsPrice().entrySet()) {
                classComboBox.addItem(entry.getKey().toString() + " - $" + entry.getValue());
            }
        }
    }

    private Ticket parseTicket(String classString) {
        if (classString.contains("Economy")) return Ticket.Economy;
        if (classString.contains("Business")) return Ticket.Business;
        if (classString.contains("First")) return Ticket.First;
        return null;
    }

    @Override
    public void update(Publisher publisher) {
        // Handle updates if needed
    }

    public void setVisible(boolean value) {
        frame.setVisible(value);
    }
}