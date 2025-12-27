package org.example.hanoi;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestHanoiModel {


    @Test
    public void resetShouldCreateAllDisksOnPeg0() {
        HanoiModel model = new HanoiModel(3);

        assertEquals(3, model.getPegs()[0].size());
        assertEquals(0, model.getPegs()[1].size());
        assertEquals(0, model.getPegs()[2].size());

        assertEquals(Integer.valueOf(3), model.getPegs()[0].get(0));
        assertEquals(Integer.valueOf(2), model.getPegs()[0].get(1));
        assertEquals(Integer.valueOf(1), model.getPegs()[0].get(2));
    }

    @Test
    public void moveShouldAllowSmallerOntoBigger() {
        HanoiModel model = new HanoiModel(3);
        assertTrue(model.move(0, 1));
        assertEquals(Integer.valueOf(1), model.getPegs()[1].peek());
        assertEquals(Integer.valueOf(2), model.getPegs()[0].peek());
    }
    @Test
    public void moveShouldRejectBiggerOntoSmaller() {
        HanoiModel model = new HanoiModel(3);
        assertTrue(model.move(0, 1));
        assertFalse(model.move(0, 1));
        assertEquals(Integer.valueOf(1), model.getPegs()[1].peek());
        assertEquals(Integer.valueOf(2), model.getPegs()[0].peek());
    }
    @Test
    public void isSolvedShouldBeTrueWhenAllDisksOnPeg2() {
        HanoiModel model = new HanoiModel(3);

        assertTrue(model.move(0, 2)); // 1
        assertTrue(model.move(0, 1)); // 2
        assertTrue(model.move(2, 1)); // 1
        assertTrue(model.move(0, 2)); // 3
        assertTrue(model.move(1, 0)); // 1
        assertTrue(model.move(1, 2)); // 2
        assertTrue(model.move(0, 2)); // 1
        assertTrue(model.isSolved());
        assertEquals(3, model.getPegs()[2].size());
    }

}
