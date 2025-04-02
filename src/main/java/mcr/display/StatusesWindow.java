package mcr.display;

import mcr.Subscriber;
import mcr.account.AccountStatus;
import mcr.account.Client;
import mcr.account.Publisher;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;

public class StatusesWindow implements Subscriber {
    private final HashMap<Client,JLabel> clientsLabels = new HashMap<>();
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
                    clientLabel.setForeground(Color.GRAY); break;
                case AccountStatus.GOLD:
                    clientLabel.setForeground(Color.YELLOW); break;
                case AccountStatus.PLATINIUM:
                    clientLabel.setForeground(Color.CYAN); break;
            }

            frame.add(clientLabel);
            clientsLabels.put(client,clientLabel);
            yValue += 20;
        }

        frame.setSize(400, 250);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void update(Publisher publisher) {
        if(publisher instanceof Client){
            Client client = (Client) publisher;
            JLabel j = clientsLabels.get(client);
            j.setText(client.getFullName() + " " + client.getAccount().getAccountStatus());
            switch (client.getAccount().getAccountStatus()){
                case AccountStatus.SILVER:
                    j.setForeground(Color.GRAY); break;
                case AccountStatus.GOLD:
                    j.setForeground(Color.YELLOW); break;
                case AccountStatus.PLATINIUM:
                    j.setForeground(Color.CYAN); break;
            }

        }


    }
}
