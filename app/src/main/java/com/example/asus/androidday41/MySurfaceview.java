package com.example.asus.androidday41;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.Random;

/**
 * MySurfaceview
 *
 * @author: ASUS
 * @time: 2016/1/22 10:18
 */
public class MySurfaceview extends SurfaceView implements SurfaceHolder.Callback,Runnable {
   /* public final static String TAG = "MySurfaceView";

    private SurfaceHolder holder;

    private Canvas canvas;
    private Paint paint;

    private Thread thread;
    private boolean flag;

    private float x, y;
    private float speedX, speedY;
    private float radius;
    private int color;

    private Vector loca; // 位置
    private Vector speed; // 速度
    private Vector acc; // 加速度

    private float rectX, rectY;
    private float rectWidth, rectHeight;

    private float rect1X, rect1Y;
    private float rect1Width, rect1Height;

    private boolean isColl;

    public MySurfaceview(Context context) {
        super(context);
        init();
    }

    public MySurfaceview(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    *//**
     * 初始化
     *//*
    private void init() {
        holder = getHolder();
        holder.addCallback(this);

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
    }

    *//**
     * 初始化游戏
     *//*
    private void initGame() {
        x = 0;
        y = 0;
        speedX = 10;
        speedY = 20;
        radius = 50;
        color = Color.RED;

        loca = new Vector(100, 100);
        speed = new Vector(10, 20);
        acc = new Vector(1.0f, 2.0f);


        rectX = getWidth() / 2 - 100;
        rectY = getHeight() / 2 - 80;
        rectWidth = 200;
        rectHeight = 160;

        rect1X = x;
        rect1Y = y;
        rect1Width = 200;
        rect1Height = 200;
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Log.i(TAG, "surfaceCreated");

        initGame();

        flag = true;

        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Log.i(TAG, "surfaceChanged");
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        Log.i(TAG, "surfaceDestroyed");
        flag = false;
    }

    *//**
     * 画图
     *
     * @param canvas
     *//*
    private void myDraw(Canvas canvas) {
        paint.setColor(Color.WHITE);
        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);

        paint.setColor(Color.YELLOW);
        canvas.drawRect(rectX, rectY, rectX + rectWidth, rectY + rectHeight, paint);

        paint.setColor(color);
        paint.setColor(Color.RED);
        canvas.drawCircle(x, y, radius, paint);
//        canvas.drawRect(rect1X, rect1Y, rect1X + rect1Width, rect1Y + rect1Height, paint);

        paint.setColor(Color.BLUE);
        canvas.drawCircle(loca.x, loca.y, radius, paint);

        if (isColl) {
            paint.setColor(Color.GREEN);
            canvas.drawCircle(100, 100, 100, paint);
        }
    }

    *//**
     * 逻辑
     *//*
    private void logic() {
        // 简单移动
        x += speedX;
        y += speedY;

        if (x >= getWidth() || x < 0) {
            speedX = -speedX;
        }
        if (y >= getHeight() || y < 0) {
            speedY = -speedY;
        }

        // 向量移动
        speed.limit(50);
        speed.add(acc);
        loca.add(speed);

        if (loca.x >= getWidth() || loca.x < 0) {
            speed.x = -speed.x;
            acc.x = -acc.x;
        }
        if (loca.y >= getHeight() || loca.y < 0) {
            speed.y = -speed.y;
            acc.y = -acc.y;
        }


        rect1X = x;
        rect1Y = y;
        // 碰撞检测
        // 矩形与矩形
//        isColl = rectAndRect(rect1X, rect1Y, rect1Width, rect1Height, rectX, rectY,
//                rectWidth, rectHeight);
        // 圆与圆
//        isColl = circleAndCircle(x, y, radius, loca.x, loca.y, radius);
        //圆与矩形
        isColl = circleAndRect(loca.x, loca.y, radius, rectX, rectY, rectWidth, rectHeight);
    }

    *//**
     * 矩形与矩形之间的碰撞检测
     *
     * @param rect1X
     * @param rect1Y
     * @param rect1W
     * @param rect1H
     * @param rect2X
     * @param rect2Y
     * @param rect2W
     * @param rect2H
     * @return
     *//*
    private boolean rectAndRect(float rect1X, float rect1Y, float rect1W, float rect1H, float
            rect2X, float rect2Y, float rect2W, float rect2H) {
        if (rect1X + rect1W < rect2X) {
            return false;
        } else if (rect1X > rect2X + rect1W) {
            return false;
        } else if (rect1Y + rect1H < rect2Y) {
            return false;
        } else if (rect1Y > rect2Y + rect2H) {
            return false;
        }
        return true;
    }

    *//**
     * 圆与圆碰撞检测
     *
     * @param circle1X
     * @param circle1Y
     * @param circle1R
     * @param circle2X
     * @param circle2Y
     * @param circle2R
     * @return
     *//*
    private boolean circleAndCircle(float circle1X, float circle1Y, float circle1R, float
            circle2X, float circle2Y, float circle2R) {
        double disSq = Math.pow(circle2X - circle1X, 2) + Math.pow(circle2Y - circle1Y, 2);
        if (disSq > Math.pow(circle1R + circle2R, 2)) {
            return false;
        }
        return true;
    }

    *//**
     * 圆与矩形间的碰撞检测
     *
     * @param circleX
     * @param circleY
     * @param circleR
     * @param rectX
     * @param rectY
     * @param rectW
     * @param rectH
     * @return
     *//*
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

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        int[] colors = new int[]{Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW};
        //color = colors[new Random().nextInt(colors.length)];
        //radius = new Random().nextInt(30) + 50;

        // 引力
        Vector touch = new Vector(x, y);
        acc = Vector.add(touch, loca);
        acc.normalize();
        acc.mutiply(15.0f);

        return super.onTouchEvent(event);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        return super.onKeyDown(keyCode, event);
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
    }*/

    public final static String TAG="MySurfaceview";
    private Paint paint;
    private Paint paint1;
    private Canvas canvas;//画布
    private  SurfaceHolder surfaceHolder;
    private Thread thread;
    private boolean flag;
    private boolean k=true;

    private float x,y;
    private float xs,ys;

    private Vector local;
    private Vector speed;
    private Vector acc;

    private float recctX;
    private float rectY;
    private float rectwidth;
    private float rectheight;

    public MySurfaceview(Context context) {
        super(context);
        init();
    }

    public MySurfaceview(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void init(){
        surfaceHolder= getHolder();
        surfaceHolder.addCallback(this);

        paint=new Paint();
        paint1=new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        paint1.setAntiAlias(true);
        paint1.setColor(Color.BLUE);

    }

    public void initxy(){
        x=0;
        y=0;
        xs=10;
        ys=20;

        local=new Vector(100,100);
        speed=new Vector(10,20);
        acc=new Vector(1.0f,2.0f);

        recctX=getWidth()/2-100;
        rectY=getHeight()/2-80;
        rectwidth=200;
        rectheight=160;



    }
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Log.i(TAG, "surfaceCreated");
        initxy();
        flag=true;
        Thread thread=new Thread(this);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Log.i(TAG, "surfaceChanged");
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        Log.i(TAG, "surfaceDestroyed");
        flag=false;

    }

    public void drawMap(Canvas canvas){
        paint.setColor(Color.WHITE);
        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);

       if(k==true)
        {
            int a=(int)(getWidth()%255*x);
            int b=(int)(getHeight()%255*y);
            paint1.setColor(Color.rgb(a,b,0));
        }
        k=false;
        //paint1.setColor(Color.GREEN);
        canvas.drawCircle(x, y, 50, paint1);

       // paint1.setColor(Color.RED);
        canvas.drawCircle(local.x, local.y, 50, paint1);

        //paint1.setColor(Color.YELLOW);
        canvas.drawRect(recctX,rectY,rectheight,rectwidth,paint1);
    }

    public void logic(){
        x=x+xs;
        y=y+ys;
        if(x>=getWidth()||x<0){
            xs=-xs;
            k=true;
        }

        if(y>=getHeight()||y<0){
            ys=-ys;
            k=true;
        }

        speed.limit(20.0f);
        local.add(speed);
        speed.add(acc);
        if(local.x>getWidth()||local.x<0){
           speed.x=-speed.x;
            acc.x=-acc.x;
            k=true;
        }

        if(local.y>getHeight()||local.y<0){
            speed.y=-speed.y;
            acc.y=-acc.y;
            k=true;
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int a=(int)event.getX();
        int b=(int)event.getY();
        paint.setColor(Color.BLACK);
        k=true;
        Vector touch=new Vector(a,b);
        acc=Vector.jian(touch,local);
        acc.normalize();
        acc.mutiply(15.0f);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }


            @Override
            public void run() {
                while(flag){
                    long start=System.currentTimeMillis();
                    canvas=surfaceHolder.lockCanvas();
            if(null!=canvas){
                drawMap(canvas);
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
                    logic();


            long end=System.currentTimeMillis();
            if(end-start<50){
                try {
                    thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else{
                try {
                    thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
