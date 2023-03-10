package nl.tudelft.jpacman.board;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Pellet;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.level.PlayerFactory;
import nl.tudelft.jpacman.points.DefaultPointCalculator;
import nl.tudelft.jpacman.sprite.PacManSprites;
import nl.tudelft.jpacman.sprite.Sprite;

class ScoreCalTest {

	PlayerFactory pf;
	PacManSprites sprites;
	PacManSprites spriteStore;

    @BeforeEach
    public void setUp() {
        pf = new PlayerFactory(spriteStore);
    }

    @Test
    public void testAddSinglePlayerKeys() {
        Player p = pf.createPacMan();
        p.addPoints(0);
        assertEquals(0,p.getScore());
        // Verify that the correct key events have been added
        // You may need to write more specific tests depending on your requirements
    }

}
