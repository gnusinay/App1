package com.mercury.gnusin.app1;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;



public class RainbowAdapter extends RecyclerView.Adapter<RainbowAdapter.ViewHolder> {



    private List<RainbowItem> items;
    private LayoutInflater inflater;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View itemView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
        }
    }


    public RainbowAdapter(Context context, List<RainbowItem> items) {
        super();
        this.items = items;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.v_list_item_rainbow, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TextView textView = (TextView) holder.itemView.findViewById(R.id.text_view);
        textView.setText(items.get(position).getText());

        View colorView = holder.itemView.findViewById(R.id.color_view);

        if (items.get(position).getColor() != null) {
            colorView.setVisibility(View.VISIBLE);
            ((GradientDrawable) colorView.getBackground()).setColor(items.get(position).getColor());
        } else {
            colorView.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

