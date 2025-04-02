package mcr.display;

import mcr.Subscriber;
import mcr.account.AccountStatus;
import mcr.account.Client;
import mcr.account.Publisher;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class StatusesWindow implements Subscriber {
    private final LinkedList<JLabel> clientsLabels = new LinkedList<>();
    private LinkedList<Client> clients;
    public StatusesWindow(LinkedList<Client> clients) {
        JFrame frame = new JFrame();
        this.clients = clients;

        int yValue = 20;
        for (Client client : clients){
            JLabel clientLabel = new JLabel(client.getFullName() + " " + client.getAccount().getAccountStatus());
            clientLabel.setBounds(20, yValue, 200, 20);

            switch (client.getAccount().getAccountStatus()){
                case AccountStatus.SILVER:
                    clientLabel.setForeground(Color.gray);
                case AccountStatus.GOLD:
                    clientLabel.setForeground(Color.YELLOW);
                case AccountStatus.PLATINIUM:
                    clientLabel.setForeground(Color.CYAN);
            }

            frame.add(clientLabel);
            clientsLabels.add(clientLabel);
            yValue += 20;
        }

        frame.setSize(400, 250);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void update(Publisher publisher) {
        if (publisher instanceof Client) {
            // TODO is there no other choice ?
            Client updatedClient = (Client) publisher;
            creditsValueLabel.setText(String.valueOf(updatedClient.getCredit()));
            nbMilesValueLabel.setText(String.valueOf(updatedClient.getMiles()));
            statusValueLabel.setText(String.valueOf(updatedClient.getAccount().getAccountStatus()));
            lastActionValueLabel.setText(updatedClient.getLastAction());
        }
    }
}
