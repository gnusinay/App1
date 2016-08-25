package com.mercury.gnusin.app1;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private ArrayList<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (savedInstanceState == null) {
            items = new ArrayList<>(20);
            for (int i = 0; i < 60;) {
                items.add("Item " + ++i);
            }
        } else {
            items = savedInstanceState.getStringArrayList("items");
        }



        final ListAdapter adapter = new RainbowAdapter(this, items);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                String itemName = (String) adapterView.getAdapter().getItem(i);
                builder.setMessage(String.format("You selected %s", itemName));

                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                builder.create().show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final RainbowAdapter listAdapter = (RainbowAdapter) adapterView.getAdapter();
                final int indexSelectedItems = i;
                String itemName = (String) listAdapter.getItem(indexSelectedItems);
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setMessage(String.format("Do you want to delete %s", itemName));

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
                builder.create().show();
                return true;
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putStringArrayList("items", items);
        super.onSaveInstanceState(outState);
    }

}
