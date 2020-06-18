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
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        drawView=new DrawView(this);
        final LinearLayout linearLayout2=findViewById(R.id.linearLayout2);
        final int[] h = new int[1];
        final int[] w = new int[1];
        linearLayout2.post(new Runnable(){
            public void run(){
                h[0] = linearLayout2.getHeight();
                w[0] = linearLayout2.getWidth();
                snake=new SnakeClass(w[0],h[0]);
                linearLayout2.addView(drawView);
                snake.setSpeed(40);
                ((Button)findViewById(R.id.down)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        snake.setDirection("down");
                        drawView.invalidate();
                    }
                });
                ((Button)findViewById(R.id.up)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        snake.setDirection("up");
                        drawView.invalidate();
                    }
                });
                ((Button)findViewById(R.id.left)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        snake.setDirection("left");
                        drawView.invalidate();
                    }
                });
                ((Button)findViewById(R.id.right)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        snake.setDirection("right");
                        drawView.invalidate();
                    }
                });
                Timer timer= new Timer();
                timer.schedule(new MyTimer(),0,100);
            }
        });
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
            snake.onMove();
            drawView.invalidate();
        }
    }

}
