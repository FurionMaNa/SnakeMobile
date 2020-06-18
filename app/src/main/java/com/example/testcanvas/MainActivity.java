package com.example.testcanvas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.sql.Time;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity{

    static int x=0;
    static int y=0;
    static SnakeClass snake;
    static DrawView drawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        snake=new SnakeClass();
        setContentView(R.layout.activity_main);
        drawView=new DrawView(this);
        LinearLayout linearLayout=findViewById(R.id.linearLayout2);
        linearLayout.addView(drawView);
        ((Button)findViewById(R.id.down)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snake.onMove(10,"down");
                drawView.invalidate();
            }
        });
        ((Button)findViewById(R.id.up)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snake.onMove(10,"up");
                drawView.invalidate();
            }
        });
        ((Button)findViewById(R.id.left)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snake.onMove(10,"left");
                drawView.invalidate();
            }
        });
        ((Button)findViewById(R.id.right)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snake.onMove(10,"right");
                drawView.invalidate();
            }
        });
        Timer timer= new Timer();
        timer.schedule(new MyTimer(),0,500);
    }

    class DrawView extends View{

        Paint p;

        public DrawView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.parseColor("#20c040"));
            snake.Draw(canvas);
        }
    }

    class MyTimer extends java.util.TimerTask{
        @Override
        public void run() {
            Log.i("my","tick");
            drawView.invalidate();
        }
    }

}
