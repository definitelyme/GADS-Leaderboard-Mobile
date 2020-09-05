package com.f0rx.gadsleaderboard.Api;

import com.f0rx.gadsleaderboard.Models.Leaderboard;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {
    @GET("/api/hours")
    Call<List<Leaderboard>> getLeaderboardByHours();

    @GET("/api/skilliq")
    Call<List<Leaderboard>> getLeaderboardBySkillIQ();
}
