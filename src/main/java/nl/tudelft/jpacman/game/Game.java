package nl.tudelft.jpacman.game;

import java.awt.*;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Objects;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Level.LevelObserver;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.points.PointCalculator;

import javax.swing.*;

import static nl.tudelft.jpacman.Launcher.DEFAULT_DIFFICULTY;
import static nl.tudelft.jpacman.Launcher.DEFAULT_PLAYER_LIFE;

/**
 * A basic implementation of a Pac-Man game.
 *
 * @author Jeroen Roosen 
 */
public abstract class Game implements LevelObserver {

    /**
     * <code>true</code> if the game is in progress.
     */
    private boolean inProgress;

    /**
     * Object that locks the start and stop methods.
     */
    private final Object progressLock = new Object();

    /**
     * The algorithm used to calculate the points that
     * they player gets whenever some action happens.
     */
    private PointCalculator pointCalculator;

    /**
     * Creates a new game.
     *
     * @param pointCalculator
     *             The way to calculate points upon collisions.
     */
    protected Game(PointCalculator pointCalculator) {
        this.pointCalculator = pointCalculator;
        inProgress = false;
    }

    /**
     * Starts or resumes the game.
     */
    public void start() {
        synchronized (progressLock) {
            if (isInProgress()) {
                return;
            }

            if (getLevel().isAnyPlayerAlive() && getLevel().remainingPellets() > 0) {
                inProgress = true;
                getLevel().addObserver(this);
                getLevel().start();
            }
        }
    }

    /**
     * Pauses the game.
     */
    public void stop() {
        synchronized (progressLock) {
            if (!isInProgress()) {
                return;
            }
            inProgress = false;
            getLevel().stop();
        }
    }

    public void reset(){
        stop();
        if(!Objects.equals(DEFAULT_DIFFICULTY, "easy") && !Objects.equals(DEFAULT_PLAYER_LIFE, "0")){
            int life = Integer.parseInt(DEFAULT_PLAYER_LIFE);
            life -= 1;
            DEFAULT_PLAYER_LIFE = String.valueOf(life);
//            System.out.println("Player Life : "+ DEFAULT_PLAYER_LIFE);
        }
        if(!Objects.equals(DEFAULT_PLAYER_LIFE,"0")){
            Launcher.pacManUI.reset();
            Launcher launcher = new Launcher();
            launcher.launch(DEFAULT_DIFFICULTY);
        }

        else if(!isInProgress() && Objects.equals(DEFAULT_PLAYER_LIFE,"0")){
            popupController();
        }
    }

    private void popupController(){
        JFrame popup = new JFrame("Popup");
        Color bgColor = Color.darkGray;
        popup.getContentPane().setBackground(bgColor);
        popup.setLayout(new GridBagLayout());

        JLabel headerLabel = new JLabel("You ....");
        headerLabel.setFont(new Font("Retro Gaming", Font.BOLD, 50));
        popup.add(headerLabel, new GridBagConstraints());
        Color headerTextColor = Color.white;
        headerLabel.setForeground(headerTextColor);

        JButton buttonBtHome = new JButton("HOME");
        JButton buttonRetry = new JButton("RETRY");
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        popup.add(headerLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1;
        popup.add(buttonBtHome, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1;
        popup.add(buttonRetry, gbc);

        popup.pack();
        popup.setSize(300,300);
        popup.setResizable(false);
        popup.setVisible(true);
    };

    /**
     * @return <code>true</code> iff the game is started and in progress.
     */
    public boolean isInProgress() {
        return inProgress;
    }

    /**
     * @return An immutable list of the participants of this game.
     */
    public abstract List<Player> getPlayers();

    /**
     * @return The level currently being played.
     */
    public abstract Level getLevel();

    /**
     * Moves the specified player one square in the given direction.
     *
     * @param player
     *            The player to move.
     * @param direction
     *            The direction to move in.
     */
    public Timer timer = new Timer();
    public void move(Player player, Direction direction) {

        if (isInProgress()) {
            // execute player move.
            getLevel().move(player, direction);
            pointCalculator.pacmanMoved(player, direction);

        }
    };


    @Override
    public void levelWon() {
        stop();
    }

    @Override
    public void levelLost() {
        reset();
    }
}
