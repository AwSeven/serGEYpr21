package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {
Timer timer;
TimerTask timerTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer =  new Timer();
        timerTask = new MyTimerTask();
        timer.schedule(timerTask,5000);
    }

    class MyTimerTask extends TimerTask{

        @Override
        public void run(){
            Intent intent = new Intent(MainActivity.this, Analis.class);
            startActivity(intent);
        }
    };
}