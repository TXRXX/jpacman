package nl.tudelft.jpacman.game;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.ui.HomeUI;
import nl.tudelft.jpacman.ui.ScoreBoardUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import static nl.tudelft.jpacman.Launcher.DEFAULT_DIFFICULTY;
import static nl.tudelft.jpacman.Launcher.DEFAULT_PLAYER_NAME;

public class PopupGame {


    public static void popupController(String text){
        JFrame popup = new JFrame("");
        Color bgColor = Color.darkGray;
        popup.getContentPane().setBackground(bgColor);
        popup.setLayout(null);

        if(text.equals("You Won")) {
            ImageIcon icon = new ImageIcon("src/main/resources/assets/winTitle.png");
            Image image = icon.getImage();
            ImageIcon scaledIcon = new ImageIcon(image);
            JLabel headerLabel = new JLabel("");
            Color headerTextColor = Color.white;
            headerLabel.setForeground(headerTextColor);
            headerLabel.setIcon(scaledIcon);
            headerLabel.setBounds(65, 20, 67, 9);
            popup.add(headerLabel);
        } else if (text.equals("You Lose")) {
            ImageIcon icon = new ImageIcon("src/main/resources/assets/loseTitle.png");
            Image image = icon.getImage();
            ImageIcon scaledIcon = new ImageIcon(image);
            JLabel headerLabel = new JLabel("");
            Color headerTextColor = Color.white;
            headerLabel.setForeground(headerTextColor);
            headerLabel.setIcon(scaledIcon);
            headerLabel.setBounds(60, 20, 80, 9);
            popup.add(headerLabel);
        }

        JButton buttonBtHome = new JButton(new ImageIcon("src/main/resources/assets/popupHomeButton.png"));
        buttonBtHome.setBounds(65, 50, 67, 22);

        JButton buttonBtScore = new JButton(new ImageIcon("src/main/resources/assets/popupScoreButton.png"));
        buttonBtScore.setBounds(65, 80, 67, 22);

        JButton buttonRetry = new JButton(new ImageIcon("src/main/resources/assets/popupRetryButton.png"));
        buttonRetry.setBounds(65, 110, 67, 22);


        popup.add(buttonBtHome);
        popup.add(buttonRetry);
        popup.add(buttonBtScore);

        buttonBtHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Launcher.pacManUI.reset();
                popup.dispose();
                HomeUI.main(null);
            }
        });

        buttonRetry.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                popup.dispose();
                Launcher.pacManUI.reset();
                Launcher launcher = new Launcher();
                if(Objects.equals(DEFAULT_DIFFICULTY, "medium")){
                    Launcher.DEFAULT_PLAYER_LIFE = "3";
                }
                else if (Objects.equals(DEFAULT_DIFFICULTY, "hard")) {
                    Launcher.DEFAULT_PLAYER_LIFE = "1";
                }
                launcher.launch(DEFAULT_DIFFICULTY);
            }
        });

        buttonBtScore.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //write playerName and score to database
                Launcher.pacManUI.reset();
                DBScoreBoard.WriteScoreBoard(DEFAULT_PLAYER_NAME,Player.score);
                popup.dispose();
                ScoreBoardUI.main(null);

            }
        });

        popup.pack();
        popup.setSize(200,  200);
        popup.setResizable(false);
        popup.setVisible(true);
    };
}
