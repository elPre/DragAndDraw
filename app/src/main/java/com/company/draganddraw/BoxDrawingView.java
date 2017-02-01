package com.company.draganddraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hectorleyvavillanueva on 1/23/17.
 */

public class BoxDrawingView extends View{
    private static final String TAG = "BoxDrawingView";
    private Box mCurrentBox;
    private List<Box> mBoxen = new ArrayList<>();
    private Paint mBoxPaint;
    private Paint mBackgroundPaint;

    public BoxDrawingView(Context context) {
        super(context,null);
    }

    public BoxDrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //Paint the boxes a nice semitransparent red (ARGB)
        mBoxPaint = new Paint();
        mBoxPaint.setColor(0x22ff0000);

        //Paint the background off-white
        mBackgroundPaint = new Paint();
        mBackgroundPaint.setColor(0xfff8efe0);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPaint(mBackgroundPaint);
        for (Box box : mBoxen) {
            float left = Math.min(box.getmOrigin().x, box.getmCurrent().x);
            float right = Math.max(box.getmOrigin().x, box.getmCurrent().x);
            float top = Math.min(box.getmOrigin().y, box.getmCurrent().y);
            float bottom = Math.max(box.getmOrigin().y, box.getmCurrent().y);

            canvas.drawRect(left, top, right, bottom, mBoxPaint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        PointF current = new PointF(event.getX(), event.getY());
        String action = "";

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                action = "Action_Down";
                //Reset drawing state
                mCurrentBox = new Box(current);
                mBoxen.add(mCurrentBox);
                break;
            case MotionEvent.ACTION_MOVE:
                action = "Action_Move";
                if (mCurrentBox != null) {
                    mCurrentBox.setmCurrent(current);
                    invalidate();
                }
                break;
            case MotionEvent.ACTION_UP:
                action = "Action_Up";
                mCurrentBox = null;
                break;
            case MotionEvent.ACTION_CANCEL:
                action = "Action_Cancel";
                mCurrentBox = null;
                break;
        }
        Log.i(TAG, action + " at  x=" + current.x + " ,  y= " + current.y);
        return true;
    }

    @Override
    protected Parcelable onSaveInstanceState() {

        View v = findViewById(R.id.custonView);
        Bundle bundle = new Bundle();
        bundle.putParcelable("superState", super.onSaveInstanceState());
        return bundle;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        Log.i(TAG, "inside the onRestoreInstanceState and getting the state "+ state);
        super.onRestoreInstanceState(state);
    }
}
