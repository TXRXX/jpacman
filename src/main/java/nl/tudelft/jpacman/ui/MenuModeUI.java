package nl.tudelft.jpacman.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuModeUI {
    public static void main(String s[]) {
        JFrame frame = new JFrame("JPacman");
        Color bgColor = Color.black;
        frame.getContentPane().setBackground(bgColor);
        frame.setLayout(new GridBagLayout());


        JLabel headerLabel = new JLabel("SELECT MODE");
        headerLabel.setFont(new Font("Retro Gaming", Font.BOLD, 16));
        frame.add(headerLabel, new GridBagConstraints());
        Color headerTextColor = Color.white;
        headerLabel.setForeground(headerTextColor);

        JButton classicButton = new JButton(new ImageIcon("src/main/resources/assets/classicButton.png"));
        JButton ghostButton = new JButton(new ImageIcon("src/main/resources/assets/ghostButton.png"));
        JButton backButton = new JButton(new ImageIcon("src/main/resources/assets/backButton.png"));

        classicButton.setBorderPainted(false);
        ghostButton.setBorderPainted(false);
        backButton.setBorderPainted(false);

        classicButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                MenuDifficultyUI.main(null);
            }
        });

        ghostButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                MenuDifficultyUI.main(null);
            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                HomeUI.main(null);
            }
        });


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(headerLabel, gbc);

        gbc.gridy = 1;
        gbc.weighty = 0.5;
        frame.add(classicButton, gbc);

        gbc.gridy = 2;
        gbc.weighty = 0.5;
        frame.add(ghostButton, gbc);

        gbc.gridy = 3;
        gbc.weighty = 0.5;
        frame.add(backButton, gbc);



        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
