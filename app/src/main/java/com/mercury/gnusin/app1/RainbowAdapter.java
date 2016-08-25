package com.mercury.gnusin.app1;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

/**
 * Created by gnusin on 24.08.2016.
 */
public class RainbowAdapter extends BaseAdapter {


    private List<RainbowItem> items;
    private LayoutInflater inflater;

    public RainbowAdapter(Context context, List<RainbowItem> items) {
        super();
        this.items = items;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public void removeItem(int i) {
        items.remove(i);
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.v_list_item_rainbow, parent, false);
        }

        RainbowItem item = (RainbowItem) getItem(i);
        TextView textColorItem = (TextView) view.findViewById(R.id.textColorItem);
        textColorItem.setText(item.getText());

        if (item.getColor() != null) {
            View iconColorItem = view.findViewById(R.id.iconColorItem);
            iconColorItem.setVisibility(View.VISIBLE);
            ((GradientDrawable) iconColorItem.getBackground()).setColor(item.getColor());
        } else {
            View iconColorItem = view.findViewById(R.id.iconColorItem);
            iconColorItem.setVisibility(View.INVISIBLE);
        }

        return view;
    }
}
