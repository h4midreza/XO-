package com.example.xo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.xo.databinding.ActivityGameDisplayBinding;

public class GameDisplay extends AppCompatActivity {
    ActivityGameDisplayBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGameDisplayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.playAgainBtn.setVisibility(View.GONE);
        binding.homeBtn.setVisibility(View.GONE);

        String[] playerNames = getIntent().getStringArrayExtra("PLAYER_NAMES");

        if (playerNames != null){
            binding.PlayerDisplay.setText(playerNames[0]+"'s Turn");
        }

        binding.ticTacToeBoard.setUpGame(binding.playAgainBtn, binding.homeBtn, binding.PlayerDisplay, playerNames);

        binding.playAgainBtn.setOnClickListener(view -> {
            binding.ticTacToeBoard.resetGame();
            binding.ticTacToeBoard.invalidate();
        });

        binding.homeBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }

}