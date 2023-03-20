package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.Launcher;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.*;

import static nl.tudelft.jpacman.Launcher.DEFAULT_DIFFICULTY;

/**
 * A panel containing a button for every registered action.
 *
 * @author Jeroen Roosen 
 */
class ButtonPanel extends JPanel {

    /**
     * Default serialisation ID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Create a new button panel with a button for every action.
     * @param buttons The map of caption - action for each button.
     * @param parent The parent frame, used to return window focus.
     */
    ButtonPanel(final Map<String, Action> buttons, final JFrame parent) {
        super();
        assert buttons != null;
        assert parent != null;

        for (final String caption : buttons.keySet()) {
            JButton button = new JButton(caption);
            if (button.getText().equals("Start")) {
                button = new JButton(new ImageIcon("src/main/resources/assets/inGamePlayButton.png"));
                button.setBorderPainted(false);
                button.setOpaque(false);
                button.setContentAreaFilled(false);
            }
            if (button.getText().equals("Stop")) {
                button = new JButton(new ImageIcon("src/main/resources/assets/pauseButton.png"));
                button.setBorderPainted(false);
                button.setOpaque(false);
                button.setContentAreaFilled(false);
            }
            if (button.getText().equals("Home")) {
                button = new JButton(new ImageIcon("src/main/resources/assets/homeButton.png"));
                button.setBorderPainted(false);
                button.setOpaque(false);
                button.setContentAreaFilled(false);
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Launcher.pacManUI.reset();
                        HomeUI.main(null);
                    }
                });
            }
            button.addActionListener(e -> {
                buttons.get(caption).doAction();
                parent.requestFocusInWindow();
            });



//            JButton playButton = new JButton(new ImageIcon("src/main/resources/assets/playButton.png"));

            add(button);
        }
    }

}
