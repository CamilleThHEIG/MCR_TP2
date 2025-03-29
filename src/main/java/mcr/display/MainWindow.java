package mcr.display;

import mcr.Flight;
import mcr.Ticket;
import mcr.TicketType;
import mcr.account.Client;

import javax.swing.*;
import java.util.LinkedList;

public class MainWindow {
    private final JFrame frame;
    private Flight selectedFlight;
    private Ticket selectedTicket;
    private Client selectedClient;

    public MainWindow(LinkedList<Client> clients, LinkedList<Flight> flights) {
        // TODO we can slit this constructor into multiple functions
        this.selectedFlight = flights.getFirst();
        this.selectedClient = clients.getFirst();
        this.selectedTicket = this.selectedFlight.getTickets().get(0);
        frame = new JFrame();
        frame.setTitle("Clients manager");
        JLabel clientLabel = new JLabel("Client");
        JComboBox<Client> clientComboBox = new JComboBox<>();
        for (Client client : clients) {
            clientComboBox.addItem(client);
        }

        JButton detailsButton = new JButton("Details");
        detailsButton.addActionListener(e -> {
            selectedClient = (Client) clientComboBox.getSelectedItem();
            if (selectedClient != null) {
                new ClientDetailsWindow(selectedClient);
            }
        });

        JLabel creditsLabel = new JLabel("Credits");
        JTextField creditsField = new JTextField();
        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> {
            selectedClient = (Client) clientComboBox.getSelectedItem();
            try {
                int amount = Integer.parseInt(creditsField.getText());
                assert selectedClient != null;
                selectedClient.addCredit(amount);
                creditsField.setText("");
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid number");
            }
        });
        JLabel flightLabel = new JLabel("Flight");

        JComboBox<Flight> flightComboBox = new JComboBox<>();
        for (Flight flight : flights) {
            flightComboBox.addItem(flight);
        }

        JComboBox<Ticket> ticketComboBox = new JComboBox<>();
        for(Ticket t : this.selectedFlight.getTickets()){
            ticketComboBox.addItem(t);
        }

        flightComboBox.addActionListener(e -> {
            selectedFlight = (Flight) flightComboBox.getSelectedItem();
            ticketComboBox.removeAllItems();
            for(Ticket t : this.selectedFlight.getTickets()){
                ticketComboBox.addItem(t);
            }
        });

        ticketComboBox.addActionListener(e -> {
            selectedTicket = (Ticket) ticketComboBox.getSelectedItem();
        });

        JButton bookCashButton = new JButton("Book (cash)");
        bookCashButton.addActionListener(e -> {
            Client selectedClient = (Client) clientComboBox.getSelectedItem();
            if (selectedClient != null && selectedFlight != null && selectedTicket != null) {
                selectedClient.bookWithCredits(selectedFlight, selectedTicket);
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a client, flight and ticket class");
            }
        });

        JButton bookMilesButton = new JButton("Book (miles)");
        bookMilesButton.addActionListener(e -> {
            Client selectedClient = (Client) clientComboBox.getSelectedItem();
            if (selectedClient != null && selectedFlight != null && selectedTicket != null) {
                selectedClient.bookWithMiles(selectedFlight, selectedTicket);
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a client, flight and ticket class");
            }
        });

        JButton statusButton = new JButton("Statuses");
        statusButton.addActionListener(e -> new StatusesWindow(clients));

        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(e -> frame.dispose());

        // Setting the bounds of the elements

        clientLabel.setBounds(50, 50, 80, 30);
        clientComboBox.setBounds(100, 50, 130, 30);
        detailsButton.setBounds(240, 50, 100, 30);

        creditsLabel.setBounds(50, 100, 80, 30);
        creditsField.setBounds(100, 100, 115, 30);
        addButton.setBounds(225, 100, 120, 30);

        flightLabel.setBounds(20, 150, 50, 30);
        flightComboBox.setBounds(80, 150, 135, 30);
        ticketComboBox.setBounds(235, 150, 120, 30);
        bookCashButton.setBounds(365, 150, 120, 30);
        bookMilesButton.setBounds(500, 150, 120, 30);

        statusButton.setBounds(20, 200, 100, 30);
        quitButton.setBounds(130, 200, 80, 30);

        // Adding everything to the window frame

        frame.add(clientLabel);
        frame.add(clientComboBox);
        frame.add(detailsButton);

        frame.add(creditsLabel);
        frame.add(creditsField);
        frame.add(addButton);

        frame.add(flightLabel);
        frame.add(flightComboBox);
        frame.add(ticketComboBox);
        frame.add(bookCashButton);
        frame.add(bookMilesButton);

        frame.add(statusButton);
        frame.add(quitButton);

        frame.setSize(700, 350);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}