package com.plaps.androidcleancode.home;

import android.content.Context;

import com.plaps.androidcleancode.models.CityListData;
import com.plaps.androidcleancode.models.CityListResponse;

import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Created by ennur on 6/25/16.
 */
public interface HomeView {
    void showWait();

    void removeWait();

    void onFailure(String appErrorMessage);

    void getCityListSuccess(List<CityListData> cityListResponse);

    @Nullable
    Context getContext();
}
