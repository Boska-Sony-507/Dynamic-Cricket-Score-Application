package com.example.cricketlivescore;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView tvMatchInfo, tvScore;
    private Button btnRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        tvMatchInfo = findViewById(R.id.tvMatchInfo);
        tvScore = findViewById(R.id.tvScore);
        btnRefresh = findViewById(R.id.btnRefresh);

        // Simulate fetching live score initially
        fetchLiveScore();

        // Refresh button listener
        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchLiveScore();
            }
        });
    }

    private void fetchLiveScore() {
        tvScore.setText("Fetching live cricket score...");

        // Simulate delay for API or server response
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Simulate random cricket match score
                String[] teams = {"India", "Australia", "England", "Pakistan", "South Africa"};
                String team1 = teams[new Random().nextInt(teams.length)];
                String team2 = teams[new Random().nextInt(teams.length)];

                // Ensure teams are different
                while (team1.equals(team2)) {
                    team2 = teams[new Random().nextInt(teams.length)];
                }

                int runs = new Random().nextInt(400); // Random runs
                int wickets = new Random().nextInt(10); // Random wickets
                int overs = new Random().nextInt(50); // Random overs

                tvMatchInfo.setText(team1 + " vs " + team2);
                tvScore.setText(team1 + " " + runs + "/" + wickets + " (" + overs + " overs)");
            }
        }, 2000); // Simulated delay
    }
}
