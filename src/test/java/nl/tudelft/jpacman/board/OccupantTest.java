package nl.tudelft.jpacman.board;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test suite to confirm that {@link Unit}s correctly (de)occupy squares.
 *
 * @author Jeroen Roosen
 */
class OccupantTest {

    /**
     * The unit under test.
     */
    private Unit unit;

    /**
     * The square under test.
     */
    private Square square;

    /**
     * Sets up the unit and square for testing.
     */
    @BeforeEach
    void setUp() {
        unit = new BasicUnit();
        square = new BasicSquare();
    }

    /**
     * Asserts that a unit has no square to start with.
     */
    @Test
    void noStartSquare() {
        assertNull(unit.getSquare());
    }

    /**
     * Tests that the unit indeed has the target square as its base after
     * occupation.
     */
    @Test
    void testOccupy() {
        unit.occupy(square);
        assertSame(square, unit.getSquare());
    }

    /**
     * Test that the unit indeed has the target square as its base after
     * double occupation.
     */
    @Test
    void testReoccupy() {
        unit.occupy(square);
        unit.occupy(square);
        assertSame(square, unit.getSquare());
    }
}
