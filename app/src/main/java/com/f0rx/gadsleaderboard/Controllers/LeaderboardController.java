package com.f0rx.gadsleaderboard.Controllers;

import android.os.Build;
import android.util.Log;

import com.f0rx.gadsleaderboard.Api.APIInterface;
import com.f0rx.gadsleaderboard.Api.ApiClient;
import com.f0rx.gadsleaderboard.Models.Leaderboard;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LeaderboardController implements Callback<List<Leaderboard>> {
    private APIInterface api;
    public List<Leaderboard> data;

    public LeaderboardController() {
        init();
    }

    public void init() {
        Retrofit retrofit = ApiClient.get();
        api = retrofit.create(APIInterface.class);
    }

    public void getHours() {
        Call<List<Leaderboard>> call = api.getLeaderboardByHours();
        call.enqueue(this);
    }

    public void getSkillIQ() {
        Call<List<Leaderboard>> call = api.getLeaderboardBySkillIQ();
        call.enqueue(this);
    }

    @Override
    public void onResponse(@NotNull Call<List<Leaderboard>> call, @NotNull Response<List<Leaderboard>> response) {
        if (response.isSuccessful()) {
            data = response.body();

            assert data != null;

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                data.forEach((item) -> Log.i("Learner's name: ", item.name));
            } else {
                for (Leaderboard item : data) {
                    Log.i("Learner's name: ", item.name);
                }
            }
        } else {
            Log.i("error-response", String.valueOf(response.errorBody()));
        }
    }

    @Override
    public void onFailure(@NotNull Call<List<Leaderboard>> call, @NotNull Throwable t) {
        t.printStackTrace();
    }
}
