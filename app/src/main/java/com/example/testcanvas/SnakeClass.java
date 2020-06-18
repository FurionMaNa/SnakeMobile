package com.example.testcanvas;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;

public class SnakeClass {

    private ArrayList<ElemSnakeClass> elemSnakeClasses= new ArrayList<>();

    public SnakeClass() {
        ElemSnakeClass elem=new ElemSnakeClass(40,40);
        elemSnakeClasses.add(elem);
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

    public void onMove(Integer speed, String direction){
        switch (direction){
            case "up":
                offset();
                elemSnakeClasses.get(0).setY(elemSnakeClasses.get(0).getY()-speed);
                break;
            case "down":
                offset();
                elemSnakeClasses.get(0).setY(elemSnakeClasses.get(0).getY()+speed);
                break;
            case "left":
                offset();
                elemSnakeClasses.get(0).setX(elemSnakeClasses.get(0).getX()-speed);
                break;
            case "right":
                offset();
                elemSnakeClasses.get(0).setX(elemSnakeClasses.get(0).getX()+speed);
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
