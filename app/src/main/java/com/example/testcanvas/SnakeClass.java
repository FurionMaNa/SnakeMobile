package com.example.testcanvas;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class SnakeClass {

    private String direction="right";
    private Integer speed=1;
    private ArrayList<ElemSnakeClass> elemSnakeClasses= new ArrayList<>();
    private int width;
    private int height;
    private Context context;

    public SnakeClass(int width, int height, Context context) {
        this.width=width;
        this.height=height;
        this.context=context;
        Random r=new Random();
        ElemSnakeClass elem=new ElemSnakeClass(40,40);
        elemSnakeClasses.add(elem);
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        if((this.direction.equals("right"))&&(direction.equals("left"))) {
            return;
        }else{
            if((this.direction.equals("up"))&&(direction.equals("down"))) {
                return;
            }else{
                if((this.direction.equals("left"))&&(direction.equals("right"))) {
                    return;
                }else{
                    if ((this.direction.equals("down"))&&(direction.equals("up"))) {
                        return;
                    }
                }
            }
        }
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
        for(Integer i=elemSnakeClasses.size()-2;i>=0;i--){
            ElemSnakeClass e =new ElemSnakeClass(elemSnakeClasses.get(i).getX(),elemSnakeClasses.get(i).getY());
            elemSnakeClasses.set(i+1,e);
        }
        for(Integer i=0;i<elemSnakeClasses.size();i++){
            Log.i("Myc",i+" "+elemSnakeClasses.get(i).getX()+" "+elemSnakeClasses.get(i).getY());
        }
        Log.i("Myc","------------------------------------------------------------------");
    }

    public void onMove(){
        switch (direction){
            case "up":
                if(elemSnakeClasses.get(0).getY()>40) {
                    offset();
                    elemSnakeClasses.get(0).setY(elemSnakeClasses.get(0).getY() - speed);
                }else{
                    elemSnakeClasses=new ArrayList<>();
                    Random r=new Random();
                    ElemSnakeClass elem=new ElemSnakeClass(40,40);
                    elemSnakeClasses.add(elem);
                }
                break;
            case "down":
                if(elemSnakeClasses.get(0).getY()<height-80) {
                    offset();
                    elemSnakeClasses.get(0).setY(elemSnakeClasses.get(0).getY() + speed);
                }else{
                    elemSnakeClasses=new ArrayList<>();
                    Random r=new Random();
                    ElemSnakeClass elem=new ElemSnakeClass(40,40);
                    elemSnakeClasses.add(elem);
                    Toast.makeText(context,"Ты проиграл",Toast.LENGTH_SHORT).show();
                }
                break;
            case "left":
                if(elemSnakeClasses.get(0).getX()>40) {
                    offset();
                    elemSnakeClasses.get(0).setX(elemSnakeClasses.get(0).getX() - speed);
                }else{
                    elemSnakeClasses=new ArrayList<>();
                    Random r=new Random();
                    ElemSnakeClass elem=new ElemSnakeClass(40,40);
                    elemSnakeClasses.add(elem);
                }
                break;
            case "right":
                if(elemSnakeClasses.get(0).getX()<width-40) {
                    offset();
                    elemSnakeClasses.get(0).setX(elemSnakeClasses.get(0).getX() + speed);
                }else{
                    elemSnakeClasses=new ArrayList<>();
                    Random r=new Random();
                    ElemSnakeClass elem=new ElemSnakeClass(40,40);
                    elemSnakeClasses.add(elem);
                }
                break;
        }
    }

    public void isCollision(){
        for(int i=3; i<elemSnakeClasses.size();i++){
            if(80>(Math.sqrt(Math.pow(elemSnakeClasses.get(0).getY()-elemSnakeClasses.get(i).getY(),2)+Math.pow(elemSnakeClasses.get(0).getX()-elemSnakeClasses.get(i).getX(),2)))){
                elemSnakeClasses=new ArrayList<>();
                Random r=new Random();
                ElemSnakeClass elem=new ElemSnakeClass(40,40);
                elemSnakeClasses.add(elem);
                break;
            }
        }
    }

    public void isAte(EatClass eatClass){
        if(60>(Math.sqrt(Math.pow(elemSnakeClasses.get(0).getY()-eatClass.getY(),2)+Math.pow(elemSnakeClasses.get(0).getX()-eatClass.getX(),2)))){
            elemSnakeClasses.add(elemSnakeClasses.get(0));
            eatClass.newPosition();
        }
    }

    public void Draw(Canvas canvas){
        Paint p=new Paint();
        p.setStyle(Paint.Style.FILL);
        for(int i=0;i<elemSnakeClasses.size();i++){
            if(i==0){
                p.setColor(Color.GRAY);
            }else{
                p.setColor(Color.RED);
            }
            canvas.drawCircle(elemSnakeClasses.get(i).getX(),elemSnakeClasses.get(i).getY(),40,p);
        }
    }
}
