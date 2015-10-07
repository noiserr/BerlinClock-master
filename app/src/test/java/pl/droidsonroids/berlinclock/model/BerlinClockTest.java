package pl.droidsonroids.berlinclock.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BerlinClockTest {

    BerlinClock berlinClock;

    @Before
    public void setUp() {
        berlinClock = new BerlinClock();
    }

    @Test
    public void testConvertToBerlinTime() throws Exception {
    }

    @Test
    public void testGetSeconds_yellow() throws Exception {
        assertEquals("Y", berlinClock.getSeconds(2));
        assertEquals("Y", berlinClock.getSeconds(34));
        assertEquals("Y", berlinClock.getSeconds(0));
    }

    @Test
    public void testGetSeconds_off() throws Exception {
        assertEquals("O", berlinClock.getSeconds(1));
        assertEquals("O", berlinClock.getSeconds(31));
    }


    @Test
    public void testGetTopHours() throws Exception {
        assertEquals("OOOO", berlinClock.getTopHours(4));
        assertEquals("ROOO", berlinClock.getTopHours(5));
        assertEquals("RROO", berlinClock.getTopHours(10));
        assertEquals("RROO", berlinClock.getTopHours(12));
        assertEquals("RRRO", berlinClock.getTopHours(16));
        assertEquals("RRRR", berlinClock.getTopHours(20));
        assertEquals("RRRR", berlinClock.getTopHours(21));
    }

    @Test
    public void testGetBottomHours() throws Exception {
        assertEquals("OOOO", berlinClock.getBottomHours(5));
        assertEquals("ROOO", berlinClock.getBottomHours(1));
        assertEquals("ROOO", berlinClock.getBottomHours(6));
        assertEquals("RROO", berlinClock.getBottomHours(2));
        assertEquals("RROO", berlinClock.getBottomHours(17));
        assertEquals("RRRO", berlinClock.getBottomHours(3));
        assertEquals("RRRO", berlinClock.getBottomHours(8));
        assertEquals("RRRR", berlinClock.getBottomHours(4));
        assertEquals("RRRR", berlinClock.getBottomHours(24));
    }

    @Test
    public void testGetTopMinutes() throws Exception {
        assertEquals("YOOOOOOOOOO", berlinClock.getTopMinutes(5));
        assertEquals("YYROOOOOOOO", berlinClock.getTopMinutes(15));
        assertEquals("YYRYYRYYOOO", berlinClock.getTopMinutes(43));
    }

    @Test
    public void testGetBottomMinutes() throws Exception {
        assertEquals("YYOO", berlinClock.getBottomMinutes(37));
        assertTrue(berlinClock.getBottomMinutes(13).equals("YYYO"));
        assertTrue(berlinClock.getBottomMinutes(39).equals("YYYY"));
    }
}