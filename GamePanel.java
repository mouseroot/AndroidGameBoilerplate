package com.example.mouseroot.mynetworkgame;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.graphics.Canvas;
import android.graphics.Paint;



/**
 * Created by mouseroot on 4/11/17.
 */

class GamePanel extends SurfaceView implements SurfaceHolder.Callback {

    private SharedPreferences.Editor keyStore;
    private MainThread thread;

    public GamePanel(Context cx, SharedPreferences.Editor keyStore) {
        super(cx);
        this.keyStore = keyStore;

        getHolder().addCallback(this);
        setFocusable(true);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {


        //Start Gameloop
        thread = new MainThread(getHolder(), this);
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while(retry) {
            try {
                thread.setRunning(false);
                thread.join();
                retry = false;
                thread = null;
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        Paint textPaint = new Paint();
        textPaint.setColor(Color.RED);
        canvas.drawText("Hello world",50,50,textPaint);
    }

    public void update() {

    }
}
