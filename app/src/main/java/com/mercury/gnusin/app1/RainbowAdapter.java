package com.mercury.gnusin.app1;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;


public class RainbowAdapter extends RecyclerView.Adapter<RainbowAdapter.ViewHolder> {

    private List<RainbowItem> items;
    private List<Integer> swipedNowPositions;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public View colorView;
        public ImageButton removeButton;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text_view);
            colorView = itemView.findViewById(R.id.color_view);
            removeButton = (ImageButton) itemView.findViewById(R.id.remove_button);
        }
    }


    public RainbowAdapter(Context context, List<RainbowItem> items) {
        super();
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.v_list_item_rainbow, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.textView.setText(items.get(position).getText());

        if (items.get(position).getColor() != null) {
            holder.colorView.setVisibility(View.VISIBLE);
            ((GradientDrawable) holder.colorView.getBackground()).setColor(items.get(position).getColor());
        } else {
            holder.colorView.setVisibility(View.INVISIBLE);
        }


        holder.removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RainbowAdapter.this.removeItem(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public void addSwipedPosition(int position) {
        swipedNowPositions.add(position);
    }

    public void deleteSwipedPosition(int position) {
        swipedNowPositions.remove(Integer.valueOf(position));
    }

    public boolean addItem(RainbowItem item) {
        if (items.contains(item)) {
            return false;
        } else {
            items.add(item);
            notifyItemInserted(items.size());
            return true;
        }
    }

    public void removeItem(Object item) {
       /* items.
        items.remove(item);
        notifyItemRemoved();*/
    }
}

