package GameLayout;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.KeyEvent;
import android.view.MotionEvent;

import Game.GameSurface;
import User.Constest;

/**
 * Score
 *
 * @author: ASUS
 * @time: 2016/1/24 10:04
 */
public class Score extends Base{
    private float scoreX,scoreY;
    private int score;
    private long start;
    private long end;
    private boolean isstart;
    private float scoreMax;


    public Score(GameSurface gameSurface) {
        super(gameSurface);
        score=0;
        scoreX=screenWidth-200;
        scoreY=300;
        isstart=true;
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
            paint.setColor(Color.BLACK);
            paint.setTextSize(100);

           switch (gameSurface.getGameState()){
               case Constest.Game_Start:
                   canvas.drawText(scoreMax + "s", scoreX, scoreY, paint);
                   break;
               case Constest.Game_Runing:
                   canvas.drawText(score + "s", scoreX, scoreY, paint);
                   break;
               default:
                   break;

           }


    }

    @Override
    public void logic() {
        if(isstart) {
            start = System.currentTimeMillis();
            isstart=false;
        }
        end=System.currentTimeMillis();

        score=(int)(end-start)/1000;
        // 保存最高分
        if (score > scoreMax) {
            gameSurface.setScoreMax(score);
        }
    }

    @Override
    public void onTouchEvent(MotionEvent event) {

    }

    @Override
    public void onKeyDown(int KeyCode, KeyEvent keyEvent) {

    }

    public float getScoreMax() {
        return scoreMax;
    }

    public void setScoreMax(float scoreMax) {
        this.scoreMax = scoreMax;
    }
}
