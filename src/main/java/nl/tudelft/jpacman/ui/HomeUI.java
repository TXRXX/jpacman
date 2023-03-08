package nl.tudelft.jpacman.ui;

import javax.swing.*;
import java.awt.*;

public class HomeUI {
    public static void main(String s[]) {
        JFrame frame = new JFrame("JPacman");
        Color bgColor = Color.black;
        frame.getContentPane().setBackground(bgColor);
        frame.setLayout(new GridBagLayout());

        ImageIcon icon = new ImageIcon("src/main/resources/sprite/fullPacman.png");
        Image image = icon.getImage();
        Image scaledImage = ((Image) image).getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel headerLabel = new JLabel("PacMan");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 50));
        frame.add(headerLabel, new GridBagConstraints());
        Color headerTextColor = Color.white;
        headerLabel.setForeground(headerTextColor);
        headerLabel.setIcon(scaledIcon);


        JButton buttonPlayGame = new JButton("PLAY");
        JButton buttonSkins = new JButton("SKINS");
        JButton buttonScore = new JButton("SCORE");
        JButton buttonQuit = new JButton("QUIT");

        buttonPlayGame.setPreferredSize(new Dimension(250, 50));
        buttonSkins.setPreferredSize(new Dimension(250, 50));
        buttonScore.setPreferredSize(new Dimension(250, 50));
        buttonQuit.setPreferredSize(new Dimension(250, 50));

        Color buttonTextColor = Color.white;

        buttonPlayGame.setForeground(buttonTextColor);
        buttonSkins.setForeground(buttonTextColor);
        buttonScore.setForeground(buttonTextColor);
        buttonQuit.setForeground(buttonTextColor);

        
        Color PlayColor = new Color(138, 202, 88);
        buttonPlayGame.setBackground(PlayColor);
        buttonPlayGame.setOpaque(true);
        Color SkinsColor = new Color(88, 202, 147);
        buttonSkins.setBackground(SkinsColor);
        buttonSkins.setOpaque(true);
        Color ScoreColor = new Color(209, 100, 0);
        buttonScore.setBackground(ScoreColor);
        buttonScore.setOpaque(true);
        Color QuitColor = new Color(209, 62, 62);
        buttonQuit.setBackground(QuitColor);
        buttonQuit.setOpaque(true);
        

        frame.add(buttonPlayGame, new GridBagConstraints());
        frame.add(buttonSkins, new GridBagConstraints());
        frame.add(buttonScore, new GridBagConstraints());
        frame.add(buttonQuit, new GridBagConstraints());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(headerLabel, gbc);

        gbc.gridy = 1;
        gbc.weighty = 0.5;
        frame.add(buttonPlayGame, gbc);

        gbc.gridy = 2;
        gbc.weighty = 0.5;
        frame.add(buttonSkins, gbc);

        gbc.gridy = 3;
        gbc.weighty = 0.5;
        frame.add(buttonScore, gbc);

        gbc.gridy = 4;
        gbc.weighty = 0.5;
        frame.add(buttonQuit, gbc);

        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
