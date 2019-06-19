package com.example.myapplication.view;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.adapter.SpotListAdapter;
import com.example.myapplication.file.SharePreferenceUtil;
import com.example.myapplication.model.Spot;

import java.util.List;

public class SpotListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private SpotListAdapter spotListAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spot_list);
        recyclerView = findViewById(R.id.list);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        List<Spot> spots = SharePreferenceUtil.getSpots();
        if (!spots.isEmpty()) {
            spotListAdapter = new SpotListAdapter(spots);
            recyclerView.setAdapter(spotListAdapter);

        }
        setToolBar();

    }

    private void setToolBar() {
        View back = findViewById(R.id.back);
        findViewById(R.id.list_bar).setVisibility(View.INVISIBLE);
        back.setVisibility(View.VISIBLE);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SpotListActivity.this.onBackPressed();
            }
        });
    }
}
