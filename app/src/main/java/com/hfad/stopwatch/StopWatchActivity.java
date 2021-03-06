package com.hfad.stopwatch;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class StopWatchActivity extends AppCompatActivity {
    // number of seconds displayed on the stopwatch.
    private int seconds = 0;
    // Is the stopwatch running.
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);
        runTimer();
    }

    // Start the stopwatch running when the start button is clicked.
    public void onClickStart(View view) {
        running = true;
    }

    // Stop the stopwatch when the stop button is clicked.
    public void onClickStop(View view) {
        running = false;
    }

    // Reset the stopwatch when the button is clicked.
    public void onClickReset(View view) {
        running = false;
        seconds = 0;
    }

    private void runTimer(){
        final TextView timeView = (TextView)findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;
                String time = String.format("%d:%02d:%02d", hours, minutes, secs);
                timeView.setText(time);
                if (running) {
                    seconds ++;
                }
                handler.postDelayed(this,1000);
            }
        });

    }
}
