package nl.tudelft.jpacman.ui;
import nl.tudelft.jpacman.Launcher;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.AbstractBorder;


public class MenuDifficultyUI {
        public static void main(String s[]) {
            JFrame frame = new JFrame("Pacman Select Difficulty");
            Color bgColor = Color.black;
            frame.getContentPane().setBackground(bgColor);
            frame.setLayout(new GridBagLayout());

            ImageIcon ss = new ImageIcon("src/main/resources/assets/selectDifficultyTitle.png");
            Image title = ss.getImage();
            ImageIcon titleImg = new ImageIcon(title);
            JLabel headerLabel = new JLabel("");
            frame.add(headerLabel, new GridBagConstraints());
            Color headerTextColor = Color.white;
            headerLabel.setForeground(headerTextColor);
            headerLabel.setIcon(titleImg);

            //set image icon
            ImageIcon icon = new ImageIcon("src/main/resources/sprite/fullPacman.png");
            Image image = icon.getImage();
            Image scaledImage = ((Image) image).getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            JButton buttonEasyMode = new JButton(new ImageIcon("src/main/resources/assets/easyButton.png"));
            JButton buttonNormalMode = new JButton(new ImageIcon("src/main/resources/assets/mediumButton.png"));
            JButton buttonHardMode = new JButton(new ImageIcon("src/main/resources/assets/hardButton.png"));
            JButton backButton = new JButton(new ImageIcon("src/main/resources/assets/backButton.png"));


            buttonEasyMode.setBorderPainted(false);
            buttonEasyMode.setOpaque(false);
            buttonEasyMode.setContentAreaFilled(false);

            buttonNormalMode.setBorderPainted(false);
            buttonNormalMode.setOpaque(false);
            buttonNormalMode.setContentAreaFilled(false);

            buttonHardMode.setBorderPainted(false);
            buttonHardMode.setOpaque(false);
            buttonHardMode.setContentAreaFilled(false);

            backButton.setBorderPainted(false);
            backButton.setOpaque(false);
            backButton.setContentAreaFilled(false);

            buttonEasyMode.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    Launcher.DEFAULT_DIFFICULTY = "easy";
                    Launcher.DEFAULT_PLAYER_LIFE = "infinity";
                    InputNameUI.main(null);
                }
            });

            buttonNormalMode.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    Launcher.DEFAULT_DIFFICULTY = "medium";
                    Launcher.DEFAULT_PLAYER_LIFE = "3";
                    InputNameUI.main(null);
                }
            });

            buttonHardMode.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    Launcher.DEFAULT_DIFFICULTY = "hard";
                    Launcher.DEFAULT_PLAYER_LIFE = "1";
                    InputNameUI.main(null);
                }
            });
            backButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    MenuModeUI.main(null);
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
            frame.add(buttonEasyMode, gbc);

            gbc.gridy = 2;
            gbc.weighty = 0.5;
            frame.add(buttonNormalMode, gbc);

            gbc.gridy = 3;
            gbc.weighty = 0.5;
            frame.add(buttonHardMode, gbc);

            gbc.gridy = 4;
            gbc.weighty = 1;
            frame.add(backButton, gbc);

            frame.setSize(400, 400);
            frame.setResizable(false);
            frame.setVisible(true);
        }
}
