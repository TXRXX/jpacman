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

public class ScoreBoardUI {
    static JList b;
    public static void main(String s[]) {

        JFrame frame = new JFrame("Pacman Scoreboard");
        Color bgColor = Color.black;
        frame.getContentPane().setBackground(bgColor);
        frame.setLayout(new GridBagLayout());

        ImageIcon icon = new ImageIcon("src/main/resources/assets/Scoreboard-Logo.png");
        Image image = icon.getImage();
        ImageIcon scaledIcon = new ImageIcon(image);
        JLabel headerLabel = new JLabel("");
        frame.add(headerLabel, new GridBagConstraints());
        Color headerTextColor = Color.white;
        headerLabel.setForeground(headerTextColor);
        headerLabel.setIcon(scaledIcon);

        JButton backButton = new JButton(new ImageIcon("src/main/resources/assets/backButton.png"));

        ArrayList<PlayerScore> scoreList = DBScoreBoard.ReturnScoreBoard();

        System.out.println(scoreList.get(0));
//        try {
//            List<String> lines = Files.readAllLines(Paths.get("src/main/resources/assets/ss.txt"));
//            String[] data = lines.toArray(new String[0]);
//            JList<String> list = new JList<>(data);
//            GridBagConstraints gbc = new GridBagConstraints();
//            gbc.gridy = 2;
//            gbc.weightx = 1.0;
//            gbc.weighty = 1;
//            frame.add(list, gbc);
//            System.out.println(list);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }


        String [] col = {"Name", "Score"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        JTable table = new JTable(tableModel);
        tableModel.addRow(col);
        table.setShowGrid(false);

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        table.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);

        for( PlayerScore item : scoreList ) {
            String[] objs = {item.getPlayerName(), String.valueOf(item.getScore())};
            tableModel.addRow(objs);
        }
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.setModel(tableModel);





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
        gbc.weighty = 1;
        frame.add(table, gbc);

        gbc.gridy = 4;
        gbc.weighty = 1;
        frame.add(backButton, gbc);

        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
