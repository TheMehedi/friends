package com.example.friends.mainActivity.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.friends.R;
import com.example.friends.mainActivity.adapters.MainAdapter;
import com.example.friends.mainActivity.models.datamodels.MainDataModel;
import com.example.friends.mainActivity.presenters.MainPresenter;

public class MainActivity extends AppCompatActivity implements IMainView {

    private RecyclerView recyclerView;
    private MainPresenter mainPresenter;
    private SwipeRefreshLayout swipeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        mainPresenter.getUser();

        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                mainPresenter.getUser();

                swipeLayout.setRefreshing(false);
            }
        });


    }

    private void initViews() {

        recyclerView = findViewById(R.id.recyclerView);
        swipeLayout = findViewById(R.id.swipeLayout);

        mainPresenter = new MainPresenter(MainActivity.this, this);

        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void onListResponse(MainDataModel data) {

        Log.i("onListResponse ", data.getInfo().getVersion());

        recyclerView.setAdapter(new MainAdapter(MainActivity.this, data.getResults()));
    }

    @Override
    public void onListError(String errMessage) {

        Toast.makeText(getApplicationContext(), errMessage, Toast.LENGTH_LONG).show();
    }
}