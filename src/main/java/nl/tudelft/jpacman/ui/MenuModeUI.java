package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.Launcher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuModeUI {
    public static void main(String s[]) {
        JFrame frame = new JFrame("Pacman Select Mode");
        Color bgColor = Color.black;
        frame.getContentPane().setBackground(bgColor);
        frame.setLayout(new GridBagLayout());


        ImageIcon icon = new ImageIcon("src/main/resources/assets/selectModeTitle.png");
        Image image = icon.getImage();
        ImageIcon scaledIcon = new ImageIcon(image);
        JLabel headerLabel = new JLabel("");
        frame.add(headerLabel, new GridBagConstraints());
        Color headerTextColor = Color.white;
        headerLabel.setForeground(headerTextColor);
        headerLabel.setIcon(scaledIcon);

        JButton classicButton = new JButton(new ImageIcon("src/main/resources/assets/classicButton.png"));
        JButton ghostButton = new JButton(new ImageIcon("src/main/resources/assets/challengeButton.png"));
        JButton backButton = new JButton(new ImageIcon("src/main/resources/assets/backButton.png"));

        classicButton.setBorderPainted(false);
        classicButton.setOpaque(false);
        classicButton.setContentAreaFilled(false);

        ghostButton.setBorderPainted(false);
        ghostButton.setOpaque(false);
        ghostButton.setContentAreaFilled(false);

        backButton.setBorderPainted(false);
        backButton.setOpaque(false);
        backButton.setContentAreaFilled(false);

        classicButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Launcher.DEFAULT_MODE = "";
                frame.dispose();
                MenuDifficultyUI.main(null);
            }
        });

   ghostButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               Launcher.DEFAULT_MODE = "Challenge";
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
