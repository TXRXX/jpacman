package nl.tudelft.jpacman.ui;

import javax.swing.*;
import java.awt.*;

public class MenuModeUI {
    public static void main(String s[]) {
        JFrame frame = new JFrame("JPacman");
        Color bgColor = Color.black;
        frame.getContentPane().setBackground(bgColor);
        frame.setLayout(new GridBagLayout());


        JLabel headerLabel = new JLabel("SELECT MODE");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 35));
        frame.add(headerLabel, new GridBagConstraints());
        Color headerTextColor = Color.white;
        headerLabel.setForeground(headerTextColor);

        //set image icon
        ImageIcon icon = new ImageIcon("src/main/resources/sprite/fullPacman.png");
        Image image = icon.getImage();
        Image scaledImage = ((Image) image).getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JButton buttonPlayClassicMode = new JButton("Pacman Classic");
        JButton buttonPlayGhostHuntMode = new JButton("Ghost Hunt");
        JButton buttonBack = new JButton("Back");


        buttonPlayClassicMode.setIcon(scaledIcon);
        buttonPlayGhostHuntMode.setIcon(scaledIcon);


        buttonPlayClassicMode.setPreferredSize(new Dimension(200, 50));
        buttonPlayGhostHuntMode.setPreferredSize(new Dimension(200, 50));
        buttonBack.setPreferredSize(new Dimension(100, 50));


        Color buttonBgColor = Color.DARK_GRAY;
        Color buttonTextColor = Color.white;
        buttonPlayClassicMode.setBackground(buttonBgColor);
        buttonPlayGhostHuntMode.setBackground(buttonBgColor);
        buttonBack.setBackground(buttonBgColor);

        buttonPlayClassicMode.setForeground(buttonTextColor);
        buttonPlayGhostHuntMode.setForeground(buttonTextColor);
        buttonBack.setForeground(buttonTextColor);

        frame.add(buttonPlayClassicMode, new GridBagConstraints());
        frame.add(buttonPlayGhostHuntMode, new GridBagConstraints());
        frame.add(buttonBack, new GridBagConstraints());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(headerLabel, gbc);

        gbc.gridy = 1;
        gbc.weighty = 0.5;
        frame.add(buttonPlayClassicMode, gbc);

        gbc.gridy = 2;
        gbc.weighty = 0.5;
        frame.add(buttonPlayGhostHuntMode, gbc);

        gbc.gridy = 3;
        gbc.weighty = 0.5;
        frame.add(buttonBack, gbc);


        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
