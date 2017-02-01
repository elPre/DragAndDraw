package com.company.draganddraw;

import android.graphics.PointF;

/**
 * Created by hectorleyvavillanueva on 1/23/17.
 */

public class Box {
    private PointF mOrigin;
    private PointF mCurrent;

    public Box(PointF origin) {
        mOrigin = origin;
        mCurrent = origin;
    }


    public PointF getmCurrent() {
        return mCurrent;
    }

    public void setmCurrent(PointF mCurrent) {
        this.mCurrent = mCurrent;
    }

    public PointF getmOrigin() {
        return mOrigin;
    }

}
