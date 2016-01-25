package GameLayout;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.KeyEvent;
import android.view.MotionEvent;

import Game.GameSurface;

/**
 * Base
 *
 * @author: ASUS
 * @time: 2016/1/24 10:12
 */
public abstract class Base {
    protected GameSurface gameSurface;
    protected int screenWidth;
    protected int screenHeight;
    protected Resources resources;//资源


    public Base(GameSurface gameSurface){
        this.gameSurface=gameSurface;
        this.screenWidth=gameSurface.getWidth();
        this.screenHeight=gameSurface.getHeight();

        resources = gameSurface.getResources();
    }

    public abstract void draw(Canvas canvas,Paint paint);

    public abstract void logic();

    public abstract void onTouchEvent(MotionEvent event);

    public abstract void onKeyDown(int KeyCode,KeyEvent keyEvent);
}
