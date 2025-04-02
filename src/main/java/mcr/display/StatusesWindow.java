package mcr.display;

import mcr.Subscriber;
import mcr.account.Client;
import mcr.account.Publisher;

import javax.swing.*;
import java.util.LinkedList;

public class StatusesWindow implements Subscriber {
    private final LinkedList<JLabel> clientsLabels = new LinkedList<>();
    public StatusesWindow(LinkedList<Client> clients) {
        JFrame frame = new JFrame();

        int yValue = 20;
        for (Client client : clients){
            JLabel clientLabel = new JLabel(client.getFullName() + " " + client.getAccount().getAccountType());
            clientLabel.setBounds(20, yValue, 200, 20);




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
        // TODO
    }
}
