package com.plaps.androidcleancode.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.plaps.androidcleancode.R;
import com.plaps.androidcleancode.models.CityListData;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity implements DetailView {
    @BindView(R.id.city)
    TextView city;
    @BindView(R.id.num_hotels)
    TextView numHotels;
    @BindView(R.id.detail_image)
    ImageView image;

    DetailPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        presenter = new DetailPresenter(this);
        CityListData cityData = (CityListData) getIntent().getExtras().get("city_item");

        fillData(cityData);
    }

    public void fillData(CityListData cityData) {
        Glide.with(this)
            .load(cityData.getBackground())
            .apply(new RequestOptions().placeholder(R.mipmap.placeholder).error(R.mipmap.placeholder))
            .into(image);
        city.setText(cityData.getName());
        numHotels.setText(cityData.getDescription());
    }
}
