package mcr.display;

import mcr.Subscriber;
import mcr.account.Client;
import mcr.account.Publisher;

import javax.swing.*;

/**
 * Window showing clients informations
 * Update when client changes
 */
public class ClientDetailsWindow implements Subscriber {
    private final JLabel creditsValueLabel;
    private final JLabel nbMilesValueLabel;
    private final JLabel statusValueLabel;
    private final JLabel lastActionValueLabel;

    /**
     * Creates window for client.
     * @param client Client to display
     */
    public ClientDetailsWindow(Client client) {
        client.subscribe(this);

        JFrame frame = new JFrame();
        frame.setTitle("Details of client #" + client.getId());
        JLabel lastNameLabel = new JLabel("Last name:");
        JLabel firstNameLabel = new JLabel("First name:");
        JLabel creditsLabel = new JLabel("Credits:");
        JLabel nbMilesLabel = new JLabel("Nb miles:");
        JLabel statusLabel = new JLabel("Status:");
        JLabel lastActionLabel = new JLabel("Last action:");

        JLabel lastNameValueLabel = new JLabel(client.getLastName());
        JLabel firstNameValueLabel = new JLabel(client.getFirstName());
        creditsValueLabel = new JLabel(String.valueOf(client.getCredit()));
        nbMilesValueLabel = new JLabel(String.valueOf(client.getMiles()));
        statusValueLabel = new JLabel(String.valueOf(client.getAccount().getAccountStatus()));
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
        lastActionValueLabel.setBounds(120, 170, 600, 40);

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

    /**
     * Update window when client changes
     * @param publisher The client
     */
    @Override
    public void update(Publisher publisher) {
        if (publisher instanceof Client updatedClient) {
            creditsValueLabel.setText(String.valueOf(updatedClient.getCredit()));
            nbMilesValueLabel.setText(String.valueOf(updatedClient.getMiles()));
            statusValueLabel.setText(String.valueOf(updatedClient.getAccount().getAccountStatus()));
            lastActionValueLabel.setText(updatedClient.getLastAction());
        }
    }
}
