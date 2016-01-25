package com.example.asus.androidday41;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Printer;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by ASUS on 2016/1/22.
 */
public class MainView extends View {

    private Paint paint;
    private int x;
    private int y;

    public MainView(Context context) {
        super(context);
        init();
    }

    public MainView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        paint=new Paint();
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        x=100;
        y=100;

    }
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(15);
       // canvas.drawLine(0, 0, x, y, paint);
       // drawTest(canvas);

        //setPath(canvas);
        drawBitmap(canvas);
    }

    private void drawTest(Canvas canvas){
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(15);
        canvas.drawLine(0,0 , 400, 500, paint);
        canvas.drawCircle(200, 500, 100, paint);
        paint.setColor(Color.RED);
        canvas.drawRect(100, 500, 300, 600, paint);
        //canvas.drawRoundRect();
    }
    private void setPath(Canvas canvas){
        Path path=new Path();
        path.moveTo(100, 100);
        path.lineTo(100, 300);
        path.lineTo(200, 250);
        path.lineTo(100,100);
        paint.setColor(Color.BLUE);
        canvas.drawPath(path, paint);

        /*画自定义
        Path path1=new Path();
        path1.addCircle(500, 500, 200, Path.Direction.CW);
        path1.addCircle(500,500,100,Path.Direction.CCW);
        path1.moveTo(500, 300);
        path1.lineTo(500, 700);
        path1.lineTo(300, 500);
        path1.lineTo(700, 500);

        paint.setColor(Color.GRAY);
       // paint.setStyle();
       */
    }

    private void drawBitmap(Canvas canvas){
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        //canvas.drawBitmap(bitmap,500,500,paint);
        canvas.drawBitmap(bitmap, 0, 0, paint);

        canvas.save();
        canvas.translate(getWidth() / 2, getHeight() / 2);//改变坐标系的原点位置
        canvas.drawLine(-getWidth() / 2, 0, getHeight() / 2, 0, paint);
        canvas.drawLine(0, -getHeight() / 2, 0, 0, paint);
        canvas.drawBitmap(bitmap, 0, 0, paint);
        canvas.restore();

        canvas.save();
        canvas.rotate(45);//旋转坐标系    仅限此次旋转
        canvas.drawBitmap(bitmap, 0, 0, paint);
        canvas.restore();

        canvas.drawCircle(200, 200, 100, paint);

        canvas.drawBitmap(bitmap,300,500,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x=(int)event.getX();
        y=(int)event.getY();
        invalidate();//作废，无效
        return super.onTouchEvent(event);
    }
}
