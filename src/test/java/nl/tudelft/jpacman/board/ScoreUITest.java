package nl.tudelft.jpacman.board;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nl.tudelft.jpacman.ui.HomeUI;
import nl.tudelft.jpacman.ui.MenuDifficultyUI;

class ScoreUITest {
	JFrame frame = new JFrame("Pacman Scoreboard");
	JButton backButton = new JButton(new ImageIcon("src/main/resources/assets/backButton.png"));

	@DisplayName("Back Button")
	@Test
	void testBackButton() {
		backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                HomeUI.main(null);
            }
        });
		backButton.doClick();
		
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

}
