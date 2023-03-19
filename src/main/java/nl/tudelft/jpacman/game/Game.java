package nl.tudelft.jpacman.game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import nl.tudelft.jpacman.ui.HomeUI;
import nl.tudelft.jpacman.ui.MenuModeUI;

import javax.swing.*;

import static nl.tudelft.jpacman.Launcher.*;

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
        // show Player Name and Score
        System.out.println("Player Name : " + DEFAULT_PLAYER_NAME + ", Get Score :" + Player.score);
        //write playerName and score to database
//        DBScoreBoard.WriteScoreBoard(DEFAULT_PLAYER_NAME,Player.score);

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
            popupController("You Lost");
        }

    }

    public void popupController(String text){
        JFrame popup = new JFrame("Popup");
        Color bgColor = Color.darkGray;
        popup.getContentPane().setBackground(bgColor);
        popup.setLayout(new GridBagLayout());

        JLabel headerLabel = new JLabel(text);
        headerLabel.setFont(new Font("Retro Gaming", Font.BOLD, 50));
        popup.add(headerLabel, new GridBagConstraints());
        Color headerTextColor = Color.white;
        headerLabel.setForeground(headerTextColor);

        JButton buttonBtHome = new JButton("HOME");
        JButton buttonBtScore = new JButton("Score");
        JButton buttonRetry = new JButton("RETRY");


        popup.add(headerLabel);
        popup.add(buttonBtHome);
        popup.add(buttonRetry);

        buttonBtHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Launcher.pacManUI.reset();
                popup.dispose();
                HomeUI.main(null);

            }
        });

        buttonRetry.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                popup.dispose();
                Launcher.pacManUI.reset();
                Launcher launcher = new Launcher();
                if(Launcher.DEFAULT_DIFFICULTY == "medium"){
                    Launcher.DEFAULT_PLAYER_LIFE = "3";
                }
                else if (Launcher.DEFAULT_DIFFICULTY == "hard") {
                    Launcher.DEFAULT_PLAYER_LIFE = "1";
                }

                launcher.launch(DEFAULT_DIFFICULTY);

            }
        });

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
        popupController("You Won");
        stop();
    }

    @Override
    public void levelLost() {
        reset();
    }
}
