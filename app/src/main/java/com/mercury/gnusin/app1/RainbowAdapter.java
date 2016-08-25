package com.mercury.gnusin.app1;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * Created by gnusin on 24.08.2016.
 */
public class RainbowAdapter extends BaseAdapter {

    private int[] colors = {Color.RED, Color.rgb(239, 179, 16), Color.YELLOW, Color.GREEN, Color.BLUE, Color.rgb(37, 141, 246), Color.rgb(162, 37, 246) };

    private ArrayList<String> items;
    private LayoutInflater inflater;

    public RainbowAdapter(Context context, ArrayList<String> items) {
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

        TextView textColorItem = (TextView) view.findViewById(R.id.textColorItem);
        textColorItem.setText((String) getItem(i));

        int indexColor = ++i % 8;
        if (indexColor != 0) {
            View iconColorItem = view.findViewById(R.id.iconColorItem);
            iconColorItem.setVisibility(View.VISIBLE);
            ((GradientDrawable) iconColorItem.getBackground()).setColor(colors[indexColor - 1]);
        } else {
            View iconColorItem = view.findViewById(R.id.iconColorItem);
            iconColorItem.setVisibility(View.INVISIBLE);
        }

        return view;
    }
}
