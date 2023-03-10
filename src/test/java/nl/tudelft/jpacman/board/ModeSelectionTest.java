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
import nl.tudelft.jpacman.ui.MenuModeUI;

class ModeSelectionTest {
	JFrame frame = new JFrame("Pacman Select Mode");
	JButton classicButton = new JButton(new ImageIcon("src/main/resources/assets/classicButton.png"));
    JButton ghostButton = new JButton(new ImageIcon("src/main/resources/assets/ghostButton.png"));
    JButton backButton = new JButton(new ImageIcon("src/main/resources/assets/backButton.png"));

    @DisplayName("Classic Button Test")
	@Test
	void testClassicButton() {
    	classicButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                MenuDifficultyUI.main(null);
            }
        });
    	classicButton.doClick();
		
		Frame[] frames = JFrame.getFrames();
	    boolean isMenuDifficaltyUIVisible = false;

	    for (Frame f : frames) {
	        if (f.getTitle().equals("Pacman Select Difficulty") && f.isShowing()) {
	            isMenuDifficaltyUIVisible = true;
	            break;
	        }
	    }
	    assertTrue(isMenuDifficaltyUIVisible);
	}

    @DisplayName("Ghost Button Test")
	@Test
	void testGhostButton() {
    	ghostButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                MenuDifficultyUI.main(null);
            }
        });
    	ghostButton.doClick();
		
		Frame[] frames = JFrame.getFrames();
	    boolean isMenuDifficaltyUIVisible = false;

	    for (Frame f : frames) {
	        if (f.getTitle().equals("Ghost Select Difficulty") && f.isShowing()) {
	            isMenuDifficaltyUIVisible = true;
	            break;
	        }
	    }
	    assertFalse(isMenuDifficaltyUIVisible);
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
	    boolean isMenuDifficaltyUIVisible = false;

	    for (Frame f : frames) {
	        if (f.getTitle().equals("Pacman Main Menu") && f.isShowing()) {
	            isMenuDifficaltyUIVisible = true;
	            break;
	        }
	    }
	    assertTrue(isMenuDifficaltyUIVisible);
	}
}
