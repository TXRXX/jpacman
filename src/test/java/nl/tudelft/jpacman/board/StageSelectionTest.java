package nl.tudelft.jpacman.board;

import static nl.tudelft.jpacman.Launcher.DEFAULT_MAP;
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
import nl.tudelft.jpacman.ui.MenuDifficultyUI;
import nl.tudelft.jpacman.ui.MenuModeUI;

class StageSelectionTest {
	JFrame frame = new JFrame("Pacman Select Stage");
	JButton map1 = new JButton(new ImageIcon("src/main/resources/assets/map1.png"));
	JButton map2 = new JButton(new ImageIcon("src/main/resources/assets/map2.png"));
	JButton map3 = new JButton(new ImageIcon("src/main/resources/assets/map3.png"));
	JButton map4 = new JButton(new ImageIcon("src/main/resources/assets/map4.png"));
	JButton map5 = new JButton(new ImageIcon("src/main/resources/assets/map5.png"));
	JButton backButton = new JButton(new ImageIcon("src/main/resources/assets/backButton.png"));

	@DisplayName("Map1 to Input name")
	@Test
	void testMap1toName() {
		map1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                if(Launcher.DEFAULT_DIFFICULTY.equals("hard")){
                    DEFAULT_MAP = "/boardH.txt";
                }else{
                    DEFAULT_MAP = "/board.txt";
                }
                InputNameUI.main(null);
            }
        });
		map1.doClick();
		
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
	
	@DisplayName("Select Map1")
	@Test
	void testMap1() {
		Launcher.DEFAULT_DIFFICULTY = "easy";
		map1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                if(Launcher.DEFAULT_DIFFICULTY.equals("hard")){
                    DEFAULT_MAP = "/boardH.txt";
                }else{
                    DEFAULT_MAP = "/board.txt";
                }
                InputNameUI.main(null);
            }
        });
		map1.doClick();
		
		assertEquals("/board.txt",Launcher.DEFAULT_MAP);
	}
	
	@DisplayName("Select Map1 Hard")
	@Test
	void testMap1H() {
		Launcher.DEFAULT_DIFFICULTY = "hard";
		map1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                if(Launcher.DEFAULT_DIFFICULTY.equals("hard")){
                    DEFAULT_MAP = "/boardH.txt";
                }else{
                    DEFAULT_MAP = "/board.txt";
                }
                InputNameUI.main(null);
            }
        });
		map1.doClick();
		
		assertEquals("/boardH.txt",Launcher.DEFAULT_MAP);
	}
	
	@DisplayName("Map2 to Input name")
	@Test
	void testMap2toName() {
		map2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                if(Launcher.DEFAULT_DIFFICULTY.equals("hard")){
                    DEFAULT_MAP = "/board2H.txt";
                }else{
                    DEFAULT_MAP = "/board2.txt";
                }
                InputNameUI.main(null);
            }
        });
		map2.doClick();
		
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
	
	@DisplayName("Select Map2")
	@Test
	void testMap2() {
		Launcher.DEFAULT_DIFFICULTY = "easy";
		map2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                if(Launcher.DEFAULT_DIFFICULTY.equals("hard")){
                    DEFAULT_MAP = "/board2H.txt";
                }else{
                    DEFAULT_MAP = "/board2.txt";
                }
                InputNameUI.main(null);
            }
        });
		map2.doClick();
		
		assertEquals("/board2.txt",Launcher.DEFAULT_MAP);
	}
	
	@DisplayName("Select Map2 Hard")
	@Test
	void testMap2H() {
		Launcher.DEFAULT_DIFFICULTY = "hard";
		map2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                if(Launcher.DEFAULT_DIFFICULTY.equals("hard")){
                    DEFAULT_MAP = "/board2H.txt";
                }else{
                    DEFAULT_MAP = "/board2.txt";
                }
                InputNameUI.main(null);
            }
        });
		map2.doClick();
		
		assertEquals("/board2H.txt",Launcher.DEFAULT_MAP);
	}
	
	@DisplayName("Map3 to Input name")
	@Test
	void testMap3toName() {
		map3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                if(Launcher.DEFAULT_DIFFICULTY.equals("hard")){
                    DEFAULT_MAP = "/boardH.txt";
                }else{
                    DEFAULT_MAP = "/board.txt";
                }
                InputNameUI.main(null);
            }
        });
		map3.doClick();
		
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
	
	@DisplayName("Select Map3")
	@Test
	void testMap3() {
		Launcher.DEFAULT_DIFFICULTY = "easy";
		map3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                if(Launcher.DEFAULT_DIFFICULTY.equals("hard")){
                    DEFAULT_MAP = "/board3H.txt";
                }else{
                    DEFAULT_MAP = "/board3.txt";
                }
                InputNameUI.main(null);
            }
        });
		map3.doClick();
		
		assertEquals("/board3.txt",Launcher.DEFAULT_MAP);
	}
	
	@DisplayName("Select Map3 Hard")
	@Test
	void testMap3H() {
		Launcher.DEFAULT_DIFFICULTY = "hard";
		map3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                if(Launcher.DEFAULT_DIFFICULTY.equals("hard")){
                    DEFAULT_MAP = "/board3H.txt";
                }else{
                    DEFAULT_MAP = "/board3.txt";
                }
                InputNameUI.main(null);
            }
        });
		map3.doClick();
		
		assertEquals("/board3H.txt",Launcher.DEFAULT_MAP);
	}
	
	@DisplayName("Map4 to Input name")
	@Test
	void testMap4toName() {
		map4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                if(Launcher.DEFAULT_DIFFICULTY.equals("hard")){
                    DEFAULT_MAP = "/board4H.txt";
                }else{
                    DEFAULT_MAP = "/board4.txt";
                }
                InputNameUI.main(null);
            }
        });
		map4.doClick();
		
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
	
	@DisplayName("Select Map4")
	@Test
	void testMap4() {
		Launcher.DEFAULT_DIFFICULTY = "easy";
		map4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                if(Launcher.DEFAULT_DIFFICULTY.equals("hard")){
                    DEFAULT_MAP = "/board4H.txt";
                }else{
                    DEFAULT_MAP = "/board4.txt";
                }
                InputNameUI.main(null);
            }
        });
		map4.doClick();
		
		assertEquals("/board4.txt",Launcher.DEFAULT_MAP);
	}
	
	@DisplayName("Select Map4 Hard")
	@Test
	void testMap4H() {
		Launcher.DEFAULT_DIFFICULTY = "hard";
		map4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                if(Launcher.DEFAULT_DIFFICULTY.equals("hard")){
                    DEFAULT_MAP = "/board4H.txt";
                }else{
                    DEFAULT_MAP = "/board4.txt";
                }
                InputNameUI.main(null);
            }
        });
		map4.doClick();
		
		assertEquals("/board4H.txt",Launcher.DEFAULT_MAP);
	}
	
	@DisplayName("Map5 to Input name")
	@Test
	void testMap5toName() {
		map5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                if(Launcher.DEFAULT_DIFFICULTY.equals("hard")){
                    DEFAULT_MAP = "/board5H.txt";
                }else{
                    DEFAULT_MAP = "/board5.txt";
                }
                InputNameUI.main(null);
            }
        });
		map5.doClick();
		
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
	
	@DisplayName("Select Map5")
	@Test
	void testMap5() {
		Launcher.DEFAULT_DIFFICULTY = "easy";
		map5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                if(Launcher.DEFAULT_DIFFICULTY.equals("hard")){
                    DEFAULT_MAP = "/board5H.txt";
                }else{
                    DEFAULT_MAP = "/board5.txt";
                }
                InputNameUI.main(null);
            }
        });
		map5.doClick();
		
		assertEquals("/board5.txt",Launcher.DEFAULT_MAP);
	}
	
	@DisplayName("Select Map1 Hard")
	@Test
	void testMap5H() {
		Launcher.DEFAULT_DIFFICULTY = "hard";
		map5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                if(Launcher.DEFAULT_DIFFICULTY.equals("hard")){
                    DEFAULT_MAP = "/board5H.txt";
                }else{
                    DEFAULT_MAP = "/board5.txt";
                }
                InputNameUI.main(null);
            }
        });
		map5.doClick();
		
		assertEquals("/board5H.txt",Launcher.DEFAULT_MAP);
	}
	
	@DisplayName("Back Button")
	@Test
	void testBackButton() {
		backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                MenuDifficultyUI.main(null);
            }
        });
		backButton.doClick();
		
		Frame[] frames = JFrame.getFrames();
	    boolean isDifficultyUIVisible = false;

	    for (Frame f : frames) {
	        if (f.getTitle().equals("Pacman Select Difficulty") && f.isShowing()) {
	        	isDifficultyUIVisible = true;
	            break;
	        }
	    }
	    assertTrue(isDifficultyUIVisible);
	}
	
}
