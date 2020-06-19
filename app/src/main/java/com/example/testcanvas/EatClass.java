package com.example.testcanvas;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

public class EatClass {

    private Integer x;
    private Integer y;
    private int width=0;
    private int height=0;

    public EatClass(int width, int height) {
        this.width = width;
        this.height = height;
        newPosition();
    }

    public void newPosition(){
        Random r=new Random();
        x=r.nextInt(this.width-40)+40;
        y=r.nextInt(this.height-40)+40;
        x=Integer.valueOf(x/40)*40;
        y=Integer.valueOf(y/40)*40;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public void Draw(Canvas canvas){
        Paint p=new Paint();
        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.RED);
        canvas.drawCircle(x,y,20,p);

    }
}
