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
        JFrame frame = new JFrame("Pacman Player Name");
        frame.setLayout(new GridBagLayout());
        Color bgColor = Color.black;
        frame.getContentPane().setBackground(bgColor);

        JTextField textField = new JTextField(15);
        JButton startButton = new JButton("START");
        JButton backButton = new JButton(new ImageIcon("src/main/resources/assets/backButton.png"));

        backButton.setBorderPainted(false);
        backButton.setOpaque(false);
        backButton.setContentAreaFilled(false);

        JLabel panel = new JLabel("ENTER YOUR NAME:");
        panel.setFont(new Font("Retro Gaming", Font.BOLD, 16));
        frame.add(panel, new GridBagConstraints());
        Color headerTextColor = Color.white;
        panel.setForeground(headerTextColor);

        frame.add(textField, new GridBagConstraints());
        frame.add(startButton, new GridBagConstraints());
        frame.add(backButton, new GridBagConstraints());

        startButton.addActionListener(new ActionListener() {
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

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                MenuDifficultyUI.main(null);
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(panel, gbc);

        gbc.gridy = 1;
        gbc.weighty = 0.5;
        frame.add(textField, gbc);

        gbc.gridy = 3;
        gbc.weighty = 0.5;
        frame.add(startButton, gbc);

        gbc.gridy = 4;
        gbc.weighty = 1;
        frame.add(backButton, gbc);

        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setVisible(true);

    }
}
