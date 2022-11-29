package com.mycompany.app;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ThreeInARowTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    // private ThreeInARow threeInARow;

    // @Before
    // public void before() {
    // threeInARow = new ThreeInARow();
    // }

    @Test
    public void whenIsOutOfXThrowException() throws Exception {
        // Prepare test
        ThreeInARow threeInARow = new ThreeInARow();

        // Test logic

        // Verify o Assert
        expectedException.expect(Exception.class);
        threeInARow.play(5, 2);
    }

    @Test
    public void whenIsOutOfYThrowException() throws Exception {
        // Prepare test
        ThreeInARow threeInARow = new ThreeInARow();

        // Test logic

        // Verify o Assert
        expectedException.expect(Exception.class);
        threeInARow.play(2, 5);
    }

    @Test
    public void whenPlaceHasPlayerThrowException() throws Exception {
        // Prepare test
        ThreeInARow threeInARow = new ThreeInARow();

        // Test logic
        expectedException.expect(Exception.class);
        // player x
        threeInARow.play(1, 3);

        // Verify o Assert
        expectedException.expect(Exception.class);
        // player 0
        threeInARow.play(1, 3);
    }

    @Test
    public void ifFirstPlayThenPlayX() throws Exception {
        // Prepare test
        ThreeInARow threeInARow = new ThreeInARow();

        // Test logic

        // Verify o Assert
        assertEquals('X', threeInARow.nextPlay());
    }

    @Test
    public void ifLastPlayXThenPlayPlus() throws Exception {
        // Prepare test
        ThreeInARow threeInARow = new ThreeInARow();

        // Test logic
        // player x
        threeInARow.play(1, 3);

        // Verify o Assert
        assertEquals('+', threeInARow.nextPlay());
    }

    @Test
    public void ifLastPlayPlusThenPlayX() throws Exception {
        // Prepare test
        ThreeInARow threeInARow = new ThreeInARow();

        // Test logic
        // player x
        threeInARow.play(1, 3);

        // Verify o Assert
        assertEquals('+', threeInARow.nextPlay());

        // player +
        threeInARow.play(2, 3);
        assertEquals('X', threeInARow.nextPlay());
    }

    @Test
    public void whenThereIsNoWinner() throws Exception {
        // Prepare test
        ThreeInARow threeInARow = new ThreeInARow();

        // Test logic
        // player x
        String result = threeInARow.play(2, 1);

        // Verify o Assert
        assertEquals("There is no winner", result);
    }

    @Test
    public void ifRowCompleteThenWin() throws Exception {
        // Prepare test
        ThreeInARow threeInARow = new ThreeInARow();

        // Test logic
        // player x
        threeInARow.play(1, 1);
        // player +
        threeInARow.play(1, 2);
        // player x
        threeInARow.play(2, 1);
        // player +
        threeInARow.play(2, 2);

        // player X
        String result = threeInARow.play(3, 1);

        // Verify o Assert
        assertEquals("The winner is X", result);
    }

    @Test
    public void ifColumnCompleteThenWin() throws Exception {
        // Prepare test
        ThreeInARow threeInARow = new ThreeInARow();

        // Test logic
        // player x
        threeInARow.play(2, 1);
        // player +
        threeInARow.play(1, 1);
        // player x
        threeInARow.play(3, 1);
        // player +
        threeInARow.play(1, 2);
        // player x
        threeInARow.play(2, 2);

        // player +
        String result = threeInARow.play(1, 3);

        // Verify o Assert
        assertEquals("The winner is +", result);
    }
}
