package nl.tudelft.jpacman.board;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DirectionTest {

	@DisplayName("testNorth Vertical")
	@Test
    void testNorthY() {
        Direction north = Direction.valueOf("NORTH");
        assertEquals(-1,north.getDeltaY());
    }
	@DisplayName("testNorth Horizontal")
	@Test
    void testNorthX() {
        Direction north = Direction.valueOf("NORTH");
        assertEquals(0,north.getDeltaX());
    }
	
	@DisplayName("testSouth Vertical")
	@Test
    void testSouthY() {
        Direction south = Direction.valueOf("SOUTH");
        assertEquals(1,south.getDeltaY());
    }
	@DisplayName("testSouth Horizontal")
	@Test
    void testSouthX() {
        Direction south = Direction.valueOf("SOUTH");
        assertEquals(0,south.getDeltaX());
    }
	
	@DisplayName("testEast Vertical")
	@Test
    void testEastY() {
        Direction east = Direction.valueOf("EAST");
        assertEquals(0,east.getDeltaY());
    }
	@DisplayName("testEast Horizontal")
	@Test
    void testEastX() {
        Direction east = Direction.valueOf("EAST");
        assertEquals(1,east.getDeltaX());
    }
	
	@DisplayName("testWest Vertical")
	@Test
    void testWestY() {
        Direction west = Direction.valueOf("WEST");
        assertEquals(0,west.getDeltaY());
    }
	@DisplayName("testWest Horizontal")
	@Test
    void testWestX() {
        Direction west = Direction.valueOf("WEST");
        assertEquals(-1,west.getDeltaX());
    }

}
