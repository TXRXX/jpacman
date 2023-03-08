package nl.tudelft.jpacman.ui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;
import javax.swing.border.AbstractBorder;


public class MenuDifficultyUI {
        public static void main(String s[]) {
            JFrame frame = new JFrame("JPacman");
            Color bgColor = Color.black;
            frame.getContentPane().setBackground(bgColor);
            frame.setLayout(new GridBagLayout());


            JLabel headerLabel = new JLabel("SELECT DIFFICULTY");
            headerLabel.setFont(new Font("Retro Gaming", Font.BOLD, 16));
            frame.add(headerLabel, new GridBagConstraints());
            Color headerTextColor = Color.white;
            headerLabel.setForeground(headerTextColor);

            //set image icon
            ImageIcon icon = new ImageIcon("src/main/resources/sprite/fullPacman.png");
            Image image = icon.getImage();
            Image scaledImage = ((Image) image).getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            JButton buttonEasyMode = new JButton("Daddy, can i play this game?");
            JButton buttonNormalMode = new JButton("Let's get it");
            JButton buttonHardMode = new JButton("Are you crazy!");
            JButton backButton = new JButton(new ImageIcon("src/main/resources/assets/backButton.png"));

            buttonEasyMode.setFont(new Font("Retro Gaming", Font.PLAIN, 12));
            buttonNormalMode.setFont(new Font("Retro Gaming", Font.PLAIN, 12));
            buttonHardMode.setFont(new Font("Retro Gaming", Font.PLAIN, 12));

            buttonEasyMode.setIcon(scaledIcon);
            buttonNormalMode.setIcon(scaledIcon);
            buttonHardMode.setIcon(scaledIcon);
            backButton.setBorderPainted(false);

            buttonEasyMode.setPreferredSize(new Dimension(300, 50));
            buttonNormalMode.setPreferredSize(new Dimension(300, 50));
            buttonHardMode.setPreferredSize(new Dimension(300, 50));


            Color buttonBgColor = Color.BLACK;
            Color buttonTextColor = Color.WHITE;
            buttonEasyMode.setBackground(buttonBgColor);
            buttonNormalMode.setBackground(buttonBgColor);
            buttonHardMode.setBackground(buttonBgColor);

            buttonEasyMode.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            buttonNormalMode.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            buttonHardMode.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            

            buttonEasyMode.setForeground(buttonTextColor);
            buttonNormalMode.setForeground(buttonTextColor);
            buttonHardMode.setForeground(buttonTextColor);

            buttonEasyMode.setHorizontalAlignment(SwingConstants.LEFT);
            buttonNormalMode.setHorizontalAlignment(SwingConstants.LEFT);
            buttonHardMode.setHorizontalAlignment(SwingConstants.LEFT);

            frame.add(buttonEasyMode, new GridBagConstraints());
            frame.add(buttonNormalMode, new GridBagConstraints());
            frame.add(buttonHardMode, new GridBagConstraints());


            buttonEasyMode.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
//                    frame.dispose();
//                    DO SOMETHING
                }
            });
            buttonHardMode.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
//                    frame.dispose();
//                    DO SOMETHING
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
