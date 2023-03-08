package nl.tudelft.jpacman.ui;

import javax.swing.*;
import java.awt.*;

public class InputNameUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JPacman");
        frame.setLayout(new GridBagLayout());
        //Color bgColor = Color.black;
        //frame.getContentPane().setBackground(bgColor);
        //frame.setLayout(new GridBagLayout());

        JTextField textField = new JTextField(20);
        JButton buttonStart = new JButton("START");
        JButton buttonBack = new JButton("BACK");


        JPanel panel = new JPanel();
        panel.add(new JLabel("Enter your name:"));


        frame.add(textField, new GridBagConstraints());
        frame.add(buttonStart, new GridBagConstraints());
        frame.add(buttonBack, new GridBagConstraints());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 1;
        gbc.weighty = 0.5;
        frame.add(textField, gbc);

        gbc.gridy = 1;
        gbc.weighty = 0.5;
        frame.add(buttonStart, gbc);

        gbc.gridy = 2;
        gbc.weighty = 0.5;
        frame.add(buttonBack, gbc);

        frame.add(panel);

        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
