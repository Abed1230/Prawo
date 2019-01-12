package com.abed.prawo.ui.main;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.abed.prawo.data.models.Collection;
import com.abed.prawo.ui.addedit.AddEditCollectionActivity;

import com.abed.prawo.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CollectionsViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.title_main_activity);
        toolbar.inflateMenu(R.menu.menu_main);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.item_add) {
                    startActivity(new Intent(getApplicationContext(),AddEditCollectionActivity.class));
                }
                return true;
            }
        });
        setSupportActionBar(toolbar);

        RecyclerView rcv = findViewById(R.id.rcv);
        final CollectionsListAdapter adapter = new CollectionsListAdapter(this);
        rcv.setAdapter(adapter);
        rcv.setLayoutManager(new LinearLayoutManager(this));

        model = ViewModelProviders.of(this).get(CollectionsViewModel.class);
        model.getAllCollections().observe(this, new Observer<List<Collection>>() {
            @Override
            public void onChanged(@Nullable List<Collection> collections) {
                adapter.setData(collections);
            }
        });
    }
}