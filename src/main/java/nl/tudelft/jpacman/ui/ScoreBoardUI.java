package nl.tudelft.jpacman.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

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

        JButton backButton = new JButton(new ImageIcon("src/main/resources/assets/backButton.png"));


        try {
            List<String> lines = Files.readAllLines(Paths.get("src/main/resources/assets/ss.txt"));
            String[] data = lines.toArray(new String[0]);
            JList<String> list = new JList<>(data);
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridy = 2;
            gbc.weightx = 1.0;
            gbc.weighty = 1;
            frame.add(list, gbc);
            System.out.println(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String scores[]= {"TXRXX   30", "NEW TXRXX    40"};

//        b = new JList(scores);
//        b.setBackground(Color.BLACK);
//        b.setForeground(Color.white);

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



        gbc.gridy = 4;
        gbc.weighty = 1;
        frame.add(backButton, gbc);

        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
