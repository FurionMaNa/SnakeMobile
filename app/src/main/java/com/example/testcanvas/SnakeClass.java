package com.example.testcanvas;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import java.util.ArrayList;

public class SnakeClass {

    private String direction="right";
    private Integer speed=10;
    private ArrayList<ElemSnakeClass> elemSnakeClasses= new ArrayList<>();
    private int width;
    private int height;

    public SnakeClass(int width, int height) {
        this.width=width;
        this.height=height;
        ElemSnakeClass elem=new ElemSnakeClass(40,40);
        elemSnakeClasses.add(elem);
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public ArrayList<ElemSnakeClass> getElemSnakeClasses() {
        return elemSnakeClasses;
    }

    public void setElemSnakeClasses(ArrayList<ElemSnakeClass> elemSnakeClasses) {
        this.elemSnakeClasses = elemSnakeClasses;
    }

    private void offset(){
        for(int i=elemSnakeClasses.size()-2;i>0;i--){
            elemSnakeClasses.set(i+1,elemSnakeClasses.get(i));
        }
    }

    public void onMove(){
        switch (direction){
            case "up":
                if(elemSnakeClasses.get(0).getY()>40) {
                    offset();
                    elemSnakeClasses.get(0).setY(elemSnakeClasses.get(0).getY() - speed);
                }else{
                    //los
                    Log.i("my","GG");
                }
                break;
            case "down":
                if(elemSnakeClasses.get(0).getY()<height-80) {
                    offset();
                    elemSnakeClasses.get(0).setY(elemSnakeClasses.get(0).getY() + speed);
                }else{
                    //los
                    Log.i("my","GG");
                }
                break;
            case "left":
                if(elemSnakeClasses.get(0).getX()>40) {
                    offset();
                    elemSnakeClasses.get(0).setX(elemSnakeClasses.get(0).getX() - speed);
                }else{
                    //los
                    Log.i("my","GG");
                }
                break;
            case "right":
                if(elemSnakeClasses.get(0).getX()<width-40) {
                    offset();
                    elemSnakeClasses.get(0).setX(elemSnakeClasses.get(0).getX() + speed);
                }else{
                    //los
                    Log.i("my","GG");
                }
                break;
        }
    }

    public void Draw(Canvas canvas){
        Paint p=new Paint();
        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.GRAY);
        for(int i=0;i<elemSnakeClasses.size();i++){
            canvas.drawCircle(elemSnakeClasses.get(i).getX(),elemSnakeClasses.get(i).getY(),40,p);
        }
    }
}
