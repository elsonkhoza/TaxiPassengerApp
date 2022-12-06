package com.fienc.taxipassenger.adapters;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class SpaceDecoration extends RecyclerView.ItemDecoration {

    private final int height;

    public SpaceDecoration(int height) {
        this.height = height;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.bottom = height;
        outRect.top = height;
        outRect.left = height;
        outRect.right = height;
    }
}