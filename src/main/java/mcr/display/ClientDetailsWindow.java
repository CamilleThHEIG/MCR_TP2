package mcr.display;

import mcr.Subscriber;
import mcr.account.Client;
import mcr.account.Publisher;

import javax.swing.*;

public class ClientDetailsWindow implements Subscriber {
    private JFrame frame;
    private Client client;

    private JLabel lastNameValueLabel;
    private JLabel firstNameValueLabel;
    private JLabel creditsValueLabel;
    private JLabel nbMilesValueLabel;
    private JLabel statusValueLabel;
    private JLabel lastActionValueLabel;

    public ClientDetailsWindow(Client client) {
        this.client = client;
        client.subscribe(this);

        frame = new JFrame();
        frame.setTitle("Details of client #" + client.getId());
        JLabel lastNameLabel = new JLabel("Last name:");
        JLabel firstNameLabel = new JLabel("First name:");
        JLabel creditsLabel = new JLabel("Credits:");
        JLabel nbMilesLabel = new JLabel("Nb miles:");
        JLabel statusLabel = new JLabel("Status:");
        JLabel lastActionLabel = new JLabel("Last action:");

        lastNameValueLabel = new JLabel(client.getLastName());
        firstNameValueLabel = new JLabel(client.getFirstName());
        creditsValueLabel = new JLabel(String.valueOf(client.getCredit()));
        nbMilesValueLabel = new JLabel(String.valueOf(client.getMiles()));
        statusValueLabel = new JLabel(client.getAccount().getAccountType());
        lastActionValueLabel = new JLabel(client.getLastAction());

        lastNameLabel.setBounds(20, 20, 80, 20);
        lastNameValueLabel.setBounds(120, 20, 200, 20);

        firstNameLabel.setBounds(20, 50, 80, 20);
        firstNameValueLabel.setBounds(120, 50, 200, 20);

        creditsLabel.setBounds(20, 80, 80, 20);
        creditsValueLabel.setBounds(120, 80, 200, 20);

        nbMilesLabel.setBounds(20, 110, 80, 20);
        nbMilesValueLabel.setBounds(120, 110, 200, 20);

        statusLabel.setBounds(20, 140, 80, 20);
        statusValueLabel.setBounds(120, 140, 200, 20);

        lastActionLabel.setBounds(20, 170, 80, 20);
        lastActionValueLabel.setBounds(120, 170, 250, 40);

        frame.add(lastNameLabel);
        frame.add(lastNameValueLabel);
        frame.add(firstNameLabel);
        frame.add(firstNameValueLabel);
        frame.add(creditsLabel);
        frame.add(creditsValueLabel);
        frame.add(nbMilesLabel);
        frame.add(nbMilesValueLabel);
        frame.add(statusLabel);
        frame.add(statusValueLabel);
        frame.add(lastActionLabel);
        frame.add(lastActionValueLabel);

        frame.setSize(400, 250);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void update(Publisher publisher) {
        if (publisher instanceof Client) {
            Client updatedClient = (Client) publisher;
            SwingUtilities.invokeLater(() -> {
                creditsValueLabel.setText(String.valueOf(updatedClient.getCredit()));
                nbMilesValueLabel.setText(String.valueOf(updatedClient.getMiles()));
                statusValueLabel.setText(updatedClient.getAccount().getAccountType());
                lastActionValueLabel.setText(updatedClient.getLastAction());
            });
        }
    }

    public void close() {
        client.unsubscribe(this); // Se désabonne lors de la fermeture
        frame.dispose();
    }
}
