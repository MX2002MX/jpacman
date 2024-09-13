package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test suite to confirm that {@link Unit}s correctly (de)occupy squares.
 *
 * @author Jeroen Roosen 
 *
 */
class OccupantTest {

    /**
     * The unit under test.
     */
    private Unit unit;

    /**
     * Resets the unit under test.
     */
    @BeforeEach
    void setUp() {
        unit = new BasicUnit();
    }

    /**
     * Asserts that a unit has no square to start with.
     */
    @Test
    void noStartSquare() {
        // Remove the following placeholder:
        assertThat(unit.hasSquare()).isFalse();

    }

    /**
     * Tests that the unit indeed has the target square as its base after
     * occupation.
     */
    @Test
    void testOccupy() {
        // Remove the following placeholder:
        Square square = new BasicSquare();
        unit.occupy(square);
        assertThat(unit.getSquare()).isEqualTo(square);
        assertThat(square.getOccupants()).contains(unit);
    }

    /**
     * Test that the unit indeed has the target square as its base after
     * double occupation.
     */
    @Test
    void testReoccupy() {
        // Create two different Square instances
        Square firstSquare = new BasicSquare();
        Square secondSquare = new BasicSquare();

        // First occupation
        unit.occupy(firstSquare);
        assertThat(unit.getSquare()).isEqualTo(firstSquare);
        assertThat(firstSquare.getOccupants()).contains(unit);

        // Reoccupy the unit with a new square
        unit.occupy(secondSquare);

        // Assert that the unit is now in the new square
        assertThat(unit.getSquare()).isEqualTo(secondSquare);

        // Assert that the previous square no longer contains the unit
        assertThat(firstSquare.getOccupants()).doesNotContain(unit);

        // Assert that the new square contains the unit
        assertThat(secondSquare.getOccupants()).contains(unit);
    }
}
