package com.mercury.gnusin.app1;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    static private Integer[] colors = {null, Color.RED, Color.rgb(239, 179, 16), Color.YELLOW, Color.GREEN, Color.BLUE, Color.rgb(37, 141, 246), Color.rgb(162, 37, 246) };
    static private int count = 0;

    private int id;
    private List<RainbowItem> items;
    private AlertDialog displayedDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        id = ++count;
        Log.d("AGn HomeActivity_" + id, "create");
        setContentView(R.layout.a_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        items = (List<RainbowItem>)getLastCustomNonConfigurationInstance();
        if (items == null) {
            items = new ArrayList<>(20);
            for (int i = 0; i < 60;) {
                items.add(new RainbowItem(String.format("%s %d", getString(R.string.item_name), ++i), colors[i % 8]));
            }
        }

        ListAdapter adapter = new RainbowAdapter(this, items);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                RainbowItem item = (RainbowItem) adapterView.getAdapter().getItem(i);
                builder.setMessage(String.format(getString(R.string.item_show_dialog), item.getText()));

                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                displayedDialog = builder.create();
                displayedDialog.show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final RainbowAdapter listAdapter = (RainbowAdapter) adapterView.getAdapter();
                final int indexSelectedItems = i;
                RainbowItem item = (RainbowItem) listAdapter.getItem(indexSelectedItems);
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setMessage(String.format(getString(R.string.item_remove_dialog), item.getText()));

                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        listAdapter.removeItem(indexSelectedItems);
                        listAdapter.notifyDataSetChanged();
                        dialogInterface.cancel();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                displayedDialog = builder.create();
                displayedDialog.show();
                return true;
            }
        });

    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        super.onRetainCustomNonConfigurationInstance();
        return items;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("AGn HomeActivity_" + id, "destroy");
        if (displayedDialog != null) {
            displayedDialog.dismiss();
        }

        //finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("AGn HomeActivity_" + id, "pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("AGn HomeActivity_" + id, "stop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("AGn HomeActivity_" + id, "resume");
    }
}
