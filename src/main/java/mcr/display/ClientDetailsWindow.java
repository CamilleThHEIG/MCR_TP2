package mcr.display;

import javax.swing.*;

public class ClientDetailsWindow {
    public ClientDetailsWindow(int clientNo){
        JFrame frame = new JFrame();

        frame.setTitle("Details of client #" + clientNo);

        // Labels of the window
        // TODO eventually create these labels with some client information ?
        JLabel lastNameLabel = new JLabel("Last name:");
        JLabel firstNameLabel = new JLabel("First name:");
        JLabel creditsLabel = new JLabel("Credits :");
        JLabel nbMilesLabel = new JLabel("Nb miles :");
        JLabel statusLabel = new JLabel("Status :");
        JLabel lastActionLabel = new JLabel("Last action :");

        // setting the bounds of the labels
        lastNameLabel.setBounds(0, 10, 80, 10);
        firstNameLabel.setBounds(0, 40, 80, 10);
        creditsLabel.setBounds(0, 70, 80, 10);
        nbMilesLabel.setBounds(0, 100, 80, 10);
        statusLabel.setBounds(0, 130, 80, 10);
        lastActionLabel.setBounds(0, 160, 80, 10);

        // adding the labels to the frame
        frame.add(lastNameLabel);
        frame.add(firstNameLabel);
        frame.add(creditsLabel);
        frame.add(nbMilesLabel);
        frame.add(statusLabel);
        frame.add(lastActionLabel);

        // 400 width and 500 height
        frame.setSize(400, 250);

        // using no layout managers
        frame.setLayout(null);

        // making the frame visible
        frame.setVisible(true);
    }
}
