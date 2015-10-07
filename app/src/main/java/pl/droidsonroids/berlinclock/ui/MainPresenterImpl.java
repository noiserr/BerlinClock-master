package pl.droidsonroids.berlinclock.ui;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import pl.droidsonroids.berlinclock.model.BerlinClock;


public class MainPresenterImpl implements MainPresenter {

    private MainView mainView = new MainView.EmptyMainView();
    private BerlinClock berlinClock;

    public MainPresenterImpl() {
        berlinClock = new BerlinClock();
    }

    @Override
    public void setView(MainView view) {
        mainView = view;
        startClock();
    }


    MainView getMainView() {
        return mainView;
    }

    @Override
    public void clearView() {
        mainView = new MainView.EmptyMainView();
    }

    public void startClock() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                updateTime();
            }
        }, 1000, 1000);
    }

    private void updateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        String currentTime = sdf.format(new Date());
        setCurrentTime(currentTime);
    }

    void setCurrentTime(String currentTime) {
        String[] berlinTime = berlinClock.convertToBerlinTime(currentTime);

        manageSeconds(berlinTime[0]);
        manageUpHours(berlinTime[1]);
        manageBottomHours(berlinTime[2]);
        manageUpMinutes(berlinTime[3]);
        manageBottomMinutes(berlinTime[4]);
    }

    private void manageSeconds(String time) {
        if(time.equals("Y")) {
            mainView.showSecondsOn();
        }else {
            mainView.showSecondsOff();
        }
    }

    private void manageUpHours(String time) {
        for(int i = 0; i < time.length(); i++) {
            if(time.substring(i, i+1).equals("R")) {
                mainView.showHourUpOn(i);
            }else {
                mainView.showHourUpOff(i);
            }
        }
    }

    private void manageBottomHours(String time) {
        for(int i = 0; i < time.length(); i++) {
            if(time.substring(i, i+1).equals("R")) {
                mainView.showHourBottomOn(i);
            }else {
                mainView.showHourBottomOff(i);
            }
        }
    }

    private void manageUpMinutes(String time) {
        for(int i = 0; i < time.length(); i++) {
            if(time.substring(i, i+1).equals("Y")) {
                mainView.showMinutesUpYellowOn(i);
            }else if(time.substring(i, i+1).equals("R")) {
                mainView.showMinutesUpYRedOn(i);
            }else {
                mainView.showMinutesUpOff(i);
            }
        }
    }

    private void manageBottomMinutes(String time) {
        for(int i = 0; i < time.length(); i++) {
            if(time.substring(i, i+1).equals("Y")) {
                mainView.showMinutesBottomOn(i);
            }else {
                mainView.showMinutesBottomOff(i);
            }
        }
    }

    public void setBerlinClock(BerlinClock berlinClock) {
        this.berlinClock = berlinClock;
    }
}
