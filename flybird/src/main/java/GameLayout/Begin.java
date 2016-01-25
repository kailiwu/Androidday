package GameLayout;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.KeyEvent;
import android.view.MotionEvent;

import Game.GameSurface;
import User.Constest;

/**
 * Begin
 *
 * @author: ASUS
 * @time: 2016/1/24 10:02
 */
public class Begin extends Base{
    private float x,y;
    private float w,h;

    private float triangleW,triangleH;

    public Begin(GameSurface gameSurface) {
        super(gameSurface);
        w=250;
        h=150;
        x=gameSurface.getWidth()/2-w/2;
        y=2*screenHeight/3-h/2;

        triangleW=80;
        triangleH=50;

    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(Color.WHITE);
        canvas.drawRect(x, y, x + w, y + h, paint);

        paint.setColor(Color.GREEN);
        Path path=new Path();
        path.moveTo(x + w / 2 - triangleH / 2, y + h / 2 - triangleW / 2);
        path.lineTo(x + w / 2 - triangleH / 2, y + h / 2 + triangleW / 2);
        path.lineTo(x + w / 2 + triangleH / 2, y + h / 2);
        canvas.drawPath(path, paint);

  /*      paint.setColor(Color.BLACK);
        paint.setTextSize(300);
        canvas.drawText("0", screenWidth - 200, 300, paint);*/
    }

    @Override
    public void logic() {


    }

    @Override
    public void onTouchEvent(MotionEvent event) {
        int touchX= (int) event.getX();
        int touchY= (int) event.getY();

        if(touchX>x&&touchX<x+w&&touchY>y&&touchY<y+h){
            gameSurface.setGameState(Constest.Game_Runing);
        }


    }

    @Override
    public void onKeyDown(int KeyCode, KeyEvent keyEvent) {

    }


}
