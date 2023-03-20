package nl.tudelft.jpacman.game;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.ui.HomeUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import static nl.tudelft.jpacman.Launcher.DEFAULT_DIFFICULTY;

public class PopupGame {

    public static void popupController(String text){
        JFrame popup = new JFrame("Popup");
        Color bgColor = Color.darkGray;
        popup.getContentPane().setBackground(bgColor);
        popup.setLayout(new GridBagLayout());

        JLabel headerLabel = new JLabel(text);
        headerLabel.setFont(new Font("Retro Gaming", Font.BOLD, 50));
        popup.add(headerLabel, new GridBagConstraints());
        Color headerTextColor = Color.white;
        headerLabel.setForeground(headerTextColor);

        JButton buttonBtHome = new JButton("HOME");
        JButton buttonBtScore = new JButton("Score");
        JButton buttonRetry = new JButton("RETRY");


        popup.add(headerLabel);
        popup.add(buttonBtHome);
        popup.add(buttonRetry);

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

        popup.pack();
        popup.setSize(300,300);
        popup.setResizable(false);
        popup.setVisible(true);
    };
}