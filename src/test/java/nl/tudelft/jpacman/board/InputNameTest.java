package nl.tudelft.jpacman.board;

import static nl.tudelft.jpacman.Launcher.DEFAULT_PLAYER_NAME;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import nl.tudelft.jpacman.ui.HomeUI;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.ui.MenuModeUI;

class InputNameTest {
	JFrame frame = new JFrame("Pacman Player Name");
    JTextField textField = new JTextField(15);
	JButton startButton = new JButton(new ImageIcon("src/main/resources/assets/startButton.png"));
    JButton backButton = new JButton(new ImageIcon("src/main/resources/assets/backButton.png"));

	@DisplayName("Start Button Test")
	@Test
	void testStartButton() {
		startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                try {
                    DEFAULT_PLAYER_NAME = textField.getText();
                    Launcher.main(null);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
		startButton.doClick();
		
		Frame[] frames = JFrame.getFrames();
	    boolean isInGameVisible = false;

	    for (Frame f : frames) {
	        if (f.getTitle().equals("JPacman") && f.isShowing()) {
	            isInGameVisible = true;
	            break;
	        }
	    }
	    assertTrue(isInGameVisible);
	}

    @DisplayName("Back Button Test")
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
        boolean isMenuDifficultyUIVisible = false;

        for (Frame f : frames) {
            if (f.getTitle().equals("Pacman Select Difficulty") && f.isShowing()) {
                isMenuDifficultyUIVisible = true;
                break;
            }
        }
        assertTrue(isMenuDifficultyUIVisible);
    }

}
