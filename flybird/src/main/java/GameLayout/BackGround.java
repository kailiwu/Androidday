package GameLayout;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Camera;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

import com.example.asus.flybird.R;

import Game.GameSurface;
import User.Assist;

/**
 * BackGround
 *
 * @author: ASUS
 * @time: 2016/1/24 10:02
 */
public class BackGround extends Base{

    public BackGround(GameSurface gameSurface) {
        super(gameSurface);
    }

    @Override
    public void draw(Canvas canvas, Paint paint)     {
       /* paint.setColor(Assist.getColor(resources, R.color.colorQingse));
        canvas.drawRect(0, 0, screenWidth, screenHeight, paint);*/

    }

    @Override
    public void logic() {

    }

    @Override
    public void onTouchEvent(MotionEvent event) {

    }

    @Override
    public void onKeyDown(int KeyCode, KeyEvent keyEvent) {

    }
}
