package nl.tudelft.jpacman.board;

import static nl.tudelft.jpacman.Launcher.DEFAULT_DIFFICULTY;
import static nl.tudelft.jpacman.Launcher.DEFAULT_PLAYER_NAME;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.game.DBScoreBoard;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.ui.HomeUI;
import nl.tudelft.jpacman.ui.MenuModeUI;
import nl.tudelft.jpacman.ui.MenuStageUI;
import nl.tudelft.jpacman.ui.ScoreBoardUI;

class PopupTest {
	JFrame popup = new JFrame("");
	JLabel namePlayer = new JLabel("Name : "+ Launcher.DEFAULT_PLAYER_NAME, JLabel.CENTER);
    JLabel scorePlayer = new JLabel("Score : "+ Player.score, JLabel.CENTER);
    JButton buttonBtHome = new JButton(new ImageIcon("src/main/resources/assets/popupHomeButton.png"));
    JButton buttonBtScore = new JButton(new ImageIcon("src/main/resources/assets/popupScoreButton.png"));
    JButton buttonRetry = new JButton(new ImageIcon("src/main/resources/assets/popupRetryButton.png"));
	
	@DisplayName("Win UI")
	@Test
	void testWinUI() {
		String text = "You Won";
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
		assertEquals("You Won",text);
	}
	
	@DisplayName("Lose UI")
	@Test
	void testLoseUI() {
		String text = "You Lose";
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
		assertEquals("You Lose",text);
	}
	
	@DisplayName("Home Button")
	@Test
	void testHomeButton() {
		buttonBtHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Launcher.pacManUI.reset();
                popup.dispose();
                HomeUI.main(null);
            }
        });
		buttonBtHome.doClick();
		
		Frame[] frames = JFrame.getFrames();
	    boolean isHomeUIVisible = false;

	    for (Frame f : frames) {
	        if (f.getTitle().equals("Pacman Main Menu") && f.isShowing()) {
	        	isHomeUIVisible = true;
	            break;
	        }
	    }
	    assertTrue(isHomeUIVisible);
	}
	
	@DisplayName("Score Button")
	@Test
	void testScoreButton() {
		Player.score = 0;
		buttonBtScore.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //write playerName and score to database
                //Launcher.pacManUI.reset();
                DBScoreBoard.WriteScoreBoard(DEFAULT_PLAYER_NAME,Player.score);
                popup.dispose();
                ScoreBoardUI.main(null);

            }
        });
		buttonBtScore.doClick();
		
		Frame[] frames = JFrame.getFrames();
	    boolean isScoreBoardVisible = false;

	    for (Frame f : frames) {
	        if (f.getTitle().equals("Pacman Scoreboard") && f.isShowing()) {
	        	isScoreBoardVisible = true;
	            break;
	        }
	    }
	    assertTrue(isScoreBoardVisible);
	}

}
