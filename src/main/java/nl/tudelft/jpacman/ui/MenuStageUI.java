package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.game.DBScoreBoard;
import nl.tudelft.jpacman.game.PlayerScore;
import nl.tudelft.jpacman.level.Player;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MenuStageUI {
    public static void main(String s[]) {

        JFrame frame = new JFrame("Pacman Select Stage");
        Color bgColor = Color.black;
        frame.getContentPane().setBackground(bgColor);
        frame.setLayout(null);

        ImageIcon icon = new ImageIcon("src/main/resources/assets/selectStageTitle.png");
        Image image = icon.getImage();
        ImageIcon scaledIcon = new ImageIcon(image);
        JLabel headerLabel = new JLabel("");
        Color headerTextColor = Color.white;
        headerLabel.setForeground(headerTextColor);
        headerLabel.setIcon(scaledIcon);
        headerLabel.setBounds(105, 20, 193, 25);
        frame.add(headerLabel);


        JButton map1 = new JButton(new ImageIcon("src/main/resources/assets/map.png"));
        map1.setBorderPainted(false);
        map1.setOpaque(false);
        map1.setContentAreaFilled(false);
        map1.setBounds(35, 100, 80, 80);
        frame.add(map1);

        JButton map2 = new JButton(new ImageIcon("src/main/resources/assets/map.png"));
        map2.setBorderPainted(false);
        map2.setOpaque(false);
        map2.setContentAreaFilled(false);
        map2.setBounds(155, 100, 80, 80);
        frame.add(map2);

        JButton map3 = new JButton(new ImageIcon("src/main/resources/assets/map.png"));
        map3.setBorderPainted(false);
        map3.setOpaque(false);
        map3.setContentAreaFilled(false);
        map3.setBounds(275, 100, 80, 80);
        frame.add(map3);

        JButton map4 = new JButton(new ImageIcon("src/main/resources/assets/map.png"));
        map4.setBorderPainted(false);
        map4.setOpaque(false);
        map4.setContentAreaFilled(false);
        map4.setBounds(90, 200, 80, 80);
        frame.add(map4);

        JButton map5 = new JButton(new ImageIcon("src/main/resources/assets/map.png"));
        map5.setBorderPainted(false);
        map5.setOpaque(false);
        map5.setContentAreaFilled(false);
        map5.setBounds(210, 200, 80, 80);
        frame.add(map5);



        JButton backButton = new JButton(new ImageIcon("src/main/resources/assets/backButton.png"));
        backButton.setBorderPainted(false);
        backButton.setOpaque(false);
        backButton.setContentAreaFilled(false);
        backButton.setBounds( 100,310, 170,39);
        frame.add(backButton);

        map1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                HomeUI.main(null);
            }
        });

        map2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                HomeUI.main(null);
            }
        });

        map3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                HomeUI.main(null);
            }
        });

        map4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                HomeUI.main(null);
            }
        });

        map5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                HomeUI.main(null);
            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                HomeUI.main(null);
            }
        });



        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
