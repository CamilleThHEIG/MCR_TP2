package mcr.display;

import mcr.Subscriber;
import mcr.account.AccountStatus;
import mcr.account.Client;
import mcr.account.Publisher;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Window showing all clients and their status
 * Updates automatically when status change
 */
public class StatusesWindow implements Subscriber {
    private final HashMap<Client,JLabel> clientsLabels = new HashMap<>();
    private LinkedList<Client> clients;

    /**
     * Creates status window
     * @param clients All the clients to display
     */
    public StatusesWindow(LinkedList<Client> clients) {
        JFrame frame = new JFrame();
        this.clients = clients;
        int yValue = 20;
        for (Client client : clients) {
            JLabel clientLabel = createClientLabel(client, yValue);
            frame.add(clientLabel);
            clientsLabels.put(client, clientLabel);
            yValue += 20;
        }
        frame.setSize(400, 250);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    /**
     * Updates the display when a client change
     * @param publisher The publisher that triggered the update
     */
    @Override
    public void update(Publisher publisher) {
        if (publisher instanceof Client) {
            Client client = (Client) publisher;
            updateClientLabel(client);
        }
    }

    /**
     * Creates a JLabel for a client
     * @param client The client to create a label for
     * @param yPos The vertical position of the label in the window
     * @return The JLabel
     */
    private JLabel createClientLabel(Client client, int yPos) {
        JLabel label = new JLabel(client.getFullName() + " " + client.getAccount().getAccountStatus());
        label.setBounds(20, yPos, 200, 20);
        setLabelColorBasedOnStatus(label, client.getAccount().getAccountStatus());
        return label;
    }

    /**
     * Updates the label for a client
     * @param client The client
     */
    private void updateClientLabel(Client client) {
        JLabel label = clientsLabels.get(client);
        if (label != null) {
            label.setText(client.getFullName() + " " + client.getAccount().getAccountStatus());
            setLabelColorBasedOnStatus(label, client.getAccount().getAccountStatus());
        }
    }

    /**
     * Sets the color of a label based on the account status
     * @param label The label to modify
     * @param status The account status for the correct color
     */
    private void setLabelColorBasedOnStatus(JLabel label, AccountStatus status) {
        switch (status) {
            case AccountStatus.SILVER:
                label.setForeground(Color.GRAY);
                break;
            case AccountStatus.GOLD:
                label.setForeground(Color.YELLOW);
                break;
            case AccountStatus.PLATINIUM:
                label.setForeground(Color.CYAN);
                break;
            default:
                break;
        }
    }
}
