package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.security.DigestException;

public class Analis extends Activity implements GestureDetector.OnGestureListener {

    TextView textView,textView1,textView2;

    ImageView imageView,imageView1;



    int [] title = new int[3];
    float x1 = 0;
    int i = 0;
    ConstraintLayout lay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.analis);
        lay = findViewById(R.id.lay);
        lay.setOnTouchListener(this::onTouch);

        textView = findViewById(R.id.textViewYd);
        textView1 = findViewById(R.id.textView2Yd);
        textView2 = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageViewI);
        imageView1 = findViewById(R.id.imageView4);


        title[0] = 1;
        title[1] = 2;
        title[2] = 3;
        Check(i);
    }
    public boolean onTouch(View v, MotionEvent event){
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = x;
                break;
                case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        if(x>x1){
                            if (i != 0){
                                i--;
                            }
                        } else if (x<x1) {
                            if(i<2){
                                i++;
                            }
                            if (i==2){
                                textView2.setText("Завершить");
                            }

                        }
                        Check(i);
                        break;
        }
        return true;
    }

    private void Check(int i) {
        if (title[i] == 1){
            textView.setText("Анализы");
            textView1.setText("Экспресс сбор и получение проб");
            imageView.setImageResource(R.drawable.illustration);
            imageView1.setImageResource(R.drawable.group_2__1_);
        }
        if (title[i] == 2){
            textView.setText("Уведомления");
            textView1.setText("Вы просто узнаёте о результатах");
            imageView.setImageResource(R.drawable.first_bc);
            imageView1.setImageResource(R.drawable.gr2);
        }
        if (title[i] == 3){
            textView.setText("Уведомления");
            textView1.setText("наши врачи всегда наблюдают \n"+"за вашими показателями здоровья");
            imageView.setImageResource(R.drawable.bc23333);
            imageView1.setImageResource(R.drawable.gr3);
        }
    }
    public void onClick(View view){
        Intent intent = new Intent(this, LogIn.class);
        startActivity(intent);
    }


    @Override
    public boolean onDown(@NonNull MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(@NonNull MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(@NonNull MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(@NonNull MotionEvent e1, @NonNull MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(@NonNull MotionEvent e) {

    }

    @Override
    public boolean onFling(@NonNull MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
}
