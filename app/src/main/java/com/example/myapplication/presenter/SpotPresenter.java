package com.example.myapplication.presenter;

import com.example.myapplication.file.SharePreferenceUtil;
import com.example.myapplication.model.Spot;
import com.example.myapplication.service.SpotService;
import com.example.myapplication.view.SpotView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SpotPresenter {

    private SpotView spotView;
    private SpotService spotService;


    public SpotPresenter(SpotView view) {
        this.spotView = view;

        if (this.spotService == null) {
            this.spotService = new SpotService();
        }
    }

    public void getSpots() {
        List<Spot> file = SharePreferenceUtil.getSpots();
        if (file.isEmpty()) {
            spotService
                    .getAPI()
                    .getListOfSpot()
                    .enqueue(new Callback<List<Spot>>() {
                        @Override
                        public void onResponse(Call<List<Spot>> call, Response<List<Spot>> response) {
                            List<Spot> data = response.body();

                            if (data != null && !data.isEmpty()) {
                                SharePreferenceUtil.setSpots(data);
                                spotView.spotsReady(data);
                            }
                        }

                        @Override
                        public void onFailure(Call<List<Spot>> call, Throwable t) {
                            try {
                                throw new InterruptedException("Something went wrong!");
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    });
        } else {
            spotView.spotsReady(file);
        }


    }
}
