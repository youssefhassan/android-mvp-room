package com.plaps.androidcleancode.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.plaps.androidcleancode.BaseApp;
import com.plaps.androidcleancode.R;
import com.plaps.androidcleancode.detail.DetailActivity;
import com.plaps.androidcleancode.models.CityListData;
import com.plaps.androidcleancode.models.CityListResponse;
import com.plaps.androidcleancode.networking.Service;

import org.jetbrains.annotations.Nullable;

import java.util.List;

import javax.inject.Inject;

public class HomeActivity extends BaseApp implements HomeView {

    private RecyclerView list;
    @Inject
    public  Service service;
    ProgressBar progressBar;
    private HomePresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDeps().inject(this);

        renderView();
        init();

        presenter = new HomePresenter(service, this);
        presenter.getCityList();
    }

    public  void renderView(){
        setContentView(R.layout.activity_home);
        list = findViewById(R.id.list);
        progressBar = findViewById(R.id.progress);
    }

    public void init(){
        list.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void showWait() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void removeWait() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onFailure(String appErrorMessage) {
    }

    @Override
    public void getCityListSuccess(List<CityListData> cityListResponse) {
        HomeAdapter adapter = new HomeAdapter(getApplicationContext(), cityListResponse,
            item -> {
                Intent intent = new Intent(HomeActivity.this, DetailActivity.class);
                intent.putExtra("city_item", item);
                startActivity(intent);
            });

        list.setAdapter(adapter);
    }

    @Nullable
    @Override
    public Context getContext() {
        return null;
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onStop();
    }
}
