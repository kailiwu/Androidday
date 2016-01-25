package Camera;

import android.content.Context;
import android.graphics.Canvas;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

/**
 * CameraSurfaceView
 *
 * @author: ASUS
 * @time: 2016/1/23 9:27
 */
public class CameraSurfaceView extends SurfaceView implements SurfaceHolder.Callback{
    public final static String TAG="CameraSurfaceView";

    private SurfaceHolder holder;
    private Canvas canvas;
    protected  Camera camera;
    private boolean ispreview;

    public CameraSurfaceView(Context context) {
        super(context);
        init();
    }

    public CameraSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void init(){
        holder=getHolder();
        holder.addCallback(this);
        ispreview=false;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        camera= Camera.open();//打开Camera

        if(null!=camera){
            try {
                camera.setDisplayOrientation(90);
                camera.setPreviewDisplay(holder);//设置预览界面到当前的surface中
            } catch (IOException e) {
                e.printStackTrace();
                camera.release();
                camera=null;
            }
        }

        /*Camera.Parameters parameters=camera.getParameters();
        parameters.setPreviewSize(getWidth(),getHeight());//设置camera预览的尺寸
        camera.setParameters(parameters);*/

        camera.startPreview();//开始预览
        ispreview=true;
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        if(null!=camera){
            if(ispreview)
                camera.stopPreview();
        }
        camera.release();
        camera=null;
    }


}
