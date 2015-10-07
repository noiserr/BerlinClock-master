package pl.droidsonroids.berlinclock.ui;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;

import pl.droidsonroids.berlinclock.model.BerlinClock;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by noiser on 24.09.2015.
 */
public class MainPresenterImplTest {

    BerlinClock berlinClock;
    MainView mainView;
    MainView.EmptyMainView emptyMainView = new MainView.EmptyMainView();
    MainPresenterImpl mainPresenter;

    String[] time = new String[]{"O", "RRRO", "OOOO", "YYRYYROOOOO", "YYYO"}; //15:33:31

    @Before
    public void setUp() throws Exception {
        berlinClock = mock(BerlinClock.class);
        mainView = mock(MainView.class);
        mainPresenter = new MainPresenterImpl();
        mainPresenter.setBerlinClock(berlinClock);
    }

    @Test
    public void testSetView() throws Exception {
        mainPresenter.setView(mainView);
        assertEquals(mainView, mainPresenter.getMainView());
    }

    @Test
    public void testClearView() throws Exception {
        mainPresenter.clearView();
        assertSame(emptyMainView, mainPresenter.getMainView());
    }

    @Test
    public void testShowSeconds__off() throws Exception {
        when(berlinClock.convertToBerlinTime(anyString())).thenReturn(new String[]{"O", "", "", "", ""});

        mainPresenter.setView(mainView);
        mainPresenter.setCurrentTime(anyString());
        verify(mainView).showSecondsOff();
    }

    @Test
    public void testShowSeconds_on() throws Exception {
        when(berlinClock.convertToBerlinTime(anyString())).thenReturn(new String[]{"Y", "", "", "", ""});

        mainPresenter.setView(mainView);
        mainPresenter.setCurrentTime(anyString());
        verify(mainView).showSecondsOn();
    }

    @Test
    public void testShowHoursTop() {
        when(berlinClock.convertToBerlinTime(anyString())).thenReturn(new String[]{"", "ROOO", "", "", ""});
        mainPresenter.setView(mainView);
        mainPresenter.setCurrentTime(anyString());
        verify(mainView).showHourUpOn(0);
        verify(mainView).showHourUpOff(1);
        verify(mainView).showHourUpOff(2);
        verify(mainView).showHourUpOff(3);
    }

    @Test
    public void testShowHoursBottom() {
        when(berlinClock.convertToBerlinTime(anyString())).thenReturn(new String[]{"", "", "RRRO", "", ""});
        mainPresenter.setView(mainView);
        mainPresenter.setCurrentTime(anyString());
        verify(mainView).showHourBottomOn(0);
        verify(mainView).showHourBottomOn(1);
        verify(mainView).showHourBottomOn(2);
        verify(mainView).showHourBottomOff(3);
    }

    @Test
    public void testShowMinutesTop() {
        when(berlinClock.convertToBerlinTime(anyString())).thenReturn(new String[]{"", "", "", "YYRYYRYOOOO", ""});
        mainPresenter.setView(mainView);
        mainPresenter.setCurrentTime(anyString());
        verify(mainView).showMinutesUpYellowOn(0);
        verify(mainView).showMinutesUpYellowOn(1);
        verify(mainView).showMinutesUpYRedOn(2);
        verify(mainView).showMinutesUpYellowOn(3);
        verify(mainView).showMinutesUpYellowOn(4);
        verify(mainView).showMinutesUpYRedOn(5);
        verify(mainView).showMinutesUpYellowOn(6);
        verify(mainView).showMinutesUpOff(7);
        verify(mainView).showMinutesUpOff(8);
        verify(mainView).showMinutesUpOff(9);
        verify(mainView).showMinutesUpOff(10);


    }

    @Test
    public void testShowMinutesBottom() {
        when(berlinClock.convertToBerlinTime(anyString())).thenReturn(new String[]{"", "", "", "", "YYYO"});
        mainPresenter.setView(mainView);
        mainPresenter.setCurrentTime(anyString());
        verify(mainView).showMinutesBottomOn(0);
        verify(mainView).showMinutesBottomOn(1);
        verify(mainView).showMinutesBottomOn(2);
        verify(mainView).showMinutesBottomOff(3);
    }

}