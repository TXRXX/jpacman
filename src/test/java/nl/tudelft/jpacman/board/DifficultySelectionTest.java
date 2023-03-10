package nl.tudelft.jpacman.board;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import nl.tudelft.jpacman.ui.HomeUI;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.ui.InputNameUI;
import nl.tudelft.jpacman.ui.MenuModeUI;

class DifficultySelectionTest {
	JFrame frame = new JFrame("Pacman Select Difficulty");
	JButton buttonEasyMode = new JButton("Daddy, can i play this game?");
    JButton buttonNormalMode = new JButton("Let's get it");
    JButton buttonHardMode = new JButton("Are you crazy!");
    JButton backButton = new JButton(new ImageIcon("src/main/resources/assets/backButton.png"));

    @DisplayName("Easy to Input name")
	@Test
	void testEasytoName() {
    	buttonEasyMode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Launcher.DEFAULT_DIFFICULTY = "easy";
                Launcher.DEFAULT_PLAYER_LIFE = "infinity";
                InputNameUI.main(null);
            }
        });
		buttonEasyMode.doClick();
		
		Frame[] frames = JFrame.getFrames();
	    boolean isInputNameUIVisible = false;

	    for (Frame f : frames) {
	        if (f.getTitle().equals("Pacman Player Name") && f.isShowing()) {
	        	isInputNameUIVisible = true;
	            break;
	        }
	    }
	    assertTrue(isInputNameUIVisible);
	}
    @DisplayName("Player Difficalty Easy")
	@Test
    void DifficulEasy() {
    	buttonEasyMode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Launcher.DEFAULT_DIFFICULTY = "easy";
                Launcher.DEFAULT_PLAYER_LIFE = "infinity";
                InputNameUI.main(null);
            }
        });
		buttonEasyMode.doClick();
		
        assertEquals("easy",Launcher.DEFAULT_DIFFICULTY);
    }
	@DisplayName("Player Life Easy")
	@Test
    void LifeEasy() {
		buttonEasyMode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Launcher.DEFAULT_DIFFICULTY = "easy";
                Launcher.DEFAULT_PLAYER_LIFE = "infinity";
                InputNameUI.main(null);
            }
        });
		buttonEasyMode.doClick();
		
        assertEquals("infinity",Launcher.DEFAULT_PLAYER_LIFE);
    }
	
	
	@DisplayName("Medium to Input name")
	@Test
	void testMediumtoName() {
    	buttonNormalMode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Launcher.DEFAULT_DIFFICULTY = "easy";
                Launcher.DEFAULT_PLAYER_LIFE = "infinity";
                InputNameUI.main(null);
            }
        });
		buttonNormalMode.doClick();
		
		Frame[] frames = JFrame.getFrames();
	    boolean isInputNameUIVisible = false;

	    for (Frame f : frames) {
	        if (f.getTitle().equals("Pacman Player Name") && f.isShowing()) {
	        	isInputNameUIVisible = true;
	            break;
	        }
	    }
	    assertTrue(isInputNameUIVisible);
	}
	
	@DisplayName("Player Difficalty Medium")
	@Test
    void DifficulMedium() {
		buttonNormalMode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Launcher.DEFAULT_DIFFICULTY = "medium";
                Launcher.DEFAULT_PLAYER_LIFE = "3";
                InputNameUI.main(null);
            }
        });
		buttonNormalMode.doClick();
		
        assertEquals("medium",Launcher.DEFAULT_DIFFICULTY);
    }
	@DisplayName("Player Life Medium")
	@Test
    void LifeMedium() {
		buttonNormalMode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Launcher.DEFAULT_DIFFICULTY = "medium";
                Launcher.DEFAULT_PLAYER_LIFE = "3";
                InputNameUI.main(null);
            }
        });
		buttonNormalMode.doClick();
		
        assertEquals("3",Launcher.DEFAULT_PLAYER_LIFE);
    }
	
	@DisplayName("Hard to Input name")
	@Test
	void testHardtoName() {
    	buttonHardMode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Launcher.DEFAULT_DIFFICULTY = "easy";
                Launcher.DEFAULT_PLAYER_LIFE = "infinity";
                InputNameUI.main(null);
            }
        });
		buttonHardMode.doClick();
		
		Frame[] frames = JFrame.getFrames();
	    boolean isInputNameUIVisible = false;

	    for (Frame f : frames) {
	        if (f.getTitle().equals("Pacman Player Name") && f.isShowing()) {
	        	isInputNameUIVisible = true;
	            break;
	        }
	    }
	    assertTrue(isInputNameUIVisible);
	}
	
	@DisplayName("Player Difficalty Hard")
	@Test
    void DifficulHard() {
		buttonHardMode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Launcher.DEFAULT_DIFFICULTY = "hard";
                Launcher.DEFAULT_PLAYER_LIFE = "1";
                InputNameUI.main(null);
            }
        });
		buttonHardMode.doClick();
		
        assertEquals("hard",Launcher.DEFAULT_DIFFICULTY);
    }
	@DisplayName("Player Life Hard")
	@Test
    void LifeHard() {
		buttonHardMode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Launcher.DEFAULT_DIFFICULTY = "hard";
                Launcher.DEFAULT_PLAYER_LIFE = "1";
                InputNameUI.main(null);
            }
        });
		buttonHardMode.doClick();
		
        assertEquals("1",Launcher.DEFAULT_PLAYER_LIFE);
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
        boolean isMenuModeUIVisible = false;

        for (Frame f : frames) {
            if (f.getTitle().equals("Pacman Select Mode") && f.isShowing()) {
                isMenuModeUIVisible = true;
                break;
            }
        }
        assertTrue(isMenuModeUIVisible);
    }

}
