package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.game.DBScoreBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HomeUI {


    public static void main(String s[]) {

        JFrame frame = new JFrame("Pacman Main Menu");
        Color bgColor = Color.black;
        frame.getContentPane().setBackground(bgColor);
        frame.setLayout(new GridBagLayout());


        ImageIcon icon = new ImageIcon("src/main/resources/assets/PacMan-Logo.png");
        Image image = icon.getImage();
        ImageIcon scaledIcon = new ImageIcon(image);
        JLabel headerLabel = new JLabel("");
        frame.add(headerLabel, new GridBagConstraints());
        Color headerTextColor = Color.white;
        headerLabel.setForeground(headerTextColor);
        headerLabel.setIcon(scaledIcon);


        JButton playButton = new JButton(new ImageIcon("src/main/resources/assets/playButton.png"));
//        JButton skinsButton = new JButton(new ImageIcon("src/main/resources/assets/skinButton.png"));
        JButton scoreButton = new JButton(new ImageIcon("src/main/resources/assets/scoreButton.png"));
        JButton quitButton = new JButton(new ImageIcon("src/main/resources/assets/quitButton.png"));

        playButton.setBorderPainted(false);
        playButton.setOpaque(false);
        playButton.setContentAreaFilled(false);

//        skinsButton.setBorderPainted(false);
//        skinsButton.setOpaque(false);
//        skinsButton.setContentAreaFilled(false);

        scoreButton.setBorderPainted(false);
        scoreButton.setOpaque(false);
        scoreButton.setContentAreaFilled(false);

        quitButton.setBorderPainted(false);
        quitButton.setOpaque(false);
        quitButton.setContentAreaFilled(false);


        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                MenuModeUI.main(null);
            }
        });

        scoreButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                frame.dispose();
                ScoreBoardUI.main(null);
            }
        });

        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
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
        frame.add(playButton, gbc);


//        gbc.gridy = 2;
//        gbc.weighty = 0.5;
//        frame.add(skinsButton, gbc);

        gbc.gridy = 2;
        gbc.weighty = 0.5;
        frame.add(scoreButton, gbc);

        gbc.gridy = 3;
        gbc.weighty = 0.5;
        frame.add(quitButton, gbc);

        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
