package pl.droidsonroids.berlinclock.ui;

public interface MainView {
    void showSecondsOn();
    void showSecondsOff();

    void showHourUpOn(int i);
    void showHourUpOff(int i);

    void showHourBottomOn(int i);
    void showHourBottomOff(int i);

    void showMinutesUpYellowOn(int i);
    void showMinutesUpYRedOn(int i);
    void showMinutesUpOff(int i);

    void showMinutesBottomOn(int i);
    void showMinutesBottomOff(int i);

    class EmptyMainView implements MainView {

        @Override
        public void showSecondsOn() {

        }

        @Override
        public void showSecondsOff() {

        }

        @Override
        public void showHourUpOn(int i) {

        }

        @Override
        public void showHourUpOff(int i) {

        }

        @Override
        public void showHourBottomOn(int i) {

        }

        @Override
        public void showHourBottomOff(int i) {

        }

        @Override
        public void showMinutesUpYellowOn(int i) {

        }

        @Override
        public void showMinutesUpYRedOn(int i) {

        }

        @Override
        public void showMinutesUpOff(int i) {

        }

        @Override
        public void showMinutesBottomOn(int i) {

        }

        @Override
        public void showMinutesBottomOff(int i) {

        }
    }
}
