package com.company.draganddraw;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hectorleyvavillanueva on 1/23/17.
 */

public class DragAndDrawFragment extends Fragment {

    private View mCustomView;

    private static final String TAG = "DragAndDrawFragment";
    public static DragAndDrawFragment newInstance(){
        return new DragAndDrawFragment();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_drag_and_draw, container, false);
        mCustomView = v.findViewById(R.id.custonView);
        return v;
    }

}
