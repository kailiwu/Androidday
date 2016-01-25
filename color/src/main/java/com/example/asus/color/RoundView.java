package com.example.asus.color;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * RoundView
 *
 * @author: ASUS
 * @time: 2016/1/23 8:19
 */
public class RoundView extends SurfaceView implements SurfaceHolder.Callback {
    public final static String TAG="SurfaceView";
    private SurfaceHolder holder;
    private Canvas canvas;
    private Paint paint;
    private int color;



    public RoundView(Context context) {
        super(context);
        init();
    }

    public RoundView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void init(){
        holder=getHolder();
        holder.addCallback(this);

        holder.setFormat(PixelFormat.TRANSPARENT);
        setKeepScreenOn(true);
        setZOrderOnTop(true);

        paint=new Paint();
        paint.setAntiAlias(true);

        paint.setColor(Color.RED);

        Log.i(TAG,"init");

    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Log.i(TAG,"Creat");
        refresh();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    public void myDraw(Canvas canvas){
        /*paint.setColor(Color.WHITE);
        canvas.drawRect(0,0,getWidth(),getHeight(),paint);*/

        canvas.save();
        canvas.translate(getWidth() / 2, getHeight() / 2);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(color);
        paint.setStrokeWidth(20);
        float radius=getHeight()/4;
        canvas.drawCircle(0, 0, getHeight() / 4, paint);
        paint.setStrokeWidth(5);
        canvas.drawLine(0, paint.getStrokeWidth()/2, 0, -radius, paint);
        canvas.drawLine(-paint.getStrokeWidth()/2,0,radius,0,paint);
        canvas.restore();

    }

    public void logic(){

    }

    public void refresh(){
        canvas=holder.lockCanvas(); //加锁
        if (null!=canvas) {
            myDraw(canvas);
            holder.unlockCanvasAndPost(canvas); //解锁
        }
        logic();
    }

    public void setColor(int color) {
        this.color = color;
    }
}
