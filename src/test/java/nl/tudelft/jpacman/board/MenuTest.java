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

import nl.tudelft.jpacman.ui.MenuModeUI;

class MenuTest {
	JFrame frame = new JFrame("Pacman Main Menu");
	JButton playButton = new JButton(new ImageIcon("src/main/resources/assets/playButton.png"));
    JButton skinsButton = new JButton(new ImageIcon("src/main/resources/assets/skinButton.png"));
    JButton scoreButton = new JButton(new ImageIcon("src/main/resources/assets/scoreButton.png"));

    @DisplayName("Play Button Test")
	@Test
	void testPlayButton() {
		playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                MenuModeUI.main(null);
            }
        });
		playButton.doClick();
		
		Frame[] frames = JFrame.getFrames();
	    boolean isMenuModeUIVisible = false;

	    for (Frame f : frames) {
	        if (f.getTitle().equals("Pacman Select Mode") && f.isShowing()) {
	            isMenuModeUIVisible = true;
	            break;
	        }
	    }
	    assertTrue(isMenuModeUIVisible);
	}
    
    @DisplayName("Skin Button Test")
	@Test
	void testSkinButton() {
    	skinsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                MenuModeUI.main(null);
            }
        });
    	skinsButton.doClick();
		
		Frame[] frames = JFrame.getFrames();
	    boolean isMenuModeUIVisible = false;

	    for (Frame f : frames) {
	        if (f.getTitle().equals("Custom Skin") && f.isShowing()) {
	            isMenuModeUIVisible = true;
	            break;
	        }
	    }
	    assertFalse(isMenuModeUIVisible);
	}
    
    @DisplayName("Score Button Test")
	@Test
	void testScoreButton() {
    	scoreButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                MenuModeUI.main(null);
            }
        });
    	scoreButton.doClick();
		
		Frame[] frames = JFrame.getFrames();
	    boolean isMenuModeUIVisible = false;

	    for (Frame f : frames) {
	        if (f.getTitle().equals("Pacman Scoreboard") && f.isShowing()) {
	            isMenuModeUIVisible = true;
	            break;
	        }
	    }
	    assertFalse(isMenuModeUIVisible);
	}

}
