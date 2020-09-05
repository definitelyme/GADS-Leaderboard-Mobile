package com.f0rx.gadsleaderboard;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.f0rx.gadsleaderboard.Controllers.LeaderboardController;
import com.f0rx.gadsleaderboard.Models.Leaderboard;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button getHoursBtn = findViewById(R.id.get_hours);
        Button getSkillIQBtn = findViewById(R.id.get_skilliq);

        LeaderboardController controller = new LeaderboardController();

        getHoursBtn.setOnClickListener((listener) -> controller.getHours());

        getSkillIQBtn.setOnClickListener((listener) -> controller.getSkillIQ());
    }

    @SuppressWarnings("unused")
    public static class AsyncLeaderboard extends AsyncTask<CallType, Integer, List<Leaderboard>> {
        @Override
        protected List<Leaderboard> doInBackground(@NotNull CallType... callTypes) {
            LeaderboardController controller = new LeaderboardController();

            switch (callTypes[0]) {
                case Hours:
                    controller.getHours();
                case SkillIQ:
                    controller.getSkillIQ();
            }

            assert controller.data != null;

            return controller.data;
        }

        @Override
        protected void onPostExecute(List<Leaderboard> leaderboardList) {

        }
    }
}

enum CallType {
    Hours,
    SkillIQ,
}