package com.example.asus.color;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements PreviewSurfaceView.OnColorListener {

   // private RoundView roundView;
    private RoundView roundView1;
    private PreviewSurfaceView previewSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /*roundView=(RoundView)findViewById(R.id.cross); //和New的区别？？？？？？

        roundView.setColor(Color.GREEN);
        roundView.refresh();
*/
        roundView1= (RoundView) findViewById(R.id.cross);
        previewSurfaceView= (PreviewSurfaceView) findViewById(R.id.preview);
        previewSurfaceView.setOnColorListener(this);

    }

   @Override
    public void onColor(int color) {
        roundView1.setColor(color);
        roundView1.refresh();
    }
}
