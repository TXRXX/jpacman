package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.Launcher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScoreBoardUI {
        static JList b;
    public static void main(String s[]) {
        JFrame frame = new JFrame("Pacman Scoreboard");
        Color bgColor = Color.black;
        frame.getContentPane().setBackground(bgColor);
        frame.setLayout(new GridBagLayout());

        JLabel headerLabel = new JLabel("SCOREBOARD");
        headerLabel.setFont(new Font("Retro Gaming", Font.BOLD, 16));
        frame.add(headerLabel, new GridBagConstraints());
        Color headerTextColor = Color.white;
        headerLabel.setForeground(headerTextColor);

        //set image icon
        ImageIcon icon = new ImageIcon("src/main/resources/sprite/fullPacman.png");
        Image image = icon.getImage();
        Image scaledImage = ((Image) image).getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JButton backButton = new JButton(new ImageIcon("src/main/resources/assets/backButton.png"));


        String scores[]= {"TXRXX   30", "NEW TXRXX    40"};

        b = new JList(scores);
        b.setBackground(Color.BLACK);
        b.setForeground(Color.white);

        backButton.setBorderPainted(false);
        backButton.setOpaque(false);
        backButton.setContentAreaFilled(false);

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

        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1;
        frame.add(b, gbc);

        gbc.gridy = 4;
        gbc.weighty = 1;
        frame.add(backButton, gbc);

        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
