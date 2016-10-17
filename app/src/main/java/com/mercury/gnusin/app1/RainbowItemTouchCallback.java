package com.mercury.gnusin.app1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;



public class RainbowItemTouchCallback extends ItemTouchHelper.SimpleCallback {

    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        /*RainbowAdapter.ViewHolder rainbowViewHolder = (RainbowAdapter.ViewHolder) viewHolder;
        getDefaultUIUtil().clearView(rainbowViewHolder.textView);
        getDefaultUIUtil().clearView(rainbowViewHolder.colorView);
        getDefaultUIUtil().clearView(rainbowViewHolder.removeButton);
        rainbowViewHolder.removeButton.setVisibility(View.GONE);*/
        super.clearView(recyclerView, viewHolder);
    }

    public RainbowItemTouchCallback(int dragDirs, int swipeDirs) {
        super(dragDirs, swipeDirs);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public float getSwipeThreshold(RecyclerView.ViewHolder viewHolder) {
        return .4f;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

        return;
        //int swipedPosition = viewHolder.getAdapterPosition();
        //adapter.removeItem(swipedPosition);
    }

   /* @Override
    public void onSelectedChanged(final RecyclerView.ViewHolder viewHolder, int actionState) {
        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
            RainbowAdapter.ViewHolder rainbowViewHolder = (RainbowAdapter.ViewHolder) viewHolder;

            int removeButtonWidth = (int) (0.8 * (viewHolder.itemView.getWidth() / 4));
            int removeButtonDX = viewHolder.itemView.getWidth() / 4;

            ViewGroup.LayoutParams params = rainbowViewHolder.removeButton.getLayoutParams();
            params.width = removeButtonWidth;
            params.height = viewHolder.itemView.getHeight();
            rainbowViewHolder.removeButton.setLayoutParams(params);
            rainbowViewHolder.removeButton.setVisibility(View.VISIBLE);
            rainbowViewHolder.removeButton.setTranslationX(removeButtonDX);
        }
        super.onSelectedChanged(viewHolder, actionState);
    }

    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        float translationX = Math.min(-dX, viewHolder.itemView.getWidth() / 4);

        RainbowAdapter.ViewHolder rainbowViewHolder = (RainbowAdapter.ViewHolder) viewHolder;

        rainbowViewHolder.textView.setTranslationX(-translationX);
        rainbowViewHolder.colorView.setTranslationX(-translationX);
        rainbowViewHolder.removeButton.setTranslationX(-(translationX - viewHolder.itemView.getWidth() / 4));

    }*/

}
