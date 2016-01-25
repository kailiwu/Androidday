package GameLayout;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.example.asus.flybird.R;

import java.util.Random;

import Game.GameSurface;
import User.Assist;
import User.Constest;

/**
 * Barrier
 *
 * @author: ASUS
 * @time: 2016/1/24 10:03
 */
public class Barrier extends Base{

    private float spaceH;//上下障碍间隔
    private float distance;//左右间距
    private float barrier1X,barrierY;//坐标
    private float barrier2X;
    private float barrier1H,barrierW;//长宽
    private float barrier2H;
    private float speed;
    private float birdX;
    private float birdY;
    private float birdRadius;


    public Barrier(GameSurface gameSurface) {
        super(gameSurface);
        spaceH=screenHeight/4;
        barrierW=100;//障碍的宽
        barrierY=0;//障碍的Y坐标     固定不变
        distance=screenWidth/2-barrierW/2;
        speed=15;

        barrier1X=screenWidth+200;
        barrier1H=getBarrierH();//产生随机数   要用Int

        barrier2X=barrier1X+distance+barrierW;
        barrier2H=getBarrierH();//产生随机数   要用Int

    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(Assist.getColor(resources, R.color.coloeGreen));

        canvas.drawRect(barrier1X, barrierY, barrier1X + barrierW,barrierY+barrier1H,paint);
        canvas.drawRect(barrier1X, barrier1H+spaceH, barrier1X + barrierW,screenHeight, paint);

        canvas.drawRect(barrier2X,barrierY,barrier2X+barrierW,barrierY+barrier2H,paint);
        canvas.drawRect(barrier2X,barrier2H+spaceH,barrier2X+barrierW,screenHeight,paint);
    }

    @Override
    public void logic() {
        barrier1X-=speed;
        barrier2X-=speed;

        if(barrier1X+barrierW<0){
            barrier1X=screenWidth;
            barrier1H=new Random().nextInt((int) (screenHeight-spaceH));
        }
        if(barrier2X+barrierW<0){
            barrier2X=screenWidth;
            barrier2H=new Random().nextInt((int) (screenHeight-spaceH));
        }
        boolean isColl1=circleAndRect(birdX,birdY,birdRadius,barrier1X,barrierY,barrierW,barrier1H);
        boolean isColl2=circleAndRect(birdX,birdY,birdRadius,barrier1X,barrier1H+spaceH,barrierW,screenHeight-barrier1H-spaceH);
        boolean isColl3=circleAndRect(birdX,birdY,birdRadius,barrier2X,barrierY,barrierW,barrier2H);
        boolean isColl4=circleAndRect(birdX,birdY,birdRadius,barrier2X,barrier2H+spaceH,barrierW,screenHeight-barrier2H-spaceH);

        if(isColl1||isColl2||isColl3||isColl4){
            gameSurface.setGameState(Constest.Game_end);
        }
    }

    @Override
    public void onTouchEvent(MotionEvent event) {

    }

    @Override
    public void onKeyDown(int KeyCode, KeyEvent keyEvent) {

    }

    private float getBarrierH(){
        return new Random().nextInt((int) (screenHeight-spaceH-100));
    }

    public void setBirdX(float birdX) {
        this.birdX = birdX;
    }

    public void setBirdY(float birdY) {
        this.birdY = birdY;
    }

    public void setBirdRadius(float birdRadius) {
        this.birdRadius = birdRadius;
    }



    private boolean circleAndRect(float circleX, float circleY, float circleR, float rectX, float
            rectY, float rectW, float rectH) {
        if (circleX + circleR < rectX) {
            return false;
        } else if (circleX - circleR > rectX + rectW) {
            return false;
        } else if (circleY + circleR < rectY) {
            return false;
        } else if (circleY - circleR > rectY + rectH) {
            return false;
        } else if (Math.pow(rectX - circleX, 2) + Math.pow(rectY - circleY, 2) > circleR *
                circleR && circleX < rectX && circleY < rectX) {
            return false;
        } else if (Math.pow(rectX + rectW - circleX, 2) + Math.pow(rectY - circleY, 2) > circleR *
                circleR && circleX > rectX + rectW && circleY < rectY) {
            return false;
        } else if (Math.pow(rectX - circleX, 2) + Math.pow(rectY + rectH - circleY, 2) > circleR *
                circleR && circleX < rectX && circleY > rectY + rectH) {
            return false;
        } else if (Math.pow(rectX + rectW - circleX, 2) + Math.pow(rectY + rectH - circleY, 2) >
                circleR * circleR && circleX > rectX + rectW && circleY > rectY + rectH) {
            return false;
        }

        return true;
    }


}

