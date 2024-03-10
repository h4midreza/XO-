package com.example.xo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.xo.databinding.ActivityPlayerSetupBinding;

public class PlayerSetup extends AppCompatActivity {
    ActivityPlayerSetupBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlayerSetupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.submitBtn.setOnClickListener(this::submitButtonClick);
    }

    private void submitButtonClick(View view) {
        String player1 = binding.player1Name.getText().toString();
        String player2 = binding.player2Name.getText().toString();

        Intent intent = new Intent(this, GameDisplay.class);
        intent.putExtra("PLAYER_NAMES", new String[] {player1, player2});
        startActivity(intent);
    }
}