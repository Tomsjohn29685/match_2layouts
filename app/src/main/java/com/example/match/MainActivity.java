package com.example.match;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.TextView;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
    private TextView tvScoreTeamA;
    private TextView tvScoreTeamB;
    private int scoreTeamA = 0;
    private int scoreTeamB = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvScoreTeamA = findViewById(R.id.tv_score_team_a);
        tvScoreTeamB = findViewById(R.id.tv_score_team_b);

        Button btnPlus3TeamA = findViewById(R.id.btn_plus_3_team_a);
        Button btnPlus2TeamA = findViewById(R.id.btn_plus_2_team_a);
        Button btnFreeThrowTeamA = findViewById(R.id.btn_free_throw_team_a);

        Button btnPlus3TeamB = findViewById(R.id.btn_plus_3_team_b);
        Button btnPlus2TeamB = findViewById(R.id.btn_plus_2_team_b);
        Button btnFreeThrowTeamB = findViewById(R.id.btn_free_throw_team_b);
        Button btnReset = findViewById(R.id.btn_reset);

        btnPlus3TeamA.setOnClickListener(v -> addPointsForTeamA(3));
        btnPlus2TeamA.setOnClickListener(v -> addPointsForTeamA(2));
        btnFreeThrowTeamA.setOnClickListener(v -> addPointsForTeamA(1));

        btnPlus3TeamB.setOnClickListener(v -> addPointsForTeamB(3));
        btnPlus2TeamB.setOnClickListener(v -> addPointsForTeamB(2));
        btnFreeThrowTeamB.setOnClickListener(v -> addPointsForTeamB(1));

        btnReset.setOnClickListener(v -> resetScores());
    }

    private void addPointsForTeamA(int points) {
        scoreTeamA += points;
        displayScoreForTeamA();
    }

    private void addPointsForTeamB(int points) {
        scoreTeamB += points;
        displayScoreForTeamB();
    }

    private void displayScoreForTeamA() {
        tvScoreTeamA.setText(String.valueOf(scoreTeamA));
    }

    private void displayScoreForTeamB() {
        tvScoreTeamB.setText(String.valueOf(scoreTeamB));
    }

    private void resetScores() {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayScoreForTeamA();
        displayScoreForTeamB();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("ScoreTeamA", scoreTeamA);
        outState.putInt("ScoreTeamB", scoreTeamB);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //savedInstanceState.getInt("ScoreTeamA", scoreTeamA);
        //savedInstanceState.getInt("ScoreTeamB", scoreTeamB);
        scoreTeamA = savedInstanceState.getInt("ScoreTeamA");
        scoreTeamB = savedInstanceState.getInt("ScoreTeamB");
        updateScoreDisplay();
    }
    private void updateScoreDisplay() {
        tvScoreTeamA.setText(String.valueOf(scoreTeamA));
        tvScoreTeamB.setText(String.valueOf(scoreTeamB));
    }
}