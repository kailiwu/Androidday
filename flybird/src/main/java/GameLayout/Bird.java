package GameLayout;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.example.asus.flybird.R;

import Game.GameSurface;
import User.Assist;
import User.Constest;

/**
 * Bird
 *
 * @author: ASUS
 * @time: 2016/1/24 10:01
 */
public class Bird extends Base{

    private float birdX,bireY;
    private float radius;

    private float speed;
    private float acc;

    public Bird(GameSurface gameSurface) {
        super(gameSurface);
        birdX=gameSurface.getWidth()/2;
        bireY=gameSurface.getHeight()/2;

        speed=15;
        acc=10;
        radius=screenHeight/40;
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        /*Bitmap bitmap= BitmapFactory.decodeResource(resources, R.mipmap.icon);
        canvas.drawBitmap(bitmap,x,y,paint);*/
        paint.setColor(Assist.getColor(resources, R.color.colorBlack));
        switch (gameSurface.getGameState()) {
            case Constest.Game_Start:
                canvas.drawCircle(screenWidth / 2, screenHeight / 2, radius, paint);
                break;
            case Constest.Game_Runing:
                canvas.drawCircle(birdX, bireY, radius, paint);
                break;
            case Constest.Game_end:
                canvas.drawCircle(screenWidth / 2, screenHeight / 2, radius, paint);
                break;
            default:
                break;
        }

    }



    @Override
    public void logic() {
        bireY+=speed;
        speed+=acc;
        if(bireY-radius<0||bireY+radius>screenHeight){
            gameSurface.setGameState(Constest.Game_end);
        }


    }

    @Override
    public void onTouchEvent(MotionEvent event) {
        speed=-50;
    }

    @Override
    public void onKeyDown(int KeyCode, KeyEvent keyEvent) {

    }

    public float getBirdX() {
        return birdX;
    }

    public float getBireY() {
        return bireY;
    }

    public float getRadius() {
        return radius;
    }
}
