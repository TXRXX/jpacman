package nl.tudelft.jpacman;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.game.GameFactory;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.LevelFactory;
import nl.tudelft.jpacman.level.MapParser;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.level.PlayerFactory;
import nl.tudelft.jpacman.npc.ghost.GhostFactory;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.points.PointCalculatorLoader;
import nl.tudelft.jpacman.sprite.PacManSprites;
import nl.tudelft.jpacman.ui.Action;
import nl.tudelft.jpacman.ui.PacManUI;
import nl.tudelft.jpacman.ui.PacManUiBuilder;

/**
 * Creates and launches the JPacMan UI.
 * 
 * @author Jeroen Roosen
 */
@SuppressWarnings("PMD.TooManyMethods")
public class Launcher {

    private static PacManSprites SPRITE_STORE = new PacManSprites();

    public static final String DEFAULT_MAP = "/board.txt";

    public static String DEFAULT_DIFFICULTY = "easy";

    public static String DEFAULT_PLAYER_LIFE = "infinity";
    public static String DEFAULT_PLAYER_NAME = "";
    private String levelMap = DEFAULT_MAP;


    public static PacManUI pacManUI;

    private Game game;

    public Launcher() {
    }

    /**
     * @return The game object this launcher will start when {@link #launch(String difficulty)}
     *         is called.
     */
    public Game getGame() {
        return game;
    }

    /**
     * The map file used to populate the level.
     *
     * @return The name of the map file.
     */
    protected String getLevelMap() {
        return levelMap;
    }

    /**
     * Set the name of the file containing this level's map.
     *
     * @param fileName
     *            Map to be used.
     * @return Level corresponding to the given map.
     */
    public Launcher withMapFile(String fileName) {
        levelMap = fileName;
        return this;
    }

    /**
     * Creates a new game using the level from {@link #makeLevel(String difficulty)}.
     *
     * @return a new Game.
     */
    public Game makeGame(String difficulty) {
        GameFactory gf = getGameFactory();
        Level level = makeLevel(difficulty);
        game = gf.createSinglePlayerGame(level, loadPointCalculator());
        return game;
    }

    private PointCalculator loadPointCalculator() {
        return new PointCalculatorLoader().load();
    }

    /**
     * Creates a new level. By default this method will use the map parser to
     * parse the default board stored in the <code>board.txt</code> resource.
     *
     * @return A new level.
     */
    public Level makeLevel(String difficulty) {
        try {
            return getMapParser(difficulty).parseMap(getLevelMap());
        } catch (IOException e) {
            throw new PacmanConfigurationException(
                    "Unable to create level, name = " + getLevelMap(), e);
        }
    }

    /**
     * @return A new map parser object using the factories from
     *         {@link #getLevelFactory(String difficulty)} and {@link #getBoardFactory()}.
     */
    protected MapParser getMapParser(String difficulty) {
        return new MapParser(getLevelFactory(difficulty), getBoardFactory());
    }

    /**
     * @return A new board factory using the sprite store from
     *         {@link #getSpriteStore()}.
     */
    protected BoardFactory getBoardFactory() {
        return new BoardFactory(getSpriteStore());
    }

    /**
     * @return The default {@link PacManSprites}.
     */
    protected PacManSprites getSpriteStore() {
        return SPRITE_STORE;
    }

    /**
     * @return A new factory using the sprites from {@link #getSpriteStore()}
     *         and the ghosts from {@link #getGhostFactory()}.
     */
    protected LevelFactory getLevelFactory(String difficulty) {
        LevelFactory level = new LevelFactory(getSpriteStore(), getGhostFactory(), loadPointCalculator());
        level.setSpeed(difficulty);
        return level;
    }

    /**
     * @return A new factory using the sprites from {@link #getSpriteStore()}.
     */
    protected GhostFactory getGhostFactory() {
        return new GhostFactory(getSpriteStore());
    }

    /**
     * @return A new factory using the players from {@link #getPlayerFactory()}.
     */
    protected GameFactory getGameFactory() {
        return new GameFactory(getPlayerFactory());
    }

    /**
     * @return A new factory using the sprites from {@link #getSpriteStore()}.
     */
    protected PlayerFactory getPlayerFactory() {
        return new PlayerFactory(getSpriteStore());
    }

    /**
     * Adds key events UP, DOWN, LEFT and RIGHT to a game.
     *
     * @param builder The {@link PacManUiBuilder} that will provide the UI.
     */

    protected void addSinglePlayerKeys(final PacManUiBuilder builder) {

        builder.addKey(KeyEvent.VK_UP, moveTowardsDirection(Direction.NORTH))
            .addKey(KeyEvent.VK_DOWN, moveTowardsDirection(Direction.SOUTH))
            .addKey(KeyEvent.VK_LEFT, moveTowardsDirection(Direction.WEST))
            .addKey(KeyEvent.VK_RIGHT, moveTowardsDirection(Direction.EAST));

    }

    private Direction ValueDirection;
    public boolean checkSameOldAndNew(Direction newValueDirection){
        Direction oldValueDirection = this.ValueDirection;
        this.ValueDirection = newValueDirection;
        if(ValueDirection!=oldValueDirection){
            return true;
        }
        else {
            return false;
        }

    }

    private Timer timer = new Timer();
    private TimerTask oldTask;
    public void taskCancel(TimerTask task, Boolean c){
        TimerTask ot = oldTask;
        this.oldTask = task;
        synchronized (ot){
            if(c){
                ot.cancel();
            }
        }
    }
    private Action moveTowardsDirection(Direction direction) {
        boolean c = checkSameOldAndNew(direction);
        if(c==false){
            return null;
        }

        return () -> {
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    assert game != null;
                    getGame().move(getSinglePlayer(getGame()), direction);
                }
            };
            try{
                taskCancel(task,c);
            }finally {
                timer.schedule(task, 0, 200);
            }
        };

    }


    private Player getSinglePlayer(final Game game) {
        List<Player> players = game.getPlayers();
        if (players.isEmpty()) {
            throw new IllegalArgumentException("Game has 0 players.");
        }
        return players.get(0);
    }

    /**
     * Creates and starts a JPac-Man game.
     */
    public void launch(String difficulty) {
        makeGame(difficulty);
        PacManUiBuilder builder = new PacManUiBuilder().withDefaultButtons();
        addSinglePlayerKeys(builder);
        pacManUI = builder.build(getGame());
        pacManUI.start();
    }

    public void reset(){
        if (getGame().getLevel().isAnyPlayerAlive()){
            makeGame(DEFAULT_DIFFICULTY);
            PacManUiBuilder builder = new PacManUiBuilder().withDefaultButtons();
            addSinglePlayerKeys(builder);
            pacManUI = builder.build(getGame());
            pacManUI.start();
        }
    }

    /**
     * Disposes of the UI. For more information see
     * {@link javax.swing.JFrame#dispose()}.
     * Precondition: The game was launched first.
     */
    public void dispose() {
        assert pacManUI != null;
        pacManUI.dispose();
    }

    /**
     * Main execution method for the Launcher.
     *
     * @param args
     *            The command line arguments - which are ignored.
     * @throws IOException
     *             When a resource could not be read.
     */
    public static void main(String[] args) throws IOException {
        new Launcher().launch(DEFAULT_DIFFICULTY);
    }
}
