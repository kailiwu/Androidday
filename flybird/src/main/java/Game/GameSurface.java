package Game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.asus.flybird.R;

import GameLayout.BackGround;
import GameLayout.Barrier;
import GameLayout.Begin;
import GameLayout.Bird;
import GameLayout.Score;
import User.Assist;
import User.Constest;

/**
 * GameSurface
 *
 * @author: ASUS
 * @time: 2016/1/24 9:33
 */
public class GameSurface extends SurfaceView implements SurfaceHolder.Callback,Runnable {
    public final static String TAG = "GameSurface";
    private SurfaceHolder holder;
    private Canvas canvas;
    private Paint paint;
    private Thread thread;
    private boolean flag;
    private static int gameState;//游戏状态
    private Constest constest;
    private BackGround backGround;
    private Bird bird;
    private Begin begin;
    private Barrier barrier;
    private Score score;
    private int scoreMax;


    public GameSurface(Context context) {
        super(context);
        init();
    }

    public GameSurface(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void init() {
        holder = getHolder();
        holder.addCallback(this);
        setKeepScreenOn(true);

        holder.setFormat(PixelFormat.TRANSPARENT);
        setZOrderOnTop(true);

        paint = new Paint();
        paint.setAntiAlias(true);

        scoreMax=0;
    }

    public void initGame() {
        gameState = 0;
        backGround = new BackGround(this);
        bird = new Bird(this);
        begin = new Begin(this);
        barrier=new Barrier(this);
        score=new Score(this);
        score.setScoreMax(scoreMax);
        scoreMax=0;
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        initGame();

        flag = true;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        flag = false;
    }

    public void myDraw(Canvas canvas) {
        //backGround.draw(canvas, paint);
        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);

        /*paint.setColor(Assist.getColor(getResources(), R.color.colorQingse));
        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);*/


        switch (gameState) {
            case Constest.Game_Start:
                bird.draw(canvas, paint);
                begin.draw(canvas, paint);
                score.draw(canvas,paint);
                break;
            case Constest.Game_Runing:
                score.draw(canvas, paint);
                bird.draw(canvas, paint);
                barrier.draw(canvas, paint);
                break;
            case Constest.Game_end:
                bird.draw(canvas, paint);
                begin.draw(canvas, paint);
                break;
            default:
                break;
        }
    }

    public void logic() {
        switch (gameState) {
            case Constest.Game_Start:

                break;
            case Constest.Game_Runing:
                bird.logic();
                barrier.logic();
                barrier.setBirdX(bird.getBirdX());
                barrier.setBirdY(bird.getBireY());
                barrier.setBirdRadius(bird.getRadius());
                score.logic();
                break;
            case Constest.Game_end:
                initGame();
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (gameState) {
            case Constest.Game_Start:
                begin.onTouchEvent(event);

                break;
            case Constest.Game_Runing:
                bird.onTouchEvent(event);
                break;
            case Constest.Game_end:
                break;
            default:
                break;

        }
        return super.onTouchEvent(event);
    }

    @Override
    public void run() {
        while (flag) {
            long start = System.currentTimeMillis(); //开始时间

            canvas = holder.lockCanvas(); //加锁
            if (null != canvas) {
                myDraw(canvas);
                holder.unlockCanvasAndPost(canvas); //解锁
            }
            logic();

            long end = System.currentTimeMillis(); //结束时间

            if (end - start < 50) {
                try {
                    Thread.sleep(50 - (end - start));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static int getGameState() {
        return gameState;
    }

    public static void setGameState(int gameState) {
        GameSurface.gameState = gameState;
    }

    public void setScoreMax(int scoreMax) {
        this.scoreMax = scoreMax;
    }
}

