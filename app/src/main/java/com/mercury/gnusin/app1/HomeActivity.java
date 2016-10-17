package com.mercury.gnusin.app1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private static int ACTIVITY_RESULT_CODE = 1;

    private List<RainbowItem> items;
    private RecyclerView recyclerView;
    private CoordinatorLayout coordinatorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.a_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        items = (List<RainbowItem>)getLastCustomNonConfigurationInstance();
        if (items == null) {
            items = new ArrayList<>(20);
            for (int i = 0; i < 60;) {
                items.add(new RainbowItem(String.format("%s %d", getString(R.string.item_name), ++i), RainbowColorsHelper.getColorByPosition(i % 8).getColor()));
            }
        }

        FloatingActionButton addItemButton = (FloatingActionButton) findViewById(R.id.add_float_button);
        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, NewItemActivity.class);
                startActivityForResult(intent, ACTIVITY_RESULT_CODE);
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        coordinatorView = (CoordinatorLayout) findViewById(R.id.coordinator_view);

        final RainbowAdapter adapter = new RainbowAdapter(this, items);
        recyclerView.setAdapter(adapter);

        RainbowItemTouchCallback rainbowItemTouchCallback = new RainbowItemTouchCallback(0, ItemTouchHelper.LEFT);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(rainbowItemTouchCallback);

        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ACTIVITY_RESULT_CODE) {
            if (resultCode == RESULT_OK) {
                String title = data.getStringExtra("title");
                if (title != null && !title.isEmpty()) {
                    int color = data.getIntExtra("color", 0);
                    RainbowItem rainbowItem = new RainbowItem(title, RainbowColorsHelper.getColorByPosition(color).getColor());
                    if (((RainbowAdapter) recyclerView.getAdapter()).addItem(rainbowItem)) {
                        Snackbar.make(coordinatorView, R.string.add_new_item_successful_message, Snackbar.LENGTH_SHORT).show();
                    } else {
                        Snackbar.make(coordinatorView, R.string.add_new_item_error_message, Snackbar.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        super.onRetainCustomNonConfigurationInstance();
        return items;
    }

}
