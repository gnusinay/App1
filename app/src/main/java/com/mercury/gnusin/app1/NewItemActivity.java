package com.mercury.gnusin.app1;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class NewItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_addition_new_item);

        ArrayList<Map<String, Object>> adapterData = new ArrayList<>(RainbowColorsHelper.getColorsCount());
        for(int i = 0; i < RainbowColorsHelper.getColorsCount(); i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("title", RainbowColorsHelper.getColorByPosition(i).getTitle());
            item.put("color", RainbowColorsHelper.getColorByPosition(i).getColor());
            adapterData.add(item);
        }

        SimpleAdapter colorsAdapter = new SimpleAdapter(this,
                                                        adapterData,
                                                        R.layout.i_colors_spinner,
                                                        new String[] {"title", "color"},
                                                        new int[] {R.id.title_color_colors_spinner, R.id.color_view_colors_spinner});
        colorsAdapter.setViewBinder(new SimpleAdapter.ViewBinder() {
            @Override
            public boolean setViewValue(View view, Object data, String textRepresentation) {
                if (data instanceof String) {
                    ((TextView) view).setText((String) data);
                    return true;
                }

                if (data instanceof Integer) {
                    ((GradientDrawable) view.getBackground()).setColor((Integer) data);
                    view.setVisibility(View.VISIBLE);
                    return true;
                }

                return true;
            }
        });


        final Spinner colorNewItemSpinner = (Spinner) findViewById(R.id.color_new_item_spinner);
        final EditText titleNewItemEditText = (EditText) findViewById(R.id.title_new_item_edit_text);


        colorNewItemSpinner.setAdapter(colorsAdapter);
        colorNewItemSpinner.setSelection(0);

        final Button saveButton = (Button) findViewById(R.id.new_item_save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (titleNewItemEditText.getText().toString().isEmpty()) {
                    Snackbar.make((View) saveButton.getParent(), R.string.empty_title_new_item_error_message, Snackbar.LENGTH_SHORT).show();

                } else {
                    Intent intent = new Intent();
                    intent.putExtra("title", titleNewItemEditText.getText().toString());
                    intent.putExtra("color", colorNewItemSpinner.getSelectedItemPosition());

                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });


    }


}
