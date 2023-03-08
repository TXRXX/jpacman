package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.Launcher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static nl.tudelft.jpacman.Launcher.DEFAULT_PLAYER_NAME;

public class InputNameUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pacman Enter Name");
        frame.setLayout(new GridBagLayout());
        Color bgColor = Color.black;
        frame.getContentPane().setBackground(bgColor);

        JTextField textField = new JTextField(20);
        JButton buttonStart = new JButton("START");
        JButton buttonBack = new JButton("BACK");

        JPanel panel = new JPanel();
        panel.add(new JLabel("ENTER YOUR NAME:"));
        panel.setFont(new Font("Retro Gaming", Font.BOLD, 16));
        frame.add(panel, new GridBagConstraints());
        Color headerTextColor = Color.white;
        panel.setForeground(headerTextColor);

        frame.add(textField, new GridBagConstraints());
        frame.add(buttonStart, new GridBagConstraints());
        frame.add(buttonBack, new GridBagConstraints());

        buttonStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                try {
                    DEFAULT_PLAYER_NAME = textField.getText();
                    Launcher.main(null);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                MenuDifficultyUI.main(null);
            }
        });

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
