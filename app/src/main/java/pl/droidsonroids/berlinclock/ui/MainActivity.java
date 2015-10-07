package pl.droidsonroids.berlinclock.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import java.util.List;
import butterknife.Bind;
import butterknife.ButterKnife;
import pl.droidsonroids.berlinclock.R;

public class MainActivity extends AppCompatActivity implements MainView {

    @Bind(R.id.image_seconds)
    ImageView seconds;

    @Bind({R.id.image_up_hour1, R.id.image_up_hour2, R.id.image_up_hour3, R.id.image_up_hour4})
    List<ImageView> hoursUp;

    @Bind({R.id.image_bottom_hour1, R.id.image_bottom_hour2, R.id.image_bottom_hour3, R.id.image_bottom_hour4})
    List<ImageView> hoursBottom;

    @Bind({R.id.image_up_minute1, R.id.image_up_minute2, R.id.image_up_minute3, R.id.image_up_minute4, R.id.image_up_minute5,
            R.id.image_up_minute6, R.id.image_up_minute7, R.id.image_up_minute8, R.id.image_up_minute9, R.id.image_up_minute10, R.id.image_up_minute11})
    List<ImageView> minutesUp;

    @Bind({R.id.image_bottom_minute1, R.id.image_bottom_minute2, R.id.image_bottom_minute3, R.id.image_bottom_minute4})
    List<ImageView> minutesBottom;

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new MainPresenterImpl();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.setView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.clearView();
    }

    @Override
    public void showSecondsOn() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                seconds.setBackgroundResource(R.drawable.shape_circle_on);
            }
        });
    }

    @Override
    public void showSecondsOff() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                seconds.setBackgroundResource(R.drawable.shape_circle_off);
            }
        });
    }

    @Override
    public void showHourUpOn(final int i) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                hoursUp.get(i).setBackgroundResource(R.drawable.shape_rectangle_red_on);
            }
        });
    }

    @Override
    public void showHourUpOff(final int i) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                hoursUp.get(i).setBackgroundResource(R.drawable.shape_rectangle_off);
            }
        });
    }

    @Override
    public void showHourBottomOn(final int i) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                hoursBottom.get(i).setBackgroundResource(R.drawable.shape_rectangle_red_on);
            }
        });
    }

    @Override
    public void showHourBottomOff(final int i) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                hoursBottom.get(i).setBackgroundResource(R.drawable.shape_rectangle_off);
            }
        });
    }

    @Override
    public void showMinutesUpYellowOn(final int i) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                minutesUp.get(i).setBackgroundResource(R.drawable.shape_rectangle_yellow_on);
            }
        });
    }

    @Override
    public void showMinutesUpYRedOn(final int i) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                minutesUp.get(i).setBackgroundResource(R.drawable.shape_rectangle_red_on);
            }
        });
    }

    @Override
    public void showMinutesUpOff(final int i) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                minutesUp.get(i).setBackgroundResource(R.drawable.shape_rectangle_off);
            }
        });
    }

    @Override
    public void showMinutesBottomOn(final int i) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                minutesBottom.get(i).setBackgroundResource(R.drawable.shape_rectangle_yellow_on);
            }
        });
    }

    @Override
    public void showMinutesBottomOff(final int i) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                minutesBottom.get(i).setBackgroundResource(R.drawable.shape_rectangle_off);
            }
        });
    }
}
